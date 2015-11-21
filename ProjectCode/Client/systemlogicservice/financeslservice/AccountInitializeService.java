package financeslservice;

import vo.CompanyAccountVO;

public interface AccountInitializeService {
	public CompanyAccountVO initialize(CompanyAccountVO oldaccount,String customer,String agency,String people,String stock,String bankaccount);
}
