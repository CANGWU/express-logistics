package checksl;

import vo.LogisticsVO;
import checkslservice.CheckService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;

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

	@Override
	public ResultMessage add(LogisticsVO vo) {
		// TODO Auto-generated method stub
		return check.add(vo);
	}

	@Override
	public ResultMessage update(LogisticsVO vo) {
		// TODO Auto-generated method stub
		return check.update(vo);
	}

}
