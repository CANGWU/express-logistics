package stocksl;
import ioputsl.IoputCalculation;
import dataservice.DataFactoryService;
import enums.ResultMessage;
import enums.WarningMessage;
import stockslservice.StockService;
import vo.AreaVO;
import vo.StockInfoVO;
import vo.StockInitializeVO;

public class StockController implements StockService {
	
	private StockAdjust Adjust = null;
	private DataFactoryService Data;
	private StockInfo Info;
	private StockChange Change;
	
	public StockController(DataFactoryService d,StockChange change,IoputCalculation io){
		Info = new StockInfo(d,change,io);
		Data = d;
		Change = change;
		
	}

	@Override
	public AreaVO[] getAreas() {
		// TODO Auto-generated method stub
		return Adjust.getAreas();
	}

	@Override
	public AreaVO selectArea(String name) {
		// TODO Auto-generated method stub
		return Adjust.selectArea(name);
	}

	@Override
	public WarningMessage range(String adjustrange) {
		// TODO Auto-generated method stub
		return Adjust.range(adjustrange);
	}

	@Override
	public StockInfoVO show(String[] time) {
		// TODO Auto-generated method stub
		return Info.show(time);
	}

	@Override
	public ResultMessage initialize(StockInitializeVO vo) {
		// TODO Auto-generated method stub
		Adjust = new StockAdjust(Data,vo.getRowall()*vo.getSeat()*vo.getSeat(),vo.getRowall(),vo.getShelf(),vo.getSeat(),Change);
		return Info.initialize(vo);
	}

	@Override
	public ResultMessage check() {
		// TODO Auto-generated method stub
		return null;
	}

}
