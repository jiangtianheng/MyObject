package com.turing.pilot.monitor.beans;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.turing.pilot.monitor.factory.MonitorLog;
import com.turing.pilot.monitor.utils.HttpUtil;
import com.turing.pilot.monitor.utils.ReadProperties;

public class SMS {
	private static String	mobile	= "";
	private static String	corpid	= "";
	private static String	pwd		= "";
	private static String	content	= "";
	private static String	smsapi	= "";

	public SMS(String str, String tel) {
		content = str;
		mobile = tel;
		smsapi = ReadProperties.getSmsValue("smsapi");
		corpid = ReadProperties.getSmsValue("user");
		pwd = ReadProperties.getSmsValue("pwd");
	}

	public void sendSMS() {
		String api = "";
		api = smsapi.replace("{corpid}", corpid);
		api = api.replace("{pwd}", pwd);
		api = api.replace("{mobile}", mobile);
		api = api.replace("{content}", content);
		try {
			String resultString = HttpUtil.sendGet(api);
			MonitorLog.printlog("send sms result : " + resultString);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
