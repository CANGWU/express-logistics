package vo;

import java.util.Vector;

public class OutMessageVO   extends Vector<String>   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String outputdate;
	private String destination;
	private String transport;
	private String receiptID;
	
	public OutMessageVO(String i,String outputd,String des,String trans,String rID){
		id = i;
		outputdate = outputd;
		destination = des;
		transport = trans;
		receiptID = rID;
	}
	
	public String getID(){
		return id;
	}
	public String getOutputdate(){
		return outputdate;
	}
	
	public String getDestination(){
		return destination;
	}
	
	public String getTransport(){
		return transport;
	}
	
	public String getReceiptID(){
		return receiptID;
	}

}
