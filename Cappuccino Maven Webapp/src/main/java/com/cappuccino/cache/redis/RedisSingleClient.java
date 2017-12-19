package com.cappuccino.cache.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cappuccino.cache.key.KeyInfo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SuppressWarnings("deprecation")
public class RedisSingleClient
{

    private static RedisConfig redisConfig = null;

    public void setRedisConfig(RedisConfig config)
    {
        redisConfig = config;
    }

    private static JedisPool getInstance()
    {
        return RedisSingleClientHolder.jedisPool;
    }

    private static class RedisSingleClientHolder
    {
        private static JedisPool jedisPool = null;
        static
        {
            jedisPool = new JedisPool(redisConfig.getJedisPoolConfig(),
                    redisConfig.getHost(), redisConfig.getPort());
        }
    }

    /**
     * 从指定的列表右边出队,添加到目的列表中
     * 
     * @param srckey
     *            源列表
     * @param dstkey
     *            　目的列表
     * @return
     */
    public static String rpoppush(String srckey, String dstkey)
    {
        JedisPool pool = getInstance();
        Jedis redis = null;

        try
        {
            redis = pool.getResource();
            return redis.rpoplpush(srckey, dstkey);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 从队列的左边取出一条数据
     * 
     * @param key
     *            　列表名
     * @return
     */
    public static String lpop(KeyInfo keyInfo)
    {
        JedisPool pool = getInstance();
        Jedis redis = null;
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.lpop(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 从队列的右边取出一条数据
     * 
     * @param key
     *            列表名
     * @return
     */
    public static String rpop(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.rpop(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 把一个值添加到对应列表中
     * 
     * @param key
     *            列表名
     * @param index
     *            　添加的位置
     * @param value
     *            　数据
     * @return
     */
    public static String lset(KeyInfo keyInfo, long index, String value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.lset(key, index, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Long lpush(KeyInfo keyInfo, String value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            String[] strs = new String[1];
            strs[0] = value;
            long ret = redis.lpush(key, strs);
            if (expire > 0)
                redis.expire(key, expire);
            return ret;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 把所有数据添加到一个列表中,并且设置列表的存活时间
     * 
     * @param key
     *            列表名
     * @param values
     *            数据
     * @param liveTime
     *            存活时间--单位(秒)
     * @return
     */
    public static Long lpush(KeyInfo keyInfo, String[] values)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            Long result = redis.lpush(key, values);
            if (expire > 0)
                redis.expire(key, expire);
            return result;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 删除列表中对应值的元素
     * 
     * @param key
     *            列表名
     * @param count
     *            删除多少个相同的元素
     * @param value
     *            数据
     * @return
     */
    public static Long lrem(KeyInfo keyInfo, long count, String value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.lrem(key, count, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 返回指定列表范围内的元素
     * 
     * @param key
     *            列表名
     * @param start
     *            开始位置
     * @param end
     *            结束位置
     * @return
     */
    public static List<String> lrange(KeyInfo keyInfo, long start, long end)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.lrange(key, start, end);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Long llen(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.llen(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
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
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            redis.del(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 添加key value 并且设置存活时间
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void set(KeyInfo keyInfo, String value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            redis.set(key, value);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
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
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            String value = redis.get(key);
            return value;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static String hget(KeyInfo keyInfo, String field)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.hget(key, field);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static long hset(KeyInfo keyInfo, String field, String value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            long ret = redis.hset(key, field, value);
            if (expire > 0)
                redis.expire(key, expire);
            return ret;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return 0;
    }

    public static long hdel(KeyInfo keyInfo, String field)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            long ret = redis.hdel(key, field);
            return ret;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return 0;
    }

    public static String hmset(KeyInfo keyInfo, Map<String, String> map)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            String ret = redis.hmset(key, map);
            if (expire > 0)
                redis.expire(key, expire);
            return ret;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static Map<String, String> hgetAll(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.hgetAll(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static List<String> hmget(KeyInfo keyInfo, String... fields)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.hmget(key, fields);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 通过正则匹配keys
     * 
     * @param pattern
     * @return
     */
    public static Set<String> keys(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.keys(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static long hincrBy(KeyInfo keyInfo, String field, long value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        long ret = 0L;
        try
        {
            redis = pool.getResource();
            ret = redis.hincrBy(key, field, value);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return ret;
    }

    public static Long publish(KeyInfo keyInfo, String message)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.publish(key, message);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    public static void incr(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            redis.incr(key);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    public static void incrBy(KeyInfo keyInfo, long incr)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            redis.incrBy(key, incr);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void sadd(KeyInfo keyInfo, String member)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            redis.sadd(key, member);
            if (expire > 0)
                redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static Set<String> smember(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.smembers(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static Boolean sismember(KeyInfo keyInfo, String member)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.sismember(key, member);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return false;
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static long scard(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        try
        {
            redis = pool.getResource();
            return redis.scard(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return 0;
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static Set<String> sunion(String... keys)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.sunion(keys);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static long sunionstore(String dstkey, String... keys)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.sunionstore(dstkey, keys);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return 0;
    }

    /**
     * 添加key value 并且设置存活时间
     * 
     * @param key
     * @param value
     * @param liveTime
     */
    public static void expire(KeyInfo keyInfo)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        String key = keyInfo.getKey();
        int expire = keyInfo.getExpire();
        try
        {
            redis = pool.getResource();
            redis.expire(key, expire);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    /**
     * 检查key是否已经存在
     * 
     * @param key
     * @return
     */
    public static Boolean exists(String key)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.exists(key);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 清空redis 所有数据
     * 
     * @return
     */
    public static String flushDB()
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.flushDB();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;

    }

    /**
     * 查看redis里有多少数据
     */
    public static Long dbSize()
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.dbSize();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    /**
     * 检查是否连接成功
     * 
     * @return
     */
    public static String ping()
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            return redis.ping();
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    // 加入对集合set的操作的，添加一个值
    public static void setSetAdd(String key, String... value)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            redis.sadd(key, value);
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
    }

    // smembers(key) ：返回名称为key的set的所有元素

    public static Set<String> getSetmembers(String key)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            Set<String> value = redis.smembers(key);
            return value;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return null;
    }

    // sismember(key, member) ：测试member是否是名称为key的set的元素
    public static Boolean getIsSetmembers(String key, String member)
    {
        Jedis redis = null;
        JedisPool pool = getInstance();
        try
        {
            redis = pool.getResource();
            Boolean value = redis.sismember(key, member);
            return value;
        }
        catch (Exception e)
        {
            pool.returnBrokenResource(redis);
            e.printStackTrace();
        }
        finally
        {
            pool.returnResource(redis);
        }
        return false;
    }

}
