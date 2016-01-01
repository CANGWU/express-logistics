package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import enums.ResultMessage;
import po.LogisticsPO;

public interface CheckDataService extends Remote{
	
           public LogisticsPO find(String ordernumber) throws RemoteException;
           public ResultMessage add(LogisticsPO po) throws RemoteException;
           public ResultMessage update(LogisticsPO po) throws RemoteException;
}
