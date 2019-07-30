package ar.com.osde.middleware.es.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.Validate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "event", namespace = "http://osde.com.ar/services/eventbrokerproviderservice")
public class Event implements Serializable {

	private static final long serialVersionUID = 6901306967236837437L;
	private HashMap<String, String> stringHeaders;
	private HashMap<String, Integer> intHeaders;
	private HashMap<String, Boolean> booleanHeaders;
	private HashMap<String, Long> longHeaders;
	private static final String _HEADER_ADDRESS = "address";
	private static final String _HEADER_ID = "id";
	private static final String _HEADER_TTL = "ttl";
	private static final String _HEADER_NODE_TIMESTAMP = "nodeTimestamp";
	private static final String _HEADER_SOURCE = "source";
	private static final String _HEADER_TIMESTAMP = "timestamp";
	private static final String _HEADER_NAMESPACE = "namespace";
	private static final String _HEADER_EVENT_NAME = "eventname";
	private static final String _HEADER_DURATION = "duration";
	private static final String _HEADER_CLASSNAME = "classname";
	private static final String _HEADER_TOPIC_NAME = "topicname";
	private static final String _HEADER_EVENT_PRIORITY = "eventPriority";
	private String payload;
	private HashMap<String, Object> map;

	public Event() {
		setDefaultHeaders();
		this.map = new HashMap();
	}

	private void setDefaultHeaders() {
		this.booleanHeaders = new HashMap();
		this.intHeaders = new HashMap();
		this.longHeaders = new HashMap();
		this.stringHeaders = new HashMap();

		this.stringHeaders.put("address", extractAddres());

		this.stringHeaders.put("id", UUID.randomUUID().toString());

		this.intHeaders.put("eventPriority",
				Integer.valueOf(LevelEnum.Normal.ordinal()));

		this.longHeaders.put("duration", Long.valueOf(0L));
		this.longHeaders.put("ttl", Long.valueOf(-1L));
		this.stringHeaders.put("timestamp",
				String.valueOf(System.currentTimeMillis()));
	}

	private String[] getNotFiletered() {
		String[] notFiltered = { "address", "classname", "duration",
				"eventPriority", "id", "nodeTimestamp", "timestamp", "ttl" };
		return notFiltered;
	}

	public Map<String, String> getFilteredStringHeaders() {
		Map<String, String> filteredMap = new HashMap(this.stringHeaders);
		filterMap(filteredMap);
		return filteredMap;
	}

	public Map<String, Integer> getFilteredIntHeaders() {
		Map<String, Integer> filteredMap = new HashMap(this.intHeaders);
		filterMap(filteredMap);
		return filteredMap;
	}

	public Map<String, Long> getFilteredLongHeaders() {
		Map<String, Long> filteredMap = new HashMap(this.longHeaders);
		filterMap(filteredMap);
		return filteredMap;
	}

	public Map<String, Boolean> getFilteredBooleanHeaders() {
		Map<String, Boolean> filteredMap = new HashMap(this.booleanHeaders);
		filterMap(filteredMap);
		return filteredMap;
	}

	private void filterMap(Map<String, ?> mapToFilter) {
		for (String headerName : getNotFiletered()) {
			mapToFilter.remove(headerName);
		}
	}

	public Long getDuration() {
		return Long.valueOf(this.longHeaders.get("duration") == null ? 0L
				: ((Long) this.longHeaders.get("duration")).longValue());
	}

	public void setDuration(long duration) {
		this.longHeaders.put("duration", Long.valueOf(duration));
	}

	public String getAddress() {
		return (String) this.stringHeaders.get("address");
	}

	public void setAddress(String address) {
		this.stringHeaders.put("address", address);
	}

	public String getId() {
		return (String) this.stringHeaders.get("id");
	}

	public void setId(String id) {
		this.stringHeaders.put("id", id);
	}

	public LevelEnum getLevel() {
		int ordinal = ((Integer) this.intHeaders.get("eventPriority"))
				.intValue();

		return LevelEnum.values()[ordinal];
	}

	public void setLevel(LevelEnum level) {
		this.intHeaders.put("eventPriority", Integer.valueOf(level.ordinal()));
	}

	public String getNodeTimestamp() {
		if (this.stringHeaders.get("nodeTimestamp") != null) {
			return (String) this.stringHeaders.get("nodeTimestamp");
		}
		this.stringHeaders.put("nodeTimestamp", "");
		return (String) this.stringHeaders.get("nodeTimestamp");
	}

	public void setNodeTimestamp(String nodeTimestamp) {
		this.stringHeaders.put("nodeTimestamp", nodeTimestamp);
	}

	public String getSource() {
		if (this.stringHeaders.get("source") == null) {
			this.stringHeaders.put("source", "");
		}
		return (String) this.stringHeaders.get("source");
	}

	public void setSource(String source) {
		this.stringHeaders.put("source", source);
	}

	public String getTimestamp() {
		return (String) this.stringHeaders.get("timestamp");
	}

	public void setTimestamp(String timestamp) {
		this.stringHeaders.put("timestamp", timestamp);
	}

	public void setTtl(long ttl) {
		this.longHeaders.put("ttl", Long.valueOf(ttl));
	}

	public long getTtl() {
		return ((Long) this.longHeaders.get("ttl")).longValue();
	}

	public Date getTimestampAsDate() {
		Date date = null;
		if ((getTimestamp() != null) && (!getTimestamp().isEmpty())) {
			date = new Date(new Long(getTimestamp()).longValue());
		}
		return date;
	}

