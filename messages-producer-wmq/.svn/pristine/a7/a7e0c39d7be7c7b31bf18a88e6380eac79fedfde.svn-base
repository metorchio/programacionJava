package ar.com.osde.handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import ar.com.osde.wmq.configuration.ThreadPoolProperties;

public class ThreadPoolExecutorMessagesProducer {
	
	private static ThreadPoolExecutorMessagesProducer instance = null;
	
	private static ThreadPoolExecutor executor;
	
	private ThreadPoolExecutorMessagesProducer() {
	}
	
	public static ThreadPoolExecutorMessagesProducer getInstance() {
		if(instance == null) {
			ThreadPoolProperties properties = new ThreadPoolProperties();
			BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(properties.getPoolQueueCapacity());
			RejectedExecutionHandler executionHandler = new RejectedExecutionHandlerImpl();
			executor = new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaximumPoolSize(),
					properties.getKeepAliveTime(), TimeUnit.MILLISECONDS, worksQueue, executionHandler);
			instance = new ThreadPoolExecutorMessagesProducer();
		}
		return instance;
	}

	public ThreadPoolExecutor getExecutor() {
		return executor;
	}

}
