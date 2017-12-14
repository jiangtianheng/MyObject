package com.turing.cache.key;

public interface CacheKeyDic {

	/** 1分钟过期 */
	public final int ONE_MINUTE = 60;
	/** 1小时过期 */
	public final int ONE_HOUR = 60 * 60;
	/** 1天过期 */
	public final int ONE_DAY = 60 * 60 * 24;
	/** 1周过期 */
	public final int ONE_WEEK = 60 * 60 * 24 * 7;
	/** 1月过期 */
	public final int ONE_MONTH = 60 * 60 * 24 * 30; // 最大不能超过30天
	/** 永不过期 */
	public final int ALWAYS = 0;

	public final String UNION_OFFLINEAD_CLICK_COUNT = "unino_offlineAd_click_country_";
	public final String UNION_AD_CLICK_REDIS_COUNT = "unino_ad_click_redis_count_";
	public final String UNION_AD_POSTBACK_REDIS_COUNT = "unino_ad_postback_redis_count_";
	public final String AD_CONTROL_CR = "AD_CONTROL_CR_";
	public final String UNION_AD_INFO_MEM = "union_ad_info_mem_";
	public final String UNION_AD_INFO_REDIS = "union_ad_info_redis_";
	// 根据设备记录点击
	public final String UNION_ADOS_CLICK_REDIS_COUNT = "unino_adOS_clickCount_";
	// 根据渠道记录点击
	public final String PROVIDER_ADOS_CLICK_REDIS_COUNT = "Provider_adOS_clickCount_";
}
