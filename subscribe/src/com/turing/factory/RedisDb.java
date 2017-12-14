package com.turing.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.turing.pilot.bean.PilotAd;
import com.turing.pilot.bean.SupervisorsBean;

public class RedisDb {
	private static RedisDb instance = null;

	public static RedisDb getInstance() {
		if (instance == null) {
			instance = new RedisDb();
		}
		return instance;
	}

	public List<PilotAd> getAll(String key) {
		List<PilotAd> list = new ArrayList<PilotAd>();
		Map<String, String> map = RedisFactory.hgetAll(key);
		for (String k : map.keySet()) {
			String value = map.get(k);
			PilotAd item = JSON.parseObject(value, PilotAd.class);
			list.add(item);
		}
		return list;
	}

	public List<PilotAd> replaceAll(String key, List<PilotAd> list) {
		if (list == null || list.size() <= 0) {
			return null;
		}
		RedisFactory.del(key);
		Map<String, String> map = new HashMap<String, String>();
		for (PilotAd item : list) {
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
	 * @author chenbq
	 * 
	 * @return
	 */
	public boolean updateRedisFromDb(List<PilotAd> adList) {
		// 清除现有的key
		Map<String, String> keysMap = RedisFactory.getAllmap(TuringEnum.REDIS_KEY_DB_COUNTRY_KEYS);
		if (keysMap != null) {
			for (String key : keysMap.keySet()) {
				RedisFactory.del(key);
			}
		}

		RedisFactory.del(TuringEnum.REDIS_KEY_DB_COUNTRY_KEYS);

		// 添加新的offer数据
		RedisDb.getInstance().replaceByCountry(adList);

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
	public List<PilotAd> replaceByCountry(List<PilotAd> list) {

		if (list == null || list.size() <= 0) {
			return null;
		}
		for (PilotAd item : list) {
			updateOfferByCountry(item);
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
	public void updateOfferByCountry(PilotAd ad) {
		String couKey = "";
		Map<String, String> keysMap = RedisFactory.getAllmap(TuringEnum.REDIS_KEY_DB_COUNTRY_KEYS);

		if (ad == null) {
			return;
		}
		String k = String.valueOf(ad.getId());
		String country = ad.getCountry();
		if (country.equalsIgnoreCase("ALL")) {
			couKey = TuringEnum.REDIS_KEY_DB_COUNTRY + "ALL";
			keysMap.put(couKey, "ALL");
			RedisFactory.hset(couKey, k, toJson(ad));
		} else if (country.indexOf(":") > 0) {
			String[] countryList = country.split(":");
			for (int i = 0; i < countryList.length; i++) {
				couKey = TuringEnum.REDIS_KEY_DB_COUNTRY + countryList[i].trim();
				keysMap.put(couKey, countryList[i]);
				RedisFactory.hset(couKey, k, toJson(ad));
			}
		} else {
			couKey = TuringEnum.REDIS_KEY_DB_COUNTRY + country.trim();
			keysMap.put(couKey, country);
			RedisFactory.hset(couKey, k, toJson(ad));
		}
		RedisFactory.set(TuringEnum.REDIS_KEY_DB_COUNTRY_KEYS, keysMap);
	}

	public List<SupervisorsBean> getAllSupervisors(String key) {
		List<SupervisorsBean> list = new ArrayList<SupervisorsBean>();
		Map<String, String> map = RedisFactory.hgetAll(key);
		for (String k : map.keySet()) {
			String value = map.get(k);
			SupervisorsBean item = JSON.parseObject(value, SupervisorsBean.class);
			list.add(item);
		}
		return list;
	}

	public List<SupervisorsBean> replaceAllSupervisors(String key, List<SupervisorsBean> list) {
		if (list == null || list.size() <= 0) {
			return null;
		}
		RedisFactory.del(key);
		Map<String, String> map = new HashMap<String, String>();
		for (SupervisorsBean item : list) {
			String k = String.valueOf(item.getId());
			map.put(k, toJson(item));
		}
		RedisFactory.hmset(key, map);
		return list;
	}

}
