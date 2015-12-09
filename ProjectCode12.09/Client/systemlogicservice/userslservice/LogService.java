package userslservice;

import java.util.ArrayList;

import po.LogPO;
import vo.LogVO;

public interface LogService {
       public ArrayList<LogVO> logmessage(String office,String time);
}
