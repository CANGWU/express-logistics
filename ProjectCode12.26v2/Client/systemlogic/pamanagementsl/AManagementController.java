package pamanagementsl;

import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import pamanagementslservice.AManagementService;
import vo.AgencyVO;

public class AManagementController implements AManagementService {
	
	AManagement amanagement;
	
	public AManagementController(DataFactory datafactory){
		amanagement=AManagement.creatAManagement(datafactory);
	}

	@Override
	public AgencyVO select(String id) {
		// TODO Auto-generated method stub
		return amanagement.select(id);
	}

	@Override
	public ArrayList<AgencyVO> getAllAgency() {
		// TODO Auto-generated method stub
		return amanagement.getAllAgency();
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return amanagement.delete(id);
	}

	@Override
	public AgencyVO revise(String id) {
		// TODO Auto-generated method stub
		return amanagement.revise(id);
	}

	@Override
	public ResultMessage saveChange(AgencyVO vo) {
		// TODO Auto-generated method stub
		return amanagement.saveChange(vo);
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		amanagement.save();
	}

	@Override
	public ResultMessage add(String name, String idNumber,
			ArrayList<String> staff, String phonenumber, String address,
			String leader) {
		// TODO Auto-generated method stub
		return amanagement.add(name, idNumber, staff, phonenumber, address, leader);
	}

}
