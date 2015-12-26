package receivesl;

import java.rmi.RemoteException;

import po.OrderPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import receiveslservice.ReceiveService;
import vo.BillVO;
import vo.GoodsVO;
import vo.OrderVO;
import vo.ReceiverVO;
import vo.SenderVO;

public class Receive implements ReceiveService {
	DataFactoryService dataFactory;
	ReceiveDataService receiveData;

	public Receive() {
		try {
			this.dataFactory = DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.receiveData = dataFactory.getReceiveData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public OrderVO addExpress(String receivername, String receivetime,
			String orderNumber) throws Exception {
		OrderPO orderpo = receiveData.find(orderNumber);

		OrderVO ordervo = new OrderVO(orderpo);
		ordervo.setReceivetime(receivetime);
		this.saveExpress(ordervo);
		return ordervo;
	}

	@Override
	public ResultMessage saveExpress(OrderVO ordervo) throws Exception {
		OrderPO orderpo = new OrderPO(ordervo.getTimeOfSend(),
				ordervo.getDueOfReceive(), ordervo.getOrdernumber(),
				ordervo.getNameOfCourier(), ordervo.getSender(),
				ordervo.getReceiver(), ordervo.getBill(), ordervo.getGoods(),
				ordervo.getDocumentCondition());
		orderpo.setReceivetime(ordervo.getReceivetime());
		return receiveData.updateO(orderpo);

	}

	@Override
	public void endReceive() throws Exception {
		receiveData.finish();
	}
	
	public OrderVO getOrder(String orderNumber){
		OrderPO orderpo=null;
		try {
			orderpo = receiveData.find(orderNumber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrderVO ordervo = new OrderVO(orderpo);
		return ordervo;
		
	}

}
