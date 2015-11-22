package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.ReceiveDataService;
import enums.ResultMessage;
import po.DeliverPO;
import po.OrderPO;

public class ReceiveDataImpl extends UnicastRemoteObject implements ReceiveDataService {

	private ReceiveDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderPO findO(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findsO(String field, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertO(OrderPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage deleteO(OrderPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage updateO(OrderPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public DeliverPO findD(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DeliverPO> findsD(String field, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertD(DeliverPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage deleteD(DeliverPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage updateD(DeliverPO po) throws Exception {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() throws Exception {
		// TODO Auto-generated method stub

	}
	  public static ReceiveDataImpl create() throws RemoteException{
			if(receive == null){
				synchronized(ReceiveDataImpl.class){
			
			if(receive == null)
			receive = new ReceiveDataImpl();
				}
			}
				
			return receive;
		}
		
	   private volatile static ReceiveDataImpl receive;  

}
