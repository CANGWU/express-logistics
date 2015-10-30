package vo;

import java.util.ArrayList;

public class TransportVO {
	String sign;
	String departure;
	String destination;
	String time;
	String traffic;
	String id;
	long fare;
	ArrayList<String> member;
	ArrayList<String> order;
	ArrayList<String> condition;

	public TransportVO(String sign,String id, String departure, String destination,
			String time, String traffic, long fare, ArrayList<String> member,
			ArrayList<String> order, ArrayList<String> condition) {
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
	}
	
	public String getSign(){
		return sign;
	}
	public String getID(){
		return id;
	}
	public String getDeparture(){
		return departure;
	}
	public String getDestination(){
		return destination;
	}
	public String getTime(){
		return time;
	}
	public String getTraffic(){
		return traffic;
	}
	public long getfare(){
		return fare;
	}
	public  ArrayList<String> getMember(){
		return member;
	}
	public  ArrayList<String> getOrder(){
		return order;
	}
	public  ArrayList<String> getCondition(){
		return condition;
	}
	public  void setSign(String sign){
		this.sign=sign;
	}
	public  void setID(String id){
		this.id=id;
	}
	public  void setDeparture(String departure){
		this.departure=departure;
	}
	public  void setDestination(String destination){
		this.destination=destination;
	}
	public  void setTime(String time){
		this.time=time;
	}
	public  void setTraffic(String traffic){
		this.traffic=traffic;
	}
	public  void setFare(long fare){
		this.fare=fare;
	}
	public  void setMember(ArrayList<String> member){
		this.member=member;
	}
	public void setOrder(ArrayList<String> order){
		this.order=order;
	}
	public void setCondition(ArrayList<String> condition){
		this.condition=condition;
	}
}
