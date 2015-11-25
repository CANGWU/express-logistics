package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import dataservice.UserDataService;
import enums.ResultMessage;
import enums.Work;
import link.Helper;
import po.LogPO;
import po.UserPO;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

	private UserDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static UserDataImpl create() throws RemoteException{
		if(user == null){
			synchronized(UserDataImpl.class){
		
		if(user == null)
		user = new UserDataImpl();
			}
		}
			
		return user;
	}
	
   private volatile static UserDataImpl user;

@Override
public UserPO findUserPO(String id) {
	// TODO Auto-generated method stub
	ResultSet result = null;
	String sql = "select*from userpo where accountnumber='"+id+"';";
	UserPO po = null;
	try{result = Helper.find(sql);
	if(result.next())
		po = new UserPO(result.getString("name"),result.getString("accountnumber"),result.getString("code"),result.getString("privileges"),Work.valueOf(result.getString("work")));
		
	}catch(Exception e){
		e.printStackTrace();
	}
	return po;
}


@Override
public ArrayList<UserPO> findsUserPO(String[] id) {
	// TODO Auto-generated method stub
	ArrayList<UserPO>users = new ArrayList<UserPO>();
	for(String i:id){
		users.add(findUserPO(i));
	}
	return users;
}


@Override
public enums.ResultMessage insertUserPO(UserPO user) {
	// TODO Auto-generated method stub
	String sql = "insert into Userpo values('"+user.getName()+"','"+user.getAccountnumber()+"','"+user.getCode()+"','"+user.getPrivileges()+"','"+user.getWork()+"');";
	return Helper.insert(sql);
}


@Override
public enums.ResultMessage deleteUserPO(String id) {
	// TODO Auto-generated method stub
	String sql ="delete from userpo where accountnumber='"+id+"';";
	return Helper.delete(sql);
}


@Override
public enums.ResultMessage updateUserPO(UserPO user) {
	// TODO Auto-generated method stub
	ResultMessage result = deleteUserPO(user.getAccountnumber());
    if(result==ResultMessage.FAIL)
    	return result;
    return insertUserPO(user);
}


@Override
public ArrayList<UserPO> getAllUsers() {
	// TODO Auto-generated method stub
	ResultSet result = null;
	String sql = "select*from userpo;";
	ArrayList<UserPO> users = new ArrayList<UserPO>();
	UserPO po = null;
	try{
		result = Helper.find(sql);
	while(result.next()){
		po = new UserPO(result.getString("name"),result.getString("accountnumber"),result.getString("code"),result.getString("privileges"),Work.valueOf(result.getString("work")));
	users.add(po);	
	}
	}catch(Exception e){
		e.printStackTrace();
	}
	return users;
}


@Override
public LogPO findLogPO(String office, String time) {
	String sql = "select*from logpo where office='"+office+"' and time='"+time+"';";
	//Helper.insert(sql1);
	LogPO po = null;
	ResultSet result = null;
	try{
		result = Helper.find(sql);
		if(result.next())
		po = new LogPO(result.getString("time"),result.getString("office"),result.getString("userid"),result.getString("logmessage"));
	}catch(Exception e){
		e.printStackTrace();
	}
			
	// TODO Auto-generated method stub
	return po;
}


@Override
public enums.ResultMessage insertLogPO(LogPO log) {
	// TODO Auto-generated method stub
	String sql = "insert into logpo values('"+log.getTime()+"','"+log.getOffice()+"','"+log.getUseuId()+"','"+log.getLogmessage()+"');";
	return Helper.insert(sql);
}


@Override
public ArrayList<LogPO> findsLogsPO(String office, String time) {
	// TODO Auto-generated method stub
	
	//String sql1 = "set sql_safe_update=0;";
	String sql2 = "select*from logpo where office='"+office+"' and time='"+time+"';";
	//Helper.insert(sql1);
	LogPO po = null;
	ResultSet result = null;
	ArrayList<LogPO>logs=new ArrayList<LogPO>();
	try{
		result = Helper.find(sql2);
		while(result.next()){
		po = new LogPO(result.getString("time"),result.getString("office"),result.getString("userid"),result.getString("logmessage"));
	   logs.add(po);
		}
		}catch(Exception e){
		e.printStackTrace();
	}
			
	// TODO Auto-generated method stub
	return logs;
}


}
