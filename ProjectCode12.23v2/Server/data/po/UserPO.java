package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Work;

public class UserPO implements Serializable{
     
	String name;
	String accountnumber;
	String code;
	String privileges;
	Work work;
	
 
	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
	//ArrayList<LogPO> loglist=new ArrayList<LogPO>();
    
    public UserPO(String name,String accountnumber,String code,String privileges,Work work){
    	this.name=name;
    	this.accountnumber=accountnumber;
    	this.code=code;
    	this.privileges=privileges;
    	this.work=work;
    	
    }
    
//    public void addMessage(LogPO newlogpo){
//    	loglist.add(newlogpo);
//    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	
}
