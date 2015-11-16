package mockreportmessage;

import reportsl.ReportMessage;

public class MockReportMessage extends ReportMessage{
	long income;
	long pay;
	long profit;
	
	public MockReportMessage(long a, long b, long c) {
		super(a, b, c);
		this.income=a;
		this.pay=b;
		this.profit=c;
	}
}
