package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.StaffPO;
import dataservice.PManagementDataService;
import enums.ResultMessage;

public class PManagementDataImpl extends UnicastRemoteObject implements PManagementDataService{

	private PManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StaffPO find(String id) {
		// TODO Auto-generated method stub
		StaffPO  staff1 = new StaffPO();
		staff1.setName("oldYellow");
		return staff1;
	}

	@Override
	public ArrayList<StaffPO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insert(StaffPO po) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage delect(StaffPO po) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage delect(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage update(StaffPO po) {
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
	
	public static PManagementDataImpl create() throws RemoteException{
		if(pm == null){
			synchronized(PManagementDataImpl.class){
		
		if(pm == null)
		pm = new PManagementDataImpl();
			}
		}
			
		return pm;
	}
	
   private volatile static PManagementDataImpl pm;

}
