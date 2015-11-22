package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.StockDataService;
import enums.ResultMessage;
import po.StockPO;

public class StockDataImpl extends UnicastRemoteObject implements StockDataService {

	private StockDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StockPO findposition(int row, int shelf, int seat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StockPO> findpositions(ArrayList<int[][]> positions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insert(StockPO PO) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delete(StockPO PO) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(StockPO PO) {
		return null;
		// TODO Auto-generated method stub

	}
	public static StockDataImpl creat() throws RemoteException {
		if(stock == null){
			synchronized(StockDataImpl.class){
		
		if(stock == null)
		stock = new StockDataImpl();
			}
		}
			
		return stock;
	}
	
   private volatile static StockDataImpl stock;

}
