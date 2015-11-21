package dataserviceimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.TransportDataService;
import po.TransportPO;

public class TransportDataImpl implements TransportDataService {

	@Override
	public TransportPO find(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransportPO> finds(String fields, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TransportPO po) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(TransportPO po) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(TransportPO po) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() throws Exception {
		// TODO Auto-generated method stub

	}
	public static TransportDataImpl creat() throws RemoteException {
		if(transport == null){
			synchronized(TransportDataImpl.class){
		
		if(transport == null)
		transport = new TransportDataImpl();
			}
		}
			
		return transport;
	}
	
   private volatile static TransportDataImpl transport;

}
