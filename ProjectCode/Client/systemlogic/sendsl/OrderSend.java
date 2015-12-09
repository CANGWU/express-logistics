package sendsl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dataservice.DataFactoryService;
import po.OrderPO;
import sendslservice.OrderInputCheckMessage;
import vo.BillVO;
import vo.OrderVO;

public class OrderSend {
	
	private DataFactoryService Data;
	private GetConstant Constant;
	
	public OrderSend(DataFactoryService d,GetConstant c){
		Data = d;
		Constant = c;
	}

	public OrderVO calculate(OrderVO order) {
		// TODO Auto-generated method stub
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String date = dateFormat.format( now );
		
		
		//
		String couriername="张三";//使用User的桩
		
		

        
		
		double Totalfee = 0;
		double Length;
		double Type;
		double Packing = 0;
		String cities="";
		
		if(order.getSender().getAddress().contains("广州市")) cities = cities+"G";
		if(order.getSender().getAddress().contains("北京市")) cities = cities+"B";
		if(order.getSender().getAddress().contains("上海市")) cities = cities+"S";
		if(order.getSender().getAddress().contains("南京市")) cities = cities+"N";
			
		if(order.getReceiver().getAddress().contains("广州市")) cities = cities+"G";
		if(order.getReceiver().getAddress().contains("北京市")) cities = cities+"B";
		if(order.getReceiver().getAddress().contains("上海市")) cities = cities+"S";
		if(order.getReceiver().getAddress().contains("南京市")) cities = cities+"N";
		
		if(cities.equals("BG")||cities.equals("GB"))
			Length = Constant.getConstant().getLengthOfBG();
		if(cities.equals("BS")||cities.equals("SB"))
			Length = Constant.getConstant().getLengthOfBS();
		if(cities.equals("BN")||cities.equals("NB"))
			Length = Constant.getConstant().getLengthOfBN();
		if(cities.equals("GN")||cities.equals("NG"))
			Length = Constant.getConstant().getLengthOfGN();
		if(cities.equals("SG")||cities.equals("GS"))
			Length = Constant.getConstant().getLengthOfSG();
		if(cities.equals("SN")||cities.equals("NS"))
			Length = Constant.getConstant().getLengthOfSN();
		else
			Length = Constant.getConstant().getLengthOfHall();
		
		if(order.getGoods().getExpressType().equals("Cheapest"))
			Type = Constant.getConstant().getPriceOfCheapest();
		if(order.getGoods().getExpressType().equals("Express"))
			Type = Constant.getConstant().getPriceOfExpress();
		else
			Type = Constant.getConstant().getPriceOfStandard();
		
		switch(order.getGoods().getPacking()){
		case Bag:Packing = Constant.getConstant().getPriceOfBag();
		case Carton:Packing = Constant.getConstant().getPriceOfCarton();
		case Wood:Packing = Constant.getConstant().getPriceOfWood();
		}
		
		Totalfee = Length*Type+Packing;
		
		order.getBill().setTotalfee(Totalfee);//使用Straetgy的桩
		return order;
	}

	public BillVO setBill(OrderVO order) {
		// TODO Auto-generated method stub
		BillVO bill=new BillVO();
		bill.setTotalfee(order.getBill().getTotalfee());
		return bill;
	}
	
	


	public BillVO getchange(double cash, BillVO bill) {
		// TODO Auto-generated method stub
		bill.setChange(cash-bill.getTotalfee());
		bill.setMoneyReceived(cash);
		return bill;
	}


	public void orderend(BillVO bill, OrderVO order) {
		// TODO Auto-generated method stub
		order.setDueOfReceive(this.computedue(order));
		order.setBill(bill);
		
		OrderPO orderpo=new OrderPO(order.getTimeOfSend(),order.getDueOfReceive(),order.getOrdernumber(),order.getNameOfCourier(),order.getSender(),order.getReceiver(),order.getBill(),order.getGoods(),order.getDocumentCondition());
		try {
			Data.getSendData().insertOrderPO(orderpo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String computeOrdernumber() {
		// TODO Auto-generated method stub
		OrderPO HistoryData = null;
		try {
			HistoryData = Data.getSendData().findLatest();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(HistoryData==null)
			return "0000000001";
		else
			return Long.toString(Long.parseLong(HistoryData.getOrdernumber())+1);

	}


	public String computedue(OrderVO order) {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> HistoryData = new ArrayList<OrderPO>();
		try {
			HistoryData = Data.getSendData().findReceived();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		if(HistoryData==null)
			return df.format(new Date());
		else{
			
			Date sendTime=null,receiveTime=null;
			long Avarage=0;
			for(int i =0;i<HistoryData.size();i++){
			
				try {
					sendTime = df.parse(HistoryData.get(i).getTimeOfSend().split(" ")[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					receiveTime = df.parse(HistoryData.get(i).getTimeOfSend().split(" ")[0]);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Avarage = Avarage + receiveTime.getTime() - sendTime.getTime();
			}
			Avarage = Avarage / HistoryData.size();
			Date now = new Date();
			return df.format(new Date(Avarage+now.getTime()));
		}
	}


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


	public OrderInputCheckMessage changecheck(BillVO bill) {
		// TODO Auto-generated method stub
		if(bill.getChange()<0.0){
			return OrderInputCheckMessage.WRONG_CASH;
		}
		return OrderInputCheckMessage.SUCCESS;
	}

}
