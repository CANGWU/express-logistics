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
	private String id;
	private Position departure;
	private Position destination;
	private String time;
	private Traffic traffic;
	private double fare;
	private ArrayList<String> member;
	private ArrayList<String> order;
	private ArrayList<Condition> condition;
	private DocumentCondition dCondition;

	public TransportPO(TransportType sign, String id, Position departure, Position destination,
			String time, Traffic traffic, double fare, ArrayList<String> member,
			ArrayList<String> order, ArrayList<Condition> condition,DocumentCondition dCondition) {
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
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}

	public TransportType getSign(){
		return sign;
	}
	public String getID(){
		return id;
	}

	public String getTime(){
		return time;
	}
	public Traffic getTraffic(){
		return traffic;
	}
	public double getfare(){
		return fare;
	}
	public  ArrayList<String> getMember(){
		return member;
	}
	public  ArrayList<String> getOrder(){
		return order;
	}
	public  ArrayList<Condition> getCondition(){
		return condition;
	}
	public  void setSign(TransportType sign){
		this.sign=sign;
	}
	public  void setID(String id){
		this.id=id;
	}
	
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
	}
	public  void setMember(ArrayList<String> member){
		this.member=member;
	}
	public void setOrder(ArrayList<String> order){
		this.order=order;
	}
	public void setCondition(ArrayList<Condition> condition){
		this.condition=condition;
	}
}
//class Test{  
//public static void main(String[] args) throw Exception{  
//  ArrayList<String> al = new ArrayLIst<String>();  
//  al.add("1");  
//  al.add("2");  
//  al.add("3");  
//  //先进行数据的保存  
//  Connection conn = DataBase.getConnection();  
//  PreparedStatement pstmt = con.prepareStatement("insert into books values(1,?)");//想数据库中插入第一组数据  
//  pstmt.setObject(1,al);  
//  int time = pstmt.executeUpdate();//执行操作  
//  System.out.println(time+"插入完成");//提示插入完成  
//  pstmt.close();  
//  //再进行数据的提出  
//  Statement stmt = con.createStatement();  
//  ResultSet rs = stmt.executeQuery("select book from books where id=1");  
//  if(rs.next()){  
//      ObjectInputStream oips = new ObjectInputStream(rs.getBinaryStream(1));  
//      //从rs中得到对象的流,如果直接从rs.getObject(1)得到的对象是无法直接转化为下面的对象的。  
//      ArrayList<String> obb = (ArrayList<String>)oips.readObject();//从流中读取对象  
//      System.out.println(obb.get(2));//输出对象中指定的数据  
//      oips.close();  
//  }  
//  rs.close();  
//  stmt.close();                 
//  con.close();  
//}  
//}  
