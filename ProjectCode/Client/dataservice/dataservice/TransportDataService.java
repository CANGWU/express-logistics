package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.DocumentCondition;
import enums.ResultMessage;
import po.TransportPO;

public interface TransportDataService extends Remote{
	public TransportPO find(String id) throws Exception;
	public ArrayList<TransportPO> finds(String fields,String id) throws Exception;
	public ResultMessage insert(TransportPO po) throws Exception;
	public ResultMessage delete(TransportPO po) throws Exception;
	public ResultMessage update(TransportPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
	public ArrayList<TransportPO> findWithdCondition(String nameOfWriter, DocumentCondition dCondition)throws Exception;
}
