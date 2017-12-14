package com.turing.pilot.monitor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static Properties promail = new Properties();
	public static Properties prosms = new Properties();
	
    static {
    	InputStream in= ReadProperties.class.getClassLoader().getResourceAsStream("jmail.properties");
    	InputStream insms= ReadProperties.class.getClassLoader().getResourceAsStream("sms.properties");
    	try {
    		promail.load(in);
    		prosms.load(insms);
			in.close();
			insms.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public static String getMailValue(String key){
    	return promail.getProperty(key);
    }
    public static String getSmsValue(String key){
    	return prosms.getProperty(key);
    }
}
