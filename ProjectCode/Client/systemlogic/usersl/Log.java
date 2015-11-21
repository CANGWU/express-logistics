package usersl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;






import java.util.Date;

import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
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
		
		this.log();
		

		
		return logs;
	
	}
	
	public void log(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		LogList loglist=LogList.creatLogList(datafactory);
		
		ResultMessage message=loglist.logCreate(time, null, null, "»’÷æ≤È—Ø");
	}
	
	
	
	static Log creatCheck(DataFactory datafactory){
		if(log==null)
			log = new Log(datafactory);	
		
		 return log;
	}

}