	public String getNameSpace() {
		return (String) this.stringHeaders.get("namespace");
	}

	public void setNameSpace(String namespace) {
		this.stringHeaders.put("namespace", namespace);
	}

	public String getEventName() {
		return (String) this.stringHeaders.get("eventname");
	}

	public void setEventName(String eventName) {
		this.stringHeaders.put("eventname", eventName);
	}

	public String getQualifiedName() {
		return getNameSpace() + "." + getEventName();
	}

	public String getTopicName() {
		return (String) this.stringHeaders.get("topicname");
	}

	public void setTopicName(String topicName) {
		this.stringHeaders.put("topicname", topicName);
	}

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getClassname() {
		return (String) this.stringHeaders.get("classname");
	}

	public void setClassname(String classname) {
		this.stringHeaders.put("classname", classname);
	}

	public Object putMap(String key, Boolean value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, Byte value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, Character value) {
		if (isValidChar(value.charValue())) {
			return this.map.put(key, value);
		}
		return value;
	}

	public Object putMap(String key, Short value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, int value) {
		return this.map.put(key, Integer.valueOf(value));
	}

	public Object putMap(String key, long value) {
		return this.map.put(key, Long.valueOf(value));
	}

	public Object putMap(String key, String value) {
		Validate.isTrue(value.length() < 250000,
				"El string no puede contener mas de 250.000 caracteres");
		Validate.isTrue(isValidString(value), "El string " + value
				+ " no puede contener caracteres de control unicode");
		return this.map.put(key, value);
	}

	public Object putMap(String key, Float value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, double value) {
		return this.map.put(key, Double.valueOf(value));
	}

	public Object putMap(String key, Double value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, Integer value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, Long value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, BigDecimal value) {
		return this.map.put(key, value);
	}

	public Object putMap(String key, Date value) {
		return this.map.put(key, value);
	}

	public void putMap(String key, Object value) {
		if ((value instanceof Boolean)) {
			putMap(key, (Boolean) value);
			return;
		}
		if ((value instanceof Byte)) {
			putMap(key, (Byte) value);
			return;
		}
		if ((value instanceof Character)) {
			putMap(key, (Character) value);
			return;
		}
		if ((value instanceof Double)) {
			putMap(key, (Double) value);
			return;
		}
		if ((value instanceof Float)) {
			putMap(key, (Float) value);
			return;
		}
		if ((value instanceof Integer)) {
			putMap(key, (Integer) value);
			return;
		}
		if ((value instanceof Long)) {
			putMap(key, (Long) value);
			return;
		}
		if ((value instanceof Short)) {
			putMap(key, (Short) value);
			return;
		}
		if ((value instanceof String)) {
			putMap(key, (String) value);
			return;
		}
		if ((value instanceof BigDecimal)) {
			putMap(key, (BigDecimal) value);
			return;
		}
		if ((value instanceof Date)) {
			putMap(key, (Date) value);
			return;
		}
		throw new RuntimeException(
				"EL mapa de la clase evento no soporta valores de la clase, con la clave  "
						+ key + " y el valor "
						+ (value == null ? "null" : value.getClass().getName()));
	}

	public Set<String> getKeys() {
		return this.map.keySet();
	}

	public Object getMap(String key) {
		return this.map.get(key);
	}

	public Map<String, Object> getMap() {
		return (Map) this.map.clone();
	}

	public String toString() {
		return MessageFormat.format(getClass().getName()
				+ " [id={0}, nameSapace={1}, eventName={2}, source={3}]",
				new Object[] { getId(), getNameSpace(), getEventName(),
						getSource() });
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (!Event.class.isAssignableFrom(obj.getClass())) {
			return false;
		}
		Event theOther = (Event) obj;

		return (null != getQualifiedName())
				&& (getQualifiedName().equalsIgnoreCase(theOther
						.getQualifiedName())) && (null != getAddress())
				&& (getAddress().equalsIgnoreCase(theOther.getAddress()))
				&& (null != getId())
				&& (getId().equalsIgnoreCase(theOther.getId()))
				&& (null != getMap()) && (getMap().equals(theOther.getMap()))
				&& (null != getDuration())
				&& (getDuration().equals(theOther.getDuration()));
	}

	public final int hashCode() {
		int hash = 0;
		if (null != getEventName()) {
			hash += getEventName().hashCode();
		}
		if (null != getNameSpace()) {
			hash += getNameSpace().hashCode();
		}
		if (null != getSource()) {
			hash += getSource().hashCode();
		}
		if (null != getId()) {
			hash += getId().hashCode();
		}
		if (null != getDuration()) {
			hash += getDuration().hashCode();
		}
		if (null != this.map) {
			hash += this.map.hashCode();
		}
		return hash;
	}

	private boolean isValidString(String value) {
		char[] charArray = value.toCharArray();
		boolean isValidString = true;
		for (int i = 0; (i < charArray.length) && (isValidString); i++) {
			isValidString = (isValidString) && (isValidChar(charArray[i]));
		}
		return isValidString;
	}

	private boolean isValidChar(char c) {
		return !Character.isISOControl(c);
	}

	private String extractAddres() {
		String ip;
		try {
			InetAddress addres = Inet4Address.getLocalHost();

			ip = addres.getHostName() + "(" + addres.getHostAddress() + ")";
		} catch (UnknownHostException uhe) {
			ip = "noAddres";
		}
		return ip;
	}

}
