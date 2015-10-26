package stockdataservice;
import java.util.ArrayList;

import po.*;

public interface StockDataService {
	
	public StockPO findposition(int row,int shelf,int seat);
	public StockPO[] findpositions(ArrayList<int[][]> positions );
	public void insert(StockPO PO);
	public void delete(StockPO PO);
	public void update(StockPO PO);


}
