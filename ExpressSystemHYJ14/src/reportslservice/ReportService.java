package reportslservice;

import vo.ReportVO;

public interface ReportService {
	//统计报表的过程
	public void inquire();
	public ReportVO addMessage(String id,String beginTime,String endTime);
	public void exportReport(ReportVO reportvo);
	public void printReport(ReportVO reportvo);
	public void endReport();
}
