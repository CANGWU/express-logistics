package reportsl;

import vo.ReportVO;

public class Report {
	ReportVO reportvo;
	ReportList reportlist;
	
	public void inquire() {
		reportvo=new ReportVO(null, 0, 0, 0, null, null);
	}

	public ReportVO addMessage(String id, String beginTime, String endTime) {
		reportvo.setID(id);
		reportvo.setBeginTime(beginTime);
		reportvo.setEndTime(endTime);
		reportlist=new ReportList(id, beginTime, endTime);
		reportvo.setIncome(reportlist.getIncome());
		reportvo.setPay(reportlist.getPay());
		reportvo.setProfit(reportlist.getProfit());
		return reportvo;
	}

	public void exportReport(ReportVO reportvo) {

	}

	public void printReport(ReportVO reportvo) {

	}

	public void endReport() {

	}

}
