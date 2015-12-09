package driver;

import pamanagementslservice.PManagementService;
import vo.StaffVO;

public class PManagementServiceDriver {
	public void driver(PManagementService pm){
		pm.save(new StaffVO("张三", "司机", "020001003", "020001", 
				"1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "男", 4000));
		StaffVO vo  = pm.select("020001003");
		if(vo.getAddress().equals("南京市栖霞区仙林大道162号")) System.out.println("save and select succeed!!!!");
		else System.out.println("insert and find failed!!!");
		pm.saveChange(new StaffVO("张三", "司机", "020001003", "020001", 
				"1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "女", 4000));
		vo = pm.select("020001003");
		if(vo.getSex().equals("女")) System.out.println("saveChange succeed!!!");
		else System.out.println("update failed!!!");
		pm.delect("0200010003");
		if(pm.select("020001003")==null) System.out.println("delect succeed!!!");
		else System.out.println("delect failed!!!");
		pm.endPManagement();
	}


}
