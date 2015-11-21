package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.CheckDataService;
import po.LogisticsPO;

public class CheckDataImpl  extends UnicastRemoteObject implements CheckDataService {

	private CheckDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public LogisticsPO find(String ordernumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	public static CheckDataImpl create() throws RemoteException{
		if(check == null){
			synchronized(CheckDataImpl.class){
		
		if(check == null)
		check = new CheckDataImpl();
			}
		}
			
		return check;
	}
	
   private volatile static CheckDataImpl check;
}
