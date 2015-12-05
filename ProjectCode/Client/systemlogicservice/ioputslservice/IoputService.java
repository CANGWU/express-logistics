package ioputslservice;

import enums.ResultMessage;
import enums.WarningMessage;
import vo.InMessageVO;
import vo.OutMessageVO;

public interface IoputService {
	public InMessageVO showInputInfo (String id);
	public WarningMessage position (String position);
	public OutMessageVO showOutputInfo(String id);
	public ResultMessage report(String id);


}