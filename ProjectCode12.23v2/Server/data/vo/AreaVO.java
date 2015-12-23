package vo;

import java.util.Vector;

public class AreaVO  extends Vector<String>  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String[] emptySeats;
	private String emptyPercent;
	
	public AreaVO(String name,String[] emptySeats,String emptyP){
		this.name = name;
		this.emptySeats = emptySeats;
		this.emptyPercent = emptyP;
	}
	
	public String getName(){
		return name;
	}
	public String[] getEmptySeats(){
		return emptySeats;
	}
	
	public String getEmptyPercent(){
		return emptyPercent;
	}

}
