package receivesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DeliverPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
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
	public DeliverVO newDeliver(String id, String nameOfWriter, String time,
			ArrayList<String> member, ArrayList<String> order,
			DeliverVO delivervo) {
		delivervo.setID(id);
		delivervo.setWriter(nameOfWriter);
		delivervo.setTime(time);
		delivervo.setMember(member);
		delivervo.setOrder(order);
		delivervo.setDocumentCondition(DocumentCondition.handing);
		return delivervo;
	}

	@Override
	public ArrayList<DeliverPO> findDWithdCondition(String nameOfWriter,
			DocumentCondition dCondition) throws Exception {
		return receiveData.findDWithdCondition(nameOfWriter, dCondition);
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
	public ResultMessage updateDeliver(DeliverVO delivervo) throws Exception {	
		DeliverPO deliverpo = new DeliverPO(delivervo.getID(),
				delivervo.getWriter(), delivervo.getTime(),
				delivervo.getMember(), delivervo.getOrder(),
				delivervo.getDocumentCondition());
		return receiveData.updateD(deliverpo);
	}

	@Override
	public ResultMessage deleteDeliver(String id) throws Exception {
		return receiveData.deleteD(id);
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
	public void printDeliver(String id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void endDeliver() throws Exception {
		receiveData.finish();
	}
}
