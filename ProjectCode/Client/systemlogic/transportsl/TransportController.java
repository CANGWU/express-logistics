package transportsl;

import enums.Condition;
import enums.TransportType;
import transportslservice.TransportService;
import vo.TransportVO;

public class TransportController implements TransportService{
	Transport transport;
	public TransportController(Transport transport){
		this.transport=transport;
	}
	
	@Override
	public TransportVO getTransport(String Transportid) throws Exception {
		return transport.getTransport(Transportid);
	}

	@Override
	public void choose(TransportType sign,TransportVO transportvo) {
		transport.choose(sign,transportvo);
	}

	@Override
	public void addMember(String id, TransportVO transportvo) {
		transport.addMember(id, transportvo);
	}

	@Override
	public void addExpress(String orderNumber, TransportVO transportvo) {
		transport.addExpress(orderNumber, transportvo);
	}

	@Override
	public void addCondition(String orderNumber, Condition conditon,
			TransportVO transportvo) {
		transport.addCondition(orderNumber, conditon, transportvo);
	}

	@Override
	public void addMessage(String departure, String destination,
			String time, TransportVO transportvo) {
		transport.addMessage(departure, destination, time, transportvo);
	}

	@Override
	public void addTraffic(String id, TransportVO transportvo) {
		transport.addTraffic(id, transportvo);
	}

	@Override
	public void addFare(String departure, String destination,
			TransportVO transportvo) {
		transport.addFare(departure, destination, transportvo);
	}

	@Override
	public void saveTransport(TransportVO transportvo) throws Exception {
		transport.saveTransport(transportvo);
	}

	@Override
	public void printTransport(String id) {
		transport.printTransport(id);
	}

	@Override
	public void endTransport() throws Exception {
		transport.endTransport();
	}

}
