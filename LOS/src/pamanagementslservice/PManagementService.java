package pamanagementslservice;

import java.util.ArrayList;

import vo.StaffVO;

public interface PManagementService {
	
	public StaffVO select(String id);
	public void delect(String id);
	public void revise(String id);
	public void saveChange(StaffVO vo);
	public void save(StaffVO vo);
	public void add();
	public void endPManagement();
	public ArrayList<StaffVO> getAllStaff();

}
