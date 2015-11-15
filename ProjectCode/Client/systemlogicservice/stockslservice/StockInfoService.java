package stockslservice;

import slstub.ResultMessage;
import vo.StockInfoVO;

public interface StockInfoService {
	
	public void startShow ();
	public  StockInfoVO show (String[] time);
	public void endShow();
	public void startInitialize ();
	public void cancelInitialize();
	public ResultMessage initialize(String initialinfo);
	public ResultMessage check();



}
