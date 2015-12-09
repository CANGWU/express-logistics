package pamanagementsl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import pamanagementslservice.DManagementService;
import vo.DriverVO;

public class DManagementController implements DManagementService{
	
	DManagement damanagement;
	
	public DManagementController(DataFactory datafactory){
		damanagement=DManagement.createDManagement(datafactory);
	}

	@Override
	public DriverVO select(String id) {
		// TODO Auto-generated method stub
		return damanagement.select(id);
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return damanagement.delete(id);
	}

	@Override
	public DriverVO revise(String id) {
		// TODO Auto-generated method stub
		return damanagement.revise(id);
	}

	@Override
	public ResultMessage saveChange(DriverVO vo) {
		// TODO Auto-generated method stub
		return damanagement.saveChange(vo);
	}

	@Override
	public ResultMessage save(DriverVO vo) {
		// TODO Auto-generated method stub
		return damanagement.save(vo);
	}

	@Override
	public ResultMessage add(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, int driverYear,
			int page) {
		// TODO Auto-generated method stub
		return damanagement.add(name, work, workNumber, workPlaceNumber, birthDate, idNumber, phoneNumber, address, sex, driverYear, page);
	}

	@Override
	public ResultMessage endDManagement() {
		// TODO Auto-generated method stub
		return damanagement.endDManagement();
	}

	@Override
	public ArrayList<DriverVO> getAllDriver() {
		// TODO Auto-generated method stub
		return damanagement.getAllDriver();
	}

}
