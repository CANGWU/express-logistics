package pamanagementslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import vo.StaffVO;

public interface PManagementService {
	
	public StaffVO select(String id);
	public ResultMessage delete(String id);
	public StaffVO revise(String id);
	public ResultMessage saveChange(StaffVO vo);
	public ResultMessage save(StaffVO vo);
	public ResultMessage add(String name,Work work,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,Sex sex,double page);
	public ResultMessage endPManagement();
	public ArrayList<StaffVO> getAllStaff();

}
