package strategysl;

import java.util.ArrayList;

import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategyController implements SalaryStrategyService{
	
	SalaryStrategy salarystrategy;

	public SalaryStrategyController(SalaryStrategy salarystrategy){
		this.salarystrategy=salarystrategy;
	}
	
	@Override
	public ArrayList<SalaryVO> getSalaryStrategy() {
		return salarystrategy.getSalaryStrategy();
	}

	@Override
	public void endSalaryStrategy() {
		salarystrategy.endSalaryStrategy();
	}

	@Override
	public void save(SalaryVO vo) {
		salarystrategy.save(vo);
	}

	@Override
	public void saveChange(SalaryVO vo) {
		salarystrategy.saveChange(vo);
	}

	@Override
	public void newSalaryVO() {
		salarystrategy.newSalaryVO();
	}

	@Override
	public SalaryVO select(String id) {
		return salarystrategy.select(id);
	}

	@Override
	public void revise() {
		salarystrategy.revise();
	}

}
