package sendsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import auditsl.AuditInfo;
import dataservice.DataFactoryService;
import enums.OrderInputCheckMessage;
import enums.ResultMessage;
import sendslservice.SendService;
import vo.*;

public class SendController implements SendService,AuditInfo{
	//DataFactory factory=new 		DataFactory();
	
	private GatheringSend Gathering;
	private OrderSend Order;
	

	
	public SendController(){
		Gathering = new GatheringSend();
		Order = new OrderSend();
		
	}
	
	@Override
	public OrderVO calculate(OrderVO info) {
		// TODO Auto-generated method stub
        	 OrderVO vo=Order.calculate(info);
		return vo;
	}

	@Override
	public BillVO setBill(OrderVO order) {
		// TODO Auto-generated method stub
		return Order.setBill(order);
	}
	
	

	@Override
	public BillVO getchange(double cash, BillVO bill) {
		// TODO Auto-generated method stub
		return Order.getchange(cash, bill);
	}

	@Override
	public void orderend(BillVO bill, OrderVO order) {
		// TODO Auto-generated method stub
		Order.orderend(bill, order);
	}

	@Override
	public String computeOrdernumber() {
		// TODO Auto-generated method stub
		return Order.computeOrdernumber();
	}

	@Override
	public String computedue(OrderVO order) {
		// TODO Auto-generated method stub
		return Order.computedue(order);
	}


	@Override
	public ArrayList<OrderVO> getAuditInfo() {
		// TODO Auto-generated method stub
		return Order.findAudit();
	}

	@Override
	public ResultMessage EndAudit(ArrayList list) {
		// TODO Auto-generated method stub
		return Order.endAudit(list);
	}
	
	@Override
	public ArrayList<ReceiptsVO> newReceipts(String Date,String workplace) throws RemoteException {
		return Gathering.newReceipts(Date,workplace);
	}

	@Override
	public ReceiptsVO findReceipt(String Date, String courier) throws RemoteException{
			return Gathering.findReceipt(Date, courier);
	}
	
	@Override
	public ArrayList<ReceiptsVO> findReceipts(String Date, String office) {
		return Gathering.findReceipts(Date, office);
	}

	@Override
	public ResultMessage updateReceipts(ReceiptsVO receiptsvo){
		try{
			return Gathering.updateReceipts(receiptsvo);
		}catch(RemoteException re){
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage deleteReceipts(String Date, String courier){
		try {
			return Gathering.deleteReceipts(Date, courier);
		} catch (RemoteException e) {
			return ResultMessage.FAIL;
		}
	}
}
