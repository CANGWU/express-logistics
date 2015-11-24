package transportslservice;

import enums.TransportType;
import vo.TransportVO;

public interface TransportService {
	//查看运输单信息
	public TransportVO getTransport(String Transportid) throws Exception;
	
	//生成运输单的过程
	public void choose(TransportType sign,TransportVO transportvo);//选择生成何种单据
	public void addMember(String id,TransportVO transportvo);
	public void addExpress(String orderNumber,TransportVO transportvo);
	public void addCondition(String orderNumber,String conditon,TransportVO transportvo);
	public void addMessage(String departure,String destination,String time,TransportVO transportvo);
	public void addTraffic(String id,TransportVO transportvo);
	public void addFare(String departure,String destination,TransportVO transportvo);
	public void saveTransport(TransportVO transportvo) throws Exception;
	public void printTransport(String id);
	public void endTransport() throws Exception;
}
