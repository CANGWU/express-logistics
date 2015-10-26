package sldriver;

import slstub.ResultMessage;
import vo.InMessageVO;
import ioputslservice.InputStockSLService;

public class InputStockSLServiceDriver {
	
	public void drive(InputStockSLService InputStockSLService){
		InMessageVO vo = InputStockSLService.showInfo("1234567890");
		if(vo!=null)
			System.out.print("Info shows");
		if(InputStockSLService.position("(50,50,50)")==ResultMessage.True)
			System.out.print("Position save succeed!");
	}

}
