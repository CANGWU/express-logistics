package financeslservice;

import java.util.ArrayList;

import vo.ReceiptsVO;

public interface BalanceService {
	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,String endtime,String office);
	public ArrayList<ReceiptsVO> getBalanceMessage(String date,String office);
	public double getTotalMoney(ArrayList<ReceiptsVO> list);
}
