package com.cappuccino.offer.cache.key;

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

	/** status为0的全部offer对应key */
	public final String REDIS_KEY_DB_COUNTRY_KEYS = "redis_db_country_keys";

	/** status为0的对应国家的offer */
	public final String REDIS_KEY_DB_COUNTRY = "redis_db_country";

	/** status为0的全部ios offer对应key */
	public final String REDIS_IOS_KEY_DB_COUNTRY_KEYS = "redis_ios_db_country_keys";

	/** status为0的全部ios offer */
	public final String REDIS_IOS_KEY_DB_ALL = "redis_ios_db_all";

	/**
	 * 每个网盟用户对应的广告key+userid
	 */
	public final String UNION_AD_INFO_REDIS = "union_ad_info_redis_";

	/** status为0的对应国家的ios offer */
	public final String REDIS_IOS_KEY_DB_COUNTRY = "redis_ios_db_country";

	/** provider id对应数据key */
	public final String CACHE_KEY_PROVIDER_ID = "provider_id_";
	/** is not null cap provider */
	public final String CACHE_KEY_PROVIDER_CAPSIN = "provider_capsin";

	public final String CACHE_KEY_AD_TYPE_PROVIDER = "ad_type_provider_";
	/** 数据库中国家信息 */
	public final String CACHE_KEY_COUNTRY_ALL = "db_country_all";

	/** cps offer 对应的operator 运营商 */
	public final String CACHE_KEY_OPERATOR_ID = "operator_id_";
	public final String CACHE_KEY_OPERATOR_ALL = "operator_id_all";
	/** cps offer 对应的os 系统名称 */
	public final String CACHE_KEY_OS_ID = "os_id_";
	public final String CACHE_KEY_OS_ALL = "os_id_all";

	/** 渠道点击 */
	public final String UNION_AD_CLICK_REDIS_COUNT = "unino_ad_click_redis_count_";
	/** 渠道转化 */
	public final String UNION_AD_POSTBACK_REDIS_COUNT = "unino_ad_postback_redis_count_";
}
