package financeslservice;

import vo.AccountVO;

public interface AccountBalanceChange {
	public AccountVO changeBalance(AccountVO vo,double balance);

}
