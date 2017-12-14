package com.turing.factory;

import javax.servlet.http.HttpServletRequest;

public class TuringSrcFactory {
	public final static int SRC_GEN_DEVICE = 1; //
	public final static int SRC_API_END = 1000000;
	public final static int SRC_GET_OFFER = 1001; //
	
	
	public final static int SRC_PULL_OFFER = 2001; //
	
	
	/**
	 * 根据请求的URL来判断来源
	 */
	public static int getSrc(final HttpServletRequest request) {
		String src = request.getRequestURI().substring(request.getContextPath().length());
		if (src.contains("api")) {
			int startIndex = src.indexOf("api/") + 4;
			int endIndex = src.lastIndexOf('/');
			if (startIndex >= endIndex) {
				endIndex = src.length();
			}
			src = src.substring(startIndex, endIndex);
			int ret = Integer.valueOf(src).intValue();
			return ret;
		}
		return SRC_GEN_DEVICE;
	}
}
