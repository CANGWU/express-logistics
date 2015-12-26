package financesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

import pamanagementsl.PManagementController;
import po.AccountPO;
import po.OrderPO;
import po.PaymentPO;
import po.SalaryPO;
import strategysl.SalaryStrategy;
import strategysl.SalaryStrategyController;
import dataservice.FinanceDataService;
import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.PaymentType;
import enums.ResultMessage;
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
		GetSingleStrategy salarystrategy=new SalaryStrategyController();
		PManagementController pmc=new PManagementController();
		StaffVO receiver=pmc.select(payment.getReceiver());
		SalaryPO salarypo=salarystrategy.getSingleSalaryStrategy(receiver.getWork());
		switch(salarypo.getWork()){
		case Driver:
		case Courier:
			payment.setNumberOfPayment(salarypo.getBaseWage()+salarypo.getCommission()*receiver.getNumber()
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




	public PaymentVO setPayment(PaymentType paymentType, String receiver) {
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
			try {
				data.updateAccountPO(accountpo);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			payment.setAccountname(account.getName());
			PaymentPO paymentpo=new PaymentPO(payment);
			try {
				return data.insertPaymentPO(paymentpo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			return ResultMessage.FAIL;
		}
		return null;
	}
	
	
	
	public ArrayList<PaymentVO> findAudit(){
		FinanceDataService data=datafactory.getFinanceData();
		ArrayList<PaymentPO> polist=null;
		ArrayList<PaymentVO> volist=new ArrayList<PaymentVO>();
		try {
             polist=data.findAudit();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<polist.size();i++){
			volist.add(new PaymentVO(polist.get(i)));
		}
		
		return volist;
		
	}
	
	public ResultMessage endAudit(ArrayList<PaymentVO> volist){
		FinanceDataService data=datafactory.getFinanceData();
        for(int i=0;i<volist.size();i++){
        	try {
				data.updatePaymentPO(new PaymentPO(volist.get(i)));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultMessage.FAIL;
			}
        }
		
		
		return ResultMessage.SUCCESS;
	}
	
	
	public String computeAuditNumber(){
		PaymentPO HistoryData = null;
	    MaskFormatter numberformatter=null;
		try {
			FinanceDataService data=datafactory.getFinanceData();
			HistoryData = data.findLastest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0000000001";
		}
		if(HistoryData==null)
			return "0000000001";
		else


			return String.format("%010d", Long.parseLong(HistoryData.getAuditnumber())+1);
		
	}




	

}
