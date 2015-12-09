package receivesl;

import java.rmi.RemoteException;

import po.DeliverPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import receiveslservice.DeliverService;
import vo.DeliverVO;

public class Deliver implements DeliverService {

	DataFactoryService dataFactory;
	ReceiveDataService receiveData;

	public Deliver() {
		try {
			this.dataFactory = DataFactory.create();
			this.receiveData = dataFactory.getReceiveData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public DeliverVO getDeliver(String deliverNumber) throws Exception {
		DeliverPO deliverpo = receiveData.findD(deliverNumber);
		DeliverVO delivervo = new DeliverVO(deliverpo.getID(),
				deliverpo.getWriter(), deliverpo.getTime(),
				deliverpo.getMember(), deliverpo.getOrder(),
				deliverpo.getDocumentCondition());
		return delivervo;
	}

	@Override
	public void newDeliver(String time, DeliverVO delivervo) {
		delivervo.setTime(time);
	}

	@Override
	public void addMember(String id, DeliverVO delivervo) {
		delivervo.getMember().add(id);
	}

	@Override
	public void addExpress(String orderNumber, DeliverVO delivervo) {
		delivervo.getOrder().add(orderNumber);
	}

	@Override
	public void printDeliver(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage saveDeliver(DeliverVO delivervo) throws Exception {
		DeliverPO deliverpo = new DeliverPO(delivervo.getID(),
				delivervo.getWriter(), delivervo.getTime(),
				delivervo.getMember(), delivervo.getOrder(),
				delivervo.getDocumentCondition());
		return receiveData.insertD(deliverpo);

	}

	@Override
	public void endDeliver() throws Exception {
		receiveData.finish();
	}
}
