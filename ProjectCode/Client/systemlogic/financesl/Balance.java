package financesl;

import java.util.ArrayList;

import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class Balance implements BalanceService{
	
	static Balance balance;
	
	private Balance(){
		
	}

	@Override
	public ArrayList<ReceiptsVO> getBalanceMessage(String office,
			String time) {
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
