package financesl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class BalanceController implements BalanceService{
	
	Balance balance;
	
	public BalanceController(DataFactory datafactory){
		balance=Balance.createBalance();
	}

	@Override
	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime, String office) {
		// TODO Auto-generated method stub
		return balance.getBalanceMessage(starttime, endtime, office);
	}

}
