package financesl;

import java.util.ArrayList;

import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class Balance {
	
	static Balance balance;
	
	private Balance(){
		
	}

	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime,String office) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
	
	public static Balance createBalance(){
		if(balance==null){
			balance=new Balance();
		}
		
		return balance;
	}

}
