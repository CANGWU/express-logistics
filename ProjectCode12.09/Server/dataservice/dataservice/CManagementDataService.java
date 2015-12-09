package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.CarPO;

public interface CManagementDataService extends Remote{
	
	public CarPO find(String id)throws RemoteException;
	public ArrayList<CarPO> findAll()throws RemoteException;
	public ResultMessage insert(CarPO po)throws RemoteException;
	public ResultMessage delete(CarPO po)throws RemoteException;
	public ResultMessage delete(String id)throws RemoteException;
	public ResultMessage update(CarPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;

}
