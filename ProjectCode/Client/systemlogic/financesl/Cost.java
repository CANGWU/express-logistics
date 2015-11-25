package financesl;

import po.AccountPO;
import po.PaymentPO;
import po.SalaryPO;
import strategysl.SalaryStrategy;
import dataservice.FinanceDataService;
import dataserviceimpl.DataFactory;
import enums.PaymentType;
import enums.ResultMessage;
import enums.Work;
import financeslservice.AccountBalanceChange;
import financeslservice.CostService;
import vo.AccountVO;
import vo.PaymentVO;
import vo.StaffVO;

public class Cost  {
	
	DataFactory datafactory;
	static Cost cost;
	
	
	private Cost(DataFactory datafactory){
		this.datafactory=datafactory;
	}




	public PaymentVO computePayment(PaymentVO payment) {
		// TODO Auto-generated method stub
		SalaryStrategy salarystrategy=new SalaryStrategy(datafactory);
		SalaryPO salarypo=salarystrategy.getSingleSalaryStrategy(payment.getReceiver().getWork());
		switch(salarypo.getWork()){
		case Driver:
		case Courier:
			payment.setNumberOfPayment(salarypo.getBaseWage()+salarypo.getCommission()*payment.getReceiver().getNumber()
					);
			break;
		case Officer:
		case Finance:
		case Manager:
		case Admin:
		case Stock:
		case TransOffice:
			payment.setNumberOfPayment(salarypo.getBaseWage());
			break;
			
		}
		return payment;
	}


	public PaymentVO computePayment(PaymentVO payment, double money) {
		// TODO Auto-generated method stub
		payment.setNumberOfPayment(money);
		return payment;
	}


	
	
	public static Cost createCost(DataFactory datafactory){
		if(cost==null){
			cost=new Cost(datafactory);
		}
		
		return cost;
	}




	public PaymentVO setPayment(PaymentType paymentType, StaffVO receiver) {
		// TODO Auto-generated method stub

		PaymentVO vo=new PaymentVO(receiver,paymentType);
		return vo;
		
	}




	public ResultMessage payPayment(PaymentVO payment, AccountVO account) {
		// TODO Auto-generated method stub
		if(account.getBalance()>=payment.getNumberOfPayment()){

			AccountManagement accountmanagement= AccountManagement.creatAccountManagement(datafactory);
			account=accountmanagement.changeBalance(account, account.getBalance()-payment.getNumberOfPayment());
			FinanceDataService data=datafactory.getFinanceData();
			AccountPO accountpo=account.changeToPo();
			data.updateAccountPO(accountpo);
			
			PaymentPO paymentpo=payment.changeToPO();
			return data.insertPaymentPO(paymentpo);
		}else{
			return ResultMessage.FAIL;
		}
	}




	

}
