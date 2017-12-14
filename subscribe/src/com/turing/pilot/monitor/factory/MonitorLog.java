package com.turing.pilot.monitor.factory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MonitorLog {
	private static SimpleDateFormat	sdf	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static void printlog(String info) {
		String time = sdf.format(Calendar.getInstance().getTime());
		System.out.println(time + " : " + info);
	}
	public static void printlog(Exception  info) {
		String time = sdf.format(Calendar.getInstance().getTime());
		System.out.println(time + " : " + excep2Str(info));
	}
	
	public static String excep2Str(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		e.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return sw.toString();
	}
}
