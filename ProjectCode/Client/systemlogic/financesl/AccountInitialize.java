package financesl;

import dataserviceimpl.DataFactory;
import vo.CompanyAccountVO;
import financeslservice.AccountInitializeService;

public class AccountInitialize implements AccountInitializeService{
	
	static AccountInitialize accountinitialize;
	DataFactory datafactory;
	
	private AccountInitialize(DataFactory datafactory){
		this.datafactory=datafactory;
	}

	@Override
	public CompanyAccountVO initialize(CompanyAccountVO oldaccount,
			String customer, String agency, String people, String stock,
			String bankaccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static AccountInitialize createAccountInitialize(DataFactory datafactory){
		if(accountinitialize==null){
			accountinitialize=new AccountInitialize(datafactory);
		}
		
		return accountinitialize;
	}

}
