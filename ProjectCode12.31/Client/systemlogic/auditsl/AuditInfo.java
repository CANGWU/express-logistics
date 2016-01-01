package auditsl;

import java.util.ArrayList;

import enums.ResultMessage;

public interface AuditInfo{
	
	public ArrayList<?> getAuditInfo();
	
	public ResultMessage EndAudit(ArrayList<?> list);

}
