package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LogisticsPO;

public interface CheckDataService extends Remote{
	
           public LogisticsPO find(String ordernumber) throws RemoteException;
}
