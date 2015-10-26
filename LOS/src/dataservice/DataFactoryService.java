package dataservice;

public interface DataFactoryService {
          
	   public CheckDataService getCheckData();
	   
	   public FinanceDataService getFinanceData();
	   
	   public SendDataService getSendData();
	   
	   public UserDataService getUserData();
	   
}
