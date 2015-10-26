package driver;

import dataservice.DManagementDataService;
import po.DriverPO;

public class DManagementDataServiceDriver {
	public void driver(DManagementDataService dm){
		dm.init();
		dm.insert(new DriverPO("寮犱笁", "鍙告満", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�", "鐢�", 4000, 10));
		DriverPO po = dm.find("020001003");
		if(po.getAddress().equals("鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�")) System.out.println("find and insert succeed!!!");
		else System.out.println("find and insert failed");
		dm.update(new DriverPO("鏉庡洓", "鍙告満", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�", "鐢�", 4000, 10));
		po = dm.find("020001003");
		if(po.getName().equals("鏉庡洓")) System.out.println("update succeed!!!");
		else System.out.println("update failed");
		dm.delect("020001003");
		if(dm.find("020001003")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		dm.finish();
		
	}

}
