package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sun.org.apache.regexp.internal.recompile;

import enums.DocumentCondition;
import enums.ResultMessage;
import enums.TransportType;
import po.TransportPO;

public interface TransportDataService extends Remote{
	public TransportPO find(String id) throws RemoteException;
	public ArrayList<TransportPO> finds(TransportType sign) throws RemoteException;
	public ResultMessage insert(TransportPO po) throws RemoteException;
	public ResultMessage delete(TransportPO po) throws RemoteException;
	public ResultMessage update(TransportPO po) throws RemoteException;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
	public ArrayList<TransportPO> findWithdCondition(String nameOfWriter, DocumentCondition dCondition)throws RemoteException;
	public ArrayList<TransportPO> findAudit() throws RemoteException;
}
