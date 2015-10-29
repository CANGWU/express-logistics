package slstub;

import java.util.ArrayList;

import vo.*;

import financeslservice.FinanceService;

public class FinanceStub implements FinanceService {

	@Override
	public ArrayList<ReceiptsVO> getBalanceMessage(String office,
			String starttime, String endtime) {
		// TODO Auto-generated method stub
		String[] ordernumbers={"0000000001"};
		ReceiptsVO receipts=new ReceiptsVO("2015/1/1",10.00,"ÕÅÈý",ordernumbers);
		ArrayList<ReceiptsVO> list=new ArrayList<ReceiptsVO>();
		list.add(receipts);
		return list;
	}

	@Override
	public PaymentVO setPayment(AccountVO account, String paymentType,
			StaffVO receiver) {
		// TODO Auto-generated method stub
		PaymentVO payment=new PaymentVO(receiver,PaymentType.Salary);
		return payment;
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment) {
		// TODO Auto-generated method stub
	    payment.setNumberOfPayment(1000.0);
		return payment;
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment, double money) {
		// TODO Auto-generated method stub
        payment.setNumberOfPayment(money);
		return payment;
	}

	@Override
	public vo.ResultMessage payPayment(PaymentVO payment) {
		// TODO Auto-generated method stub
		return vo.ResultMessage.SUCCESS;
	}

	@Override
	public AccountVO addAccount(String accountname, double accountmoney) {
		// TODO Auto-generated method stub
		AccountVO account=new AccountVO(accountname,accountmoney);
		return account;
	}

	@Override
	public vo.ResultMessage deleteAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return vo.ResultMessage.SUCCESS;
	}

	@Override
	public AccountVO fixAccount(AccountVO account, String accountname) {
		// TODO Auto-generated method stub
		account.setName(accountname);
		return account;
	}

	@Override
	public ArrayList<AccountVO> seekAccount(String accountname) {
		// TODO Auto-generated method stub
		ArrayList<AccountVO> list=new ArrayList<AccountVO>();
		AccountVO account=new AccountVO(accountname,1000.0);
		list.add(account);
		return list;
	}

	@Override
	public CompanyAccountVO initialize(CompanyAccountVO oldaccount,
			String customer, String agency, String people, String stock,
			String bankaccount) {
		// TODO Auto-generated method stub
		CompanyAccountVO hh=new CompanyAccountVO();
		return hh;
	}

}
