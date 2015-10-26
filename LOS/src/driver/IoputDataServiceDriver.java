package driver;

import po.IoputPO;
import dataservice.IoputDataService;

public class IoputDataServiceDriver {
	
	IoputPO po = new IoputPO("1234567890","2015/10/25","14:45:00","±±¾©","(4,5,6)",true);
	
	public void drive(IoputDataService IoputDataService){
		if(IoputDataService.find("1234567890")!=null)
			System.out.print("Ioput data found by id!");
		
		String[] ids = {"1234567890","0123456789"};
		String[] dates = {"2015/10/25","2015/10/26"};
		String[] time = {"2015/10/25,00:00:00","2015/10/26,23:59:59"};
		
		if(IoputDataService.finds(ids)!=null)
			System.out.print("Ioput data found by ids!");
		if(IoputDataService.findDate("2015/10/26")!=null)
			System.out.print("Ioput data found by date!");
		if(IoputDataService.findDates(dates)!=null)
			System.out.print("Ioput data found by dates!");
		if(IoputDataService.findTimes(time)!=null)
			System.out.print("Ioput data found by time!");
		
		IoputDataService.insert(po);
		IoputDataService.delete(po);
		IoputDataService.update(po);
		
		
	}

}
