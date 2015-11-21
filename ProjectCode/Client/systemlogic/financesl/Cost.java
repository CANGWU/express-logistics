package financesl;

import enums.ResultMessage;
import financeslservice.CostService;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;

public class Cost implements CostService {

	@Override
	public PaymentVO setPayment(AccountVO account, String paymentType,
			StaffVO receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment, double money) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage payPayment(PaymentVO payment) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
