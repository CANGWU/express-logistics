package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import enums.Work;
import po.SalaryPO;

public interface SalaryStrategyDataService extends Remote{
	
	public ArrayList<SalaryPO> findAll() throws RemoteException;
	public ResultMessage insert(SalaryPO po)throws RemoteException;
	public ResultMessage delete(SalaryPO po)throws RemoteException;
	public ResultMessage delete(Work work)throws RemoteException;
    public SalaryPO find(Work work)throws RemoteException;
	public ResultMessage update(SalaryPO po)throws RemoteException;
	public void init()throws RemoteException;
	public void finish()throws RemoteException;


}
