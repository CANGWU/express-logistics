package vo;

import java.util.Vector;

public class StockInfoVO extends Vector<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int inSum;
	private int outSum;
	private int seatSum;
	private int seatEmptySum;
	private int stockSum;
	
	public StockInfoVO(int ins,int outs,int seatS,int seatE, int stockS){
		inSum = ins;
		outSum = outs;
		seatSum = seatS;
		seatEmptySum = seatE;
		stockSum = stockS;
	}
	
	public int getInSum(){
		return inSum;
	}
	
	public int getOutSum(){
		return outSum;
	}
	
	public int getSeatSum(){
		return seatSum;
	}
	
	public int getSeatEmptySum(){
		return seatEmptySum;
	}
	
	public int getStockSum(){
		return stockSum;
	}
	

}
