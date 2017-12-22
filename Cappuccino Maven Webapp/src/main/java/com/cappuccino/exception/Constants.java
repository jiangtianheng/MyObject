package com.cappuccino.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常信息
 */
public class Constants {

	public static Map<String, String> EXCEPTION_MAP = new HashMap<String, String>();

	static {

		EXCEPTION_MAP.put("400", "Bad Request!");
		EXCEPTION_MAP.put("401", "NotAuthorization");
		EXCEPTION_MAP.put("405", "Method Not Allowed");
		EXCEPTION_MAP.put("406", "Not Acceptable");
		EXCEPTION_MAP.put("500", "Internal Server Error");

		EXCEPTION_MAP.put("1001", "缺少参数或值为空");
		EXCEPTION_MAP.put("1002", "参数不合法");
		EXCEPTION_MAP.put("1003", "无效的Token");
		EXCEPTION_MAP.put("1004", "无操作权限");
	}

	/** 传入参数为空 */
	public static final Integer ex_code_1 = 1001;

	/** 参数不合法 */
	public static final Integer ex_code_2 = 1002;
}
