package com.cappuccino.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;

public class RedisCacheTransfer
{
    @Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
