package transportslservice;

import vo.TransportVO;

public interface TransportService {
	//查看运输单信息
	public TransportVO getTransport(String Transportid);
	
	//生成运输单的过程
	public TransportVO choose(String sign);//选择生成何种单据
	public TransportVO addMember(String id,TransportVO transportvo);
	public TransportVO addExpress(String orderNumber,TransportVO transportvo);
	public TransportVO addCondition(String orderNumber,String conditon,TransportVO transportvo);
	public TransportVO addMessage(String departure,String destination,String time,TransportVO transportvo);
	public TransportVO addTraffic(String id,TransportVO transportvo);
	public TransportVO addFare(String departure,String destination,TransportVO transportvo);
	public void saveTransport(TransportVO transportvo);
	public void printTransport(String id);
	public void endTransport();
}
