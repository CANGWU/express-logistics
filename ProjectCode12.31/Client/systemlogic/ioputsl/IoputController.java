package ioputsl;

import dataservice.DataFactoryService;
import enums.ResultMessage;
import enums.WarningMessage;
import stocksl.IoputStock;
import vo.InMessageVO;
import vo.OutMessageVO;
import ioputslservice.IoputService;

public class IoputController implements IoputService {
	
	private InputStock In;
	private OutputStock Out;
	
	public IoputController(DataFactoryService d,IoputStock Stock,OutputMessage OutputMessage,InputMessage InputMessage){
		In = new InputStock(Stock,InputMessage,d);
		Out = new OutputStock(Stock,OutputMessage,d);
	}

	@Override
	public InMessageVO showInputInfo(String id) {
		// TODO Auto-generated method stub
		return In.showInputInfo(id);
	}

	@Override
	public WarningMessage position(String position) {
		// TODO Auto-generated method stub
		return In.position(position);
	}

	@Override
	public OutMessageVO showOutputInfo(String id) {
		// TODO Auto-generated method stub
		return Out.showOutputInfo(id);
	}

	@Override
	public ResultMessage report(String id) {
		// TODO Auto-generated method stub
		return Out.report(id);
	}

}
