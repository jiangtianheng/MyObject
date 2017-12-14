package com.turing.log;

import java.util.Date;

import org.apache.log4j.Logger;

import com.turing.factory.TuringSrcFactory;
import com.turing.factory.TuringTag;
import com.turing.pilot.bean.RequestBean;
import com.turing.pilot.bean.ResponseBean;
import com.turing.util.TuringUtil;

public class TuringLog {
	// subtraction
	protected static final Logger CLIENT_REQ_LOG = Logger.getLogger("client"); // 客户端请求
	protected static final Logger ADMIN_REQ_LOG = Logger.getLogger("admin"); // 管理后台
	protected static final Logger USER_ERROR_LOG = Logger.getLogger("runerror"); // 运行错误
	protected static final Logger MOBILE_LOG = Logger.getLogger("mobile"); // 无法识别的手机短信中心号

	protected static final Logger subtraction = Logger.getLogger("subtraction"); // 减数3002
	protected static final Logger TEST = Logger.getLogger("test"); // 测试

	protected static final Logger LOG4J = Logger.getLogger("log4j"); // 测试

	protected static final Logger REQUESTDATA = Logger.getLogger("requestData");// 获取请求数据
	// protected static final Logger RUNNERERROR=Logger.getLogger("runerror");

	protected static final Logger LOG3001 = Logger.getLogger("log3001"); // 3001
	protected static final Logger LOG3002 = Logger.getLogger("log3002"); // 3002
	protected static final Logger LOG3003 = Logger.getLogger("log3003"); // 3003
	protected static final Logger LOG3004 = Logger.getLogger("log3004"); // 3004
	protected static final Logger LOG3005 = Logger.getLogger("log3005"); // 3005

	protected static final Logger ADS_LOG = Logger.getLogger("ads"); // getAds3
	protected static final Logger iCON_LOG = Logger.getLogger("icon"); // icon
	
	/**
	 * SUBTRACTION3002
	 */
	protected static final Logger FEEDBACK_LOG = Logger.getLogger("feedback");
	protected static final Logger EXCEPTION_LOG = Logger.getLogger("exception");

	private static final int BUFFER_SIZE = 1024;

	public final static int ERROR_LOG = 1;
	public final static int ADMIN_LOG = 2;
	public final static int CLIENT_LOG = 3;

	public static void log(RequestBean request, ResponseBean response, String result, long totaltime) {
		if (request.getSrc() < TuringSrcFactory.SRC_API_END) {
			clientLog(request, response, result, totaltime);
		}
	}

