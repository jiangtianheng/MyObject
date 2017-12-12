package com.cappuccino.offer.cache.memcache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.log4j.Logger;

import com.cappuccino.offer.cache.key.KeyInfo;
import com.cappuccino.offer.util.SpringHelper;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class MemCacheFactory {

	private static Logger logger = Logger.getLogger(MemCacheFactory.class);

	private static MemcachedClient cacheClient = null;

	public static MemcachedClient getInstance() {
		if (cacheClient == null) {
			cacheClient = SpringHelper.getBean("memcachedClient", MemcachedClient.class);
		}
		return cacheClient;
	}

	public static void setMemcachedClient(MemcachedClient cachedClient) {
		if (cachedClient != null) {
			cacheClient = cachedClient;
		}
	}

	/**
	 * 缓存对象
	 * */
	public static void add(KeyInfo keyInfo, Object obj) {
		MemcachedClient memcache = getInstance();
		try {
			String key = keyInfo.getKey();
			int expire = keyInfo.getExpire();
			memcache.add(key, expire, obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 获取对象
	 * */
	public static Object get(KeyInfo keyInfo) {
		MemcachedClient memcache = getInstance();
		Object obj = null;
		try {
			String key = keyInfo.getKey();
			if (memcache != null) {
				obj = memcache.get(key);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return obj;
	}

	/**
	 * 删除对象
	 * */
	public static void delete(KeyInfo keyInfo) {
		MemcachedClient memcache = getInstance();
		try {
			String key = keyInfo.getKey();
			if (memcache != null) {
				memcache.delete(key);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * 清除所有缓存
	 */
	public static void flushAll() {
		MemcachedClient memcache = getInstance();
		try {
			if (memcache != null) {
				memcache.flushAll();
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * add((序列化通过Kryo))
	 * 
	 * @param key
	 * @param exp
	 * @param value
	 */
	public static void addByKryo(KeyInfo keyInfo, Object value) {
		MemcachedClient memcache = getInstance();
		String key = keyInfo.getKey();
		int exp = keyInfo.getExpire();
		try {
			byte[] b = encode(value);
			memcache.add(key, exp, b);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * get(序列化通过Kryo)
	 * 
	 * @param <T>
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> T getByKryo(String key, Class<T> clazz) {
		MemcachedClient memcache = getInstance();
		T t = null;
		try {
			byte[] b = memcache.get(key);
			t = decode(b, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * 将对象序列化成二进制流
	 * 
	 * @param out
	 * @param o
	 * @param clazz
	 * @throws IOException
	 */
	private static byte[] encode(Object o) {
		Output output = null;
		byte[] result = null;
		try {
			// 序列化
			Kryo kryo = new Kryo();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			output = new Output(baos);
			kryo.writeObject(output, o);
			output.flush();
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (output != null) {
				output.close();
			}
		}
		return result;

	}

	/**
	 * 将二进制流反序列化成对象
	 * 
	 * @param in
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	private static <T> T decode(byte[] o, Class<T> clazz) {
		if (o == null || o.length <= 0)
			return null;
		Input input = null;
		T t = null;
		try {
			// 反序列化
			Kryo kryo = new Kryo();
			ByteArrayInputStream bais = new ByteArrayInputStream(o);
			input = new Input(bais);
			t = kryo.readObject(input, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return t;
	}

	public static void main(String[] args) {
		String countries="CN:JP";
		String geo = "KR:JP:US:TW:CN";
		if (!geo.contains(countries)) {
			System.out.println("**********");
		}
		if (countries.length() > 6) {
			System.out.println("******111****");
		}
	  }

}
