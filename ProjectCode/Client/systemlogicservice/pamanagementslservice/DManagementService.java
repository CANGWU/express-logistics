package pamanagementslservice;

import java.util.ArrayList;

import vo.DriverVO;

public interface DManagementService {

	public DriverVO select(String id);
	public void delect(String id);
	public DriverVO revise(String id);
	public void saveChange(DriverVO vo);
	public void save(DriverVO vo);
	public void add();
	public void endDManagement();
    public ArrayList<DriverVO>getAllDriver();
}
