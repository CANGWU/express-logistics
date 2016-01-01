package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import enums.DocumentCondition;
import enums.ResultMessage;
import po.*;

public interface FinanceDataService extends Remote{
//    
    public ResultMessage insertPaymentPO(PaymentPO paymennt) throws RemoteException;
    public ArrayList<PaymentPO> findsPaymentPO(String workplacenumber)throws RemoteException;
    public ArrayList<PaymentPO> findAudit() throws RemoteException;
    
    public ResultMessage updatePaymentPO(PaymentPO payment) throws RemoteException;
    public PaymentPO findLastest() throws RemoteException;
    
    public AccountPO findAccountPO(String id)throws RemoteException;
    public ArrayList<AccountPO> seekAccount(String name)throws RemoteException;
    public ResultMessage insertAccountPO(AccountPO account)throws RemoteException;
    public ResultMessage deleteAccountPO(AccountPO account)throws RemoteException;
    public ResultMessage updateAccountPO(AccountPO account)throws RemoteException;
    public ArrayList<AccountPO> getAllAccount()throws RemoteException;

    public CompanyAccountPO findCompanyAccountPO(String id)throws RemoteException;
    public ResultMessage insertCompanyAccountPO(CompanyAccountPO companyaccount)throws RemoteException;
	public ArrayList<PaymentPO> findPWithdContion(String nameOfWriter, DocumentCondition dCondition) throws RemoteException;
	
}
