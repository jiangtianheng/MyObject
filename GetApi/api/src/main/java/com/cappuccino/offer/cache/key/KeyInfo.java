package com.cappuccino.offer.cache.key;

public class KeyInfo {
	/**key*/
	private String key;
	/**过去时间*/
	private int expire;
	
	public KeyInfo(String key,int expire){
		this.key = key;
		this.expire = expire;
	}
	
	public KeyInfo keyAppend(String str){
		this.key = this.key+str;
		return this;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getExpire() {
		return expire;
	}
	public void setExpire(int expire) {
		this.expire = expire;
	}
	
	
}
