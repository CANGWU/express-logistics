package driver;

import dataservice.PManagementDataService;
import po.StaffPO;

public class PManagementDataServiceDriver {
	public void driver(PManagementDataService pm){
		pm.init();
		pm.insert(new StaffPO("寮犱笁", "鍙告満", "020001003", "020001", 
				"1980/2/2", "23712314843724", "137137223728", "鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�", "鐢�", 4000));
		StaffPO po  = pm.find("020001003");
		if(po.getAddress().equals("鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�")) System.out.println("insert and find succeed!!!!");
		else System.out.println("insert and find failed!!!");
		pm.update(new StaffPO("寮犱笁", "鍙告満", "020001003", "020001", 
				"1980/2/2", "23712314843724", "137137223728", "鍗椾含甯傛爾闇炲尯浠欐灄澶ч亾162鍙�", "濂�", 4000));
		po = pm.find("020001003");
		if(po.getSex().equals("濂�")) System.out.println("update succeed!!!");
		else System.out.println("update failed!!!");
		pm.delect("0200010003");
		if(pm.find("020001003")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		pm.finish();
	}

}
