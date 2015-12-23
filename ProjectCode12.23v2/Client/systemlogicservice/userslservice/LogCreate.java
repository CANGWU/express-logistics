package userslservice;

import enums.ResultMessage;

public interface LogCreate {
	
	public ResultMessage logCreate(String time,String office,String userId,String logmessage);

}
