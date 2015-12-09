package slstub;

import reportslservice.ReportService;
import vo.ReportVO;

public class ReportService_Stub implements ReportService{
	String id="000025002";
	String beginTime="2015/10/25";
	String endTime="2015/10/26";
	long income=5000;
	long pay=4000;
	long profit=1000;

	@Override
	public void inquire() {
		// TODO Auto-generated method stub
		System.out.println("Start the report");
	}

	@Override
	public ReportVO addMessage(String id, String beginTime, String endTime) {
		// TODO Auto-generated method stub
		return new ReportVO(id, this.income, this.pay, this.profit, beginTime, endTime);
	}

	@Override
	public void exportReport(ReportVO reportvo) {
		// TODO Auto-generated method stub
		System.out.println("Export the report!");
	}

	@Override
	public void printReport(ReportVO reportvo) {
		// TODO Auto-generated method stub
		System.out.println("Print the report!");
	}

	@Override
	public void endReport() {
		// TODO Auto-generated method stub
		System.out.println("End the report!");
	}

}
