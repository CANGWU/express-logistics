package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.DocumentCondition;
import enums.ResultMessage;
import po.DeliverPO;
import po.OrderPO;

public interface ReceiveDataService extends Remote{
	//对OrderPO的操作
	public OrderPO find(String id) throws Exception;
	public ArrayList<OrderPO> findsO(String field,String id) throws Exception;
	public ResultMessage insertO(OrderPO po) throws Exception;
	public ResultMessage deleteO(String ordernumber) throws Exception;
	public ResultMessage updateO(OrderPO po) throws Exception;
	public DeliverPO findD(String id) throws Exception;
	//对DeliverPO的操作
	public ArrayList<DeliverPO> findsD(String field,String id) throws Exception;
	public ResultMessage insertD(DeliverPO po) throws Exception;
	public ResultMessage deleteD(String deliverID) throws Exception;
	public ResultMessage updateD(DeliverPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
	public ArrayList<DeliverPO> findDWithdCondition(String nameOfWriter, DocumentCondition dCondition) throws Exception;
    public ArrayList<DeliverPO> findAudit()throws RemoteException;
}
