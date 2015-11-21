package ioputslservice;

import slstub.ResultMessage;
import vo.InMessageVO;
import vo.OutMessageVO;

public interface IoputService {
	public InMessageVO showInputInfo (String id);
	public ResultMessage position (String position);
	public OutMessageVO showOutputInfo(String id);
	public ResultMessage report(String id);


}