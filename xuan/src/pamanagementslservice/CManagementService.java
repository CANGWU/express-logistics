package pamanagementslservice;

import java.util.ArrayList;

import vo.CarVO;

public interface CManagementService {
	

	public CarVO select(String id);
	public void delect(String id);
	public void revise(String id);
	public void saveChange(CarVO vo);
	public void save(CarVO vo);
	public void add();
	public void endCManagement();
	public ArrayList<CarVO>getAllCar();
	

}
