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
		
	}
	
	public SendController(DataFactoryService d,String code,getCouriers c,GetConstant constant ){
		Gathering = new GatheringSend(d,c,code);
		Order = new OrderSend(d,constant);
		
	}
	
	@Override
	public OrderVO calculate(OrderVO info) {
		// TODO Auto-generated method stub
		return Order.calculate(info);
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
	public ArrayList<ReceiptsVO> receiptsNew(String Date) {
		// TODO Auto-generated method stub
		return Gathering.receiptsNew(Date);
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
