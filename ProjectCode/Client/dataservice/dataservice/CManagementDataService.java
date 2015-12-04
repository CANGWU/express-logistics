package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.CarPO;

public interface CManagementDataService extends Remote{
	
	public CarPO find(String id);
	public ArrayList<CarPO> findAll();
	public ResultMessage insert(CarPO po);
	public ResultMessage delete(CarPO po);
	public ResultMessage delete(String id);
	public ResultMessage update(CarPO po);
	public void init();
	public void finish();

}
