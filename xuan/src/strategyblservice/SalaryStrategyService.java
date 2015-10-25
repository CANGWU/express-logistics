package strategyblservice;
import java.util.ArrayList;

import po.SalaryPO;
import vo.SalaryVO;

public interface SalaryStrategyService {
	
	public ArrayList<SalaryVO> getSalaryStrategy();
    public void endSalaryStrategy();
    public void save(SalaryVO vo);
    public void update(SalaryVO vo);
	public void newSalaryVO(); 
}
