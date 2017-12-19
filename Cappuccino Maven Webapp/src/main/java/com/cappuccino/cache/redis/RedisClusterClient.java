package com.cappuccino.cache.redis;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cappuccino.cache.key.KeyInfo;
import com.cappuccino.util.SpringHelper;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisClusterClient
{

    private static RedisConfig redisConfig = null;

    private static JedisCluster getInstance()
    {
        return RedisClusterClientHolder.jedisCluster;
    }

    /**
     * 防止高并发时创建多个pool
     * 
     * @author thj
     * 
     */
    private static class RedisClusterClientHolder
    {
        private static JedisCluster jedisCluster = null;
        static
        {
            if (jedisCluster == null)
            {
                redisConfig = SpringHelper.getBean("redisConfig",
                        RedisConfig.class);
                Set<HostAndPort> nodes = new HashSet<HostAndPort>();
                nodes.add(new HostAndPort(redisConfig.getHost(), redisConfig
                        .getPort()));
                jedisCluster = new JedisCluster(nodes,
                        redisConfig.getTimeOut(),
                        redisConfig.getJedisPoolConfig());
            }
        }
    }

    /**
     * 从队列的左边取出一条数据
     * 
     * @param keyInfo
     * @return
     */
    public static String lpop(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            redis = getInstance();
            return redis.lpop(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从队列的右边取出一条数据
     * 
     * @param keyInfo
     * @return
     */
    public static String rpop(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            String key = keyInfo.getKey();
            redis = getInstance();
            return redis.rpop(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把一个值添加到对应列表中
     * 
     * @param keyInfo
     * @param index
     * @param value
     * @return
     */
    public static String lset(KeyInfo keyInfo, long index, String value)
    {
        JedisCluster redis = null;
        String result = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            redis = getInstance();
            result = redis.lset(key, index, value);
            if (expire > 0)
                redis.expire(key, expire);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 把数据添加到一个列表中
     * 
     * @param keyInfo
     * @param values
     * @return
     */
    public static Long lpush(KeyInfo keyInfo, String... values)
    {
        JedisCluster redis = null;
        Long result = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            redis = getInstance();
            result = redis.lpush(key, values);
            if (expire > 0)
                redis.expire(key, expire);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除列表中多少个对应值的元素
     * 
     * @param key
     * @param count
     * @param value
     * @return
     */
    public static Long lrem(KeyInfo keyInfo, long count, String value)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.lrem(key, count, value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回指定列表范围内的元素
     * 
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(KeyInfo keyInfo, long start, long end)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.lrange(key, start, end);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Long llen(String key)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            return redis.llen(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key删除
     * 
     * @param key
     */
    public static void del(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            redis.del(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 添加key value
     * 
     * @param key
     * @param value
     */
    public static void set(KeyInfo keyInfo, String value)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            redis.set(key, value);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取redis value (String)
     * 
     * @param key
     * @return
     */
    public static String get(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.get(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key，filed从hash中获取值
     * 
     * @param keyInfo
     * @param field
     * @return
     */
    public static String hget(KeyInfo keyInfo, String field)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.hget(key, field);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key，filed往hash中添加值
     * 
     * @param keyInfo
     * @param field
     * @param value
     * @return
     */
    public static long hset(KeyInfo keyInfo, String field, String value)
    {
        JedisCluster redis = null;
        long result = 0;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            result = redis.hset(key, field, value);
            if (expire > 0)
                redis.expire(key, expire);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过key，多个filed从hash中获取值
     * 
     * @param keyInfo
     * @param fields
     * @return
     */
    public static List<String> hmget(KeyInfo keyInfo, String... fields)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.hmget(key, fields);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key往hash添加多个值
     * 
     * @param keyInfo
     * @param value
     * @return
     */
    public static String hmset(KeyInfo keyInfo, Map<String, String> value)
    {
        JedisCluster redis = null;
        String result = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            result = redis.hmset(key, value);
            if (expire > 0)
                redis.expire(key, expire);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key，filed从hash中删除
     * 
     * @param keyInfo
     * @param field
     * @return
     */
    public static long hdel(KeyInfo keyInfo, String field)
    {
        JedisCluster redis = null;
        long result = 0;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            result = redis.hdel(key, field);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 通过key获取hash中全部元素
     * 
     * @param keyInfo
     * @return
     */
    public static Map<String, String> hgetAll(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.hgetAll(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key，field往hash中计数一次
     * 
     * @param keyInfo
     * @param field
     * @param value
     * @return
     */
    public static long hincrBy(KeyInfo keyInfo, String field, long value)
    {
        JedisCluster redis = null;
        long result = 0;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            result = redis.hincrBy(key, field, value);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过key计数计数一次
     * 
     * @param keyInfo
     * @return
     */
    public static long incr(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        long result = 0;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            result = redis.incr(key);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过key计数计数几次
     * 
     * @param key
     * @param incr
     * @param liveTime
     */
    public static long incrBy(KeyInfo keyInfo, long incr)
    {
        JedisCluster redis = null;
        long result = 0;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            result = redis.incrBy(key, incr);
            redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过key往set添加数据
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void sadd(KeyInfo keyInfo, String member)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            redis.sadd(key, member);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 通过key往set添加数据
     * 
     * @param key
     * @param value
     */
    public static void sadd(KeyInfo keyInfo, String... value)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            int expire = keyInfo.getExpire();
            redis.sadd(key, value);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 通过key获取set中所有数据
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static Set<String> smember(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            String key = keyInfo.getKey();
            redis = getInstance();
            return redis.smembers(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过key判断set中是否有对应数据
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static Boolean sismember(KeyInfo keyInfo, String member)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.sismember(key, member);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * set集合的长度
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static long scard(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.scard(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 检查key是否已经存在
     * 
     * @param key
     * @return
     */
    public static Boolean exists(KeyInfo keyInfo)
    {
        JedisCluster redis = null;
        try
        {
            redis = getInstance();
            String key = keyInfo.getKey();
            return redis.exists(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
