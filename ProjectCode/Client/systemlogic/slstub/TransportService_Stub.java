package slstub;

import java.util.ArrayList;

import transportslservice.TransportService;
import vo.TransportVO;

public class TransportService_Stub implements TransportService {
	String sign = "1";
	String id = "0250000000000";
	String departure = "000025003";
	String destination = "000025004";
	String time = "2015/10/10";
	String traffic = "A00000";
	long fare = 66666;
	ArrayList<String> memberList;
	ArrayList<String> orderList;
	ArrayList<String> conditionList;
	String memberID = "000025000";
	String orderNumber = "0123456789";
	String condition = "Perfect";

	@Override
	public TransportVO getTransport(String Transportid) {
		// TODO Auto-generated method stub
		memberList = new ArrayList<String>();
		memberList.add(memberID);
		orderList = new ArrayList<String>();
		orderList.add(orderNumber);
		conditionList = new ArrayList<String>();
		conditionList.add(condition);
		return new TransportVO(sign, Transportid, departure, destination,
				this.time, this.traffic, this.fare, memberList, orderList,
				conditionList);
	}

	@Override
	public TransportVO choose(String sign) {
		// TODO Auto-generated method stub
		memberList = new ArrayList<String>();
		memberList.add(memberID);
		orderList = new ArrayList<String>();
		orderList.add(orderNumber);
		conditionList = new ArrayList<String>();
		conditionList.add(condition);
		return new TransportVO(sign, null, null, null, null, null,0, memberList,
				orderList, conditionList);
	}

	@Override
	public TransportVO addMember(String id,TransportVO transportvo) {
		// TODO Auto-generated method stub
		memberList=transportvo.getMember();
		memberList.add(id);
		transportvo.setMember(memberList);
		return transportvo;
	}

	@Override
	public TransportVO addExpress(String orderNumber,TransportVO transportvo) {
		// TODO Auto-generated method stub
		orderList=transportvo.getOrder();
		orderList.add(orderNumber);
		transportvo.setOrder(orderList);
		return transportvo;
	}

	@Override
	public TransportVO addCondition(String orderNumber, String conditon,TransportVO transportvo) {
		// TODO Auto-generated method stub
		conditionList=transportvo.getCondition();
		conditionList.add(condition);
		transportvo.setCondition(conditionList);
		return transportvo;
	}

	@Override
	public TransportVO addMessage(String departure, String destination,
			String time,TransportVO transportvo) {
		// TODO Auto-generated method stub
		transportvo.setDeparture(departure);
		transportvo.setDestination(destination);
		transportvo.setTime(time);
		return transportvo;
	}

	@Override
	public TransportVO addTraffic(String id,TransportVO transportvo) {
		// TODO Auto-generated method stub
		transportvo.setTraffic(id);
		return transportvo;
	}

	@Override
	public TransportVO addFare(String departure, String destination,TransportVO transportvo) {
		// TODO Auto-generated method stub
		transportvo.setFare(fare);
		return transportvo;
	}

	@Override
	public void saveTransport(TransportVO transportvo) {
		// TODO Auto-generated method stub
		System.out.println("Transport saved!");
	}

	@Override
	public void printTransport(String id) {
		// TODO Auto-generated method stub
		System.out.println("Print the Transport!");
	}

	@Override
	public void endTransport() {
		// TODO Auto-generated method stub
		System.out.println("End the Transport!");
	}

}
