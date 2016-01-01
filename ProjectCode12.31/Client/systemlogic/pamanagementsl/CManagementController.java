package pamanagementsl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import pamanagementslservice.CManagementService;
import vo.CarVO;

public class CManagementController implements CManagementService{
	
	CManagement cmanagement;
	
	public CManagementController(DataFactory datafactory){
		cmanagement=CManagement.createCManagement(datafactory);
	}

	@Override
	public CarVO select(String id) {
		// TODO Auto-generated method stub
		return cmanagement.select(id);
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return cmanagement.delete(id);
	}

	@Override
	public CarVO revise(String id) {
		// TODO Auto-generated method stub
		return cmanagement.revise(id);
	}

	@Override
	public ResultMessage saveChange(CarVO vo) {
		// TODO Auto-generated method stub
		return cmanagement.saveChange(vo);
	}

	@Override
	public ResultMessage save(CarVO vo) {
		// TODO Auto-generated method stub
		return cmanagement.save(vo);
	}

	@Override
	public ResultMessage add(String idNumber, String workPlaceNumber,
			String licenseNumber, int workYear) {
		// TODO Auto-generated method stub
		return cmanagement.add(idNumber, workPlaceNumber, licenseNumber, workYear);
	}

	@Override
	public ResultMessage endCManagement() {
		// TODO Auto-generated method stub
		return cmanagement.endCManagement();
	}

	@Override
	public ArrayList<CarVO> getAllCar() {
		// TODO Auto-generated method stub
		return cmanagement.getAllCar();
	}

}
