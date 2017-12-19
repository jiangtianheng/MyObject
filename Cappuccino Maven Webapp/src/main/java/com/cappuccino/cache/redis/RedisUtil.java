package com.cappuccino.cache.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.cappuccino.util.DateUtil;
import com.cappuccino.util.ThreadPoolService;


public class RedisUtil {
	/**
	 * 1分钟过期
	 * */
	public static final int REDIS_INTERVAL = 1 * 60 * 1000;
	private static ConcurrentHashMap<String, RedisItem> getMap = new ConcurrentHashMap<String, RedisItem>();
	private static ConcurrentHashMap<String, RedisItem> addMap = new ConcurrentHashMap<String, RedisItem>();
	private static long getEndTime = DateUtil.endTime();
	private static long addEndTime = DateUtil.endTime();

	public static Map<Long, Integer> getAll(String key) {
		long now = System.currentTimeMillis();
		RedisItem item = getMap.get(key);
		if ((item == null) || (now - item.getTime() > REDIS_INTERVAL)) {
			Map<String, String> map = RedisFactory.hgetAll(key);
			if (map != null && map.size() > 0) {
				if (item == null) {
					item = new RedisItem();
					item.setValue(new ConcurrentHashMap<Long, Integer>());
					getMap.put(key, item);
				}
				item.setTime(now);
				Map<Long, Integer> valueMap = item.getValue();
				if (valueMap != null) {
					valueMap.clear();
				} else {
					valueMap = new ConcurrentHashMap<Long, Integer>();
					item.setValue(valueMap);
				}
				for (Entry<String, String> e : map.entrySet())
					valueMap.put(Long.valueOf(e.getKey()), Integer.valueOf(e.getValue()));
			}
		}
		if (getEndTime < now)// 零点缓存清空
		{
			getEndTime = DateUtil.endTime();
			getMap.clear();
		}
		return item == null ? new HashMap<Long, Integer>() : item.getValue();
	}

	// 获取key为String
	public static Map<String, Integer> getAllString(String key) {
		long now = System.currentTimeMillis();
		RedisItem item = getMap.get(key);
		if ((item == null) || (now - item.getTime() > REDIS_INTERVAL)) {
			Map<String, String> map = RedisFactory.hgetAll(key);
			if (map != null && map.size() > 0) {
				if (item == null) {
					item = new RedisItem();
					item.setStringvalue(new ConcurrentHashMap<String, Integer>());
					getMap.put(key, item);
				}
				item.setTime(now);
				Map<String, Integer> valueMap = item.getStringvalue();
				if (valueMap != null) {
					valueMap.clear();
				} else {
					valueMap = new ConcurrentHashMap<String, Integer>();
					item.setStringvalue(valueMap);
				}
				for (Entry<String, String> e : map.entrySet())
					valueMap.put(e.getKey(), Integer.valueOf(e.getValue()));
			}
		}
		if (getEndTime < now)// 零点缓存清空
		{
			getEndTime = DateUtil.endTime();
			getMap.clear();
		}
		return item == null ? new HashMap<String, Integer>() : item.getStringvalue();
	}

	public static void incr(String key, List<Long> list, int liveTime) {
		long now = System.currentTimeMillis();
		RedisItem item = addMap.get(key);
		if (item == null) {
			item = new RedisItem();
			item.setTime(now);
			item.setValue(new ConcurrentHashMap<Long, Integer>());
			addMap.put(key, item);
		}
		Map<Long, Integer> map = item.getValue();
		if (map == null) {
			map = new ConcurrentHashMap<Long, Integer>();
			item.setValue(map);
		}
		for (Long id : list) {
			Integer v = map.get(id);
			map.put(id, v == null ? 1 : v + 1);
		}
		if (now - item.getTime().longValue() > REDIS_INTERVAL) {
			Map<Long, Integer> valueMap = new HashMap<Long, Integer>(map);
			map.clear();
			writeRedis(null, valueMap, key, liveTime);
			item.setTime(now);
		}
		if (addEndTime < now)// 零点写缓存清空
		{
			addEndTime = DateUtil.endTime();
			Map<String, RedisItem> valueMap = new HashMap<String, RedisItem>(addMap);
			addMap.clear();
			writeRedis(valueMap, null, key, liveTime);
		}
	}

