package vo;

public class StockInitializeVO {
	
	int rowall,row1[],row2[],row3[],row4[];
	int shelf;
	int seat;
	
	public StockInitializeVO(int rA,int r1[],int r2[],int r3[],int r4[],int sh,int se){
		rowall = rA;
		row1 = r1;
		row2 = r2;
		row3 = r3;
		row4 = r4;
		shelf = sh;
		seat = se;
		
	}
	
	public int getRowall(){
		return rowall;
	}
	
	public int getShelf(){
		return shelf;
	}
	
	public int getSeat(){
		return seat;
	}
	
	public int[] getArea1(){
		return row1;
	}
	
	public int[] getArea2(){
		return row2;
	}
	public int[] getArea3(){
		return row3;
	}
	public int[] getArea4(){
		return row4;
	}

}
