package financesl;

import java.rmi.RemoteException;

import dataserviceimpl.DataFactory;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;
import enums.PaymentType;
import enums.ResultMessage;
import financeslservice.CostService;

public class CostController implements CostService{
	Cost cost;
	
	public CostController(){
		try {
			cost=Cost.createCost(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public PaymentVO setPayment(PaymentType paymentType, String receiver) {
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
