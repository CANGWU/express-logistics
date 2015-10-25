package driver;

import java.util.ArrayList;

import pamanagementslservice.AManagementService;
import vo.AgencyVO;
import vo.StaffVO;

public class AManagementServiceDriver {
	public void driver(AManagementService aManagementService){
		aManagementService.save(new AgencyVO("鼓楼营业厅","020001",new ArrayList<StaffVO>(), "1371372278","南京鼓楼区xx大道63号",new StaffVO()));
		AgencyVO agency = aManagementService.select("020001");
		if(agency.getName().equals("鼓楼营业厅"))System.out.println("save and select succeed!!!");
		else System.out.println("save and select failed");
		aManagementService.saveChange(new AgencyVO("仙林营业厅","020001",new ArrayList<StaffVO>(), "1371372278","南京鼓楼区xx大道63号",new StaffVO()));
		agency = aManagementService.select("020001");
		if(agency.getName().equals("仙林营业厅")) System.out.println("saveChange succeed!!!");
		aManagementService.delect("020001");
		if(aManagementService.select("0200001")==null)System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		aManagementService.endAManagement();
	}

}
