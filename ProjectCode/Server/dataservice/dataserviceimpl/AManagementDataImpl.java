package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.AManagementDataService;
import po.AgencyPO;

public class AManagementDataImpl extends UnicastRemoteObject  implements AManagementDataService {

	private AManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgencyPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AgencyPO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(AgencyPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect(AgencyPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AgencyPO po) {
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
	public static AManagementDataImpl create() throws RemoteException{
		if(am == null){
			synchronized(AManagementDataImpl.class){
		
		if(am == null)
		am = new AManagementDataImpl();
			}
		}
			
		return am;
	}
	
   private volatile static AManagementDataImpl am;

}
