package pamanagementslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import vo.CarVO;

public interface CManagementService {
	

	public CarVO select(String id);
	public ResultMessage delete(String id);
	public CarVO revise(String id);
	public ResultMessage saveChange(CarVO vo);
	public ResultMessage save(CarVO vo);
	public ResultMessage add(String idNumber, String workPlaceNumber, String licenseNumber, int workYear);
	public ResultMessage endCManagement();
	public ArrayList<CarVO>getAllCar();
	

}
