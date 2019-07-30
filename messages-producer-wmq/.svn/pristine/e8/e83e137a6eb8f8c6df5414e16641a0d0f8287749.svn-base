package ar.com.osde.producers;

import java.io.IOException;

import org.apache.log4j.Logger;

import ar.com.osde.wmq.configuration.PropertiesWMQ;

import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPoolToken;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

public class ProducerMessage {
	
	private MQQueueManager objQueueManager;
	
	private MQQueue objCola;
	
	private static final Logger log= Logger.getLogger(ProducerMessage.class);

	public void send(PropertiesWMQ propWMQ, String msg) {
		
		MQPoolToken token=new MQPoolToken();
		MQEnvironment.addConnectionPoolToken(token);
		try {
			MQEnvironment.disableTracing();
			objQueueManager = new MQQueueManager( propWMQ.getNombreQManager(), propWMQ.getConnectionProperties() );
		 	
			//Configuro las opciones en la cola que se va a abrir.
			int opcionesInputMQ  = MQC.MQOO_OUTPUT;
			
			//Especifico las opciones de mensaje para escribir (PUT)
			objCola = this.objQueueManager.accessQueue(propWMQ.getCola(), opcionesInputMQ, null, null, null);   
			MQPutMessageOptions opcionesPUT = new MQPutMessageOptions();
			
			MQMessage message = new MQMessage();
			message.writeString(msg);
			
			//Formato que consiste en Solo Caracteres enviados.
			message.format = MQC.MQFMT_STRING;  
			message.persistence = MQC.MQPER_PERSISTENT;
			message.priority = Integer.valueOf(propWMQ.getPrioridadMsj());
			
			//Escribo el mensaje en la cola MQ.
			objCola.put(message, opcionesPUT); 
			
		} catch( MQException e ){
			log.error( "Se ha producido un error: " + e );
		} catch( IOException e ){
			log.error( "Se ha producido un error: " + e );
		} finally {
			try {
				//Cierro Cola MQ.
				if(objCola != null) {
					objCola.close();
				}
				//Desconecto del gestor de colas
				if(objQueueManager != null) {
					objQueueManager.disconnect();
				}
				MQEnvironment.removeConnectionPoolToken(token);
            } catch (MQException e) {
                log.error("Se ha producido un error al intentar cerrar los recursos abiertos: "+ e);
            }
		}	
	}
	
}
