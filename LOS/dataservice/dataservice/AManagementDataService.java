package dataservice;

import java.util.ArrayList;

import po.AgencyPO;

public interface AManagementDataService {
	public AgencyPO find(String id);
	public ArrayList<AgencyPO> findAll();
	public void insert(AgencyPO po);
	public void delect(AgencyPO po);
	public void delect(String id);
	public void update(AgencyPO po);
	public void init();
	public void finish();

}
