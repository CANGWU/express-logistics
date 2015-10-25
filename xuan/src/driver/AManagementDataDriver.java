package driver;

import java.util.ArrayList;

import pamanagementdataservice.AManagementDataService;
import po.AgencyPO;
import po.StaffPO;

public class AManagementDataDriver {
	public void driver(AManagementDataService aManagementData){
		aManagementData.init();
		aManagementData.insert(new AgencyPO("鼓楼营业厅","020001",new ArrayList<StaffPO>(), 
				"1371372278","南京鼓楼区xx大道63号",new StaffPO()));
		AgencyPO agencyPo = aManagementData.find("020001");
		if(agencyPo.getName().equals("鼓楼营业厅"))
			System.out.println("insert and find succeed!!!");
		else System.out.println("insert and find failed!!!");
		aManagementData.update(new AgencyPO("栖霞营业厅","020001",new ArrayList<StaffPO>(), 
				"1371372278","南京鼓楼区xx大道63号",new StaffPO()));
		agencyPo = aManagementData.find("020001");
		if(agencyPo.getName().equals("营业厅"))
			System.out.println("update succeed!!!");
		else System.out.println("update failed!!!");
		aManagementData.delect("020001");
		if(aManagementData.find("020001")!=null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		aManagementData.finish();
	}
	

}
