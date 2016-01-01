package pamanagementsl;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.DManagementDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import pamanagementslservice.DManagementService;
import po.DriverPO;
import vo.DriverVO;

public class DManagement {
	DataFactory datafactory;
	static DManagement dmanagement;

	private DManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	

	public DriverVO select(String id) {
		// TODO Auto-generated method stub
		DManagementDataService data=datafactory.getDManagementData();
		DriverPO po;
		DriverVO vo=null;
		try {
			po = data.find(id);		
		    vo=new DriverVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vo;
	}


	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		DManagementDataService data=datafactory.getDManagementData();
		try {
			return data.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
	}


	public DriverVO revise(String id) {
		// TODO Auto-generated method stub
		DManagementDataService data=datafactory.getDManagementData();
		DriverVO vo=null;
		DriverPO po;
		
		try {
			po=data.find(id);
			vo=new DriverVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}


	public ResultMessage saveChange(DriverVO vo) {

		// TODO Auto-generated method stub
		DManagementDataService data=datafactory.getDManagementData();
		DriverPO po=new DriverPO(vo);
		
		try {
			return data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


	public ResultMessage save(DriverVO vo) {
		DManagementDataService data=datafactory.getDManagementData();
		DriverPO po=new DriverPO(vo);
		try {
			return data.insert(po);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
		
	}


	public ResultMessage add(String name,Work work,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,Sex sex,int driverYear,int page) {
		DManagementDataService data=datafactory.getDManagementData();
		DriverPO po=new DriverPO( name, work, workNumber, workPlaceNumber, birthDate, idNumber, phoneNumber, address, sex, driverYear, page);
		try {
			
			return data.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return ResultMessage.FAIL;
		}

		// TODO Auto-generated method stub
		
	}


	public ResultMessage endDManagement() {
		return null;
		// TODO Auto-generated method stub
		
	}


	public ArrayList<DriverVO> getAllDriver() {
		// TODO Auto-generated method stub
		DManagementDataService data=datafactory.getDManagementData();
		ArrayList<DriverVO> volist=new ArrayList<DriverVO>();
		ArrayList<DriverPO> polist;
		try {
			polist = data.findAll();		
			for(int i=0;i<polist.size();i++){
			volist.add(new DriverVO(polist.get(i)));
		    }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return volist;
	}
	
	public static DManagement createDManagement(DataFactory datafactory){
		if(dmanagement==null){
			dmanagement=new DManagement(datafactory);
		}
		
		return dmanagement;
	}

}
