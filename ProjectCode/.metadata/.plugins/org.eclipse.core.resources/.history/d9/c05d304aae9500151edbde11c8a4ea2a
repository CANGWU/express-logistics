package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
import enums.TransportType;

public class TransportPO implements Serializable {
	private TransportType sign;
	private DocumentCondition documentCondition;
	private String id;
	private String departure;
	private String destination;
	private String time;
	private String traffic;
	private long fare;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;

	public TransportPO(TransportType sign, String id, String departure,
			String destination, String time, String traffic, long fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition, DocumentCondition documentCondition) {
		this.id = id;
		this.sign = sign;
		this.documentCondition = documentCondition;
		this.departure = departure;
		this.destination = destination;
		this.time = time;
		this.traffic = traffic;
		this.fare = fare;
		this.member = member;
		this.order = order;
		this.condition = condition;
	}

	public TransportType getSign() {
		return sign;
	}

	public DocumentCondition getDocumentCondition() {
		return documentCondition;
	}

	public String getID() {
		return id;
	}

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public String getTime() {
		return time;
	}

	public String getTraffic() {
		return traffic;
	}

	public long getfare() {
		return fare;
	}

	public ArrayList<String> getMember() {
		return member;
	}

	public ArrayList<String> getOrder() {
		return order;
	}

	public ArrayList<Condition> getCondition() {
		return condition;
	}

	public void setSign(TransportType sign) {
		this.sign = sign;
	}

	public void setDocumentCondition(DocumentCondition documentCondition) {
		this.documentCondition = documentCondition;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public void setFare(long fare) {
		this.fare = fare;
	}

	public void setMember(ArrayList<String> member) {
		this.member = member;
	}

	public void setOrder(ArrayList<String> order) {
		this.order = order;
	}

	public void setCondition(ArrayList<Condition> condition) {
		this.condition = condition;
	}
}
