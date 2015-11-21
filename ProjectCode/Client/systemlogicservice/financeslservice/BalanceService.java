package financeslservice;

import java.util.ArrayList;

import vo.ReceiptsVO;

public interface BalanceService {
	public ArrayList<ReceiptsVO> getBalanceMessage(String office,String time);
}
