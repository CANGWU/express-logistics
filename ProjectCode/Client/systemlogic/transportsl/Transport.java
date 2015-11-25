package transportsl;

import po.TransportPO;
import dataservice.DataFactoryService;
import dataservice.TransportDataService;
import enums.Condition;
import enums.TransportType;
import vo.TransportVO;

public class Transport {
	DataFactoryService datafactory;
	TransportDataService transportData;

	public Transport(DataFactoryService datafactory) {
		this.datafactory = datafactory;
		this.transportData = datafactory.getTransportDate();
	}

	public TransportVO getTransport(String Transportid) throws Exception {
		TransportPO po = transportData.find(Transportid);
		TransportVO vo = new TransportVO(po.getSign(), po.getID(), po.getDeparture(),
				po.getDestination(), po.getTime(), po.getTraffic(),
				po.getfare(), po.getMember(), po.getOrder(), po.getCondition(),
				po.getDocumentCondition());
		return vo;
	}

	public void choose(TransportType sign, TransportVO transportvo) {
		transportvo.setSign(sign);
	}

	public void addMember(String id, TransportVO transportvo) {
		transportvo.getMember().add(id);
	}

	public void addExpress(String orderNumber, TransportVO transportvo) {
		transportvo.getOrder().add(orderNumber);
	}

	public void addCondition(String orderNumber, Condition conditon,
			TransportVO transportvo) {
		transportvo.getCondition().add(conditon);
	}

	public void addMessage(String departure, String destination, String time,
			TransportVO transportvo) {
		transportvo.setDeparture(departure);
		transportvo.setDestination(destination);
		transportvo.setTime(time);
	}

	public void addTraffic(String id, TransportVO transportvo) {
		transportvo.setTraffic(id);
	}

	public void addFare(String departure, String destination,
			TransportVO transportvo) {
		transportvo.setFare(10000);
	}

	public void saveTransport(TransportVO transportvo) throws Exception {
		TransportPO po = new TransportPO(transportvo.getSign(), transportvo.getID(),
				transportvo.getDeparture(), transportvo.getDestination(),
				transportvo.getTime(), transportvo.getTraffic(),
				transportvo.getfare(), transportvo.getMember(),
				transportvo.getOrder(), transportvo.getCondition(),
				transportvo.getDocumentCondition());
		transportData.insert(po);
	}

	public void printTransport(String id) {

	}

	public void endTransport() throws Exception {
		transportData.finish();
	}

}
