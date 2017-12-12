package com.cappuccino.offer.jobs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class JobExecutorService {
	
	private final int DEFAULT_POOL_SIZE = 10;
	private AtomicInteger threadCounter;
	private ExecutorService executorService;
	
	
	public static JobExecutorService getInstance(){
		return JobExecutorServiceHolder.instance;
	}
	
	private static class JobExecutorServiceHolder{
		static JobExecutorService instance = new JobExecutorService();
	}
	
	private JobExecutorService(){}
	
	public void start(){
		this.threadCounter = new AtomicInteger();
		this.executorService = Executors.newFixedThreadPool(DEFAULT_POOL_SIZE, new ThreadFactory() {
			public Thread newThread(Runnable r) {
				return new Thread(r, "JobExecutorService-"
						+ JobExecutorService.this.threadCounter.incrementAndGet());
			}
		});
	}
	
	public <T> Future<T> submitTask(Callable<T> task){
		return executorService.submit(task);
	}
	
	public void execute(Runnable task){
		this.executorService.execute(task);
	}
	
	public void stop(){
		if(this.executorService!=null)
			this.executorService.shutdown();
	}
	
}
