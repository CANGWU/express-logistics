package slstub;

import stockslservice.StockInfoService;
import vo.StockInfoVO;

public class StockInfoSLStub implements StockInfoService {

	@Override
	public void startShow() {
		// TODO Auto-generated method stub
		System.out.print("Started!");
		
	}

	@Override
	public StockInfoVO show(String[] time) {
		// TODO Auto-generated method stub
		return new StockInfoVO(100,60,5000,2000,3000);
	}

	@Override
	public void endShow() {
		// TODO Auto-generated method stub
		System.out.print("Ended!");
	}

	@Override
	public void startInitialize() {
		// TODO Auto-generated method stub
		System.out.print("Started!");
	}

	@Override
	public void cancelInitialize() {
		// TODO Auto-generated method stub
		System.out.print("canceled!");
	}

	@Override
	public ResultMessage initialize(String initialinfo) {
		// TODO Auto-generated method stub
		return ResultMessage.True;
	}

	@Override
	public ResultMessage check() {
		// TODO Auto-generated method stub
		return ResultMessage.True;
	}



}
