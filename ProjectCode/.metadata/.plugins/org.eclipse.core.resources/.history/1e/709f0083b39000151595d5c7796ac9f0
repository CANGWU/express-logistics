package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.FinanceDataService;
import po.AccountPO;
import po.CompanyAccountPO;
import po.PaymentPO;
import po.ReceiptsPO;
import po.ResultMessage;

public class FinanceDataImpl extends UnicastRemoteObject implements FinanceDataService {

	private FinanceDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ReceiptsPO findReceiptsPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptsPO> findsUser(String[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertPaymentPO(PaymentPO paymennt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountPO findAccountPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountPO> findsAccountPO(String[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyAccountPO findCompanyAccountPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertCompanyAccountPO(CompanyAccountPO companyaccount) {
		// TODO Auto-generated method stub
		return null;
	}

	public static FinanceDataImpl creat() throws RemoteException {
		if(finance == null){
			synchronized(FinanceDataImpl.class){
		
		if(finance == null)
		finance = new FinanceDataImpl();
			}
		}
			
		return finance;
	}
	
   private volatile static FinanceDataImpl finance;

}
