package financesl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class BalanceController implements BalanceService{
	
	Balance balance;
	
	public BalanceController(){
		balance=Balance.createBalance();
	}

	@Override
	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime, String office) {
		// TODO Auto-generated method stub
		return balance.getBalanceMessage(starttime, endtime, office);
	}

	@Override
	public ArrayList<ReceiptsVO> getBalanceMessage(String date, String office) {
		// TODO Auto-generated method stub
		return balance.getBalanceMessage(date, office);
	}

	@Override
	public double getTotalMoney(ArrayList<ReceiptsVO> list) {
		// TODO Auto-generated method stub
		return balance.getTotalMoney(list);
	}

}
