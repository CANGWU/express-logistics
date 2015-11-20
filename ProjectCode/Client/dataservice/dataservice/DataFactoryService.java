package dataservice;

import java.rmi.Remote;

public interface DataFactoryService extends Remote{
          
	   public CheckDataService getCheckData();
	   
	   public FinanceDataService getFinanceData();
	   
	   public SendDataService getSendData();
	   
	   public UserDataService getUserData();
	   
	   public AManagementDataService getAManagementData();
	   
	   public PManagementDataService getPManagementData();
	   
	   public DManagementDataService getDManagementData();
	   
	   public CManagementDataService getCManagementData();
	   
	     
	   
}
