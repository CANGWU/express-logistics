package slstub;

import java.util.ArrayList;

import sendslservice.OrderInputCheckMessage;
import sendslservice.SendService;
import vo.*;

public class SendStub implements SendService {

	@Override
	public OrderVO calculate(String[] info) {
		// TODO Auto-generated method stub
		OrderVO order=new OrderVO("2015/1/1","张三","李四","南京大学","南京大学","123456","123456","李四","南京大学","南京大学","123456","123456",1,1.0,1.0,"木块","1*1","normal");
		return order;
	}

	@Override
	public BillVO getchange(double cash, BillVO bill) {
		// TODO Auto-generated method stub
		bill.setChange(cash-bill.getTotalfee());
		bill.setMoneyReceived(cash);
		return bill;
	}

	@Override
	public void orderend(BillVO bill,OrderVO order) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<ReceiptsVO> receiptsNew(String office) {
		// TODO Auto-generated method stub
		String[] ordernumbers={"0000000001"};
		ReceiptsVO receipts=new ReceiptsVO("2015/1/1",10.00,"张三",ordernumbers);
		ArrayList<ReceiptsVO> list=new ArrayList<ReceiptsVO>();
		list.add(receipts);
		return list;
	}

	@Override
	public ArrayList<ReceiptsVO> receiptscheck(String office, String data) {
		// TODO Auto-generated method stub
		String[] ordernumbers={"0000000001"};
		ReceiptsVO receipts=new ReceiptsVO("2015/1/1",10.00,"张三",ordernumbers);
		ArrayList<ReceiptsVO> list=new ArrayList<ReceiptsVO>();
		list.add(receipts);
		return list;
	}



	@Override
	public BillVO setBill(OrderVO order) {
		// TODO Auto-generated method stub
		order.getBill().setTotalfee(10.0);
		return order.getBill();
	}

	@Override
	public String computeOrdernumber() {
		// TODO Auto-generated method stub
		return "0000000001";
	}

	@Override
	public String computedue(OrderVO order) {
		// TODO Auto-generated method stub
		return "2015/1/15";
	}

	@Override
	public OrderInputCheckMessage inputcheck(String[] info) {
		// TODO Auto-generated method stub
		return OrderInputCheckMessage.SUCCESS;
	}

	@Override
	public OrderInputCheckMessage changecheck(BillVO bill) {
		// TODO Auto-generated method stub
		return OrderInputCheckMessage.SUCCESS;
	}

}
