package po;
import java.io.Serializable;


public class StockPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int num;
	String area;
	int row;
	int shelf;
	int seat;
	boolean empty;
	String id;
	String inputdate;
	
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

	public StockPO(int n,String a,int r,int sh,int se,boolean E,String id,String inputdate){
		num = n;
		area = a;
		row = r;
		shelf = sh;
		seat = se;
		empty = E;
		this.id=id;
		this.inputdate=inputdate;
		
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

}
