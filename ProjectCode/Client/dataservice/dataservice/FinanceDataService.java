package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.*;

public interface FinanceDataService extends Remote{
    public ReceiptsPO findReceiptsPO(String id);
    public ArrayList<ReceiptsPO> findsUser(String id[]);
    
    public ResultMessage insertPaymentPO(PaymentPO paymennt);
    
    public AccountPO findAccountPO(String id);
    public ArrayList<AccountPO> findsAccountPO(String id[]);
    public ResultMessage insertAccountPO(AccountPO account);
    public ResultMessage deleteAccountPO(AccountPO account);
    public ResultMessage updateAccountPO(AccountPO account);
    
    public CompanyAccountPO findCompanyAccountPO(String id);
    public ResultMessage insertCompanyAccountPO(CompanyAccountPO companyaccount);
	
}
