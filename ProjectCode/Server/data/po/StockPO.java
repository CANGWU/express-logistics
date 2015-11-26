package po;
import java.io.Serializable;


public class StockPO implements Serializable {
	/**
	 * 
	 */
	String ID;
	public String getID() {
		return ID;
	}

	public String getInputDate() {
		return InputDate;
	}

	String InputDate;
	int num;
	String area;
	int row;
	int shelf;
	int seat;
	boolean empty;
	
	public StockPO(int n,String a,int r,int sh,int se,boolean E,String ID,String inputDate){
		num = n;
		area = a;
		row = r;
		shelf = sh;
		seat = se;
		empty = E;
		this.ID=ID;
		this.InputDate=inputDate;
		
	}
	
	public int getNum(){
		return num;
	}
	
	public String getArea(){
		return area;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getShelf(){
		return shelf;
	}
	
	public int getSeat(){
		return seat;
	}
	
	public boolean isEmpty(){
		return empty;
	}
	
	public void setEmpty(boolean state){
		if(state){
			empty = state;
			ID = null;
			InputDate = null;
		}
	}
	
	public void setID(String id){
		ID = id;
	}
	
	public void setInputDate(String date){
		InputDate = date;
		
	}
	
	public void setArea(String name){
		area = name;
	}
}
