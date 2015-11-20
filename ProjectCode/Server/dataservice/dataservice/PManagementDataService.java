package dataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StaffPO;

public interface PManagementDataService extends Remote{
	
	public StaffPO find(String id) throws RemoteException;
	public ArrayList<StaffPO>findAll()throws RemoteException;
	public void insert(StaffPO po)throws RemoteException;
	public void delect(StaffPO po)throws RemoteException;
	public void delect(String id)throws RemoteException;
	public void update(StaffPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;

}
