package pamanagementsl;

import java.util.ArrayList;

import dataservice.AManagementDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import pamanagementslservice.AManagementService;
import po.AgencyPO;
import vo.AgencyVO;

public class AManagement {
    
	DataFactory datafactory;
	static AManagement amanagement;
	
	
	private AManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	

	public AgencyVO select(String id) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		AgencyPO po=data.find(id);
		AgencyVO vo=new AgencyVO(po);
		return vo;
	}


	public ArrayList<AgencyVO> getAllAgency() {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
        ArrayList<AgencyPO> polist=		data.findAll();
        ArrayList<AgencyVO> volist=new ArrayList<AgencyVO>();
        for(int i=0;i<polist.size();i++){
        	volist.add(new AgencyVO(polist.get(i).getName(),polist.get(i).getIDNumber(),polist.get(i).getStaff(),polist.get(i).getPhoneNumber(),polist.get(i).getAddress(),polist.get(i).getLeader()));
        }
		return volist;
	}

	
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		return data.delete(id);
		
	}


	public AgencyVO revise(String id) {
		// TODO Auto-generated method stub
		
		return this.select(id);
	}


	public ResultMessage saveChange(AgencyVO vo) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		AgencyPO po=new AgencyPO(vo)
;		
		return data.update(po);
	}


	public void save() {
		// TODO Auto-generated method stub
		
	}




	
	public static AManagement creatAManagement(DataFactory datafactory){
		if(amanagement==null)
			amanagement = new AManagement(datafactory);	
		
		 return amanagement;
	}


	public ResultMessage add(String name, String idNumber,
			ArrayList<String> staff, String phonenumber, String address,
			String leader) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		AgencyPO po=new AgencyPO(name,idNumber,staff,phonenumber,address,leader);
		return data.insert(po);
	}
	
	public AManagement createAManagement(DataFactory datafactory){
		if(amanagement==null){
			amanagement=new AManagement(datafactory);
		}
		
		return amanagement;
		
	}

}
