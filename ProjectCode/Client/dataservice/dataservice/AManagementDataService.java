package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.AgencyPO;

public interface AManagementDataService extends Remote{
	public AgencyPO find(String id);
	public ArrayList<AgencyPO> findAll();
	public ResultMessage insert(AgencyPO po);
	public ResultMessage delete(AgencyPO po);
	public ResultMessage delete(String id);
	public ResultMessage update(AgencyPO po);
	public void init();
	public void finish();

}