	private static void errorLog(RequestBean request, ResponseBean response, String result, long totaltime) {
		StringBuffer sb = new StringBuffer(BUFFER_SIZE);
		sb.append(TuringUtil.getDateFormatString(new Date(), 4));
		sb.append("|");
		sb.append(request.getIp());
		sb.append("|");
		sb.append(request.getSrc());
		sb.append("|");
		sb.append(request.getValue(TuringTag.devid));
		sb.append("|");
		sb.append(request.getValue(TuringTag.channel));
		sb.append("|");
		sb.append(request.getValue(TuringTag.network));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imei));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imsi));
		sb.append("|");
		sb.append(request.toString());
		sb.append("|");
		sb.append(response.toString());
		sb.append("|");
		sb.append(totaltime);
		sb.append("|");
		sb.append(result);
		USER_ERROR_LOG.error(sb.toString());
	}

	public static void log(Exception e) {
		USER_ERROR_LOG.error("error", e);
	}

	// public static void mobilelog(Long mobile)
	// {
	// MOBILE_LOG.info(mobile);
	// }

	/**
	 * 客户端支付请求日志
	 * */
	private static void clientLog(RequestBean request, ResponseBean response, String result, long totaltime) {
		if (request == null) {
			return;
		}

		StringBuffer sb = new StringBuffer(BUFFER_SIZE);
		sb.append(TuringUtil.getDateFormatString(new Date(), 4));
		sb.append("|");
		sb.append(request.getIp());
		sb.append("|");
		sb.append(request.getSrc());
		sb.append("|");
		sb.append(request.getValue(TuringTag.devid));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imsi));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imei));
		sb.append("|");
		sb.append(request.getValue(TuringTag.channel));
		sb.append("|");
		sb.append(request.getValue(TuringTag.network));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imei));
		sb.append("|");
		sb.append(request.getValue(TuringTag.imsi));
		sb.append("|");
		sb.append(request.toString());
		sb.append("|");
		sb.append(response.toString());
		sb.append("|");
		sb.append(totaltime);
		sb.append("|");
		sb.append(result);
		CLIENT_REQ_LOG.info(sb.toString());
	}

	// /**
	// * 执行效率日志
	// * */
	// private static void userAccessLog(RequestBean request, String resultcode,
	// String result, long totaltime)
	// {
	// if (request != null)
	// {
	// StringBuffer sb = new StringBuffer(BUFFER_SIZE);
	// sb.append(CommonUtil.getDateFormatString(new Date(), 4));
	// sb.append("|");
	// sb.append(request.getIp());
	// sb.append("|");
	// sb.append(request.getValue("imsi"));
	// sb.append("|");
	// sb.append(request.getValue("imei"));
	// sb.append("|");
	// sb.append(request.getValue("mac"));
	// sb.append("|");
	// sb.append(request.getReqType());
	// sb.append("|");
	// sb.append(resultcode);
	// sb.append("|");
	// sb.append(totaltime);
	// sb.append("|");
	// sb.append(request.toString());
	// sb.append("|");
	// sb.append(result);
	// USER_ACCESS_LOG.info(sb);
	// }
	// }

	/**
	 * 管理后台请求日志
	 * */
	private static void adminLog(RequestBean request, ResponseBean response, String result, long totaltime) {
		if (request == null) {
			return;
		}
		StringBuffer sb = new StringBuffer(BUFFER_SIZE);
		sb.append(TuringUtil.getDateFormatString(new Date(), 4));
		sb.append("|");
		sb.append(request.getIp());
		sb.append("|");
		sb.append(request.getSrc());
		sb.append("|");
		sb.append(request.getValue("session_uid"));
		sb.append("|");
		// sb.append(resultcode);
		// sb.append("|");
		sb.append(totaltime);
		sb.append("|");
		sb.append(request.toString());
		sb.append("|");
		sb.append(response.toString());
		sb.append("|");
		sb.append(result);
		ADMIN_REQ_LOG.info(sb.toString());
	}

	public static void feedback(RequestBean request) {
		if (request != null) {
			StringBuffer sb = new StringBuffer(BUFFER_SIZE);
			sb.append(TuringUtil.getDateFormatString(new Date(), 4));
			sb.append("|");
			sb.append(request.getIp());
			sb.append("|");
			sb.append(request.toString());
			FEEDBACK_LOG.info(sb.toString());
		}
	}

	public static void feedback(RequestBean request, String channel, String client_id, int status) {
		if (request != null) {
			StringBuffer sb = new StringBuffer(BUFFER_SIZE);
			sb.append(TuringUtil.getDateFormatString(new Date(), 4));
			sb.append("|");
			sb.append(request.getIp());
			sb.append("|");
			sb.append("status=");
			sb.append(String.valueOf(status));
			sb.append("&");
			sb.append("client_id=");
			sb.append(client_id);
			sb.append("&");
			sb.append("channel=");
			sb.append(channel);
			FEEDBACK_LOG.info(sb.toString());
		}
	}

	public static void feedbackError(RequestBean request) {
		if (request != null) {
			StringBuffer sb = new StringBuffer(BUFFER_SIZE);
			sb.append(TuringUtil.getDateFormatString(new Date(), 4));
			sb.append("|");
			sb.append(request.getIp());
			sb.append("|");
			sb.append(request.toString());
			EXCEPTION_LOG.info(sb.toString());
		}
	}

	public static void mobileLog(String smsCenter) {
		if (smsCenter != null) {
			MOBILE_LOG.info(smsCenter);
		}
	}

	/**
	 * 客户端请求日志
	 * 
	 * @param code
	 *            业务代码
	 * @param param
	 *            参数
	 */
	public static void clientLog(int code, String param) {
		CLIENT_REQ_LOG.info("service code = " + code + "; params=" + param.replace("\r", "").replace("\n", ""));
	}

	public static void REQUESTDATA(int code, String param) {
		REQUESTDATA.info("service code = " + code + ";" + param);
	}

	/**
	 * ads日志
	 * 
	 * @param msg
	 */
	public static void adsLog(String msg) {
		if (msg != null) {
			ADS_LOG.info(msg);
		}
	}
	public static void iconLog(String msg) {
		if (msg != null) {
			iCON_LOG.info(msg);
		}
	}
}
