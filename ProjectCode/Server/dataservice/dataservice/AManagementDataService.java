package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.AgencyPO;

public interface AManagementDataService extends Remote{
	public AgencyPO find(String id);
	public ArrayList<AgencyPO> findAll();
	public void insert(AgencyPO po);
	public void delect(AgencyPO po);
	public void delect(String id);
	public void update(AgencyPO po);
	public void init();
	public void finish();

}
