package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Traffic;
import enums.TransportType;

public class TransportPO implements Serializable {
	private TransportType sign;// 运输单类型
	private String id;
	private String departure;
	private String destination;
	private String transportID;// 载运编号
	private String time;
	private String trafficID;// 载具编号
	private Traffic trafficType;// 载具类型
	private double fare;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;
	private DocumentCondition documentCondition;
	private String nameOfWriter;

	public TransportPO(TransportType sign, String id, String departure,
			String destination, String transportID, String time,
			String trafficID, Traffic trafficType, double fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition,
			DocumentCondition documentCondition, String nameOfWriter) {
		this.sign = sign;
		this.id = id;
		this.departure = departure;
		this.destination = destination;
		this.transportID = transportID;
		this.time = time;
		this.trafficID = trafficID;
		this.trafficType = trafficType;
		this.fare = fare;
		this.member = member;
		this.order = order;
		this.condition = condition;
		this.documentCondition = documentCondition;
		this.nameOfWriter = nameOfWriter;
	}

	public TransportPO() {

	}

	public TransportType getSign() {
		return sign;
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

	public String getTransportID() {
		return transportID;
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

	public DocumentCondition getDocumentCondition() {
		return documentCondition;
	}

	public String getWriter() {
		return nameOfWriter;
	}

	public void setSign(TransportType sign) {
		this.sign = sign;
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

	public void setTransportID(String transportID) {
		this.transportID = transportID;
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

	public void setDocumentCondition(DocumentCondition documentCondition) {
		this.documentCondition = documentCondition;
	}

	public void setWriter(String nameOfWriter) {
		this.nameOfWriter = nameOfWriter;
	}
}
