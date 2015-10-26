package sldriver;

import slstub.ResultMessage;
import stcokslservice.StockAdjustSLService;
import vo.AreaVO;

public class StockAdjustSLServiceDriver {
	
	public void drive(StockAdjustSLService StockAdjustSLService){
		AreaVO[] vos = StockAdjustSLService.getAreas();
		if(vos!=null)
			System.out.print("Area info got");
		AreaVO vo = StockAdjustSLService.selectArea("º½ÔËÇø");
		if(vo!=null)
			System.out.print("Area selected");
		
		ResultMessage result ;
		result = StockAdjustSLService.range("(0,1,1)-(10,10,10)");
		if(result == ResultMessage.True)
			System.out.print("Stock adjust succeed!");
	}

}
