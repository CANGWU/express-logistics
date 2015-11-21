package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.UserDataService;
import po.LogPO;
import po.ResultMessage;
import po.UserPO;

public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

	private UserDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserPO findUserPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> findsUserPO(String[] id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insertUserPO(UserPO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteUserPO(UserPO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateUserPO(UserPO user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogPO findLogPO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LogPO> findsLogsPO(String[] id) {
		// TODO Auto-generated method stub
		return null;
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
}
