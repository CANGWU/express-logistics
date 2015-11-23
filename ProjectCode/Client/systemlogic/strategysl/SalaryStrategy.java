package strategysl;

import java.util.ArrayList;

import po.SalaryPO;
import dataservice.DataFactoryService;
import dataservice.SalaryStrategyDataService;
import enums.Work;
import strategyslservice.GetSalary;
import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategy implements GetSalary {
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
			vo=new SalaryVO(po.getBaseWage(),po.getAllowance(),po.getCommission(),po.getWork());
			salaryvolist.add(vo);
		}
		return salaryvolist;
	}

	public void endSalaryStrategy() {
		salarystrategyData.finish();
	}

	public void save(SalaryVO vo) {
		SalaryPO po=new SalaryPO(vo.getBaseWage(),vo.getAllowance(),vo.getCommission(),vo.getWork());
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

	@Override
	public SalaryPO getSingleSalaryStrategy(Work work) {
		// TODO Auto-generated method stub
		SalaryPO po=salarystrategyData.find(work);
		return po;
	}
}
