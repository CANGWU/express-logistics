package receiveslservice;

import vo.DeliverVO;
import vo.OrderVO;

public interface ReceiveService {
	//在派件界面得到派件单信息
	public DeliverVO getDeliver(String deliverNumber);
	
	//生成派件单
	public DeliverVO newDeliver(String time);
	public DeliverVO addMember(String id,DeliverVO delivervo);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo);
	//收件输入
	public OrderVO addExpress(String name,String time,String orderNumber);
	public void saveExpress(OrderVO ordervo);
	public void endReceive();
}
