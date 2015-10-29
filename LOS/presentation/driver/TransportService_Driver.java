package driver;

import transportslservice.TransportService;
import vo.TransportVO;

public class TransportService_Driver {
	public void drive(TransportService transportservice){
		TransportVO transportvo=transportservice.choose("1");
		transportvo=transportservice.addMember("000025066", transportvo);
		transportvo=transportservice.addExpress("0303020324", transportvo);
		transportvo=transportservice.addCondition("0303020324", "Lost", transportvo);
		transportvo=transportservice.addMessage("000025003", "000025004", "2015/10/10", transportvo);
		transportvo=transportservice.addTraffic("A00001", transportvo);
		transportvo=transportservice.addFare("000025003", "000025004", transportvo);
		transportservice.saveTransport(transportvo);
		transportservice.printTransport(transportvo.getID());
		transportservice.endTransport();
	}
}
