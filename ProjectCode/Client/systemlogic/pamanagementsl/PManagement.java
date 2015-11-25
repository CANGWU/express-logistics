package pamanagementsl;

import java.util.ArrayList;

import dataservice.PManagementDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import pamanagementslservice.PManagementService;
import po.StaffPO;
import vo.StaffVO;

public class PManagement {
	
	DataFactory datafactory;
	static PManagement pmanagement;
	
	private PManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}


	public StaffVO select(String id) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		
		StaffPO po=data.find(id);
		StaffVO vo=new StaffVO(po);
		return vo;
	}


	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		return data.delete(id);
	}


	public StaffVO revise(String id) {
		// TODO Auto-generated method stub
		return this.select(id);
	}


	public ResultMessage saveChange(StaffVO vo) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		StaffPO po=new StaffPO(vo);
		return data.update(po);
	}


	public ResultMessage save(StaffVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResultMessage add(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, double page) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		StaffPO po=new StaffPO( name,  work,  workNumber, workPlaceNumber,  birthDate,  idNumber, phoneNumber,  address,  sex,  page);
		return data.insert(po);
	}


	public ResultMessage endPManagement() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<StaffVO> getAllStaff() {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		ArrayList<StaffVO> volist=new ArrayList<StaffVO>();
		ArrayList<StaffPO> polist=data.findAll();
		
		for(int i=0;i<polist.size();i++){
			volist.add(new StaffVO(polist.get(i)));
		}
		
		return volist;
	}
	
	public static PManagement createPManagement(DataFactory datafactory){
		if(pmanagement==null){
			pmanagement=new PManagement(datafactory);
		}
		return pmanagement;
	}

}
