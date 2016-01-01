package sendsl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.text.MaskFormatter;

import dataservice.CheckDataService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import dataservice.SendDataService;
import dataserviceimpl.DataFactory;
import enums.OrderInputCheckMessage;
import enums.ResultMessage;
import po.LogisticsPO;
import po.OrderPO;
import po.PaymentPO;
import strategysl.ConstantController;
import vo.BillVO;
import vo.OrderVO;

public class OrderSend {
	
	private DataFactoryService Data;
	private ConstantController Constant;
	
	public OrderSend(){
		try {
			Data = DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Constant = new ConstantController();
	}

	public OrderVO calculate(OrderVO order) {
		// TODO Auto-generated method stub
//		Date now = new Date(); 
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//		String date = dateFormat.format( now );
		
		
		//

		
		

        
		
		double Totalfee = 0;
		double Length=0;
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
		
		System.out.println(cities);
		
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
		if(cities.equals("SS")||cities.equals("NN")||cities.equals("BB")||cities.equals("GG"))
			Length = Constant.getConstant().getLengthOfHall();
		
		if(order.getGoods().getExpressType().equals("Cheapest"))
			Type = Constant.getConstant().getPriceOfCheapest();
		if(order.getGoods().getExpressType().equals("Express"))
			Type = Constant.getConstant().getPriceOfExpress();
		else
			Type = Constant.getConstant().getPriceOfStandard();
		
		switch(order.getGoods().getPacking()){
		case Bag:Packing = Constant.getConstant().getPriceOfBag();
		break;
		case Carton:Packing = Constant.getConstant().getPriceOfCarton();
		break;
		case Wood:Packing = Constant.getConstant().getPriceOfWood();
		break;
		}
		
		Totalfee = Length*Type+Packing;
		System.out.println(Length);
		System.out.println(Type);
		System.out.println(Packing);
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
			LogisticsPO logisticspo=new LogisticsPO(orderpo.getOrdernumber());
			logisticspo.addMessage(orderpo.getNameOfCourier());
			CheckDataService cds=Data.getCheckData();
			cds.add(logisticspo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String computeOrdernumber() {
		// TODO Auto-generated method stub
		OrderPO HistoryData = null;
	    MaskFormatter numberformatter=null;
		try {
			HistoryData = Data.getSendData().findLatest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "0000000001";
		}
		if(HistoryData==null)
			return "0000000001";
		else


			return String.format("%010d", Long.parseLong(HistoryData.getOrdernumber())+1);
          
	}


	public String computedue(OrderVO order) {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> HistoryData = new ArrayList<OrderPO>();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			HistoryData = Data.getSendData().findReceived();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return df.format(new Date());
		}
	
		if(HistoryData.isEmpty())
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





	public OrderInputCheckMessage changecheck(BillVO bill) {
		// TODO Auto-generated method stub
		if(bill.getChange()<0.0){
			return OrderInputCheckMessage.WRONG_CASH;
		}
		return OrderInputCheckMessage.SUCCESS;
	}
	
	public ArrayList<OrderVO> findAudit(){
		SendDataService sds=null;
		ArrayList<OrderVO> volist=new ArrayList<OrderVO>();
		try {
		    sds=Data.getSendData();
			ArrayList<OrderPO> polist=sds.findAudit();
			for(int i=0;i<polist.size();i++){
				volist.add(new OrderVO(polist.get(i)));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return volist;
		
	}
	
	public ResultMessage endAudit(ArrayList<OrderVO> volist){
		

        for(int i=0;i<volist.size();i++){
        	OrderVO ordervo=volist.get(i);
        	try {
        		SendDataService sds=Data.getSendData();
				sds.updateOrderPO(new OrderPO(ordervo.getTimeOfSend(),
						ordervo.getDueOfReceive(), ordervo.getOrdernumber(),
						ordervo.getNameOfCourier(), ordervo.getSender(),
						ordervo.getReceiver(), ordervo.getBill(), ordervo.getGoods(),
						ordervo.getDocumentCondition()));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResultMessage.FAIL;
			}
        }
		
		
		return ResultMessage.SUCCESS;

		
	}

}
