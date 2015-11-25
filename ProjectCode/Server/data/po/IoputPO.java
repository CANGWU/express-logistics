package po;

import java.io.Serializable;

import enums.Condition;
import enums.Ioput;

public class IoputPO implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;/*¿ìµÝÌõÐÎÂëºÅ*/
	String inputdate;
	String outputdate;
	String time;
	String destination;
	String position;
	String transport;
	String receiptID;
	Ioput ioput;
	Condition condition;
	
	public IoputPO(String i,String idate,String it,String des,String posi,Ioput ioput){
		id = i;
		inputdate = idate;
		time = it;
		position = posi;
		destination = des;
		this.ioput = ioput;
		
	}
	public IoputPO(String i,String odate,String t,String des,String trans,String rID,Ioput ioput,Condition condition){
		id = i;
		outputdate = odate;
		time = t;
		transport = trans;
		destination = des;
		receiptID = rID;
		this.ioput = ioput;
		this.condition = condition;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public String getOutputdate() {
		return outputdate;
	}
	public void setOutputdate(String outputdate) {
		this.outputdate = outputdate;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Ioput getIoput() {
		return ioput;
	}
	public void setIoput(Ioput ioput) {
		this.ioput = ioput;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}
	public String getID(){
		return id;
	}
	
	public String getTime(){
		return time;
	}
	
	public String getInputDate(){
		return inputdate;
	}
	
	public String getOutputDate(){
		return outputdate;
	}
	
	public String getPositon(){
		return position;
	}
	
	public String getTransport(){
		return transport;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public String getReceiptID(){
		return receiptID;
	}
	
	

}
