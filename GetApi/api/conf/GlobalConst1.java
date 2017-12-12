
public interface GlobalConst1 {

	final int NETWORK_UNKOWN = 0;
	static int NETWORK_WIFI = 1;
	static int NETWORK_2G = 2;
	static int NETWORK_3G = 3;
	static int NETWORK_LTE = 4;

	// --------------网盟 ad type--------------
	final int android = 1;// webeye和常春系统
	final int cps = 2;
	final int ios = 3;
	final int myandroid = 4;// 自己接的联盟
	// ---------------ad type-----------------
	/** apk下载广告 */
	final int AD_APK = 1;
	/** yeahmobi模拟googleplay广告 */
	final int AD_YEAHMOBI = 2;
	/** 联盟广告 */
	final int AD_AFFLIATE = 3;
	/** google */
	final int AD_GOOGLEPLAY = 4;
	/** google */
	final int AD_GOOGLEPLAY_QUICK = 5;
	/** 自己提供apk的方式，但是需要点击track的地址来反馈的 */
	final int AD_APK_TRACK = 6;
	final int AD_APK_TAPJOY = 7;
	/** 需要手机端于服务器比对获取交集。特点：track地址变化。Tapjoy,Applift */
	final int AD_APK_TRACKCLICK = 8;

	/** cps广告类型 */
	final int AD_TYPE_CPS = 2;

	// -----------调用方法----------------------------------

	final int CALL_WORK = 1;// 执行work方法
	final int POST_CALL_BACK = 2;// 执行postCallBack

	// ---------------------------ARTOFCLICK------------------

	final int Api_2000_YeahmobiOffer_wawayu9827 = 2000;
	final int Api_2001_YeahmobiOffer_openmidea = 2001;
	final int Api_2002_YM_API_rpxymidea = 2002;
	final int Api_1020_AppliftOffer = 1020;
	final int Api_1022_StartAppOffer = 1022;
	final int Api_1023_HuijuCXAppOffer = 1023;
	final int Kingsgame_InmobiTaptica = 1025;
	final int Kingsgame_InmobiSonic = 1026;
	final int Api_1027_Adcamie = 1027;
	final int Api_1029_AppSnt = 1029;
	final int Api_1030_Adcamie = 1030;
	final int Api_1031_Soloaware = 1031;
	final int Api_1032_MobiSummerOffer = 1032;
	final int Api_1035_Codrim = 1035;
	final int Api_1036_Gameberry = 1036;

	// ----------------subway(用于区分回调来着哪)----------------------------

	final int SUBWAY_DEFAULT = 0;
	final int SUBWAY_ZL = 1;//

	// ----------第几套拉取offer-----------
	/** 第一套 */
	final int OFFER_VERSION_1 = 1;
	/** 第二套 */
	final int OFFER_VERSION_2 = 2;
	/** 第三套 */
	final int OFFER_VERSION_3 = 3;

	// ---------------offer的类型-------------------
	final String OFFER_OS_IOS = "ios";
	final String OFFER_OS_ANDROID = "android";

	/** 支付价格比率 */
	final float PAY_OUT_RATE = 0.8f;

}
