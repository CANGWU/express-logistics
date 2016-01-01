package financesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import auditsl.AuditInfo;
import po.PaymentPO;
import dataserviceimpl.DataFactory;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;
import enums.PaymentType;
import enums.ResultMessage;
import financeslservice.CostService;

public class CostController implements CostService,AuditInfo{
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

	@Override
	public ArrayList<PaymentVO> getAuditInfo() {
		// TODO Auto-generated method stub
		return cost.findAudit();
	}

	@Override
	public ResultMessage EndAudit(ArrayList list) {
		// TODO Auto-generated method stub
		return cost.endAudit(list);
	}

	@Override
	public String computeAuditNumber() {
		// TODO Auto-generated method stub
		return cost.computeAuditNumber();
	}
	

}
