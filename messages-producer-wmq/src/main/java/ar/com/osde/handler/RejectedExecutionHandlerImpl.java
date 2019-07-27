package ar.com.osde.handler;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

public class RejectedExecutionHandlerImpl implements RejectedExecutionHandler{
	
	private static final String NAME = "wmq-messages-producer";
	private static final Long SLEEP_TIME_MILISECONDS = 300L;
	
	private static final Logger log= Logger.getLogger(RejectedExecutionHandlerImpl.class);

	public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
		
		log.info( "----->| BLOQUEO LA ENTRADA AL THREAD POOL EXECUTOR - [" + NAME + "] "
				+ "- Tiempo de espera para para volver a ejecutar: " + SLEEP_TIME_MILISECONDS 
				+ " milisegundos. ThreadPoolSize: "+executor.getPoolSize() );
		try {
			Thread.sleep(SLEEP_TIME_MILISECONDS);
		} catch (InterruptedException ie) {
			log.error(ie);
		}
		executor.execute(runnable);
		
	}
	
}
