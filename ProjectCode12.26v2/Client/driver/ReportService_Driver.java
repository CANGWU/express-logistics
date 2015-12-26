package driver;

import reportslservice.ReportService;
import vo.ReportVO;

public class ReportService_Driver {
	public void drive(ReportService reportservice){
		reportservice.inquire();
		ReportVO reportvo=reportservice.addMessage("025000666", "2015/06/06","2015/08/08");
		System.out.println("income:"+reportvo.getProfit());
		reportservice.exportReport(reportvo);
		reportservice.printReport(reportvo);
		reportservice.endReport();
	}
}
