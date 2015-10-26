package driver;

import dataservice.SalaryStrategyDataService;
import po.SalaryPO;

public class SalaryStrategyDataServiceDriver {
	public void driver(SalaryStrategyDataService ss){
		ss.init();
		ss.insert(new SalaryPO(3500,500,10));
		SalaryPO po = ss.findAll().get(0);
		if(po.getBaseWage()==3500)System.out.println("insert and get succeed!!!");
		else System.out.println("insert and get failed!!!");
		ss.update(new SalaryPO(1500,500,10));
		po = ss.findAll().get(0);
		if(po.getBaseWage()==1500) System.out.println("update succeed!!!");
		else System.out.println("update failed!!!");
		ss.delect(new SalaryPO(1500,500,10));
		if(ss.findAll().get(0)==null)System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		ss.finish();
		
		
	}

}
