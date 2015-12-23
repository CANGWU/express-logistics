package receiveslservice;

import enums.ResultMessage;
import vo.OrderVO;

public interface ReceiveService {
	// ’º˛ ‰»Î
	public OrderVO addExpress(String receivername,String _timeOfSend,String orderNumber) throws Exception;
	public ResultMessage saveExpress(OrderVO ordervo) throws Exception;
	public void endReceive() throws Exception;
}
