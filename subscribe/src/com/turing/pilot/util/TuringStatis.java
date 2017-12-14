package com.turing.pilot.util;

import java.util.Date;

import com.turing.factory.TuringRedisFactory;

public class TuringStatis
{
    private static TuringStatis instance            = null;

    private static final String  REDIS_KEY_PREFIX    = "overseapay-redis-statis#";

    private static final String  ADD_USER_KEY        = REDIS_KEY_PREFIX
                                                             + "adduser#";
    private static final String  ACTIVE_USER_KEY     = REDIS_KEY_PREFIX
                                                             + "activeuser#";

    // minutes
    private static long          startTime           = 0L;
    private static long          endTime           = 0L;
    
    public static TuringStatis getInstance()
    {
        if (instance == null)
        {
            instance = new TuringStatis();
        }
        return instance;
    }

    private static void checkTime()
    {
        long now = new Date().getTime();
        if (now > endTime)
        {
            startTime = TuringDateUtil.startTime();
            endTime = TuringDateUtil.endTime();
        }
    }
    
    public static void addUser(String channel, String appid, String country,
            String clientid, Boolean isnew)
    {
        checkTime();
        
        String key = startTime + "#" + channel + "#" + appid + "#" + country;
        
        TuringRedisFactory.sadd(ADD_USER_KEY + key, clientid,
                    TuringRedisFactory.ONE_MONTH);
        TuringRedisFactory.sadd(ACTIVE_USER_KEY + key, clientid,
                TuringRedisFactory.ONE_MONTH);
    }
}
