package ar.com.osde.senders;

import ar.com.osde.fillers.EventFiller;
import ar.com.osde.framework.entities.FrameworkEntity;

public interface EventSender {
	
	public void sendAsync(FrameworkEntity entity, EventFiller paramEventFiller);

}
