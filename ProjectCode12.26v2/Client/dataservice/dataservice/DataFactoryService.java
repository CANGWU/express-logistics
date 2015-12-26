package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface DataFactoryService{
          
	   public CheckDataService getCheckData()throws RemoteException ;
	   
	   public FinanceDataService getFinanceData()throws RemoteException;
	   
	   public SendDataService getSendData()throws RemoteException;
	   
	   public UserDataService getUserData()throws RemoteException;
	   
	   public AManagementDataService getAManagementData()throws RemoteException;
	   
	   public PManagementDataService getPManagementData() throws RemoteException;
	   
	   public DManagementDataService getDManagementData()throws RemoteException;
	   
	   public CManagementDataService getCManagementData()throws RemoteException;
	   
	   public ConstantDataService getConstantData()throws RemoteException;
	   
	   public IoputDataService getIoputData()throws RemoteException;
	   
	   public ReceiveDataService getReceiveData()throws RemoteException;
	   
	   public SalaryStrategyDataService getSalaryStrategyData()throws RemoteException;
	   
	   public StockDataService getStockDate()throws RemoteException;
	   
	   public TransportDataService getTransportDate()throws RemoteException;
	   
	 
}
