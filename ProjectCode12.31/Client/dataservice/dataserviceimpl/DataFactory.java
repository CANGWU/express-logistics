package dataserviceimpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

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
	String URL;
	private static DataFactory dataFactory;
	private CheckDataService checkDataService;


	private DataFactory(){
		//System.setSecurityManager(new RMISecurityManager());
		 URL = "localhost";
	}
	@Override
	public CheckDataService getCheckData() {
		// TODO Auto-generated method stub
		CheckDataService checkData;
		try {
			checkData = (CheckDataService)Naming.lookup("//"+URL+":1099/getCheckDataService");
			return checkData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FinanceDataService getFinanceData() {
		// TODO Auto-generated method stub
		FinanceDataService FinanceData;
		try {
			FinanceData = (FinanceDataService)Naming.lookup("//"+URL+":1099/getFinanceDataService");
			return FinanceData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SendDataService getSendData() {
		// TODO Auto-generated method stub
		SendDataService SendData;
		try {
			SendData = (SendDataService)Naming.lookup("//"+URL+":1099/getSendDataService");
			return SendData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDataService getUserData() {
		// TODO Auto-generated method stub
		UserDataService user;
		try {
			user = (UserDataService)Naming.lookup("//"+URL+":1099/getUserDataService");
			return user;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AManagementDataService getAManagementData() {
		// TODO Auto-generated method stub
		AManagementDataService amanagementData;
		try {
			amanagementData = (AManagementDataService)Naming.lookup("//"+URL+":1099/getAManagementDataService");
			return amanagementData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PManagementDataService getPManagementData() {
		// TODO Auto-generated method stub
		PManagementDataService pmanagementData;
		try {
			pmanagementData = (PManagementDataService)Naming.lookup("//"+URL+":1099/getPManagementDataService");
			return pmanagementData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DManagementDataService getDManagementData() {
		// TODO Auto-generated method stub
		DManagementDataService dmanagementData;
		try {
			dmanagementData = (DManagementDataService)Naming.lookup("//"+URL+":1099/getDManagementDataService");
			return dmanagementData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CManagementDataService getCManagementData() {
		// TODO Auto-generated method stub
		CManagementDataService cmanagementData;
		try {
			cmanagementData = (CManagementDataService)Naming.lookup("//"+URL+":1099/getCManagementDataService");
			return cmanagementData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ConstantDataService getConstantData() {
		// TODO Auto-generated method stub
		ConstantDataService constantData;
		try {
			constantData = (ConstantDataService)Naming.lookup("//"+URL+":1099/getConstantDataService");
			return constantData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public IoputDataService getIoputData() {
		// TODO Auto-generated method stub
		IoputDataService ioputData;
		try {
			ioputData = (IoputDataService)Naming.lookup("//"+URL+":1099/getIoputDataService");
			return ioputData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReceiveDataService getReceiveData() {
		// TODO Auto-generated method stub
		ReceiveDataService receiveData;
		try {
			receiveData = (ReceiveDataService)Naming.lookup("//"+URL+":1099/getReceiveDataService");
			return receiveData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public SalaryStrategyDataService getSalaryStrategyData() {
		// TODO Auto-generated method stub
		SalaryStrategyDataService salaryData;
		try {
			salaryData = (SalaryStrategyDataService)Naming.lookup("//"+URL+":1099/getSalaryStrategyDataService");
			return salaryData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StockDataService getStockDate() {
		// TODO Auto-generated method stub
		StockDataService stockData;
		try {
			stockData = (StockDataService)Naming.lookup("//"+URL+":1099/getStockDataService");
			return stockData;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransportDataService getTransportDate() {
		// TODO Auto-generated method stub
		TransportDataService transport;
		try {
			transport = (TransportDataService)Naming.lookup("//"+URL+":1099/getTransportDataService");
			return transport;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	public static DataFactory create() throws RemoteException{
		if(dataFactory == null){
			synchronized(DataFactory.class){

				if(dataFactory == null)
					dataFactory = new DataFactory();
			}
		}

		return dataFactory;
	}


}
