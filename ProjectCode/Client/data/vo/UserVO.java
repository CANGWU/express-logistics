package vo;

import java.util.ArrayList;

public class UserVO {
     
	String name;
	String accountnumber;
	String code;
	String privileges;
    ArrayList<LogVO> loglist=new ArrayList<LogVO>();
    
    public UserVO(String name,String accountnumber,String code,String privileges){
    	this.name=name;
    	this.accountnumber=accountnumber;
    	this.code=code;
    	this.privileges=privileges;
    	
    }
    
    public void addMessage(LogVO newlogpo){
    	loglist.add(newlogpo);
    }
    
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