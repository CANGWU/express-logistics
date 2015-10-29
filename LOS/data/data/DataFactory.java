package data;

import dataservice.CheckDataService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import dataservice.SendDataService;
import dataservice.UserDataService;
import dataserviceimpl.SendDataServiceTXTFileImpl;

public class DataFactory implements DataFactoryService{

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
       
}
