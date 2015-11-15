package ioputslservice;

import slstub.ResultMessage;
import vo.OutMessageVO;

public interface OutputStockService {
	
	public OutMessageVO showInfo(String id);

	public ResultMessage report(String id);


}
