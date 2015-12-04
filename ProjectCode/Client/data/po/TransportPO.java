package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Traffic;
import enums.TransportType;

public class TransportPO implements Serializable {
	private TransportType sign;
	private DocumentCondition documentCondition;
	private String id;// ‘À ‰µ•±‡∫≈
	private String transportID;// ‘ÿ‘À±‡∫≈
	private Position departure;
	private Position destination;
	private String time;
	private String trafficID;// ‘ÿæﬂ±‡∫≈
	private Traffic trafficType;
	private double fare;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;
	private String nameOfWriter;

	public TransportPO(TransportType sign, String id, String transportID,
			Position departure, Position destination, String time,
			String trafficID, Traffic trafficType, double fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition,
			DocumentCondition documentCondition, String nameOfWriter) {
		this.id = id;
		this.transportID = transportID;
		this.sign = sign;
		this.documentCondition = documentCondition;
		this.departure = departure;
		this.destination = destination;
		this.time = time;
		this.trafficID = trafficID;
		this.trafficType = trafficType;
		this.fare = fare;
		this.member = member;
		this.order = order;
		this.condition = condition;
		this.nameOfWriter = nameOfWriter;
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

	public String getWriter() {
		return nameOfWriter;
	}

	public String getTransportID() {
		return transportID;
	}

	public Position getDeparture() {
		return departure;
	}

	public Position getDestination() {
		return destination;
	}

	public String getTime() {
		return time;
	}

	public String getTrafficID() {
		return trafficID;
	}

	public Traffic getTrafficType() {
		return trafficType;
	}

	public double getfare() {
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

	public void setWriter(String nameOfWriter) {
		this.nameOfWriter = nameOfWriter;
	}

	public void setTransportID(String transportID) {
		this.transportID = transportID;
	}

	public void setDeparture(Position departure) {
		this.departure = departure;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setTrafficID(String trafficID) {
		this.trafficID = trafficID;
	}

	public void setTrafficType(Traffic trafficType) {
		this.trafficType = trafficType;
	}

	public void setFare(double fare) {
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
