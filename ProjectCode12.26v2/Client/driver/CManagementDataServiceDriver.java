package driver;


import dataservice.CManagementDataService;
import po.CarPO;

public class CManagementDataServiceDriver {
	public void driver(CManagementDataService cm){
		cm.init();
		cm.insert(new CarPO("020001001","020001","2323u12u43u",10));
		CarPO po = cm.find("2323u12u43u");
		if(po.getIDNumber().equals("020001001")) System.out.println("insert and find succeed!!!");
		else System.out.println("insert and find failed!!!");
		cm.update(new CarPO("020001001","020001","2323u12u43u",9));
		po = cm.find("2323u12u43u");
		if(po.getWorkYear()==9)System.out.println("update succeed!!!");
		else System.out.println("update failed!!!");
		cm.delect("2323u12u43u");
		if(cm.find("2323u12u43u")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed");
		cm.finish();

}
}
