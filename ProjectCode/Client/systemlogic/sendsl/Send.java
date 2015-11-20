package sendsl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import data.DataFactory;
import po.OrderPO;
import sendslservice.OrderInputCheckMessage;
import sendslservice.SendService;
import vo.*;

public class Send implements SendService{
	//DataFactory factory=new 		DataFactory();
	@Override
	public OrderVO calculate(String[] info) {
		// TODO Auto-generated method stub
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format( now );
		String couriername="张三";//使用User的桩
		OrderVO order=new OrderVO(date,couriername,info[0],info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],info[9],Integer.parseInt(info[10]),Double.parseDouble(info[11]),Double.parseDouble(info[12]),info[13],info[14],info[15]);
        order.getBill().setTotalfee(10.0);//使用Straetgy的桩
		return order;
	}

	@Override
	public BillVO setBill(OrderVO order) {
		// TODO Auto-generated method stub
		BillVO bill=new BillVO();
		bill.setTotalfee(order.getBill().getTotalfee());
		return bill;
	}
	
	

	@Override
	public BillVO getchange(double cash, BillVO bill) {
		// TODO Auto-generated method stub
		bill.setChange(cash-bill.getTotalfee());
		bill.setMoneyReceived(cash);
		return bill;
	}

	@Override
	public void orderend(BillVO bill, OrderVO order) {
		// TODO Auto-generated method stub
		order.setDueOfReceive(this.computedue(order));
		order.setBill(bill);
		OrderPO orderpo=new OrderPO(order.getTimeOfSend(),order.getDueOfReceive(),order.getOrdernumber(),order.getNameOfCourier(),order.getSender(),order.getReceiver(),order.getBill(),order.getGoods());
		//factory.getSendData().insertOrderPO(orderpo);
	}

	@Override
	public ArrayList<ReceiptsVO> receiptsNew(String office) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ReceiptsVO> receiptscheck(String office, String data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String computeOrdernumber() {
		// TODO Auto-generated method stub
		return "0000000001";
	}

	@Override
	public String computedue(OrderVO order) {
		// TODO Auto-generated method stub
		return "2015/1/25";
	}

	@Override
	public OrderInputCheckMessage inputcheck(String[] info) {
		// TODO Auto-generated method stub
		if(info[0].equals("")||info[5].equals("")){
			return OrderInputCheckMessage.WRONG_NAME ;
		}
		if(info[3].length()!=11||info[8].length()!=11){
			return OrderInputCheckMessage.WRONG_TEL;
		}
		
		if(info[4].length()!=11||info[9].length()!=11){
			return OrderInputCheckMessage.WRONG_PHONE;
		}
		try{
			Integer.parseInt(info[10]);
			Double.parseDouble(info[11]);
			Double.parseDouble(info[12]);
		}catch(Exception e){
			return OrderInputCheckMessage.WRONG_NUM;
		}
		
		return OrderInputCheckMessage.SUCCESS;
	}

	@Override
	public OrderInputCheckMessage changecheck(BillVO bill) {
		// TODO Auto-generated method stub
		if(bill.getChange()<0.0){
			return OrderInputCheckMessage.WRONG_CASH;
		}
		return OrderInputCheckMessage.SUCCESS;
	}

}
