package com.turing.factory;

public class TuringEnum {
	public final static int NETWORK_UNKOWN = 0;
	public final static int NETWORK_WIFI = 1;
	public final static int NETWORK_2G = 2;
	public final static int NETWORK_3G = 3;
	public final static int NETWORK_LTE = 4;
	public final static int BATCH_NUM = 1000;
	public final static int MOVIES_TYPE_HOME = 0;
	public final static int MOVIES_TYPE_HOTS = 1;

	public final static int ADS_TYPE_DEFAULT = 0;
	public final static int ADS_TYPE_QUICK = 1;

	public final static int AD_APK = 1;
	public final static int AD_APK_TRACK = 2;
	public final static int AD_AFFLIATE = 3;

	// redis缓存每个id对应一个广告
	public final static String REDIS_KEY_DB_ID_KEYS = "REDIS_KEY_DB_ID_KEYS";
	// redis缓存
	public final static String REDIS_ADDB_ALLKEYS = "REDIS_ADDB_ALLKEYS";
	public final static String REDIS_KEY_DB_COUNTRY = "redis_db_country_zl";
	public final static String REDIS_KEY_DB_COUNTRY_KEYS = "redis_db_country_keys_zl";
	public final static String REDIS_KEY_POP_COUNTRY = "redis_pop_country_zl";// icon
	public final static String REDIS_KEY_POP_COUNTRY_KEYS = "redis_pop_country_keys_zl";// icon_country

	public final static String REDIS_ALL_KEYS_SUPERVISORS = "REDIS_ALL_KEYS_SUPERVISORS";
	public final static String REDIS_KEYS_SUPERVISORS = "REDIS_KEYS_SUPERVISORS";
}
