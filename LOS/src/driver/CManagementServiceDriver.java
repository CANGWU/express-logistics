package driver;

import pamanagementslservice.CManagementService;
import vo.CarVO;

public class CManagementServiceDriver {
	public void driver(CManagementService cm){
		cm.save(new CarVO("020001001","020001","2323u12u43u",10));
		CarVO vo = cm.select("2323u12u43u");
		if(vo.getIDNumber().equals("020001001")) System.out.println("save and select succeed!!!");
		else System.out.println("save and select failed!!!");
		cm.saveChange(new CarVO("020001001","020001","2323u12u43u",9));
		vo = cm.select("2323u12u43u");
		if(vo.getWorkYear()==9)System.out.println("saveChange succeed!!!");
		else System.out.println("update failed!!!");
		cm.delect("2323u12u43u");
		if(cm.select("2323u12u43u")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed");
		cm.endCManagement();
		
	}

}
