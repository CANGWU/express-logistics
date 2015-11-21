package usersl;


import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import po.LogPO;
import userslservice.LogCreate;

public class LogList implements LogCreate{
	
	DataFactory datafactory;
	static LogList loglist;
	
	private LogList(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	
	

	@Override
	public ResultMessage logCreate(String time,String office,String userId,String logmessage) {
		// TODO Auto-generated method stub
		LogPO po=new LogPO(time,office,userId,logmessage);
		UserDataService userdata=datafactory.getUserData();
		
		ResultMessage message=userdata.insertLogPO(po);
		
		return message;
	}
	
	
	public static LogList creatLogList(DataFactory datafactory){
		if(loglist==null)
			loglist = new LogList(datafactory);	
		
		 return loglist;
	}

	
}
