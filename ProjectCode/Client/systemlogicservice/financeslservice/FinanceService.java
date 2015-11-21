package financeslservice;

import java.util.ArrayList;

import vo.*;

public interface FinanceService {
	public ArrayList<ReceiptsVO> getBalanceMessage(String office,String starttime,String endtime);
	
	public PaymentVO setPayment(AccountVO account,String paymentType,StaffVO receiver);
	public PaymentVO computePayment(PaymentVO payment);
	public PaymentVO computePayment(PaymentVO payment,double money);
	public ResultMessage payPayment(PaymentVO payment);
	
	
	public AccountVO addAccount(String accountname,double accountmoney);
	public ResultMessage deleteAccount(AccountVO account);
	public AccountVO fixAccount(AccountVO account,String accountname);
	public ArrayList<AccountVO> seekAccount(String accountname);
	
	public CompanyAccountVO initialize(CompanyAccountVO oldaccount,String customer,String agency,String people,String stock,String bankaccount);
	
}