	// ====
	public static void incrString(String key, List<String> list, int liveTime) {
		long now = System.currentTimeMillis();
		RedisItem item = addMap.get(key);
		if (item == null) {
			item = new RedisItem();
			item.setTime(now);
			item.setStringvalue(new ConcurrentHashMap<String, Integer>());
			addMap.put(key, item);
		}
		Map<String, Integer> map = item.getStringvalue();
		if (map == null) {
			map = new ConcurrentHashMap<String, Integer>();
			item.setStringvalue(map);
		}
		for (String id : list) {
			Integer v = map.get(id);
			map.put(id, v == null ? 1 : v + 1);
		}
		if (now - item.getTime().longValue() > REDIS_INTERVAL) {
			Map<String, Integer> valueMap = new HashMap<String, Integer>(map);
			map.clear();
			writeRedisString(null, valueMap, key, liveTime);
			item.setTime(now);
		}
		if (addEndTime < now)// 零点写缓存清空
		{
			addEndTime = DateUtil.endTime();
			Map<String, RedisItem> valueMap = new HashMap<String, RedisItem>(addMap);
			addMap.clear();
			writeRedisString(valueMap, null, key, liveTime);
		}
	}

	public static void writeRedis(Map<String, RedisItem> addMap, Map<Long, Integer> map, String key, int liveTime) {

		WriteRedisHincrBy wr = new RedisUtil().new WriteRedisHincrBy(addMap, map, key, liveTime);
		ThreadPoolService.getInstance().execute(wr);
	}

	public static void writeRedisString(Map<String, RedisItem> addMap, Map<String, Integer> map, String key, int liveTime) {

		WriteRedisHincrByString wr = new RedisUtil().new WriteRedisHincrByString(addMap, map, key, liveTime);
		ThreadPoolService.getInstance().execute(wr);
	}

	/**
	 * 异步
	 * 
	 */
	private class WriteRedisHincrBy implements Runnable {

		private Map<String, RedisItem> addMap;
		private Map<Long, Integer> map;
		private String key;
		private int liveTime;

		public WriteRedisHincrBy(Map<String, RedisItem> addMap, Map<Long, Integer> map, String key, int liveTime) {
			this.addMap = addMap;
			this.map = map;
			this.key = key;
			this.liveTime = liveTime;
		}

		public void run() {
			if (this.map != null) {
				for (Entry<Long, Integer> e : map.entrySet()) {
					Integer v = e.getValue();
					String k = String.valueOf(e.getKey());
					RedisFactory.hincrBy(key, k, v, liveTime);
				}
				this.map = null;
			}

			if (this.addMap != null) {
				Map<Long, Integer> map2;
				for (Entry<String, RedisItem> e : addMap.entrySet()) {
					RedisItem v = e.getValue();
					map2 = v.getValue();
					if (map2 != null) {
						for (Entry<Long, Integer> e2 : map2.entrySet()) {
							Integer v2 = e2.getValue();
							String k2 = String.valueOf(e2.getKey());
							RedisFactory.hincrBy(key, String.valueOf(k2), Long.valueOf(v2), liveTime);
						}
					}
				}
				this.addMap = null;
			}

		}

	}

	/**
	 * 异步key为String
	 * 
	 */
	private class WriteRedisHincrByString implements Runnable {

		private Map<String, RedisItem> addMap;
		private Map<String, Integer> map;
		private String key;
		private int liveTime;

		public WriteRedisHincrByString(Map<String, RedisItem> addMap, Map<String, Integer> map, String key, int liveTime) {
			this.addMap = addMap;
			this.map = map;
			this.key = key;
			this.liveTime = liveTime;
		}

		public void run() {
			if (this.map != null) {
				for (Entry<String, Integer> e : map.entrySet()) {
					Integer v = e.getValue();
					String k = String.valueOf(e.getKey());
					RedisFactory.hincrBy(key, k, v, liveTime);
				}
				this.map = null;
			}

			if (this.addMap != null) {
				Map<String, Integer> map2;
				for (Entry<String, RedisItem> e : addMap.entrySet()) {
					RedisItem v = e.getValue();
					map2 = v.getStringvalue();
					if (map2 != null) {
						for (Entry<String, Integer> e2 : map2.entrySet()) {
							Integer v2 = e2.getValue();
							String k2 = String.valueOf(e2.getKey());
							RedisFactory.hincrBy(key, String.valueOf(k2), Long.valueOf(v2), liveTime);
						}
					}
				}
				this.addMap = null;
			}

		}

	}
}
