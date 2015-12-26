package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.AManagementDataService;
import dataservice.CManagementDataService;
import dataservice.CheckDataService;
import dataservice.ConstantDataService;
import dataservice.DManagementDataService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import dataservice.IoputDataService;
import dataservice.PManagementDataService;
import dataservice.ReceiveDataService;
import dataservice.SalaryStrategyDataService;
import dataservice.SendDataService;
import dataservice.StockDataService;
import dataservice.TransportDataService;
import dataservice.UserDataService;

public class DataFactory implements DataFactoryService{
	
	
	@Override
	public CheckDataService getCheckData() {
		// TODO Auto-generated method stub
		try {
			return CheckDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FinanceDataService getFinanceData() {
		// TODO Auto-generated method stub
		try {
			return FinanceDataImpl.creat();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SendDataService getSendData() {
		// TODO Auto-generated method stub
		//SendDataService data=new SendDataServiceTXTFileImpl();
		try {
			return SendDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		try {
			return UserDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AManagementDataService getAManagementData() {
		// TODO Auto-generated method stub
		try {
			return AManagementDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public PManagementDataService getPManagementData() {
		// TODO Auto-generated method stub
		try {
			return PManagementDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DManagementDataService getDManagementData() {
		// TODO Auto-generated method stub
		try {
			return DManagementDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CManagementDataService getCManagementData() {
		// TODO Auto-generated method stub
		try {
			return CManagementDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ConstantDataService getConstantData() {
		// TODO Auto-generated method stub
		
		try {
			return ConstantDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public IoputDataService getIoputData() {
		// TODO Auto-generated method stub
		try {
			return IoputDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReceiveDataService getReceiveData() {
		// TODO Auto-generated method stub
		try {
			return ReceiveDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SalaryStrategyDataService getSalaryStrategyData() {
		// TODO Auto-generated method stub
		try {
			return SalaryStrategyDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StockDataService getStockDate() {
		// TODO Auto-generated method stub
		try {
			return StockDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransportDataService getTransportDate() {
		// TODO Auto-generated method stub
		try {
			return TransportDataImpl.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
       
}
