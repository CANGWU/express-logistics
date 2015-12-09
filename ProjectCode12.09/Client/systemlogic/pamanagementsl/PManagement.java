package pamanagementsl;

import java.rmi.RemoteException;
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
		
		StaffPO po=null;
		try {
			po = data.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaffVO vo=new StaffVO(po);
		return vo;
	}


	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		try {
			return data.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;

		}
	}


	public StaffVO revise(String id) {
		// TODO Auto-generated method stub
		return this.select(id);
	}


	public ResultMessage saveChange(StaffVO vo) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		StaffPO po=new StaffPO(vo);
		try {
			return data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


	public ResultMessage save(StaffVO vo) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		StaffPO po =new StaffPO(vo);
		try {
			return data.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


	public ResultMessage add(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, double page) {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		StaffPO po=new StaffPO( name,  work,  workNumber, workPlaceNumber,  birthDate,  idNumber, phoneNumber,  address,  sex,  page);
		try {
			return data.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


	public ResultMessage endPManagement() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<StaffVO> getAllStaff() {
		// TODO Auto-generated method stub
		PManagementDataService data=datafactory.getPManagementData();
		ArrayList<StaffVO> volist=new ArrayList<StaffVO>();
		ArrayList<StaffPO> polist=null;
		try {
			polist = data.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
