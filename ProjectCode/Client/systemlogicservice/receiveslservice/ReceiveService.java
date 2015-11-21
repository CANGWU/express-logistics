package receiveslservice;

import vo.OrderVO;

public interface ReceiveService {
	// ’º˛ ‰»Î
	public OrderVO addExpress(String receivername,String _timeOfSend,String orderNumber) throws Exception;
	public void saveExpress(OrderVO ordervo) throws Exception;
	public void endReceive() throws Exception;
}
