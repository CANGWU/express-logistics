package strategysl;

import po.ConstantPO;
import dataservice.ConstantDataService;
import dataservice.DataFactoryService;
import vo.ConstantVO;

public class Constant {
	DataFactoryService datafactory;
	ConstantDataService constantData;

	public Constant(DataFactoryService datafactory) {
		this.datafactory = datafactory;
		this.constantData = datafactory.getConstantData();
	}

	public ConstantVO getConstant() {
		ConstantPO po = constantData.find();
		ConstantVO vo = new ConstantVO(po.getLengthOfBN(), po.getLengthOfBS(),
				po.getLengthOfBG(), po.getLengthOfSG(), po.getLengthOfSN(),
				po.getLengthOfGN(), po.getLengthOfHall(),
				po.getPriceOfCheapest(), po.getPriceOfStandard(),
				po.getPriceOfExpress(), po.getCostOfCar(), po.getCostOfTrain(),
				po.getCostOfAir(), po.getPriceOfCarton(), po.getPriceOfWood(),
				po.getPriceOfBag());
		return vo;
	}

	public void newConstant() {
 
	}

	public void save(ConstantVO vo) {
		ConstantPO po = new ConstantPO(vo.getLengthOfBN(), vo.getLengthOfBS(),
				vo.getLengthOfBG(), vo.getLengthOfSG(), vo.getLengthOfSN(),
				vo.getLengthOfGN(), vo.getLengthOfHall(),
				vo.getPriceOfCheapest(), vo.getPriceOfStandard(),
				vo.getPriceOfExpress(), vo.getCostOfCar(), vo.getCostOfTrain(),
				vo.getCostOfAir(), vo.getPriceOfCarton(), vo.getPriceOfWood(),
				vo.getPriceOfBag());
		constantData.insert(po);
	}

	public void endConstant() {
		constantData.finish();
	}
}
