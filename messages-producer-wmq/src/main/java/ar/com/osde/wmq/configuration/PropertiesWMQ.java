package ar.com.osde.wmq.configuration;

import java.util.Hashtable;

import com.ibm.mq.MQC;

public class PropertiesWMQ {

	private String correlationIdMQ;
	
	private String tiempoInicioMQ;
	
	private String nombreQManager;
	
	private String cola;
	
	private String canal;
	
	private String servidor;
	
	private String puerto;
	
	private String prioridadMsj;
	
	private String topicName;
	
	
	// Retorna las propiedades necesarias para establecer la conexi�n
	// en un Hashtable como requiere el constructor de WMQ.
	@SuppressWarnings("unchecked")
	public Hashtable getConnectionProperties(){
		Hashtable properties = new Hashtable();
		properties.put(MQC.CHANNEL_PROPERTY, canal );
		properties.put(MQC.HOST_NAME_PROPERTY, servidor );
		properties.put(MQC.PORT_PROPERTY, Integer.parseInt( puerto ) );
		return properties;
	}
	
	//Setters y Getters

	public String getCorrelationIdMQ() {
		return correlationIdMQ;
	}

	public void setCorrelationIdMQ(String correlationIdMQ) {
		this.correlationIdMQ = correlationIdMQ;
	}

	public String getTiempoInicioMQ() {
		return tiempoInicioMQ;
	}

	public void setTiempoInicioMQ(String tiempoInicioMQ) {
		this.tiempoInicioMQ = tiempoInicioMQ;
	}

	public String getNombreQManager() {
		return nombreQManager;
	}

	public void setNombreQManager(String nombreQManager) {
		this.nombreQManager = nombreQManager;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getPrioridadMsj() {
		return prioridadMsj;
	}

	public void setPrioridadMsj(String prioridadMsj) {
		this.prioridadMsj = prioridadMsj;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
