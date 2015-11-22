package receiveslservice;

import vo.DeliverVO;

public interface DeliverService {
	//在派件界面得到派件单信息
	public DeliverVO getDeliver(String deliverNumber) throws Exception;
	
	//生成派件单
	public void newDeliver(String time,DeliverVO delivervo);
	public void addExpress(String orderNumber,DeliverVO delivervo);
	public void addMember(String id,DeliverVO delivervo);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo) throws Exception;
	public void endDeliver() throws Exception;
}
