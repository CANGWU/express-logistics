package driver;


import pamanagementslservice.DManagementService;
import po.DriverPO;
import vo.DriverVO;

public class DManagementServiceDriver {
	public void driver(DManagementService dm){
	dm.save(new DriverVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
			"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10));
	DriverVO vo = dm.select("020001003");
	if(vo.getAddress().equals("南京市栖霞区仙林大道162号")) System.out.println("select and save succeed!!!");
	else System.out.println("find and insert failed");
	dm.saveChange(new DriverVO("李四", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
			"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10));
	vo = dm.select("020001003");
	if(vo.getName().equals("李四")) System.out.println("saveChange succeed!!!");
	else System.out.println("update failed");
	dm.delect("020001003");
	if(dm.select("020001003")==null) System.out.println("delect succeed!!!");
	else System.out.println("delect failed!!!");
	dm.endDManagement();
	
}


}
