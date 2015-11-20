package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.ReportPO;

public interface ReportDataService extends Remote{
	public ReportPO find(String id) throws Exception;
	public ArrayList<ReportPO> finds(String field,String id) throws Exception;
	public void insert(ReportPO po) throws Exception;
	public void delete(ReportPO po) throws Exception;
	public void update(ReportPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
}
