package pamanagementsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import pamanagementslservice.PManagementService;
import vo.StaffVO;

public class PManagementController implements PManagementService{
	
	PManagement pmanagement;
	
	public PManagementController(){
		try {
			pmanagement=PManagement.createPManagement(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public StaffVO select(String id) {
		// TODO Auto-generated method stub
		return pmanagement.select(id);
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return pmanagement.delete(id);
	}

	@Override
	public StaffVO revise(String id) {
		// TODO Auto-generated method stub
		return pmanagement.revise(id);
	}

	@Override
	public ResultMessage saveChange(StaffVO vo) {
		// TODO Auto-generated method stub
		return pmanagement.saveChange(vo);
	}

	@Override
	public ResultMessage save(StaffVO vo) {
		// TODO Auto-generated method stub
		return pmanagement.save(vo);
	}

	@Override
	public ResultMessage add(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, double page) {
		// TODO Auto-generated method stub
		return pmanagement.add(name, work, workNumber, workPlaceNumber, birthDate, idNumber, phoneNumber, address, sex, page);
	}

	@Override
	public ResultMessage endPManagement() {
		// TODO Auto-generated method stub
		return pmanagement.endPManagement();
	}

	@Override
	public ArrayList<StaffVO> getAllStaff() {
		// TODO Auto-generated method stub
		return pmanagement.getAllStaff();
	}

}
