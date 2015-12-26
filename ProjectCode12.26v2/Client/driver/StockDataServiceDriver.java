package driver;

import po.StockPO;
import dataservice.StockDataService;

public class StockDataServiceDriver {
	
	StockPO po = new StockPO(0,"º½ÔËÇø",0,0,0,true);
	
	public void drive(StockDataService StockDataService){
		if(StockDataService.findposition(0, 0, 0)!=null)
			System.out.print("Data found!");
		if(StockDataService.findpositions(null)!=null)
			System.out.print("Positions data found!");
		
		StockDataService.insert(po);
		StockDataService.delete(po);
		StockDataService.update(po);
		
	}

}
