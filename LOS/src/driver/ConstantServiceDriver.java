package driver;

import strategyslservice.ConstantService;
import vo.ConstantVO;

public class ConstantServiceDriver {
	public void driver(ConstantService cs){
		cs.save(new ConstantVO(3423,342,4234,324,3432,343,30,5,10,15,5,3,10,10,5,1));
		ConstantVO vo = cs.getConstant();
		if(vo.getCostOfAir()==15) System.out.println("save and getConstant succeed!!!");
		else System.out.println("save and getConstant failde");
		cs.endConstant();;
	}

}
