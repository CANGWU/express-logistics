package pamanagementsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.CManagementDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import pamanagementslservice.CManagementService;
import po.CarPO;
import vo.CarVO;

public class CManagement implements CManagementService{
	DataFactory datafactory;
	static CManagement cmanagement;
	
	private CManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}

	@Override
	public CarVO select(String id) {
		// TODO Auto-generated method stub
		CarVO vo=null;
		
		CManagementDataService data=datafactory.getCManagementData();
		CarPO po = null;
		try {
			po = data.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo=new CarVO(po);
		
		return vo;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		CManagementDataService data=datafactory.getCManagementData();
		
		try {
			return data.delete(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public CarVO revise(String id) {
		// TODO Auto-generated method stub
		return this.select(id);
	}

	@Override
	public ResultMessage saveChange(CarVO vo) {
		// TODO Auto-generated method stub
		CManagementDataService data=datafactory.getCManagementData();
		CarPO po=new CarPO(vo);
		try {
			return data.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage save(CarVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(String idNumber, String workPlaceNumber,
			String licenseNumber, int workYear) {
		// TODO Auto-generated method stub
		CManagementDataService data=datafactory.getCManagementData();
		CarPO po=new CarPO(idNumber,workPlaceNumber,licenseNumber,workYear);
		
		
		try {
			return data.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage endCManagement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarVO> getAllCar() {
		// TODO Auto-generated method stub
		CManagementDataService data=datafactory.getCManagementData();
		ArrayList<CarVO> volist=new ArrayList<CarVO>();
		ArrayList<CarPO> polist = null;
		try {
			polist = data.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<polist.size();i++){
			volist.add(new CarVO(polist.get(i)));
		}
		return volist;
	}
	
	public static CManagement createCManagement(DataFactory datafactory){
		if(cmanagement==null){
			cmanagement=new CManagement(datafactory);
		}
		
		return cmanagement;
	}
	


}
