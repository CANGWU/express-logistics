package ioputslservice;

import slstub.ResultMessage;
import vo.InMessageVO;

public interface InputStockSLService {
	public InMessageVO showInfo (String id);
	public ResultMessage position (String position);


}
