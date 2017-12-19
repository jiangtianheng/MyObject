package com.cappuccino.cache.key;

public interface CacheKeyDic {
	
	/**1分钟过期*/
	public final int ONE_MINUTE = 60;
	/**1小时过期*/
	public final int ONE_HOUR = 60 * 60;
	/**1天过期*/
	public final int ONE_DAY = 60 * 60 * 24;
	/**1周过期*/
	public final int ONE_WEEK = 60 * 60 * 24 * 7;
	/**1月过期*/
	public final int ONE_MONTH = 60 * 60 * 24 * 30; // 最大不能超过30天
	/**永不过期*/
	public final int ALWAYS = 0;
	
}
