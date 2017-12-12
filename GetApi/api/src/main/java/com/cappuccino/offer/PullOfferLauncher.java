package com.cappuccino.offer;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.cappuccino.offer.jobs.JobExecutorService;
import com.cappuccino.offer.util.SpringHelper;

public class PullOfferLauncher {
	
	private static Logger logger = Logger.getLogger(PullOfferLauncher.class);
	
	public static void main(String[] args){
		PullOfferLauncher launcher = new PullOfferLauncher();
		try{
			launcher.setup();
			logger.info("server start success.");
		}catch(Exception e){
			logger.error("server start failed.", e);
			launcher.destory();
			System.exit(0);
		}
	}
	private void setup(){
		setupSpringApplicationContext();//加载spring配置文件
		JobExecutorService.getInstance().start();//启动job的多线程服务
	}
	
	private void setupSpringApplicationContext(){
		String user_dir = System.getProperty("user.dir");
		String path = user_dir+"/conf/applicationContext.xml";
		PropertyConfigurator.configure(user_dir+"/conf/log4j.properties");
		ApplicationContext context = new FileSystemXmlApplicationContext("file:"+path);
		SpringHelper.setApplicationContext(context);
	}
	
	private void destory(){
		JobExecutorService.getInstance().stop();
	}

}
