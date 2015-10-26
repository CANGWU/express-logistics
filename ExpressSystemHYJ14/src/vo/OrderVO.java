package vo;

public class OrderVO {
	private String id;
	private String time;
	private String name;
	
	public OrderVO(String name,String time,String id){
		this.time=time;
		this.id=id;
		this.name=name;
	}
	
	public String getID(){
		return id;
	}
	public String getTime(){
		return time;
	}
	public String getName(){
		return name;
	}
	public void setID(String id){
		this.id=id;
	}
	public void setTime(String time){
		this.time=time;
	}
	public void setName(String name){
		this.name=name;
	}
}

