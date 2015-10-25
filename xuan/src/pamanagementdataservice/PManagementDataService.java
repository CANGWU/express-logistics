package pamanagementdataservice;


import java.util.ArrayList;

import po.StaffPO;

public interface PManagementDataService {
	
	public StaffPO find(String id);
	public ArrayList<StaffPO>findAll();
	public void insert(StaffPO po);
	public void delect(StaffPO po);
	public void delect(String id);
	public void update(StaffPO po);
	public void init();
	public void finish();

}
