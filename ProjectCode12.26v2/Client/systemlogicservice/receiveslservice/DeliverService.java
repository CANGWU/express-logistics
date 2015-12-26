package receiveslservice;

import java.util.ArrayList;

import po.DeliverPO;
import enums.DocumentCondition;
import enums.ResultMessage;
import vo.DeliverVO;

public interface DeliverService {
	public DeliverVO newDeliver(String id, String nameOfWriter, String time,
			ArrayList<String> member, ArrayList<String> order,
			DeliverVO delivervo);
	
	public DeliverVO getDeliver(String deliverNumber) throws Exception;

	public ResultMessage saveDeliver(DeliverVO delivervo) throws Exception;

	public ResultMessage updateDeliver(DeliverVO delivervo) throws Exception;

	public ResultMessage deleteDeliver(String id) throws Exception;

	public ArrayList<DeliverVO> findDWithdCondition(String nameOfWriter, DocumentCondition dCondition) throws Exception;

	public void printDeliver(String id);

	public void endDeliver() throws Exception;
}
