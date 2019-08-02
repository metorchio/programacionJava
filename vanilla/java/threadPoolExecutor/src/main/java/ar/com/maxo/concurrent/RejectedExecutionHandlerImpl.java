package ar.com.maxo.concurrent;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
	
	private static final String NAME = "RequestHandler";
	private static final Long SLEEP_TIME_MILISECONDS = 300L;

	@Override
	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		
		System.out.println( "----->| BLOQUEO LA ENTRADA AL THREAD POOL EXECUTOR - [" + NAME + "] "
				+ "- Tiempo de espera para para volver a ejecutar: " + SLEEP_TIME_MILISECONDS 
				+ " milisegundos. ThreadPoolSize: "+executor.getPoolSize() );
		try {
			Thread.sleep(SLEEP_TIME_MILISECONDS);
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
		executor.execute(runnable);
	}
}
