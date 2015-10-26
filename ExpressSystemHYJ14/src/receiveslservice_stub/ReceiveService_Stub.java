package receiveslservice_stub;

import java.util.ArrayList;

import po.DeliverPO;
import po.OrderPO;
import receiveslservice.ReceiveService;
import vo.DeliverVO;
import vo.OrderVO;

public class ReceiveService_Stub implements ReceiveService {
	String memberID = "000025000";
	String deliverID = "025000201510250000000";
	String orderNumber = "0123456789";
	String time = "2015/10/25";
	String name = "hyj";
	ArrayList<String> memberList;
	ArrayList<String> orderList;

	@Override
	public DeliverVO getDeliver(String deliverID) {
		// TODO Auto-generated method stub
		memberList = new ArrayList<String>();
		memberList.add(memberID);
		orderList = new ArrayList<String>();
		orderList.add(orderNumber);
		return new DeliverVO(deliverID, time, memberList, orderList);
	}

	@Override
	public DeliverVO newDeliver(String time) {
		// TODO Auto-generated method stub
		orderList = new ArrayList<String>();
		orderList.add(orderNumber);
		return new DeliverVO(deliverID, time, null, orderList);
	}

	@Override
	public DeliverVO addMember(String memberID,DeliverVO delivervo) {
		// TODO Auto-generated method stub
		memberList = new ArrayList<String>();
		memberList.add(memberID);
		delivervo.setMember(memberList);
		return delivervo;
	}

	@Override
	public void printDeliver(String id) {
		// TODO Auto-generated method stub
		System.out.println("Print the deliver!");
	}

	@Override
	public void saveDeliver(DeliverVO delivervo) {
		// TODO Auto-generated method stub
		System.out.println("Deliver saved!");
		
	}

	@Override
	public OrderVO addExpress(String name, String time, String orderNumber) {
		// TODO Auto-generated method stub
		return new OrderVO(name, time, orderNumber);
	}

	@Override
	public void saveExpress(OrderVO ordervo) {
		// TODO Auto-generated method stub
//		OrderPO po=new OrderPO(ordervo.getName(),ordervo.getTime(),ordervo.getID());
		System.out.println("Express saved!");
	}

	@Override
	public void endReceive() {
		// TODO Auto-generated method stub
		System.out.println("End the receive!");
	}

}
