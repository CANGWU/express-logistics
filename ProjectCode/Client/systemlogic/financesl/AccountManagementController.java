package financesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import vo.AccountVO;
import enums.ResultMessage;
import financeslservice.AccountManagementService;

public class AccountManagementController implements AccountManagementService{
	
	AccountManagement accountmanagement;
	
	public AccountManagementController(){
		
		try {
			accountmanagement=AccountManagement.creatAccountManagement(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public ResultMessage fixAccount(AccountVO account, String accountname) {
		// TODO Auto-generated method stub
		return accountmanagement.fixAccount(account, accountname);
	}

	@Override
	public ArrayList<AccountVO> seekAccount(String accountname) {
		// TODO Auto-generated method stub
		return accountmanagement.seekAccount(accountname);
	}

	@Override
	public AccountVO findAccount(String accountname) {
		// TODO Auto-generated method stub
		return accountmanagement.findAccount(accountname);
	}

	@Override
	public ArrayList<AccountVO> getAllAccount() {
		// TODO Auto-generated method stub
		return accountmanagement.getAllAccount();
	}

}
