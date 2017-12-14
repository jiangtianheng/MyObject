package com.cappuccino.offer.dao.cache;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.cappuccino.offer.cache.key.CacheKeyDic;
import com.cappuccino.offer.cache.key.KeyInfo;
import com.cappuccino.offer.cache.memcache.MemCacheFactory;
import com.cappuccino.offer.cache.redis.RedisClusterClient;
import com.cappuccino.offer.dao.AdDAO;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.AdsTem;

@Component(value = "adDAO")
public class CacheAdDAO extends AdDAO {

	@Override
	public int insertTem(AdsTem item) {
		return super.insertTem(item);
	}
	
	@Override
	public List<Ads> findAffliateByProvider() {
		return super.findAffliateByProvider();
	}

	@Override
	public List<Ads> findByKey(String k0, String k1, String k2, String k3) {
		return super.findByKey(k0, k1, k2, k3);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ads> findAffliateByProvider(int type, int provider) {
		String key = CacheKeyDic.CACHE_KEY_AD_TYPE_PROVIDER + type + "_" + provider;
		KeyInfo keyInfo = new KeyInfo(key, CacheKeyDic.ONE_HOUR * 3);
		Object o = MemCacheFactory.get(keyInfo);
		if (o != null && o instanceof List<?>) {
			return (List<Ads>) o;
		}
		List<Ads> ads = super.findAffliateByProvider(type, provider);
		if (ads != null && !ads.isEmpty())
			MemCacheFactory.add(keyInfo, ads);
		return ads;
	}

	@Override
	public List<Ads> findAffliateByProviderInsertToday(int provider, long datetime) {
		return super.findAffliateByProviderInsertToday(provider, datetime);
	}

	@Override
	public List<Ads> findByStatus() {
		return super.findByStatus();
	}

	@Override
	public List<Ads> findManual() {
		return super.findManual();
	}

	@Override
	public void updateStatusByPkg(String pkg) {
		super.updateStatusByPkg(pkg);
	}

	/**
	 * 刷新offer在redis中的缓存
	 */
	public List<Ads> updateRedisFromDb() {
		List<Ads> ads = super.findByStatus(1);
		// updateRedisFromDb(ads);
		return ads;
	}

	/**
	 * 将最新的状态为0的offer放入redis缓存
	 * 
	 * @author chenbq
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean updateRedisFromDb(List<Ads> adList) {
		// 清除现有的key
		KeyInfo keyInfo = new KeyInfo(CacheKeyDic.REDIS_KEY_DB_COUNTRY_KEYS, 0);
		Map<String, String> keysMap = RedisClusterClient.hgetAll(keyInfo);
		if (keysMap != null) {
			for (String key : keysMap.keySet()) {
				RedisClusterClient.del(new KeyInfo(key, 0));
			}
		}

		RedisClusterClient.del(keyInfo);

		// 添加新的offer数据
		replaceByCountry(adList);

		return true;

	}


	/**
	 * 替换所有数据库offer到redis
	 * 
	 * @param key
	 *            每个国家对应的key
	 * @param countryKeys
	 *            记录增加的所有keys
	 * @param list
	 *            需要替换的广告列表
	 * @return
	 */
	private List<Ads> replaceByCountry(List<Ads> list) {
		if (list == null || list.size() <= 0) {
			return null;
		}
		for (Ads item : list) {
			updateOfferByCountry(item);
		}
		return list;
	}

	/**

	/**
	 * 增加单个offer到redis
	 * 
	 * @param key
	 * @param countryKeys
	 * @param ad
	 */
	private void updateOfferByCountry(Ads ad) {
		if (ad == null)
			return;
		String couKey = "";
		KeyInfo keyInfo = new KeyInfo(CacheKeyDic.REDIS_KEY_DB_COUNTRY_KEYS, 0);
		Map<String, String> keysMap = RedisClusterClient.hgetAll(keyInfo);
		String k = String.valueOf(ad.getId());
		String country = ad.getCountries();
		if (country.equalsIgnoreCase("ALL")) {
			couKey = CacheKeyDic.REDIS_KEY_DB_COUNTRY + "ALL";
			keysMap.put(couKey, "ALL");
			RedisClusterClient.hset(new KeyInfo(couKey, 0), k, JSON.toJSONString(ad));
		} else if (country.indexOf(":") > 0) {
			String[] countryList = country.split(":");
			for (int i = 0; i < countryList.length; i++) {
				couKey = CacheKeyDic.REDIS_KEY_DB_COUNTRY + countryList[i];
				keysMap.put(couKey, countryList[i]);
				RedisClusterClient.hset(new KeyInfo(couKey, 0), k, JSON.toJSONString(ad));
			}
		} else {
			couKey = CacheKeyDic.REDIS_KEY_DB_COUNTRY + country;
			keysMap.put(couKey, country);
			RedisClusterClient.hset(new KeyInfo(couKey, 0), k, JSON.toJSONString(ad));
		}
		RedisClusterClient.hmset(new KeyInfo(CacheKeyDic.REDIS_KEY_DB_COUNTRY_KEYS, 0), keysMap);
	}




}
