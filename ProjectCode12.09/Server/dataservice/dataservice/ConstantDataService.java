package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import enums.ResultMessage;
import po.ConstantPO;

public interface ConstantDataService extends Remote{


	public ConstantPO find()throws RemoteException;
	public ResultMessage insert(ConstantPO po)throws RemoteException;
	public ResultMessage delete()throws RemoteException;
	public ResultMessage update(ConstantPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;
	//ResultMessage delete();

}
