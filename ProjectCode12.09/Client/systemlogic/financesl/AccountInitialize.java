package financesl;

import java.util.ArrayList;

import pamanagementsl.AManagement;
import pamanagementsl.CManagement;
import pamanagementsl.PManagement;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import vo.AccountVO;
import vo.AgencyVO;
import vo.CarVO;
import vo.CompanyAccountVO;
import vo.StaffVO;
import financeslservice.AccountInitializeService;

public class AccountInitialize implements AccountInitializeService{
	
	static AccountInitialize accountinitialize;
	DataFactory datafactory;
	
	private AccountInitialize(DataFactory datafactory){
		this.datafactory=datafactory;
	}


	
	
	public static AccountInitialize createAccountInitialize(DataFactory datafactory){
		if(accountinitialize==null){
			accountinitialize=new AccountInitialize(datafactory);
		}
		
		return accountinitialize;
	}




	@Override
	public void initialize(CompanyAccountVO oldaccount) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public ResultMessage setAgency(ArrayList<AgencyVO> volist) {
		// TODO Auto-generated method stub
		
		ResultMessage result=ResultMessage.FAIL;
		
		AManagement am=AManagement.creatAManagement(datafactory);
		AgencyVO tempvo=null;
		for(int i=0;i<volist.size();i++){
			tempvo=volist.get(i);
			result=am.add(tempvo.getName(), tempvo.getIdNumber(), tempvo.getStaff(), tempvo.getPhoneNumber(), tempvo.getAddress(), tempvo.getLeader());
		    if(result==ResultMessage.FAIL){
		    	break;
		    }
		}
		
		return result;
	}




	@Override
	public ResultMessage setStaff(ArrayList<StaffVO> volist) {
		// TODO Auto-generated method stub
		
		ResultMessage result=ResultMessage.FAIL;
		PManagement pm=PManagement.createPManagement(datafactory);
		StaffVO tempvo=null;
		for(int i=0;i<volist.size();i++){
			tempvo=volist.get(i);
			result=pm.add(tempvo.getName(), tempvo.getWork(), tempvo.getWorkNumber(), tempvo.getWorkPlaceNumber(), tempvo.getBirthDate(), tempvo.getIdNumber(), tempvo.getPhoneNumber(), tempvo.getAddress(), tempvo.getSex(), tempvo.getPage());
			if(result==ResultMessage.FAIL){
				break;
			}
		}
		
		return result;
	}




	@Override
	public ResultMessage setCar(ArrayList<CarVO> volist) {
		// TODO Auto-generated method stub
		ResultMessage result=ResultMessage.FAIL;
		
		CManagement cm=CManagement.createCManagement(datafactory);
		CarVO tempvo=null;
		
		for(int i=0;i<volist.size();i++){
			tempvo=volist.get(i);
			result=cm.add(tempvo.getIDNumber(), tempvo.getWorkPlaceNumber(), tempvo.getLicenseNumber(), tempvo.getWorkYear());
			if(result==ResultMessage.FAIL){
				break;
			}
		}
		
		
		
		return result;
	}




	@Override
	public ResultMessage setAccount(ArrayList<AccountVO> volist) {
		// TODO Auto-generated method stub
		ResultMessage result=ResultMessage.FAIL;
		
		AccountVO tempvo=null;
		AccountManagement am=AccountManagement.creatAccountManagement(datafactory);
		for(int i=0;i<volist.size();i++){
			tempvo=volist.get(i);
			result=am.addAccount(tempvo.getName(), tempvo.getBalance());
			if(result==ResultMessage.FAIL){
				break;
			}
		}
				
		
		
		return result;
	}

}
