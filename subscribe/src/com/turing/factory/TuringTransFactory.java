package com.turing.factory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.tran.TuringBaseTrans;

public class TuringTransFactory {

	public static RequestBean getReqBean(final HttpServletRequest request) throws Exception {
		int src = TuringSrcFactory.getSrc(request);
		TuringBaseTrans baseTrans = getTrans(src);
		RequestBean bean = null;
		try {
			if (baseTrans != null) {
				bean = baseTrans.getReqBean(request, src);
			} else {
				bean = new RequestBean(false);
			}
			if (bean != null) {
				bean.setReqType(src);
				bean.setSrc(src);
				bean.setIp(getIpAddr(request));
			}
		} catch (Exception e) {
			throw e;
		}
		return bean;
	}

	/**
	 * 将处理结果返回给请求方
	 * 
	 * @throws Exception
	 */
	public static String outResBean(final HttpServletResponse response, ResponseBean bean) throws Exception {
		TuringBaseTrans baseTrans = getTrans(bean.getSrc());
		if (baseTrans != null) {
			return baseTrans.outResBean(response, bean);
		} else {
			return "";
		}
	}

	private static TuringBaseTrans getTrans(int src) {
		if (src < TuringSrcFactory.SRC_API_END) {
			return new TuringBaseTrans();
		}
		return null;
	}

	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
