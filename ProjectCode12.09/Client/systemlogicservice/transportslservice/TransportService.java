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
	//查看运输单信息
	public TransportVO getTransport(String Transportid) throws Exception;
	public ArrayList<TransportVO> getTransportList(String nameOfWriter, DocumentCondition dCondition) throws Exception;
	
	//生成运输单的过程
	public void choose(TransportType sign,TransportVO transportvo);//选择生成何种单据
	public void addMember(String id,TransportVO transportvo);
	public void addExpress(String orderNumber,TransportVO transportvo);
	public void addCondition(String orderNumber,Condition conditon,TransportVO transportvo);
	public void addMessage(Position departure,Position destination,String time,TransportVO transportvo);
	public void addTraffic(String id,Traffic traffic,TransportVO transportvo);
	public double addFare(TransportVO transportvo);
	public ResultMessage saveTransport(TransportVO transportvo) throws Exception;
	public ResultMessage deleteTransport(String Transportid) throws Exception;
	public ResultMessage updateTransport(TransportVO transportvo) throws Exception;
	public void printTransport(String id);
	public void endTransport() throws Exception;
}
