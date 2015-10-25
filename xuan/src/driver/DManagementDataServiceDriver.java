package driver;

import pamanagementdataservice.DManagementDataService;
import po.DriverPO;

public class DManagementDataServiceDriver {
	public void driver(DManagementDataService dm){
		dm.init();
		dm.insert(new DriverPO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10));
		DriverPO po = dm.find("020001003");
		if(po.getAddress().equals("南京市栖霞区仙林大道162号")) System.out.println("find and insert succeed!!!");
		else System.out.println("find and insert failed");
		dm.update(new DriverPO("李四", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10));
		po = dm.find("020001003");
		if(po.getName().equals("李四")) System.out.println("update succeed!!!");
		else System.out.println("update failed");
		dm.delect("020001003");
		if(dm.find("020001003")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		dm.finish();
		
	}

}
