package strategyslservice;

import enums.Work;
import po.SalaryPO;

public interface GetSalary {
	public SalaryPO getSingleSalaryStrategy(Work work);

}
