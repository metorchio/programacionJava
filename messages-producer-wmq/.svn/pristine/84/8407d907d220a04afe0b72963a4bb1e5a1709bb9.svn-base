package ar.com.osde.wmq.configuration;

import java.util.Properties;

public class ThreadPoolProperties {
	//default properties
	private static final String KEEP_ALIVE_TIME = "0";
    private static final String CORE_POOL_SIZE = "10";
    private static final String MAXIMUM_POOL_SIZE = "50";
    private static final String QUEUE_CAPACITY = "1";
	
	private long keepAliveTime;
	private int corePoolSize;
	private int maximumPoolSize;
	private int poolQueueCapacity;
	
	public ThreadPoolProperties(){
		Properties properties = loadPropertiesFromFile();
		//Si en el archivo no se especifica algún valor, se carga el valor por defecto.
		String keepAliveTime = properties.getProperty( 
				WMQPropertiesReader.THP_KEEP_ALIVE_TIME, KEEP_ALIVE_TIME );
		String corePoolSize = properties.getProperty( 
				WMQPropertiesReader.THP_CORE_POOL_SIZE, CORE_POOL_SIZE );
		String maximumPoolSize = properties.getProperty( 
				WMQPropertiesReader.THP_MAXIMUM_POOL_SIZE, MAXIMUM_POOL_SIZE );
		String poolQueueCapacity = properties.getProperty( 
				WMQPropertiesReader.THP_POOL_QUEUE_CAPACITY, QUEUE_CAPACITY );
		setThreadPoolProperties(keepAliveTime, corePoolSize, maximumPoolSize, poolQueueCapacity);
	}

	private void setThreadPoolProperties(String keepAliveTime, String corePoolSize, 
											String maximumPoolSize, String poolQueueCapacity){
		this.keepAliveTime = Long.parseLong( keepAliveTime );
		this.corePoolSize = Integer.parseInt( corePoolSize );
		this.maximumPoolSize = Integer.parseInt( maximumPoolSize );
		this.poolQueueCapacity = Integer.parseInt( poolQueueCapacity );
	}
	
	private Properties loadPropertiesFromFile() {
		WMQPropertiesReader propertiesReader = new WMQPropertiesReader();
		Properties threadpoolProperties = propertiesReader.getProperties();
		return threadpoolProperties;
	}

	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public int getPoolQueueCapacity() {
		return poolQueueCapacity;
	}
}
