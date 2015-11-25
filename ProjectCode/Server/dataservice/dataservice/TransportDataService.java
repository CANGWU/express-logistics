package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import enums.TransportType;
import po.TransportPO;

public interface TransportDataService extends Remote{
	public TransportPO find(String id) throws Exception;
	public ArrayList<TransportPO> finds(TransportType sign) throws Exception;
	public ResultMessage insert(TransportPO po) throws Exception;
	public ResultMessage delete(TransportPO po) throws Exception;
	public ResultMessage update(TransportPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
}
