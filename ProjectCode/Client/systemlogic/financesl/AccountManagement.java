package financesl;

import java.util.ArrayList;

import po.AccountPO;
import dataservice.FinanceDataService;
import dataserviceimpl.DataFactory;
import vo.AccountVO;
import enums.ResultMessage;
import financeslservice.AccountBalanceChange;
import financeslservice.AccountManagementService;

public class AccountManagement implements AccountBalanceChange{
	
	DataFactory datafactory;
	static AccountManagement accountmanagement;
	
	private AccountManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}


	public ResultMessage addAccount(String accountname, double accountmoney) {
		// TODO Auto-generated method stub
		
		FinanceDataService data=datafactory.getFinanceData();
		AccountPO po=new AccountPO(accountname,accountmoney);
		
		return data.insertAccountPO(po);
	}


	public ResultMessage deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		FinanceDataService data=datafactory.getFinanceData();
		AccountPO po=new AccountPO(account.getName(),account.getBalance());

		return 	data.deleteAccountPO(po);
	}


	public AccountVO fixAccount(AccountVO account, String accountname) {
		// TODO Auto-generated method stub
		FinanceDataService data=datafactory.getFinanceData();
		account.setName(accountname);
		AccountPO po=new AccountPO(account.getName(),account.getBalance());
		data.updateAccountPO(po);
		
		return account;
	}

	public ArrayList<AccountVO> seekAccount(String accountname) {
		// TODO Auto-generated method stub
		
		FinanceDataService data=datafactory.getFinanceData();
		ArrayList list=data.seekAccount(accountname);
		return list;
	}
	
	
	static AccountManagement creatAccountManagement(DataFactory datafactory){
		if(accountmanagement==null)
			accountmanagement = new AccountManagement(datafactory);	
		
		 return accountmanagement;
	}

	@Override
	public AccountVO changeBalance(AccountVO vo, double balance) {
		// TODO Auto-generated method stub
		vo.setBalance(balance);
		return vo;
	}

}
