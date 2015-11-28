package datastub;

import java.util.ArrayList;

import po.StockPO;
import dataservice.StockDataService;
import enums.ResultMessage;

public class StockDataStub implements StockDataService {
	
	StockPO po1 = new StockPO(0,"航运区",0,0,0,true);
	StockPO po2 = new StockPO(100,"航运区",1,2,3,false);
	StockPO[] pos ={po1,po2};

	@Override
	public StockPO findposition(int row, int shelf, int seat) {
		// TODO Auto-generated method stub
		System.out.print("find succeed!");
		return po1;
	}

	@Override
	public ArrayList<StockPO> findpositions(ArrayList<int[][]> positions) {
		// TODO Auto-generated method stub
		System.out.print("find succeed!");
		return null;
	}

	@Override
	public ResultMessage insert(StockPO PO) {
		// TODO Auto-generated method stub
		System.out.print("insert Succeed!\n");
		return null;
		
	}

	@Override
	public ResultMessage delete(StockPO PO) {
		// TODO Auto-generated method stub
		System.out.print("delete Succeed!\n");
		return null;
		
	}
	@Override
	public ResultMessage update(StockPO PO) {
		// TODO Auto-generated method stub
		System.out.print("update Succeed!\n");
		return null;
	}

}
