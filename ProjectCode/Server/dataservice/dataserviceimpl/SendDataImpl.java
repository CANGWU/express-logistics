package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import dataservice.CheckDataService;
import dataservice.SendDataService;
import enums.ResultMessage;
import link.Helper;
import po.OrderPO;
import po.ReceiptsPO;

public class SendDataImpl extends UnicastRemoteObject implements SendDataService {

	@Override
	public ResultMessage insertOrderPO(OrderPO order) {
		// TODO Auto-generated method stub
		String sql = "insert into orderpo values(?,?,?,?"+order.getTimeOfSend()+"','"+order.getDueOfReceive()+"','"+order.getOrdernumber()+"','"+order.getNameOfCourier()+"','"+order.getReceiver()+"');";
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(0,order.getReceiver());
			Helper.pStatement.setObject(1,order.getSender());
			Helper.pStatement.setObject(2,order.getSender());
			Helper.pStatement.setObject(3,order.getGoods());
			Helper.pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage insertReceiptsPO(ReceiptsPO receipts) {
		// TODO Auto-generated method stub
		String sql = "insert into receiptspo values('"+receipts.getData()+"',"+receipts.getFee()+",'"+receipts.getCourier()+"',?);";
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(3,receipts.getOrdernumbers());
			Helper.pStatement.executeUpdate();
	}catch (Exception e){
		e.printStackTrace();
		return ResultMessage.FAIL;
	}
		return ResultMessage.SUCCESS;
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
