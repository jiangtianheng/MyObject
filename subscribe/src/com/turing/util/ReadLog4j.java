package com.turing.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import com.turing.pilot.email.MailSenderInfo;
import com.turing.pilot.email.SimpleMailSender;

public class ReadLog4j {
	public static void readFileByLines() throws IOException {
		
		System.out.println("进来了");
		
		String url = ReadLog4j.Log4jUrl();
		File file = new File(url);
		BufferedReader reader = null;
		new ArrayList<Map<String, String>>();
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		reader = new BufferedReader(isr);
		String tempString = null;
		// 一次读入一行，直到读入null为文件结束
		int i = 0;
		String tem = "";
		while ((tempString = reader.readLine()) != null) {
			i = i + 1;
			String s = new String();
			if (i == 1) {
				s = "下发次数：" + tempString;
			}
			if (i == 2) {
				s = "日活：" + tempString;
			}
			if (i == 3) {
				s = "已安装offer数：" + tempString;
			}
			if (i == 4) {
				s = "下发offer数：" + tempString;
			}
			;
			tem = tem + s + "||";
		}

		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("majing_12@163.com");
		mailInfo.setPassword("MJ15134615241DJ");// 您的邮箱密码
		mailInfo.setFromAddress("majing_12@163.com");
		mailInfo.setToAddress("tianhengjiang@xinyinhe.com");
		mailInfo.setSubject("IOS_ads");
		mailInfo.setContent(tem);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		sms.sendTextMail(mailInfo);// 发送文体格式
		// sms.sendHtmlMail(mailInfo);// 发送html格式
		reader.close();
	}

	public static String Log4jUrl() {
		String url = "/data/fg/info";
		return url;
	}

}
