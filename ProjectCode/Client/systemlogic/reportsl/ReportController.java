package reportsl;

import reportslservice.ReportService;
import vo.ReportVO;

public class ReportController implements ReportService {
	Report report = new Report();

	@Override
	public void inquire() {
		report.inquire();
	}

	@Override
	public ReportVO addMessage(String id, String beginTime, String endTime) {
		return report.addMessage(id, beginTime, endTime);
	}

	@Override
	public void exportReport(ReportVO reportvo) {
		report.exportReport(reportvo);
	}

	@Override
	public void printReport(ReportVO reportvo) {
		report.printReport(reportvo);
	}

	@Override
	public void endReport() {
		report.endReport();
	}

}
