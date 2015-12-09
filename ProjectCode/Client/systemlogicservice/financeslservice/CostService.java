package financeslservice;

import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;
import enums.PaymentType;
import enums.ResultMessage;

public interface CostService {
	public PaymentVO setPayment(PaymentType paymentType,StaffVO receiver);
	public PaymentVO computePayment(PaymentVO payment);
	public PaymentVO computePayment(PaymentVO payment,double money);
	public ResultMessage payPayment(PaymentVO payment,AccountVO account);
	
}
