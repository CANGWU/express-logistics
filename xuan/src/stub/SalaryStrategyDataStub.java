package stub;

import java.util.ArrayList;

import po.SalaryPO;
import strategydataservice.SalaryStrategyDataService;

public class SalaryStrategyDataStub implements SalaryStrategyDataService{

	@Override
	public ArrayList<SalaryPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<SalaryPO>salarys = new ArrayList<SalaryPO>();
		salarys.add(new SalaryPO(3500,500,10));
		return salarys;
	}

	@Override
	public void insert(SalaryPO po) {
		// TODO Auto-generated method stub
		System.out.println("薪水策略插入成功！！！");
	}

	@Override
	public void delect(SalaryPO po) {
		// TODO Auto-generated method stub
	 System.out.println("薪水策略删除成功！！！");	
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("薪水策略删除成功！！！");	
	}

	@Override
	public void delect(ArrayList<SalaryPO> salarys) {
		// TODO Auto-generated method stub
		System.out.println("薪水策略删除成功！！！");	
	}

	@Override
	public void update(SalaryPO po) {
		// TODO Auto-generated method stub
		System.out.println("薪水策略更新成功！！！");	
	}

	@Override
	public void update(ArrayList<SalaryPO> salarys) {
		// TODO Auto-generated method stub
		System.out.println("薪水策略更新成功！！！");	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("数据初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("数据持久化成功，正在结束制定薪水策略！！！");
	}

}
