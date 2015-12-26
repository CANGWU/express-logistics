package strategyslservice;

import enums.ResultMessage;
import vo.ConstantVO;

public interface ConstantService {
	public ConstantVO getConstant();
	public void newConstant();
	public ResultMessage save(ConstantVO vo);
	public void endConstant();
}
