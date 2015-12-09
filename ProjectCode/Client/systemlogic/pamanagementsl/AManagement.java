package pamanagementsl;

import java.rmi.RemoteException;
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
		AgencyPO po = null;
		try {
			po = data.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AgencyVO vo=new AgencyVO(po);
		return vo;
	}


	public ArrayList<AgencyVO> getAllAgency() {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
        ArrayList<AgencyPO> polist = null;
		try {
			polist = data.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ArrayList<AgencyVO> volist=new ArrayList<AgencyVO>();
        for(int i=0;i<polist.size();i++){
        	volist.add(new AgencyVO(polist.get(i).getName(),polist.get(i).getIDNumber(),polist.get(i).getStaff(),polist.get(i).getPhoneNumber(),polist.get(i).getAddress(),polist.get(i).getLeader()));
        }
		return volist;
	}

	
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		AManagementDataService data=datafactory.getAManagementData();
		try {
			return data.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
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
		try {
			return data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
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
		
		try {
			return data.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public AManagement createAManagement(DataFactory datafactory){
		if(amanagement==null){
			amanagement=new AManagement(datafactory);
		}
		
		return amanagement;
		
	}

}
