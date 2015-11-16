package strategyslservice;
import java.util.ArrayList;

import vo.SalaryVO;

public interface SalaryStrategyService {
	
	public ArrayList<SalaryVO> getSalaryStrategy();
        public void endSalaryStrategy();
        public void save(SalaryVO vo);
        public void saveChange(SalaryVO vo);
        public void update(SalaryVO vo);
	    public void newSalaryVO(); 
        public SalaryVO select(String id);
        public void revise();
     
    
}
