package usersl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;






import java.util.Date;

import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import pamanagementsl.PManagementController;
import po.LogPO;
import userslservice.LogService;
import vo.LogVO;
import vo.StaffVO;

public class LogManagement implements LogService{
	
	static LogManagement log;
	DataFactory datafactory;
	ArrayList<LogPO> logs;
	ArrayList<LogVO> logVOs;
	
	private LogManagement(){
		try {
			this.datafactory=DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<LogVO> logmessage(String office,String time) {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();
		logVOs=new ArrayList<LogVO>();
		try {
			logs=userdata.findsLogsPO(office,time);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(LogPO po:logs){
			LogVO vo=new LogVO(po.getTime(), po.getOffice(), po.getUseuId(), po.getLogmessage());
			logVOs.add(vo);
		}

		
		return logVOs;
	
	}

	
	
	public static LogManagement creatCheck(){
		if(log==null)
			log = new LogManagement();	
		
		 return log;
	}

	@Override
	public ResultMessage addMessage(String userId, String logmessage) {
		// TODO Auto-generated method stub
		
		 PManagementController pm=new PManagementController();

	     StaffVO staffVO=pm.select(userId);
	     
		 UserDataService userdata=datafactory.getUserData();
		 
		 Date dt = new Date();   
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		 String timeOfLog=sdf.format(dt);
		 
		 LogPO log=new LogPO(timeOfLog,staffVO.getWorkPlaceNumber(),userId,logmessage);
		 
		 try {
			return userdata.insertLogPO(log);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	     
	     
	}

}
