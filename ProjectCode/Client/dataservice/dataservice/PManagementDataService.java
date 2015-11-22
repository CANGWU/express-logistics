package dataservice;


import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.StaffPO;

public interface PManagementDataService extends Remote{
	
	public StaffPO find(String id);
	public ArrayList<StaffPO>findAll();
	public ResultMessage insert(StaffPO po);
	public ResultMessage delect(StaffPO po);
	public ResultMessage delect(String id);
	public ResultMessage update(StaffPO po);
	public void init();
	public void finish();

}
