package financesl;

import dataserviceimpl.DataFactory;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;
import enums.PaymentType;
import enums.ResultMessage;
import financeslservice.CostService;

public class CostController implements CostService{
	Cost cost;
	
	public CostController(DataFactory datafactory){
		cost=Cost.createCost(datafactory);
	}

	@Override
	public PaymentVO setPayment(PaymentType paymentType, StaffVO receiver) {
		// TODO Auto-generated method stub
		return cost.setPayment(paymentType, receiver);
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment) {
		// TODO Auto-generated method stub
		return cost.computePayment(payment);
	}

	@Override
	public PaymentVO computePayment(PaymentVO payment, double money) {
		// TODO Auto-generated method stub
		return cost.computePayment(payment, money);
	}

	@Override
	public ResultMessage payPayment(PaymentVO payment, AccountVO account) {
		// TODO Auto-generated method stub
		return cost.payPayment(payment, account);
	}
	

}
