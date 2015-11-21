package stockslservice;

import slstub.ResultMessage;
import vo.AreaVO;
import vo.StockInfoVO;
import vo.StockInitializeVO;

public interface StockService {

	public AreaVO[] getAreas();
	public AreaVO selectArea(String name);
	public ResultMessage range(String adjustrange);
	
	public  StockInfoVO show (String[] time);
	public ResultMessage initialize(StockInitializeVO vo);
	public ResultMessage check();




}
