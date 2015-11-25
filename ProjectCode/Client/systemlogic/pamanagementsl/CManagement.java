package pamanagementsl;

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
		CarPO po=data.find(id);
		vo=new CarVO(po);
		
		return vo;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		CManagementDataService data=datafactory.getCManagementData();
		
		return data.delete(id);
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
		return data.update(po);
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
		
		
		return data.insert(po);
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
		ArrayList<CarPO> polist=data.findAll();
		
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
