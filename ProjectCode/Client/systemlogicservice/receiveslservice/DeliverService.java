package receiveslservice;

import vo.DeliverVO;

public interface DeliverService {
	//在派件界面得到派件单信息
	public DeliverVO getDeliver(String deliverNumber);
	
	//生成派件单
	public void newDeliver(String time,DeliverVO delivervo);
	public void addMember(String id);
	public void printDeliver(String id);
	public void saveDeliver(DeliverVO delivervo);
	public void endDeliver();
}
