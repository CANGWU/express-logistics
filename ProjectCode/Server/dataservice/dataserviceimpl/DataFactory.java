package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.AManagementDataService;
import dataservice.CManagementDataService;
import dataservice.CheckDataService;
import dataservice.DManagementDataService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import dataservice.PManagementDataService;
import dataservice.SendDataService;
import dataservice.UserDataService;

public class DataFactory extends UnicastRemoteObject implements DataFactoryService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataFactory() throws RemoteException{
		super();
		
	}

	@Override
	public CheckDataService getCheckData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinanceDataService getFinanceData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendDataService getSendData() {
		// TODO Auto-generated method stub
		SendDataService data=new SendDataServiceTXTFileImpl();
		return data;
	}

	@Override
	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AManagementDataService getAManagementData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PManagementDataService getPManagementData() {
		// TODO Auto-generated method stub
		try {
			return new PManagementDataImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DManagementDataService getDManagementData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CManagementDataService getCManagementData() {
		// TODO Auto-generated method stub
		return null;
	}
       
}