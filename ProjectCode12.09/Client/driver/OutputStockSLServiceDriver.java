package driver;

import ioputslservice.OutputStockService;
import slstub.ResultMessage;
import vo.OutMessageVO;

public class OutputStockSLServiceDriver {
	public void drive(OutputStockService OutputStockSLService){
		OutMessageVO vo = OutputStockSLService.showInfo("1234567890");
		if(vo!=null)
			System.out.print("Info shows & update succeed");
		if(OutputStockSLService.report("0123456789")==ResultMessage.True)
			System.out.print("Report succeed!");
	}

}
