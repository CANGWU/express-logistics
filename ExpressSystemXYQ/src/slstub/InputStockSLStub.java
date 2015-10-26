package slstub;

import vo.InMessageVO;
import ioputslservice.InputStockSLService;

public class InputStockSLStub implements InputStockSLService {

	@Override
	public InMessageVO showInfo(String id) {
		// TODO Auto-generated method stub
		if(id .equals( "1234567890"))
			return new InMessageVO(id,"2015/10/26","…œ∫£");
		else return null;
	}

	@Override
	public ResultMessage position(String position) {
		// TODO Auto-generated method stub
		return ResultMessage.True;
	}

}
