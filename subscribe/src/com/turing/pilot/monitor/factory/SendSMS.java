package com.turing.pilot.monitor.factory;

import com.turing.pilot.monitor.beans.SMS;


public class SendSMS {
	public static int		time	= 5 * 60 * 1000;
	/**
	 * 
	 * 
	 * @param content
	 * @param mobiles
	 */
	public static void sendSms(String content,String mobiles){
		SMS sms = new SMS(content,mobiles);
		sms.sendSMS();
	}
}
