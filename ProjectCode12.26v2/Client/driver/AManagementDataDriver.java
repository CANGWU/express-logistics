package driver;

import java.util.ArrayList;



import dataservice.AManagementDataService;
import po.AgencyPO;
import po.StaffPO;

public class AManagementDataDriver {
	public void driver(AManagementDataService aManagementData){
		aManagementData.init();
		aManagementData.insert(new AgencyPO("榧撴ゼ钀ヤ笟鍘�","020001",new ArrayList<StaffPO>(), 
				"1371372278","鍗椾含榧撴ゼ鍖簒x澶ч亾63鍙�",new StaffPO()));
		AgencyPO agencyPo = aManagementData.find("020001");
		if(agencyPo.getName().equals("榧撴ゼ钀ヤ笟鍘�"))
			System.out.println("insert and find succeed!!!");
		else System.out.println("insert and find failed!!!");
		aManagementData.update(new AgencyPO("鏍栭湠钀ヤ笟鍘�","020001",new ArrayList<StaffPO>(), 
				"1371372278","鍗椾含榧撴ゼ鍖簒x澶ч亾63鍙�",new StaffPO()));
		agencyPo = aManagementData.find("020001");
		if(agencyPo.getName().equals("钀ヤ笟鍘�"))
			System.out.println("update succeed!!!");
		else System.out.println("update failed!!!");
		aManagementData.delect("020001");
		if(aManagementData.find("020001")!=null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		aManagementData.finish();
	}
	

}
