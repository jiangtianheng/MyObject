package com.cappuccino.offer.cache.redis;

import java.util.Map;

public class RedisItem
{
    private Map<Long, Integer> value;
    
    
    
    private Long               time;
    private Map<String, Integer> Stringvalue;
    public Map<Long, Integer> getValue()
    {
        return value;
    }

    public void setValue(Map<Long, Integer> value)
    {
        this.value = value;
    }

    public Long getTime()
    {
        return time;
    }

    public void setTime(Long time)
    {
        this.time = time;
    }

	public Map<String, Integer> getStringvalue() {
		return Stringvalue;
	}

	public void setStringvalue(Map<String, Integer> stringvalue) {
		Stringvalue = stringvalue;
	}

}
