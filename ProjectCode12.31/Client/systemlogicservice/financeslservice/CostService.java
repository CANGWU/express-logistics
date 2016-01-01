package financeslservice;

import java.util.ArrayList;

import po.PaymentPO;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;
import enums.PaymentType;
import enums.ResultMessage;

public interface CostService {
	public PaymentVO setPayment(PaymentType paymentType,String receiver);
	public PaymentVO computePayment(PaymentVO payment);
	public PaymentVO computePayment(PaymentVO payment,double money);
	public ResultMessage payPayment(PaymentVO payment,AccountVO account);
	public String computeAuditNumber();
	
}
