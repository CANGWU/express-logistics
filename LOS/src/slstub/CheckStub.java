package slstub;

import vo.*;
import checkslservice.CheckService;

public class CheckStub implements CheckService {

	@Override
	public LogisticsVO orderNumberCheck(String ordernumber) {
		// TODO Auto-generated method stub
		LogisticsVO ordermessage=new LogisticsVO("0000000001");
		
		return ordermessage;
	}

}
