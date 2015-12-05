package auditslservice;

import java.util.ArrayList;

import vo.DocumentVO;


public interface AuditService {
	public ArrayList<DocumentVO> Initialize(String id);
	public void saveChange(DocumentVO vo);

}
