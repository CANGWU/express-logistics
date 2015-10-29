package driver;

import receiveslservice.ReceiveService;
import vo.DeliverVO;
import vo.OrderVO;

public class ReceiveService_Driver {
	public void drive(ReceiveService receiveService){
		DeliverVO delivervo=receiveService.newDeliver("2015/10/26");
		delivervo=receiveService.addMember("000025001",delivervo);
		System.out.println("deliver time:"+delivervo.getTime());
		receiveService.printDeliver(delivervo.getID());
		receiveService.saveDeliver(delivervo);

		OrderVO ordervo=receiveService.addExpress("hyj14", "2015/10/26", "6666666666");
		System.out.println("order name:"+ordervo.getReceiver());
		receiveService.saveExpress(ordervo);
		receiveService.endReceive();
	}
}
