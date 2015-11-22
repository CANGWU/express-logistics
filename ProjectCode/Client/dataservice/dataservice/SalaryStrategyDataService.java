package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.SalaryPO;

public interface SalaryStrategyDataService extends Remote{
	
	public ArrayList<SalaryPO> findAll();
	public ResultMessage insert(SalaryPO po);
	public ResultMessage delect(SalaryPO po);
	public ResultMessage delect(String id);
	public ResultMessage delect(ArrayList<String> ids);
	public ResultMessage update(SalaryPO po);
	public ResultMessage update(ArrayList<SalaryPO> salarys);
	public void init();
	public void finish();

}
