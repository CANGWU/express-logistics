package pamanagementsl;

import java.util.ArrayList;

import dataservice.AManagementDataService;
import dataserviceimpl.DataFactory;
import pamanagementslservice.AManagementService;
import po.AgencyPO;
import vo.AgencyVO;

public class AManagement implements AManagementService{
    
	DataFactory datafactory;
	static AManagement amanagement;
	
	
	private AManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	
	@Override
	public AgencyVO select(String id) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		AgencyPO po=data.find(id);
		AgencyVO vo=new AgencyVO(po.getName(),po.getIDNumber(),po.getStaff(),po.getPhoneNumber(),po.getAddress(),po.getLeader());
		return vo;
	}

	@Override
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

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		data.delete(id);
		
	}

	@Override
	public AgencyVO revise(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveChange(AgencyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(AgencyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endAManagement() {
		// TODO Auto-generated method stub
		
	}
	
	public static AManagement creatAManagement(DataFactory datafactory){
		if(amanagement==null)
			amanagement = new AManagement(datafactory);	
		
		 return amanagement;
	}

}
