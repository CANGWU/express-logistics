package transportslservice;

import java.util.ArrayList;

import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import vo.TransportVO;

public interface TransportService {
	public double addFare(TransportVO transportvo);

	public TransportVO newTransport(TransportType sign, String id,
			String departure, String destination, String transportID,
			String time, String trafficID, Traffic trafficType, double fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition,
			DocumentCondition documentCondition, String nameOfWriter);

	public TransportVO getTransport(String Transportid) throws Exception;

	public ArrayList<TransportVO> getTransportList(String nameOfWriter,
			DocumentCondition dCondition) throws Exception;

	public ResultMessage saveTransport(TransportVO transportvo)
			throws Exception;

	public ResultMessage deleteTransport(String Transportid) throws Exception;

	public ResultMessage updateTransport(TransportVO transportvo)
			throws Exception;

	public void printTransport(String id);

	public void endTransport() throws Exception;
}
