package ar.com.osde.wmq.configuration;

import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigurationWMQ {
	
	private PropertiesWMQ propWMQ;
	
	private static final Logger log= Logger.getLogger(ConfigurationWMQ.class);
	

	private void fillConfigurationWMQ(Properties properties){
		propWMQ = new PropertiesWMQ();
		propWMQ.setTiempoInicioMQ( Long.toString( new Date().getTime() ) );
		propWMQ.setCorrelationIdMQ( propWMQ.getTiempoInicioMQ() + new Date().getTime() );
		propWMQ.setNombreQManager( properties.getProperty( WMQPropertiesReader.QUEUE_MANAGER) ); 
		propWMQ.setCola( properties.getProperty( WMQPropertiesReader.QUEUE_NAME ) );  
		propWMQ.setCanal( properties.getProperty( WMQPropertiesReader.QUEUE_CHANNEL ) );  
		propWMQ.setServidor( properties.getProperty( WMQPropertiesReader.QUEUE_HOSTNAME ) );  
		propWMQ.setPuerto( properties.getProperty( WMQPropertiesReader.QUEUE_PORT ) );  
		propWMQ.setPrioridadMsj( properties.getProperty( WMQPropertiesReader.QUEUE_PRIORITY , "4") );
		propWMQ.setTopicName(properties.getProperty( WMQPropertiesReader.TOPIC_NAME ));
	}
	
	public void configurate() {
		WMQPropertiesReader wmqPropertiesReader = new WMQPropertiesReader();
		Properties wmqProperties = wmqPropertiesReader.getProperties();
		fillConfigurationWMQ(wmqProperties);
	}

	public PropertiesWMQ getPropWMQ() {
		return propWMQ;
	}
}
