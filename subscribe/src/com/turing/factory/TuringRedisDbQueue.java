package com.turing.factory;

import com.alibaba.fastjson.JSON;

public class TuringRedisDbQueue
{
    private static TuringRedisDbQueue instance       = null;

    public static TuringRedisDbQueue getInstance()
    {
        if (instance == null)
        {
            instance = new TuringRedisDbQueue();
        }
        return instance;
    }

    public Long push(String key, Object obj)
    {
        return TuringRedisFactory.lpush(key, toJson(obj));
    }

    public String toJson(Object obj)
    {
        return JSON.toJSONString(obj);
    }

}
