package vo;

import java.util.Vector;

public class InMessageVO   extends Vector<String>   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String inputdate;
	private String destination;
	
	public InMessageVO(String i,String inputd,String des){
		id = i;
		inputdate = inputd;
		destination = des;
	}
	
	public String getID(){
		return id;
	}
	public String getInputdate(){
		return inputdate;
	}
	
	public String getDestination(){
		return destination;
	}

}
