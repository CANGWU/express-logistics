package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import enums.Work;
import po.StaffPO;

public interface PManagementDataService extends Remote {

	public StaffPO find(String id) throws RemoteException;

	public ArrayList<StaffPO> findAll() throws RemoteException;

	public ArrayList<StaffPO> findMember(Work work, String workplace)
			throws RemoteException;

	public ResultMessage insert(StaffPO po) throws RemoteException;

	public ResultMessage delete(StaffPO po) throws RemoteException;

	public ResultMessage delete(String id) throws RemoteException;

	public ResultMessage update(StaffPO po) throws RemoteException;

	public void init() throws RemoteException;

	public void finish() throws RemoteException;

}
