package strategyblservice;

import po.ConstantPO;
import vo.ConstantVO;

public interface ConstantService {
	public ConstantVO getConstant();
	public void newConstant();
	public void save(ConstantVO vo);
	public void endConstant();
}
