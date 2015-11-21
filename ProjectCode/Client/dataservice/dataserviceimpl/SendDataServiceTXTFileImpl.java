package dataserviceimpl;

import java.io.*;

import po.OrderPO;
import po.ReceiptsPO;
import slstub.ResultMessage;
import dataservice.SendDataService;

public class SendDataServiceTXTFileImpl implements SendDataService {

	@Override
	public ResultMessage insertOrderPO(OrderPO order) {
		// TODO Auto-generated method stub
		System.out.println(order.getOrdernumber());
		File file=new File(order.getOrdernumber());
		try {
			FileWriter fw=new FileWriter(file);
			fw.write(order.getSender().getName()+"\r\n");
			fw.write(order.getSender().getAddress()+"\r\n");
			fw.write(order.getSender().getWorkPlace()+"\r\n");
			fw.write(order.getSender().getPhoneNumber()+"\r\n");
			fw.write(order.getSender().getTelNumber()+"\r\n");
			fw.write(order.getReceiver().getName()+"\r\n");
			fw.write(order.getReceiver().getAddress()+"\r\n");
			fw.write(order.getReceiver().getWorkPlace()+"\r\n");
			fw.write(order.getReceiver().getTelNumber()+"\r\n");
			fw.write(order.getReceiver().getPhoneNumber()+"\r\n");
			fw.write(order.getGoods().getNumberOfGoods()+"\r\n");
			fw.write(order.getGoods().getWeight()+"\r\n");
			fw.write(order.getGoods().getVolume()+"\r\n");
			fw.write(order.getGoods().getNameOfGoods()+"\r\n");
			fw.write(order.getGoods().getSize()+"\r\n");
			fw.write(order.getGoods().getExpressType()+"\r\n");
			fw.write(order.getBill().getTotalfee()+"\r\n");
			fw.write(order.getBill().getMoneyReceived()+"\r\n");
			fw.write(order.getBill().getChange()+"\r\n");
			fw.write(order.getTimeOfSend()+"\r\n");
			fw.write(order.getNameOfCourier()+"\r\n");
			fw.write(order.getDueOfReceive()+"\r\n");
			fw.write(order.getOrdernumber()+"\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public ResultMessage insertReceiptsPO(ReceiptsPO receipts) {
		// TODO Auto-generated method stub
		return null;
	}

}
