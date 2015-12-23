package auditsl;

import java.util.ArrayList;

import enums.ResultMessage;

public interface AuditInfo{
	
	@SuppressWarnings("rawtypes")
	public ArrayList getAuditInfo();
	
	@SuppressWarnings("rawtypes")
	public ResultMessage EndAudit(ArrayList list);

}
