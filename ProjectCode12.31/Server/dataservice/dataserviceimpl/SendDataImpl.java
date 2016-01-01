package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dataservice.SendDataService;
import enums.DocumentCondition;
import enums.ResultMessage;
import link.Helper;
import po.BillPO;
import po.GoodsPO;
import po.OrderPO;
import po.ReceiptsPO;
import po.ReceiverPO;
import po.SenderPO;

public class SendDataImpl extends UnicastRemoteObject implements SendDataService {

	@Override
	public ResultMessage insertOrderPO(OrderPO order) {
		// TODO Auto-generated method stub
		String sql = "insert into orderpo values(?,?,?,?,'"+order.getTimeOfSend()+"','"+order.getDueOfReceive()+"','"+order.getOrdernumber()+"','"+order.getNameOfCourier()+"','"+order.getReceivetime()+"','"+order.getdCondition()+"');";
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(1,IOObject.toByteArray(order.getReceiver()));
			Helper.pStatement.setObject(2,IOObject.toByteArray(order.getSender()));
			Helper.pStatement.setObject(3,IOObject.toByteArray(order.getBill()));
			Helper.pStatement.setObject(4,IOObject.toByteArray(order.getGoods()));
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
		String sql = "insert into receiptspo values('"+receipts.getDate()+"',"+receipts.getFee()+",'"+receipts.getCourier()+"',?,'"+receipts.getOffice()+"','"+receipts.getdCondition() +"');";
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(1,IOObject.toByteArray(receipts.getOrdernumbers()));
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

	@Override
	public ArrayList<OrderPO> findWithdCondition(String nameOfCourier, DocumentCondition dCondition) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select* from orderpo where documentcondition='"+dCondition+"' and nameofcourier='"+nameOfCourier+"';";
		ResultSet result = null;
		OrderPO po =null;
		ArrayList<OrderPO>pos = new ArrayList<OrderPO>();
		ReceiverPO receiver = null;
		SenderPO sender = null;
		BillPO bill = null;
		GoodsPO goods = null;

		try{
			result = Helper.find(sql);
			while(result.next()){

				try {
					//ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("receiver"));  
					receiver = (ReceiverPO)IOObject.getArray(result.getBytes("receiver"));
					//oips = new ObjectInputStream(result.getBinaryStream("sender"));  
					sender = (SenderPO)IOObject.getArray(result.getBytes("sender"));
					//oips = new ObjectInputStream(result.getBinaryStream("bill"));  
					bill = (BillPO)IOObject.getArray(result.getBytes("bill"));
					//oips = new ObjectInputStream(result.getBinaryStream("goods"));  
					goods = (GoodsPO)IOObject.getArray(result.getBytes("goods"));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
				po = new OrderPO(receiver,sender,bill,goods,result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),DocumentCondition.valueOf(result.getString(10)));
				pos.add(po);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return pos;
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

	@Override
	public ArrayList<ReceiptsPO> findReceipts(String date, String office) throws RemoteException {
		String sql = "select*from receiptspo where data='"+date+"' and office='"+office+"';";
		ArrayList<ReceiptsPO>receiptsPOs=new ArrayList<ReceiptsPO>();
		ResultSet resultSet=null;

		try {
			resultSet=Helper.find(sql);
			while(resultSet.next()){				  
				ArrayList<String> orderNumber=(ArrayList<String>)IOObject.getArray(resultSet.getBytes("ordernumbers"));
				ReceiptsPO po=new ReceiptsPO(resultSet.getString(1), resultSet.getDouble(2), resultSet.getString(3),orderNumber, resultSet.getString(5), DocumentCondition.valueOf(resultSet.getString(6)));
				receiptsPOs.add(po);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return receiptsPOs;
	}

	@Override
	public ArrayList<OrderPO> findForGathering(String courier, String date) throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select*from orderpo where courier='"+courier+"' and date='+"+date+"';";
		ResultSet result = null;
		OrderPO po =null;
		ArrayList<OrderPO>pos = new ArrayList<OrderPO>();
		ReceiverPO receiver = null;
		SenderPO sender = null;
		BillPO bill = null;
		GoodsPO goods = null;

		try{
			result = Helper.find(sql);
			while(result.next()){
  
				//ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("receiver"));  
				receiver = (ReceiverPO)IOObject.getArray(result.getBytes("receiver"));
				//oips = new ObjectInputStream(result.getBinaryStream("sender"));  
				sender = (SenderPO)IOObject.getArray(result.getBytes("sender"));
				//oips = new ObjectInputStream(result.getBinaryStream("bill"));  
				bill = (BillPO)IOObject.getArray(result.getBytes("bill"));
				//oips = new ObjectInputStream(result.getBinaryStream("goods"));  
				goods = (GoodsPO)IOObject.getArray(result.getBytes("goods"));
				po = new OrderPO(receiver,sender,bill,goods,result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),DocumentCondition.valueOf(result.getString(10)));
				pos.add(po);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return pos;

	}

	@Override
	public OrderPO findLatest() throws RemoteException {
		// TODO Auto-generated method stub
		
		String sql="select * from orderpo order by ordernumber desc;";
		OrderPO po = null;
		ResultSet result=null;
		ReceiverPO receiver = null;
		SenderPO sender = null;
		BillPO bill = null;
		GoodsPO goods = null;
		
		
		try {
			result=Helper.find(sql);
			if(result.next()){
				receiver = (ReceiverPO)IOObject.getArray(result.getBytes("receiver"));
				//oips = new ObjectInputStream(result.getBinaryStream("sender"));  
				sender = (SenderPO)IOObject.getArray(result.getBytes("sender"));
				//oips = new ObjectInputStream(result.getBinaryStream("bill"));  
				bill = (BillPO)IOObject.getArray(result.getBytes("bill"));
				//oips = new ObjectInputStream(result.getBinaryStream("goods"));  
				goods = (GoodsPO)IOObject.getArray(result.getBytes("goods"));
				po = new OrderPO(receiver,sender,bill,goods,result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),DocumentCondition.valueOf(result.getString(10)));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ArrayList<OrderPO> findReceived() throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select*from orderpo where receivetime != 'null';";
		ArrayList<OrderPO>orderPOs=new ArrayList<OrderPO>();
		ResultSet result=null;
		ReceiverPO receiver = null;
		SenderPO sender = null;
		BillPO bill = null;
		GoodsPO goods = null;
		
		
		try {
			result=Helper.find(sql);
			while(result.next()){
				receiver = (ReceiverPO)IOObject.getArray(result.getBytes("receiver"));
				//oips = new ObjectInputStream(result.getBinaryStream("sender"));  
				sender = (SenderPO)IOObject.getArray(result.getBytes("sender"));
				//oips = new ObjectInputStream(result.getBinaryStream("bill"));  
				bill = (BillPO)IOObject.getArray(result.getBytes("bill"));
				//oips = new ObjectInputStream(result.getBinaryStream("goods"));  
				goods = (GoodsPO)IOObject.getArray(result.getBytes("goods"));
				OrderPO po = new OrderPO(receiver,sender,bill,goods,result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),DocumentCondition.valueOf(result.getString(10)));
				orderPOs.add(po);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderPOs;
	}

	@Override
	public ArrayList<OrderPO> findAudit() throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select* from orderpo where documentcondition='handing';";
		ResultSet result = null;
		OrderPO po =null;
		ArrayList<OrderPO>pos = new ArrayList<OrderPO>();
		ReceiverPO receiver = null;
		SenderPO sender = null;
		BillPO bill = null;
		GoodsPO goods = null;

		try{
			result = Helper.find(sql);
			while(result.next()){

				try {
					//ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("receiver"));  
					receiver = (ReceiverPO)IOObject.getArray(result.getBytes("receiver"));
					//oips = new ObjectInputStream(result.getBinaryStream("sender"));  
					sender = (SenderPO)IOObject.getArray(result.getBytes("sender"));
					//oips = new ObjectInputStream(result.getBinaryStream("bill"));  
					bill = (BillPO)IOObject.getArray(result.getBytes("bill"));
					//oips = new ObjectInputStream(result.getBinaryStream("goods"));  
					goods = (GoodsPO)IOObject.getArray(result.getBytes("goods"));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
				po = new OrderPO(receiver,sender,bill,goods,result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getString(9),DocumentCondition.valueOf(result.getString(10)));
				pos.add(po);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return pos;
	}

	@Override
	public ResultMessage updateOrderPO(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "update orderpo set receivetime='"+order.getReceivetime()+"', timeOfsend='"+order.getTimeOfSend()+"', dueOfReceive='"+order.getDueOfReceive()+"', nameOfCourier='"+order.getNameOfCourier()+
				"', DocumentCondition='"+order.getdCondition()+", Receiver=?,sender=?,bill=?,goods=? where orderNumber='"+order.getOrdernumber()+"';";
				
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(1,IOObject.toByteArray(order.getReceiver()));
			Helper.pStatement.setObject(2,IOObject.toByteArray(order.getSender()));
			Helper.pStatement.setObject(3,IOObject.toByteArray(order.getBill()));
			Helper.pStatement.setObject(4,IOObject.toByteArray(order.getGoods()));
			Helper.pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage updateReceiptsPO(ReceiptsPO receipts) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage resultMessage = deleteReceiptsPO(receipts.getDate(), receipts.getCourier());
		if(resultMessage.equals(ResultMessage.FAIL))
		return ResultMessage.FAIL;
		else return insertReceiptsPO(receipts);
	}

	@Override
	public ResultMessage deleteReceiptsPO(String date, String courier) throws RemoteException {
		// TODO Auto-generated method stub
		
		String sql = "delete from receiptspo where data='" + date + "' and courier='" + courier + "';";  
		return Helper.delete(sql);
	}

	@Override
	public ReceiptsPO findReceipt(String date, String courier) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select*from receiptspo where data='"+date+"' and courier='"+courier+"';";
		ReceiptsPO receiptsPO = null;
		ResultSet resultSet=null;

		try {
			resultSet=Helper.find(sql);
			while(resultSet.next()){				  
				ArrayList<String>orderNumber=(ArrayList <String>)IOObject.getArray(resultSet.getBytes("orderNumber"));
				 receiptsPO =new ReceiptsPO(resultSet.getString(1), resultSet.getDouble(2), resultSet.getString(3),orderNumber, resultSet.getString(5), DocumentCondition.valueOf(resultSet.getString(6)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return receiptsPO;
	}
}
