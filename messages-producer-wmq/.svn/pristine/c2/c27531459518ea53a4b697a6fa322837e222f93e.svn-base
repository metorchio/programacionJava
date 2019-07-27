package ar.com.osde.senders;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

import ar.com.osde.fillers.DefaultEventFiller;
import ar.com.osde.fillers.EventFiller;
import ar.com.osde.framework.entities.FrameworkEntity;
import ar.com.osde.handler.ThreadPoolExecutorMessagesProducer;
import ar.com.osde.middleware.es.model.Event;
import ar.com.osde.producers.ProducerMessage;
import ar.com.osde.wmq.configuration.ConfigurationWMQ;
import ar.com.osde.wmq.configuration.PropertiesWMQ;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;

public class EventSenderImpl implements EventSender {
	
	private static final Logger log= Logger.getLogger(EventSenderImpl.class);
	
	private ThreadPoolExecutorMessagesProducer threadPoolExecutor = ThreadPoolExecutorMessagesProducer.getInstance();

	@Override
	public void sendAsync(final FrameworkEntity entity, final EventFiller eventFiller) {
		threadPoolExecutor.getExecutor().execute(new Runnable() {
			public void run() {
				if( entity == null ) {
					throw new RuntimeException( "El objeto a publicar no debe ser null." );					
				}
				
				ConfigurationWMQ configurationWMQ = new ConfigurationWMQ();
				configurationWMQ.configurate();
				PropertiesWMQ propWMQ = configurationWMQ.getPropWMQ();
				
				DefaultEventFiller defaultEventFiller = (DefaultEventFiller)eventFiller;
				defaultEventFiller.getEvent().setTopicName(propWMQ.getTopicName());
				
				ProducerMessage producerMsg = new ProducerMessage();
				
				//hago el marshall del objeto recibido es decir lo convierto a xml
				String xmlEntity = buildXmlFromFrameworkEntity(entity);
				
				Event event = defaultEventFiller.getEvent();
				event.setPayload(xmlEntity);
				
				String xmlEvento = buildXmlFromEventObject(event);
				producerMsg.send(propWMQ, xmlEvento);
			}
		});
	}
	
	private String buildXmlFromEventObject(Event event) {
		String xmlEvent = null;
		try {
			StringWriter sw = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(Event.class);
			Marshaller m = context.createMarshaller();
			m.marshal(event, sw);
			xmlEvent = sw.toString();
		} catch (JAXBException e) {
			log.error("Se ha producido un error al hacer el marshall del objeto evento" + e);
		}
		return xmlEvent;
	}
	
	private String buildXmlFromFrameworkEntity(FrameworkEntity entity) {
		String stringXml = "";
        XStream xstream = new XStream();
        StringWriter sw = new StringWriter();
        xstream.marshal(entity,  new CompactWriter(sw));
        stringXml = sw.toString();
        return stringXml;
	}
	
}
