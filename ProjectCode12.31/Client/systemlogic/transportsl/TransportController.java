package transportsl;

import java.util.ArrayList;

import auditsl.AuditInfo;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import transportslservice.TransportService;
import vo.TransportVO;

public class TransportController implements TransportService,AuditInfo {
	Transport transport;

	public TransportController(Transport transport) {
		this.transport = transport;
	}

	@Override
	public TransportVO getTransport(String Transportid) throws Exception {
		return transport.getTransport(Transportid);
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

	@Override
	public TransportVO newTransport(TransportType sign, String id,
			String departure, String destination, String transportID,
			String time, String trafficID, Traffic trafficType, double fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition,
			DocumentCondition documentCondition, String nameOfWriter) {
		return transport.newTransport(sign, id, departure, destination,
				transportID, time, trafficID, trafficType, fare, member, order,
				condition, documentCondition, nameOfWriter);
	}

	@Override
	public ArrayList getAuditInfo() {
		return transport.getAuditInfo();
	}

	@Override
	public ResultMessage EndAudit(ArrayList list) {
		return transport.EndAudit(list);
	}

}
