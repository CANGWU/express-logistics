package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.AgencyPO;

public interface AManagementDataService extends Remote{
	public AgencyPO find(String id) throws RemoteException;
	public ArrayList<AgencyPO> findAll() throws RemoteException;
	public ResultMessage insert(AgencyPO po)throws RemoteException;
	public ResultMessage delete(AgencyPO po)throws RemoteException;
	public ResultMessage delete(String id)throws RemoteException;
	public ResultMessage update(AgencyPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
	

}
