package checksl;

import vo.LogisticsVO;
import checkslservice.CheckService;
import dataserviceimpl.DataFactory;

public class CheckController implements CheckService{
    Check check;
    
    public CheckController(DataFactory datafactory){
    	check=Check.creatCheck(datafactory);
    }
    
	@Override
	public LogisticsVO orderNumberCheck(String ordernumber) {
		// TODO Auto-generated method stub

		return check.orderNumberCheck(ordernumber);
	}

}
