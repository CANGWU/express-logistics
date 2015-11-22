package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.CheckDataService;
import dataservice.SendDataService;
import enums.ResultMessage;
import po.OrderPO;
import po.ReceiptsPO;

public class SendDataImpl extends UnicastRemoteObject implements SendDataService {

	@Override
	public ResultMessage insertOrderPO(OrderPO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertReceiptsPO(ReceiptsPO receipts) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private SendDataImpl() throws RemoteException{
		super();
	}

	
	public static SendDataImpl create() throws RemoteException{
			if(send == null){
				synchronized(SendDataImpl.class){
			
			if(send == null)
			send = new SendDataImpl();
				}
			}
				
			return send;
		}
		
	   private volatile static SendDataImpl send;
}
