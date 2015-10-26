package ioputslservice;

import slstub.ResultMessage;
import vo.OutMessageVO;

public interface OutputStockSLService {
	
	public OutMessageVO showInfo(String id);

	public ResultMessage report(String id);


}
