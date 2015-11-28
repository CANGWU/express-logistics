package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.CarPO;

public interface CManagementDataService extends Remote{
	
<<<<<<< HEAD
	public CarPO find(String id)throws RemoteException;
	public ArrayList<CarPO> findAll()throws RemoteException;
	public ResultMessage insert(CarPO po)throws RemoteException;
	public ResultMessage delete(CarPO po)throws RemoteException;
	public ResultMessage delete(String id)throws RemoteException;
	public ResultMessage update(CarPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
=======
	public CarPO find(String id);
	public ArrayList<CarPO> findAll();
	public ResultMessage insert(CarPO po);
	public ResultMessage delete(CarPO po);
	public ResultMessage delete(String id);
	public ResultMessage update(CarPO po);
	public void init();
	public void finish();
>>>>>>> origin/master

}
