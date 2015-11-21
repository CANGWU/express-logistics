package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataserviceimpl.CManagementDataImpl;

public interface DataFactoryService{
          
	   public CheckDataService getCheckData() ;
	   
	   public FinanceDataService getFinanceData();
	   
	   public SendDataService getSendData();
	   
	   public UserDataService getUserData();
	   
	   public AManagementDataService getAManagementData();
	   
	   public PManagementDataService getPManagementData() ;
	   
	   public DManagementDataService getDManagementData();
	   
	   public CManagementDataService getCManagementData();
	   
	   public ConstantDataService getConstantData();
	   
	   public IoputDataService getIoputData();
	   
	   public ReceiveDataService getReceiveData();
	   
	   public SalaryStrategyDataService getSalaryStrategyData();
	   
	   public StockDataService getStockDate();
	   
	   public TransportDataService getTransportDate();
	   
	 
}
