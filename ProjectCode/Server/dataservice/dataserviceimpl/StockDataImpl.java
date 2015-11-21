package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.StockDataService;
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
	public StockPO[] findpositions(ArrayList<int[][]> positions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(StockPO PO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(StockPO PO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StockPO PO) {
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
