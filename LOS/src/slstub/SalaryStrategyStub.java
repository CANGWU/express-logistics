package slstub;

import java.util.ArrayList;

import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategyStub implements SalaryStrategyService{

	@Override
	public ArrayList<SalaryVO> getSalaryStrategy() {
		// TODO Auto-generated method stub
		ArrayList<SalaryVO>salarys  = new ArrayList<SalaryVO>();
		salarys.add(new SalaryVO(3500,500,10));
		return salarys;

	}

	@Override
	public void newSalaryVO() {
		// TODO Auto-generated method stub
		System.out.println("正在新建！！�?");
	}

	@Override
	public void save(SalaryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新的薪水策略保存成功！！�?");
	}
	
	public void endSalaryStrategy(){
		System.out.println("数据保存成功，正在结束制定薪水策略！！！");
	}

	@Override
	public void update(SalaryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("update succeed!!!");
	}

}
