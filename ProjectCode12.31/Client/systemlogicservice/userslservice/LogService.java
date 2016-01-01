package userslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import po.LogPO;
import vo.LogVO;

public interface LogService {
       public ArrayList<LogVO> logmessage(String office,String time);
       public ResultMessage addMessage(String userId,String logmessage);
}
