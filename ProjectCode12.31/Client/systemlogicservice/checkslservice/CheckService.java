package checkslservice;

import enums.ResultMessage;
import vo.*;

public interface CheckService {
    
	public LogisticsVO orderNumberCheck(String ordernumber);
	public ResultMessage add(LogisticsVO vo);
	public ResultMessage update(LogisticsVO vo);
	
	

	
}
