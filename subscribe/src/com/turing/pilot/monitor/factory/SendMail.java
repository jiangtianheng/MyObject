package com.turing.pilot.monitor.factory;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.turing.pilot.monitor.beans.Mail;


public class SendMail {
	public static void send(String content,String to) {
		if (content == null || content.equals("")) {
			content = "have error but  no error messages";
		}
		Mail se = new Mail(false);
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date().getTime());
		// 设置内容
		sb.append("<table border='0' width='800'><tr bgcolor='#88ADA6'><td  width='300' align='center'>TIME</td><td  width='500' colspan='3'  align='center'>information</td></tr>")
				.append("<tr><td width='300'>" + time + "</td>").append("<td  width='500' colspan='3'>").append(content + "</td>").append("</tr>").append("</table>");
		String title2 = "CDN Download Monitor";
		se.doSendHtmlEmail(title2, sb.toString(), to, null);
	}
	public static void send(String title,String content,String to) {
		if (content == null || content.equals("")) {
			content = "have error but  no error messages";
		}
		Mail se = new Mail(true);
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date().getTime());
		// 设置内容
		sb.append("<table border='0' width='800'><tr bgcolor='#88ADA6'><td  width='300' align='center'>TIME</td><td  width='500' colspan='3'  align='center'>information</td></tr>")
				.append("<tr><td width='300'>" + time + "</td>").append("<td  width='500' colspan='3'>").append(content + "</td>").append("</tr>").append("</table>");
		se.doSendHtmlEmail(title, sb.toString(), to, null);
	}
}
