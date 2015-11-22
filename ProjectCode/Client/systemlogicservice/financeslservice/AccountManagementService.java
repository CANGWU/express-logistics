package financeslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import vo.*;

public interface AccountManagementService {

	
	
	public ResultMessage addAccount(String accountname,double accountmoney);
	public ResultMessage deleteAccount(AccountVO account);
	public AccountVO fixAccount(AccountVO account,String accountname);
	public ArrayList<AccountVO> seekAccount(String accountname);
	
	
}
