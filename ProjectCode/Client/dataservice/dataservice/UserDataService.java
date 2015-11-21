package dataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import enums.ResultMessage;
import po.*;

public interface UserDataService extends Remote{
      public UserPO findUserPO(String id);
      public ArrayList<UserPO> findsUserPO(String id[]);
      public ResultMessage insertUserPO(UserPO user);
      public ResultMessage deleteUserPO(UserPO user);
      public ResultMessage updateUserPO(UserPO user);
      
      public LogPO findLogPO(String office,String time);
      public ResultMessage insertLogPO(LogPO log);
      
      public ArrayList<LogPO> findsLogsPO(String office,String time);
      
      
      
}
