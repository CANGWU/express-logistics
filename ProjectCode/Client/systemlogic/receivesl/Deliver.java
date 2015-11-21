package receivesl;

import po.DeliverPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import receiveslservice.DeliverService;
import vo.DeliverVO;

public class Deliver implements DeliverService{
	
	DataFactoryService dataFactory;
	ReceiveDataService receiveData;

	public Deliver(DataFactoryService DataFactory) {
		this.dataFactory = dataFactory;
		this.receiveData = dataFactory.getReceiveData();
	}
	@Override
	public DeliverVO getDeliver(String deliverNumber) throws Exception {
		DeliverPO deliverpo=receiveData.findD(deliverNumber);
		DeliverVO delivervo=new DeliverVO(deliverNumber, deliverNumber, null, null);
		return null;
	}

	@Override
	public void newDeliver(String time, DeliverVO delivervo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMember(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printDeliver(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDeliver(DeliverVO delivervo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDeliver() {
		// TODO Auto-generated method stub
		
	}

}
