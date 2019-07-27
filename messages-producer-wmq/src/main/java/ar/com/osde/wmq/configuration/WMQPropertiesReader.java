package ar.com.osde.wmq.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

import org.apache.log4j.Logger;

public class WMQPropertiesReader {
	private static Logger logger = Logger.getLogger(WMQPropertiesReader.class);
	private final static String OSDE_FRAMEWORK_PROPERTIES_FILE = "osde-framework.properties";
	private static Properties wmqProperties = null;
	
	private final static String PREFIX = "messages.producer.wmq.";
	private final static String ENVIRONMENT = System.getProperty("environment");
	public final static String QUEUE_MANAGER = "queue.manager";
	public final static String QUEUE_NAME = "queue.name";
	public final static String QUEUE_CHANNEL = "queue.channel";
	public final static String QUEUE_HOSTNAME = "queue.hostName";
	public final static String QUEUE_PORT = "queue.port";
	public final static String QUEUE_PRIORITY = "queue.priority";
	public final static String TOPIC_NAME = "topic.name";
	public final static String THP_KEEP_ALIVE_TIME = "threadPool.keepAliveTime";
	public final static String THP_CORE_POOL_SIZE = "threadPool.corePoolSize";
	public final static String THP_MAXIMUM_POOL_SIZE = "threadPool.maximumPoolSize";
	public final static String THP_POOL_QUEUE_CAPACITY = "threadPool.queueCapacity";
	
	static {
		//Se realiza la carga de las propiedades a través de un método de inicialización estático,
		//para evitar el excesivo acceso a disco.
		try{
			wmqProperties = getParametrizedProperties();
			logger.info("Propiedades WMQ cargadas desde archivo: " + OSDE_FRAMEWORK_PROPERTIES_FILE);
			printWMQConfigurations(wmqProperties);
		} catch ( IllegalAccessException e ) {
			logger.error("Error al cargar las propiedades para WMQ" + e);
		}
	}
	
	public String getProperty(String property) {
		String propertyValue = null;
		propertyValue = getProperties().getProperty( property );
		logger.info("Propiedad WMQ :: " + property);

		return propertyValue;
	}
	
	public Properties getProperties() {
		return wmqProperties;
	}
	
	private static Properties getPropertiesFromOsdeFrameworkFile() {
		Properties wmqProperties = null;
		try {
			InputStream osdeFrameworkPropertiesFile = Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(OSDE_FRAMEWORK_PROPERTIES_FILE);
			wmqProperties = new Properties();
			if(osdeFrameworkPropertiesFile != null) {
				wmqProperties.load(osdeFrameworkPropertiesFile);
				osdeFrameworkPropertiesFile.close();
			} else {
				throw new RuntimeException("No se ha encontrado el archivo: "+OSDE_FRAMEWORK_PROPERTIES_FILE);
			}
		} catch (IOException e) {
			logger.error("Error al abrir el archivo "+ OSDE_FRAMEWORK_PROPERTIES_FILE +" para WMQ", e);
		}
		return wmqProperties;
	}
	
	private static Properties getParametrizedProperties() throws IllegalArgumentException, IllegalAccessException {
		Properties frameworkProperties = getPropertiesFromOsdeFrameworkFile();
		Properties wmqParametrizedProperties = new Properties();

		Field publicFields[] = WMQPropertiesReader.class.getFields();
		for( Field publicField : publicFields ) {
			String value;
			String key = (String) publicField.get(null);
			String searchingProperty =  PREFIX + key + "." + ENVIRONMENT;
			if( frameworkProperties.containsKey(searchingProperty) ) {
				value = frameworkProperties.getProperty( searchingProperty );
			} else {
				String defaultProperty = PREFIX + key;
				value = frameworkProperties.getProperty( defaultProperty );
			}
			if(value != null)
				wmqParametrizedProperties.put( key, value );
		}
		return wmqParametrizedProperties;
	}
	
	private static void printWMQConfigurations(Properties propertiesWMQ){
		logger.info( "" );
		logger.info( "*************** PARAMETROS DE CONFIGURACION ***************" );
		logger.info( "- QMANAGER:       " + propertiesWMQ.getProperty(QUEUE_MANAGER) );
		logger.info( "- COLA:           " + propertiesWMQ.getProperty(QUEUE_NAME) );
		logger.info( "- CANAL:          " + propertiesWMQ.getProperty(QUEUE_CHANNEL) );
		logger.info( "- SERVIDOR:       " + propertiesWMQ.getProperty(QUEUE_HOSTNAME) );
		logger.info( "- PUERTO:         " + propertiesWMQ.getProperty(QUEUE_PORT) );
		logger.info( "- PRIORIDAD MSJ:  " + propertiesWMQ.getProperty(QUEUE_PRIORITY) );
		logger.info( "- TOPIC NAME:     " + propertiesWMQ.getProperty(TOPIC_NAME) );
		logger.info( "***********************************************************" );
		logger.info( "" );
	}
}






