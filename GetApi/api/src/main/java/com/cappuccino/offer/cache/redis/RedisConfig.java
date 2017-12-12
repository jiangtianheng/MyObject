package com.cappuccino.offer.cache.redis;

import redis.clients.jedis.JedisPoolConfig;

public class RedisConfig {

	private JedisPoolConfig jedisPoolConfig;
	private String host;
	private int port;
	private int timeOut;
	
	public JedisPoolConfig getJedisPoolConfig() {
		return jedisPoolConfig;
	}
	public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
		this.jedisPoolConfig = jedisPoolConfig;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}
	


}
