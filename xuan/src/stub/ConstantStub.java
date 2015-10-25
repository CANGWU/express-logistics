package stub;

import strategyblservice.ConstantService;
import vo.ConstantVO;

public class ConstantStub implements ConstantService{

	@Override
	public ConstantVO getConstant() {
		// TODO Auto-generated method stub
		return new ConstantVO(3423,342,4234,324,3432,343,30,5,10,15,5,3,10,10,5,1);
	}

	@Override
	public void newConstant() {
		// TODO Auto-generated method stub
		System.out.println("正在增加新的常量！！！");
		
	}

	@Override
	public void save(ConstantVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新的常量信息保存成功！！！");
	}
	
	public void endConstant(){
		System.out.println("数据已更新，正在结束制定产量！！！");
	}

}
