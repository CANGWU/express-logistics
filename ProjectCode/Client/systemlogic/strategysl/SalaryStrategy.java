package strategysl;

import java.util.ArrayList;

import po.SalaryPO;
import dataservice.DataFactoryService;
import dataservice.SalaryStrategyDataService;
import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategy {
	DataFactoryService datafactory;
	SalaryStrategyDataService salarystrategyData;
	
	public SalaryStrategy(DataFactoryService datafactory){
		this.datafactory=datafactory;
		salarystrategyData=datafactory.getSalaryStrategyData();
	}
	
	public ArrayList<SalaryVO> getSalaryStrategy() {
		ArrayList<SalaryPO> salarypolist=salarystrategyData.findAll();
		ArrayList<SalaryVO> salaryvolist=new ArrayList<SalaryVO>();
		SalaryVO vo;
		SalaryPO po;
		for(int i=0;i<salarypolist.size();i++){
			po=salarypolist.get(i);
			vo=new SalaryVO(po.getBaseWage(),po.getAllowance(),po.getCommission());
			salaryvolist.add(vo);
		}
		return salaryvolist;
	}

	public void endSalaryStrategy() {
		salarystrategyData.finish();
	}

	public void save(SalaryVO vo) {
		SalaryPO po=new SalaryPO(vo.getBaseWage(),vo.getAllowance(),vo.getCommission());
		salarystrategyData.insert(po);
	}

	public void saveChange(SalaryVO vo) {

	}

	public void newSalaryVO() {

	}

	public SalaryVO select(String id) {

		return null;
	}

	public void revise() {

		
	}
}
