package po;

import java.io.Serializable;

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
	boolean in=false;
	boolean out=false;
	boolean lost=false ;
	
	public IoputPO(String i,String idate,String t,String des,String posi,boolean IN){
		id = i;
		inputdate = idate;
		time = t;
		position = posi;
		destination = des;
		in = IN;
		
	}
	public IoputPO(String i,String odate,String t,String des,String trans,String rID,boolean OUT,boolean lost){
		id = i;
		outputdate = odate;
		time = t;
		transport = trans;
		destination = des;
		receiptID = rID;
		out = OUT;
		this.lost = lost;
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
	
	public boolean IsIn(){
		return in;
	}
	
	public boolean IsOut(){
		return out;
	}
	
	public boolean IsLost(){
		return lost;
	}

}
