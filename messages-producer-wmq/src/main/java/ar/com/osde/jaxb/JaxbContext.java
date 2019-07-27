package ar.com.osde.jaxb;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class JaxbContext {

	private static Map<Class, Unmarshaller> mapUnmarshaller = new HashMap<Class, Unmarshaller>();
	
  	public static synchronized Object convertXmlToObject(String xml, Class clazz) throws Exception{
  		Unmarshaller unmarshaller = null;
  		//-------------------------------------------
		if(mapUnmarshaller.containsKey(clazz)){
			unmarshaller = mapUnmarshaller.get(clazz);
		}else{
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			unmarshaller = jaxbContext.createUnmarshaller();
			mapUnmarshaller.put(clazz, unmarshaller);
		}
		return unmarshaller.unmarshal(new StreamSource(new StringReader(xml)));
  	}
  	
}
