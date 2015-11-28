package po;

import java.io.Serializable;
import java.util.ArrayList;
<<<<<<< HEAD
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Traffic;
=======

import enums.Condition;
import enums.DocumentCondition;
>>>>>>> origin/master
import enums.TransportType;

public class TransportPO implements Serializable {
	private TransportType sign;
	private DocumentCondition documentCondition;
	private String id;
	private Position departure;
	private Position destination;
	private String time;
	private Traffic traffic;
	private double fare;
	private String nameOfWriter;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;
<<<<<<< HEAD
	private DocumentCondition dCondition;

	public TransportPO(TransportType sign, String id, Position departure, Position destination,
			String time, Traffic traffic, double fare, ArrayList<String> member,
			ArrayList<String> order, ArrayList<Condition> condition,DocumentCondition dCondition,String nameOfWriter) {
		this.id=id;
		this.sign=sign;
		this.departure=departure;
		this.destination=destination;
		this.time=time;
		this.traffic=traffic;
		this.fare=fare;
		this.member=member;
		this.order=order;
		this.condition=condition;
		this.dCondition = dCondition;
		this.nameOfWriter = nameOfWriter;
	}
	
	public String  getNameOfWriter(){
		return nameOfWriter;
	}
	
	public void setNameOfWriter(String nameOfWriter){
		this.nameOfWriter = nameOfWriter;
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}

	public TransportType getSign(){
=======

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
>>>>>>> origin/master
		return sign;
	}

	public DocumentCondition getDocumentCondition() {
		return documentCondition;
	}

	public String getID() {
		return id;
	}

<<<<<<< HEAD
	public String getTime(){
		return time;
	}
	public Traffic getTraffic(){
		return traffic;
	}
	public double getfare(){
=======
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
>>>>>>> origin/master
		return fare;
	}

	public ArrayList<String> getMember() {
		return member;
	}

	public ArrayList<String> getOrder() {
		return order;
	}
<<<<<<< HEAD
	public  ArrayList<Condition> getCondition(){
=======

	public ArrayList<Condition> getCondition() {
>>>>>>> origin/master
		return condition;
	}

	public void setSign(TransportType sign) {
		this.sign = sign;
	}

	public void setDocumentCondition(DocumentCondition documentCondition) {
		this.documentCondition = documentCondition;
	}
<<<<<<< HEAD
	
	public Position getDeparture() {
		return departure;
	}

	public void setDeparture(Position departure) {
		this.departure = departure;
	}

	public Position getDestination() {
		return destination;
	}

	public void setDestination(Position destination) {
		this.destination = destination;
	}

	public  void setTime(String time){
		this.time=time;
	}
	public  void setTraffic(Traffic traffic){
		this.traffic=traffic;
	}
	public  void setFare(double fare){
		this.fare=fare;
=======

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
>>>>>>> origin/master
	}

	public void setMember(ArrayList<String> member) {
		this.member = member;
	}

	public void setOrder(ArrayList<String> order) {
		this.order = order;
	}
<<<<<<< HEAD
	public void setCondition(ArrayList<Condition> condition){
		this.condition=condition;
=======

	public void setCondition(ArrayList<Condition> condition) {
		this.condition = condition;
>>>>>>> origin/master
	}
}
