package financesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AccountPO;
import dataservice.FinanceDataService;
import dataserviceimpl.DataFactory;
import vo.AccountVO;
import enums.ResultMessage;
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
		
		try {
			return data.insertAccountPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public ResultMessage deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		FinanceDataService data=datafactory.getFinanceData();
		AccountPO po=new AccountPO(account.getName(),account.getBalance());

		try {
			return 	data.deleteAccountPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public ResultMessage fixAccount(AccountVO account, String accountname) {
		// TODO Auto-generated method stub
		FinanceDataService data=datafactory.getFinanceData();
		account.setName(accountname);
		AccountPO po=new AccountPO(account.getName(),account.getBalance());

		
		try {
			return 		data.updateAccountPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AccountVO> seekAccount(String accountname) {
		// TODO Auto-generated method stub
		
		FinanceDataService data=datafactory.getFinanceData();
		ArrayList<AccountVO> volist=new ArrayList<AccountVO>();
		ArrayList<AccountPO> polist=new ArrayList<AccountPO>();
		
		try {
			polist=data.seekAccount(accountname);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++){
		   volist.add(new AccountVO(polist.get(i)));
		}

		
		return volist;
	}
	
	public ArrayList<AccountVO> getAllAccount(){
		FinanceDataService data=datafactory.getFinanceData();
		ArrayList<AccountVO> volist=new ArrayList<AccountVO>();
		ArrayList<AccountPO> polist=new ArrayList<AccountPO>();
		
		try {
			polist=data.getAllAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<polist.size();i++){
		   volist.add(new AccountVO(polist.get(i)));
		}

		
		return volist;
	}
	
	public AccountVO findAccount(String accountname){
		FinanceDataService data=datafactory.getFinanceData();
		try {
			return new AccountVO(data.findAccountPO(accountname));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
