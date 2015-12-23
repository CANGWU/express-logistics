package auditsl;

import java.util.ArrayList;

import vo.DocumentVO;
import auditslservice.AuditService;

public class AuditController implements AuditService {
	
	private Audit Audit;
	

	AuditController(AuditInfo Send,AuditInfo Transport,AuditInfo Receive,AuditInfo Finance,AuditInfo InputStock,AuditInfo OutputStock){
		this.Audit = new Audit(Send,Transport,Receive,Finance,InputStock,OutputStock);
	}
	
	@Override
	public ArrayList<DocumentVO> Initialize(String id) {
		// TODO Auto-generated method stubZ
		return Audit.Initialize();
	}

	@Override
	public void saveChange(DocumentVO vo) {
		// TODO Auto-generated method stub
		
	}


}
