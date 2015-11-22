package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.ReportPO;

public interface ReportDataService extends Remote{
	public ReportPO find(String id) throws Exception;
	public ArrayList<ReportPO> finds(String field,String id) throws Exception;
	public ResultMessage insert(ReportPO po) throws Exception;
	public ResultMessage delete(ReportPO po) throws Exception;
	public ResultMessage update(ReportPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
}
