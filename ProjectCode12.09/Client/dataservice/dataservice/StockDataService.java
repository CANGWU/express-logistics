package dataservice;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.*;

public interface StockDataService extends Remote{
	
	public StockPO findposition(int row,int shelf,int seat)throws RemoteException;
	public ArrayList<StockPO> findpositions(int[][] positions )throws RemoteException;
	public ResultMessage insert(StockPO PO)throws RemoteException;
	public ResultMessage delete(StockPO PO)throws RemoteException;
	public ResultMessage update(StockPO PO)throws RemoteException;
	public ArrayList<StockPO> getAll()throws RemoteException;
	public ResultMessage clean()throws RemoteException;


}
