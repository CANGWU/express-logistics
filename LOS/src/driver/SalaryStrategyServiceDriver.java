package driver;

import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategyServiceDriver {
	public void driver(SalaryStrategyService ss){
		ss.save(new SalaryVO(3500,500,10));
		SalaryVO vo = ss.getSalaryStrategy().get(0);
		if(vo.getBaseWage()==3500)System.out.println("save and getSalaryStrategy succeed!!!");
		else System.out.println("save and getSalaryStrategy failed!!!");
		ss.endSalaryStrategy();

}
}
