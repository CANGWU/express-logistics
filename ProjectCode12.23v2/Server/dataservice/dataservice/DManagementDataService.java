package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.DriverPO;

public interface DManagementDataService extends Remote{
	
	public DriverPO find(String id) throws RemoteException, SQLException;
	public ArrayList<DriverPO> findAll() throws RemoteException;
	public ResultMessage insert(DriverPO po) throws RemoteException;
	public ResultMessage delete(DriverPO po) throws RemoteException;
	public ResultMessage delete(String id) throws RemoteException;
	public ResultMessage update(DriverPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;

}
