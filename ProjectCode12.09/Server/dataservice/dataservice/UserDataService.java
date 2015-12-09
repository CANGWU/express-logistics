package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.ResultMessage;
import po.*;

public interface UserDataService extends Remote{
      public UserPO findUserPO(String id) throws RemoteException;
      public ArrayList<UserPO> findsUserPO(String id[])throws RemoteException;
      public ResultMessage insertUserPO(UserPO user)throws RemoteException;
      public ResultMessage deleteUserPO(String id)throws RemoteException;
      public ResultMessage updateUserPO(UserPO user)throws RemoteException;
      public ArrayList<UserPO> getAllUsers()throws RemoteException;
      
      
      public LogPO findLogPO(String office,String time)throws RemoteException;
      public ResultMessage insertLogPO(LogPO log)throws RemoteException;
      
      public ArrayList<LogPO> findsLogsPO(String office,String time)throws RemoteException;
      
      
      
}
