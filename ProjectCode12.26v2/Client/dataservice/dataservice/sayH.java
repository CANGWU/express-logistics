package dataservice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class sayH extends UnicastRemoteObject implements sayHello{

	public  sayH() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void say() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}
	

}
