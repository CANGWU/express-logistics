package transportsl;

import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
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
	public void addTraffic(String id, Traffic trafficType,
			TransportVO transportvo) {
		transport.addTraffic(id, trafficType, transportvo);
	}

	@Override
	public double addFare(TransportVO transportvo) {
		return transport.addFare(transportvo);
	}

	@Override
	public ResultMessage saveTransport(TransportVO transportvo)
			throws Exception {
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

	@Override
	public ArrayList<TransportVO> getTransportList(String nameOfWriter,
			DocumentCondition dCondition) throws Exception {
		return transport.getTransportList(nameOfWriter, dCondition);
	}

	@Override
	public ResultMessage deleteTransport(String Transportid) throws Exception {
		return transport.deleteTransport(Transportid);
	}

	@Override
	public ResultMessage updateTransport(TransportVO transportvo)
			throws Exception {
		return transport.updateTransport(transportvo);
	}

}
