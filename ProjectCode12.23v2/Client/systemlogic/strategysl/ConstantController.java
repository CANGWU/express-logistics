package strategysl;

import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import strategyslservice.ConstantService;
import transportsl.ConstantInfo;
import vo.ConstantVO;

public class ConstantController implements ConstantService, ConstantInfo {
	Constant constant;

	public ConstantController() {
		this.constant = new Constant();
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
	public ResultMessage save(ConstantVO vo) {
		return constant.save(vo);
	}

	@Override
	public void endConstant() {
		constant.endConstant();
	}

	@Override
	public double getFare(Position departure, Position destination,
			Traffic trafficType) {
		return constant.getFare(departure, destination, trafficType);
	}

}
