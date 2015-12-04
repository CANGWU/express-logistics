package transportsl;

import enums.Condition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import transportslservice.TransportService;
import vo.TransportVO;

public class TransportController implements TransportService {
	Transport transport;

	public TransportController(Transport transport) {
		this.transport = transport;
	}

	@Override
	public TransportVO getTransport(String Transportid) throws Exception {
		return transport.getTransport(Transportid);
	}

	@Override
	public void choose(TransportType sign, TransportVO transportvo) {
		transport.choose(sign, transportvo);
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
	public void addMessage(Position departure, Position destination,
			String time, TransportVO transportvo) {
		transport.addMessage(departure, destination, time, transportvo);
	}

	@Override
	public void addTraffic(String id, Traffic trafficType, TransportVO transportvo) {
		transport.addTraffic(id, trafficType, transportvo);
	}

	@Override
	public void addFare(TransportVO transportvo) {
		transport.addFare(transportvo);
	}

	@Override
	public ResultMessage saveTransport(TransportVO transportvo) throws Exception {
		return transport.saveTransport(transportvo);
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
