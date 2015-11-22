package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.CManagementDataService;
import enums.ResultMessage;
import po.CarPO;

public class CManagementDataImpl extends UnicastRemoteObject implements CManagementDataService {

	private CManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CarPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarPO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insert(CarPO po) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delect(CarPO po) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delect(String id) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(CarPO po) {
		return null;
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
	public static CManagementDataImpl create() throws RemoteException{
		if(cm == null){
			synchronized(CManagementDataImpl.class){
		
		if(cm == null)
		cm = new CManagementDataImpl();
			}
		}
			
		return cm;
	}
	
   private volatile static CManagementDataImpl cm;

}
