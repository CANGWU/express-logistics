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
	public OrderVO addExpress(String receivername, String _timeOfSend,
			String orderNumber) throws Exception {
		OrderPO orderpo = receiveData.find(orderNumber);
		OrderVO ordervo = new OrderVO(_timeOfSend, orderpo.getNameOfCourier(),
				orderpo.getSender().getName(),
				orderpo.getSender().getAddress(), orderpo.getSender()
						.getWorkPlace(), orderpo.getSender().getTelNumber(),
				orderpo.getSender().getPhoneNumber(), receivername, orderpo
						.getReceiver().getAddress(), orderpo.getReceiver()
						.getWorkPlace(), orderpo.getReceiver().getTelNumber(),
				orderpo.getReceiver().getPhoneNumber(), orderpo.getGoods()
						.getNumberOfGoods(), orderpo.getGoods().getWeight(),
				orderpo.getGoods().getVolume(), orderpo.getGoods()
						.getNameOfGoods(), orderpo.getGoods().getSize(),
				orderpo.getGoods().getExpressType(), orderpo.getGoods()
						.getPacking(), orderpo.getdCondition());
		ordervo.setOrdernumber(orderNumber);
		return ordervo;
	}

	@Override
	public ResultMessage saveExpress(OrderVO ordervo) throws Exception {
		OrderPO orderpo = new OrderPO(ordervo.getTimeOfSend(),
				ordervo.getDueOfReceive(), ordervo.getOrdernumber(),
				ordervo.getNameOfCourier(), ordervo.getSender(),
				ordervo.getReceiver(), ordervo.getBill(), ordervo.getGoods(),
				ordervo.getDocumentCondition());
		return receiveData.insertO(orderpo);

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
