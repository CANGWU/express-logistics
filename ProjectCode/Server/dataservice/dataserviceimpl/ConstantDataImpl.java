package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import dataservice.ConstantDataService;
import po.ConstantPO;

public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService {

	private ConstantDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConstantPO find() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ConstantPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ConstantPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}  
	
	public static ConstantDataImpl create() throws RemoteException{
		if(constant == null){
			synchronized(ConstantDataImpl.class){
		
		if(constant == null)
		constant = new ConstantDataImpl();
			}
		}
			
		return constant;
	}
	
   private volatile static ConstantDataImpl constant;  
   
   

}
