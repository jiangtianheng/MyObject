package com.turing.pilot.monitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.turing.pilot.monitor.factory.SendMail;
import com.turing.pilot.monitor.factory.SendSMS;
import com.turing.pilot.monitor.utils.ReadProperties;

public class MailSmsTool {
	private static String sh1 = "/data/tools/chenbq/apk/sh/myverify.sh";
	private static String sh2 = "/data/tools/thj/sh/myverify1.sh";
	private static String sh3 = "/data/tools/thj/sh/testdbconn.sh";

	public static void main(String[] args) {
		SendSMS.sendSms("" + "test", ReadProperties.getSmsValue("toall"));
	}

	public static void testdb() {
		try {
			// List<String> list = ExeSH.execdn("sh/testdbconn.sh");
			// Integer max = Integer.parseInt(list.get(0).trim());
			// Integer used = Integer.parseInt(list.get(1).trim());
			// float rate = 100 * used / max;
			List<String> list = new ArrayList<String>();
			float rate = getrate(list);
			System.out.println(list);
			String content = "DBConnUsed:" + String.format("%.2f", rate) + "%;UsedConn:" + list.get(0) + ";MaxConn:" + list.get(1) + "";
			System.out.println("content=" + content);
			SendMail.send("MYSQL Connections Monitor", content, ReadProperties.getMailValue("toyx"));
			for (int i = 0; i < 3; i++) {
				if (rate > 50) {
					System.out.println(i + ":content=" + content);
					SendSMS.sendSms("mysql%20connections%20" + list.get(0), ReadProperties.getSmsValue("toall"));
					Thread.sleep(SendSMS.time);
				} else {
					break;
				}
				if (list.size() > 0) {
					list.clear();
				}
				rate = getrate(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static float getrate(List<String> list) {
		try {
			List<String> temp = execdn(sh3);
			list.addAll(temp);
			Integer used = Integer.parseInt(list.get(0).trim());
			Integer max = Integer.parseInt(list.get(1).trim());
			float rate = 100 * used / max;
			return rate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void testcdn() {
		try {
			List<String> list = execdn(sh1);
			StringBuilder sb = new StringBuilder();
			for (String s : list) {
				sb.append(s + "<br>");
			}
			System.out.println("content=" + sb.toString());
			SendMail.send("CDN Download Monitor", sb.toString(), ReadProperties.getMailValue("toall"));
			for (int i = 0; i < 3; i++) {
				if (list.size() > 1) {
					System.out.println(i + ":content=" + sb.toString());
					SendSMS.sendSms(ReadProperties.getSmsValue("content"), ReadProperties.getSmsValue("toall"));
					Thread.sleep(SendSMS.time);
				} else {
					break;
				}
				list = execdn(sh1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testcdn1() {
		try {
			List<String> list = execdn(sh2);
			StringBuilder sb = new StringBuilder();
			for (String s : list) {
				sb.append(s + "<br>");
			}
			System.out.println("content=" + sb.toString());
			SendMail.send("CDN Download Monitor", sb.toString(), ReadProperties.getMailValue("toyx"));
			for (int i = 0; i < 3; i++) {
				if (list.size() == 1) {
					break;
				}
				System.out.println(i + ":content=" + sb.toString());
				SendSMS.sendSms(ReadProperties.getSmsValue("content"), ReadProperties.getSmsValue("toyx"));
				Thread.sleep(SendSMS.time);
				list = execdn(sh2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> execdn(String path) {
		List<String> cdns = new ArrayList<String>();
		Runtime runtime = Runtime.getRuntime();
		Process p;
		try {
			p = runtime.exec(path);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String re = null;
			while ((re = br1.readLine()) != null) {
				cdns.add(re);
			}
			if (br1 != null) {
				br1.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cdns;
	}
}
