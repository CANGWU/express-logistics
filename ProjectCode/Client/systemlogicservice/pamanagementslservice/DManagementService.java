package pamanagementslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import vo.DriverVO;

public interface DManagementService {

	public DriverVO select(String id);
	public ResultMessage delete(String id);
	public DriverVO revise(String id);
	public ResultMessage saveChange(DriverVO vo);
	public ResultMessage save(DriverVO vo);
	public ResultMessage add(String name,Work work,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,Sex sex,int driverYear,int page);
	public ResultMessage endDManagement();
    public ArrayList<DriverVO>getAllDriver();
}
