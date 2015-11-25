package financesl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import vo.AccountVO;
import enums.ResultMessage;
import financeslservice.AccountManagementService;

public class AccountManagementController implements AccountManagementService{
	
	AccountManagement accountmanagement;
	
	public AccountManagementController(DataFactory datafactory){
		accountmanagement=AccountManagement.creatAccountManagement(datafactory);
	}

	@Override
	public ResultMessage addAccount(String accountname, double accountmoney) {
		// TODO Auto-generated method stub
		return accountmanagement.addAccount(accountname, accountmoney);
	}

	@Override
	public ResultMessage deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return accountmanagement.deleteAccount(account);
	}

	@Override
	public AccountVO fixAccount(AccountVO account, String accountname) {
		// TODO Auto-generated method stub
		return accountmanagement.fixAccount(account, accountname);
	}

	@Override
	public ArrayList<AccountVO> seekAccount(String accountname) {
		// TODO Auto-generated method stub
		return accountmanagement.seekAccount(accountname);
	}

}
