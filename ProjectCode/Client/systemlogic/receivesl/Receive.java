package receivesl;

import java.rmi.RemoteException;

import po.OrderPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import receiveslservice.ReceiveService;
import vo.BillVO;
import vo.GoodsVO;
import vo.OrderVO;
import vo.ReceiverVO;
import vo.SenderVO;

public class Receive implements ReceiveService {
	DataFactoryService dataFactory;
	ReceiveDataService receiveData;

	public Receive(DataFactoryService DataFactory) {
		this.dataFactory = dataFactory;
		this.receiveData = dataFactory.getReceiveData();
	}

	@Override
	public OrderVO addExpress(String receivername, String _timeOfSend,
			String orderNumber) throws Exception {
		OrderPO orderpo = receiveData.findO(orderNumber);
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
				orderpo.getGoods().getExpressType());
		ordervo.setOrdernumber(orderpo.getOrdernumber());
		return ordervo;
	}

	@Override
	public void saveExpress(OrderVO ordervo) throws Exception {
		OrderPO orderpo = new OrderPO(ordervo.getTimeOfSend(),
				ordervo.getDueOfReceive(), ordervo.getOrdernumber(),
				ordervo.getNameOfCourier(), ordervo.getSender(),
				ordervo.getReceiver(), ordervo.getBill(), ordervo.getGoods());
		receiveData.insertO(orderpo);

	}

	@Override
	public void endReceive() throws Exception {
		receiveData.finish();
	}

}
