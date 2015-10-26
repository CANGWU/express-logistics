package po;

import java.io.Serializable;
import java.util.ArrayList;

public class DeliverPO implements Serializable {
	private String id;
	private String time;
	private ArrayList<String> member;
	private ArrayList<String> order;

	public DeliverPO(String id, String time, ArrayList<String> member,
			ArrayList<String> order) {
		this.id = id;
		this.time = time;
		this.member = member;
		this.order = order;
	}
	
	public String getTime(){
		return time;
	}
	public String getID(){
		return id;
	}
	public ArrayList<String> getMember(){
		return member;
	}
	public ArrayList<String> getOrder(){
		return order;
	}
	public void setTime(String time){
		this.time = time;
	}
	public void setID(String id){
		this.id = id;
	}
	public void setMember(ArrayList<String> member){
		this.member = member;
	}
	public void setOrder(ArrayList<String> order){
		this.order = order;
	}
}
