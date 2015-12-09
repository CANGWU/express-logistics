package financesl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class Balance {
	
	static Balance balance;
	 DataFactory datafactory;
	
	private Balance(DataFactory datafactory){
		this.datafactory=datafactory;
	}

	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime,String office) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
	public ArrayList<ReceiptsVO> getBalanceMessage(String date, String office) {
		// TODO Auto-generated method stub
		return null;
	}


	public double getTotalMoney(ArrayList<ReceiptsVO> list) {
		// TODO Auto-generated method stub
		double totalMoney=0.0;
		
		for(int i=0;i<list.size();i++){
			totalMoney+=list.get(i).getFee();
		}
		return totalMoney;
	}
	
	
	public static Balance createBalance(DataFactory datafactory){
		if(balance==null){
			balance=new Balance(datafactory);
		}
		
		return balance;
	}

}
