package usersl;

import java.util.ArrayList;

import enums.ResultMessage;
import userslservice.LogService;
import vo.LogVO;

public class LogManagementController implements LogService{
	
	LogManagement lm;
	
	public LogManagementController(){
		this.lm=LogManagement.creatCheck();
	}

	@Override
	public ArrayList<LogVO> logmessage(String office, String time) {
		// TODO Auto-generated method stub
		return lm.logmessage(office, time);
	}

	@Override
	public ResultMessage addMessage(String userId, String logmessage) {
		// TODO Auto-generated method stub
		return lm.addMessage(userId, logmessage);
	}

}
