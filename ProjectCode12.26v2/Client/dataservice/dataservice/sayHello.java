package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface sayHello extends Remote{
	
	public void say() throws RemoteException;
}
