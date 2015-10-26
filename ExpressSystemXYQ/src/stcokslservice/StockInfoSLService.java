package stcokslservice;

import slstub.ResultMessage;
import vo.StockInfoVO;

public interface StockInfoSLService {
	
	public void startShow ();
	public  StockInfoVO show (String[] time);
	public void endShow();
	public void startInitialize ();
	public void cancelInitialize();
	public ResultMessage initialize(String initialinfo);
	public ResultMessage check();



}
