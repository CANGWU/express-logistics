package po;

import java.io.Serializable;

public class LogPO implements Serializable{
     
	String time;
	String office;
	String userId;
	String logmessage;
	
	public LogPO(String time,String office,String userId,String logmessage){
		this.time=time;
		this.office=office;
		this.userId=userId;
		this.logmessage=logmessage;
	}

	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getUseuId() {
		return userId;
	}
	public void setUseuId(String userId) {
		this.userId = userId;
	}
	public String getLogmessage() {
		return logmessage;
	}
	public void setLogmessage(String logmessage) {
		this.logmessage = logmessage;
	}
}
