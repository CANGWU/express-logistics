package auditslservice;

import java.util.ArrayList;

import vo.DecumentVO;


public interface AuditService {
	public DecumentVO select(String id);
	public void adopt(String id);
	public void revise(String id);
	public void saveChange(DecumentVO vo);
	public ArrayList<DecumentVO> selectNum(String[]ids);
	public void endAudit();
	public ArrayList<DecumentVO> getAllDecument();
	
}
