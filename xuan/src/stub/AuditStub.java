package stub;

import java.util.ArrayList;

import auditslservice.AuditService;
import vo.DecumentVO;

public class AuditStub implements AuditService{

	@Override
	public DecumentVO select(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adopt(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revise(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveChange(DecumentVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<DecumentVO> selectNum(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endAudit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<DecumentVO> getAllDecument() {
		// TODO Auto-generated method stub
		return null;
	}

}
