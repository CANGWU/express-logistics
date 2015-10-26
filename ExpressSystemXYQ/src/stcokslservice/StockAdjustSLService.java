package stcokslservice;

import slstub.ResultMessage;
import vo.AreaVO;

public interface StockAdjustSLService {

	public AreaVO[] getAreas();
	public AreaVO selectArea(String name);
	public ResultMessage range(String adjustrange);


}
