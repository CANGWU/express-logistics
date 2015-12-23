package financeslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import vo.AccountVO;
import vo.AgencyVO;
import vo.CarVO;
import vo.CompanyAccountVO;
import vo.StaffVO;

public interface AccountInitializeService {
	public void initialize(CompanyAccountVO oldaccount);
	public ResultMessage setAgency(ArrayList<AgencyVO> volist);
	public ResultMessage setStaff(ArrayList<StaffVO> volist);
	public ResultMessage setCar(ArrayList<CarVO> volist);
	//public ResultMessage setStock(StockVO vo);
	public ResultMessage setAccount(ArrayList<AccountVO> volist);
	
	
}
