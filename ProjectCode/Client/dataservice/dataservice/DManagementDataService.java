package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.DriverPO;

public interface DManagementDataService extends Remote{
	
	public DriverPO find(String id);
	public ArrayList<DriverPO> findAll();
	public void insert(DriverPO po);
	public void delect(DriverPO po);
	public void delect(String id);
	public void update(DriverPO po);
	public void init();
	public void finish();

}
