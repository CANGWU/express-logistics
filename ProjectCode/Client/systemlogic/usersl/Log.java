package usersl;

import java.util.ArrayList;





import dataservice.UserDataService;
import po.LogPO;
import userslservice.LogService;

public class Log implements LogService{
	
	static Log log;
	DataFactory datafactory;
	ArrayList<LogPO> logs;
	
	private Log(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	
	@Override
	public ArrayList<LogPO> logmessage(String office,String time) {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();
		logs=userdata.findsLogsPO(office,time);
		
		
		
		LogList loglist=LogList.creatCheck(datafactory);
		loglsit
		
		return logs;
	
	}
	
	
	
	
	static Log creatCheck(DataFactory datafactory){
		if(log==null)
			log = new Log(datafactory);	
		
		 return log;
	}

}
