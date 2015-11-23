package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import enums.Work;
import po.SalaryPO;

public interface SalaryStrategyDataService extends Remote{
	
	public ArrayList<SalaryPO> findAll();
	public SalaryPO find(Work work);
	public ResultMessage insert(SalaryPO po);
	public ResultMessage delete(SalaryPO po);
	public ResultMessage delete(Work work);
	public ResultMessage update(SalaryPO po);
	public void init();
	public void finish();

}
