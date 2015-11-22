package strategysl;

import strategyslservice.ConstantService;
import vo.ConstantVO;

public class ConstantController implements ConstantService{
	Constant constant;
	public ConstantController(Constant constant){
		this.constant=constant;
	}
	
	@Override
	public ConstantVO getConstant() {
		return constant.getConstant();
	}

	@Override
	public void newConstant() {
		constant.newConstant();
	}

	@Override
	public void save(ConstantVO vo) {
		constant.save(vo);
	}

	@Override
	public void endConstant() {

		
	}

}
