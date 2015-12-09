package driver;

import dataservice.ConstantDataService;
import po.ConstantPO;


public class ConstantDataServiceDriver {
	public void driver(ConstantDataService cd){
		cd.init();
		cd.insert (new ConstantPO(3423,342,4234,324,3432,343,30,5,10,15,5,3,10,10,5,1));
		ConstantPO po = cd.find();
		if(po.getCostOfAir()==15) System.out.println("insert and find succeed!!!");
		else System.out.println("insert and succeed failde");
		cd.update(new ConstantPO(3423,342,4234,324,3432,343,30,5,10,15,5,3,10,10,5,1));
		po = cd.find();
		if(po.getPriceOfBag()==1) System.out.println("update succeed!!!");
		cd.finish();
	}

}
