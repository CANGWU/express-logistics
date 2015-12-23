package sendsl;

import java.util.ArrayList;

import dataservice.DataFactoryService;
import sendslservice.OrderInputCheckMessage;
import sendslservice.SendService;
import vo.*;

public class SendController implements SendService{
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
	public ArrayList<ReceiptsVO> receiptsNew(String Date,String workplace) {
		// TODO Auto-generated method stub
		return Gathering.receiptsNew(Date,workplace);
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
	public OrderInputCheckMessage changecheck(BillVO bill) {
		// TODO Auto-generated method stub
		return Order.changecheck(bill);
	}

	@Override
	public OrderInputCheckMessage inputcheck(String[] info) {
		// TODO Auto-generated method stub
		return Order.inputcheck(info);
	}

}
