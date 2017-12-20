package com.cappuccino.util;

public interface GlobalConst
{

    final int NETWORK_UNKOWN = 0;
    static int NETWORK_WIFI = 1;
    static int NETWORK_2G = 2;
    static int NETWORK_3G = 3;
    static int NETWORK_LTE = 4;

    // http://cappuccinocreative.com/submanage/images/cappuccino.png
    // 默认图标
    final String icon = "http://cappuccinocreative.com/submanage/images/cappuccino.png";
    final int AUTO = 0;
    // --------------网盟 ad type--------------
    // 支付方式 0:CPI、1:CPA
    final int CPI = 0;//
    final int CPA = 1;//
    // ---------------incentive-----------------
    /**
     * 0:默认 1:激励、2:非激励 "incentive": "Non Incentive",
     */
    final int Incentive = 0;
    final int Non_Incentive = 2;
    // ---------------osMinVersion----------------------------
    /**
     * 客户端最低版本
     */
    final int MinVersion4 = 0;

    // -----------调用方法----------------------------------

    final int CALL_WORK = 1;// 执行work方法

    // ---------------------------ARTOFCLICK------------------

    final int avazu_template = 1;
    final int solo_template = 2;

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
    final int OFFER_OS_ANDROID = 1;
    final int OFFER_OS_IOS = 2;
    final String IOS = "IOS";
    final String ANDROID = "ANDROID";

    /** 支付价格比率 */
    final float PAY_OUT_RATE = 0.8f;
    
    final String USER_KEY = "user_key_";

}
