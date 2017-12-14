package com.cappuccino.offer.cache.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.cappuccino.offer.domain.ad.Ads;
import com.cappuccino.offer.domain.ad.SupervisorsBean;
import com.cappuccino.offer.util.MyEnum;

public class RedisDb {
	private static RedisDb instance = null;
	protected static final Logger logger = Logger.getLogger(RedisDb.class);
	private static final String UNION_USERS = "t_supervisors";

	public static RedisDb getInstance() {
		if (instance == null) {
			instance = new RedisDb();
		}
		return instance;
	}

	public List<Ads> getAll(String key) {
		List<Ads> list = new ArrayList<Ads>();
		Map<String, String> map = RedisFactory.hgetAll(key);
		for (String k : map.keySet()) {
			String value = map.get(k);
			Ads item = JSON.parseObject(value, Ads.class);
			list.add(item);
		}
		return list;
	}

	public List<Ads> replaceAll(String key, List<Ads> list) {
		if (list == null || list.size() <= 0) {
			return null;
		}
		RedisFactory.del(key);
		Map<String, String> map = new HashMap<String, String>();
		for (Ads item : list) {
			String k = String.valueOf(item.getId());
			map.put(k, toJson(item));
		}
		RedisFactory.hmset(key, map);
		return list;
	}

	public String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	/**
	 * 将最新的状态为0的offer放入redis缓存
	 * 
	 * @author
	 * 
	 * @return
	 */
	public boolean updateRedisFromDb(List<Ads> adList) {
		// 清除现有的key
		Map<String, String> keysMap = RedisFactory.getAllmap(MyEnum.REDIS_ADDB_ALLKEYS);
		if (keysMap != null) {
			for (String key : keysMap.keySet()) {
				RedisFactory.del(key);
			}
			RedisFactory.del(MyEnum.REDIS_ADDB_ALLKEYS);
		}
		// 添加新的offer数据
		RedisDb.getInstance().replaceById(adList);

		return true;

	}

	/**
	 * 替换所有数据库offer到redis
	 * 
	 * @param key
	 *            每个id对应的key
	 * @param countryKeys
	 *            记录增加的所有keys
	 * @param list
	 *            需要替换的广告列表
	 * @return
	 */
	public List<Ads> replaceById(List<Ads> list) {

		if (list == null || list.size() <= 0) {
			return null;
		}
		for (Ads item : list) {
			updateOfferById(item);
		}
		return list;
	}

	/**
	 * 增加单个offer到redis
	 * 
	 * @param key
	 * @param countryKeys
	 * @param ad
	 */
	public void updateOfferById(Ads ad) {
		String couKey = "";
		Map<String, String> keysMap = RedisFactory.getAllmap(MyEnum.REDIS_ADDB_ALLKEYS);
		if (ad == null) {
			return;
		}
		String k = String.valueOf(ad.getId());
		couKey = MyEnum.REDIS_KEY_DB_ID_KEYS + k;
		keysMap.put(couKey, k);
		RedisFactory.hset(couKey, k, toJson(ad));
		RedisFactory.set(MyEnum.REDIS_ADDB_ALLKEYS, keysMap);
	}

	/**
	 * 根据pkg country 设置缓存
	 * 
	 * @param adAll
	 * @return
	 */
	public Boolean updateRedisPkgCountry(List<Ads> adAll) {
		// 清除现有的key
		Map<String, String> keysMap = RedisFactory.getAllmap(MyEnum.REDIS_KEYS_COUNTRYPKG);
		if (keysMap != null) {
			for (String key : keysMap.keySet()) {
				RedisFactory.del(key);
			}
		}
		// 添加新的offer数据
		Map<String, List<Ads>> map = new HashMap<String, List<Ads>>();
		for (Ads ad : adAll) {
			String pkg = ad.getPkg().replace("id", "");
			String key = pkg + "_" + ad.getCountries();
			keysMap.put(key, key);
			if (map.get(key) != null) {
				List<Ads> list = map.get(key);
				list.add(ad);
				map.remove(key);
				map.put(key, list);
			} else {
				List<Ads> list = new ArrayList<Ads>();
				list.add(ad);
				map.put(key, list);
			}
		}

		for (Map.Entry<String, List<Ads>> entry : map.entrySet()) {
			RedisFactory.set(MyEnum.REDIS_KEYS_COUNTRYPKG, keysMap);
			replaceAll(entry.getKey(), map.get(entry.getKey()));
		}

		logger.info("updateRedisPkgCountry  end ");
		return true;
	}

	public Boolean updateRedisSupervisors(List<SupervisorsBean> supervisorsList) {
		// 清除现有的key
		Map<String, String> keysMap = RedisFactory.getAllmap(MyEnum.REDIS_ALL_KEYS_SUPERVISORS);
		if (keysMap != null) {
			for (String key : keysMap.keySet()) {
				RedisFactory.del(key);
			}
		}
		String couKey = "";
		for (SupervisorsBean entity : supervisorsList) {
			String k = String.valueOf(entity.getId());
			couKey = MyEnum.REDIS_KEYS_SUPERVISORS + k;
			keysMap.put(couKey, k);
			logger.info("Supervisor" + k + "===" + toJson(entity));
			RedisFactory.hset(couKey, k, toJson(entity));
			RedisFactory.set(MyEnum.REDIS_ALL_KEYS_SUPERVISORS, keysMap);
		}
		return true;
	}

}
