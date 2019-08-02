package ar.com.maxo.concurrent;

import ar.com.maxo.concurrent.config.ThreadPoolProperties;

import java.util.concurrent.*;

public class ThreadPoolManager {

    private static ThreadPoolManager instance = null;
    private static ThreadPoolExecutor executor;

    private ThreadPoolManager() {
    }

    public static ThreadPoolManager getInstance() {
        if(instance == null) {
            synchronized (ThreadPoolManager.class) {
                if(instance == null) {
                    ThreadPoolProperties properties = new ThreadPoolProperties();
                    BlockingQueue<Runnable> worksQueue = new ArrayBlockingQueue<Runnable>(properties.getPoolQueueCapacity());
                    RejectedExecutionHandler executionHandler = new RejectedExecutionHandlerImpl();
                    executor = new ThreadPoolExecutor(properties.getCorePoolSize(), properties.getMaximumPoolSize(),
                            properties.getKeepAliveTime(), TimeUnit.MILLISECONDS, worksQueue, executionHandler);
                    instance = new ThreadPoolManager();
                }
            }
        }
        return instance;
    }

    public ThreadPoolExecutor getExecutor() {
        return executor;
    }

}