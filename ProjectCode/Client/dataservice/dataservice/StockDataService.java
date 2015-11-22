package dataservice;
import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.*;

public interface StockDataService extends Remote{
	
	public StockPO findposition(int row,int shelf,int seat);
	public ArrayList<StockPO> findpositions(ArrayList<int[][]> positions );
	public ResultMessage insert(StockPO PO);
	public ResultMessage delete(StockPO PO);
	public ResultMessage update(StockPO PO);


}
