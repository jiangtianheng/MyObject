package com.cappuccino.util;

import org.springframework.context.ApplicationContext;

public class SpringHelper{
	
	private static ApplicationContext ctx;

	public static void setApplicationContext(ApplicationContext ctx) {
		SpringHelper.ctx = ctx;
	}
	
	public static ApplicationContext getApplicationContext(){
		return ctx;
	}
	
	public static Object getBean(String name){
		if(ctx==null) return null;
		return ctx.getBean(name);
	}
	
	public static <T> T getBean(String name,Class<T> clazz){
		if(ctx==null) return null;
		return ctx.getBean(name, clazz);
	}
	
	
	

}
