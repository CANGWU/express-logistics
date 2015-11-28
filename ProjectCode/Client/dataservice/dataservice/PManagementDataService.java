package dataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.StaffPO;

public interface PManagementDataService extends Remote{
	
<<<<<<< HEAD
	public StaffPO find(String id)throws RemoteException;
	public ArrayList<StaffPO>findAll()throws RemoteException;
	public ResultMessage insert(StaffPO po)throws RemoteException;
	public ResultMessage delete(StaffPO po)throws RemoteException;
	public ResultMessage delete(String id)throws RemoteException;
	public ResultMessage update(StaffPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
=======
	public StaffPO find(String id);
	public ArrayList<StaffPO>findAll();
	public ResultMessage insert(StaffPO po);
	public ResultMessage delete(StaffPO po);
	public ResultMessage delete(String id);
	public ResultMessage update(StaffPO po);
	public void init();
	public void finish();
>>>>>>> origin/master

}
