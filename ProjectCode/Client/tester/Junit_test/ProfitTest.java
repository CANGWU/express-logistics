package Junit_test;

import static org.junit.Assert.*;
import mockreportmessage.MockReportMessage;

import org.junit.Test;

import reportsl.ReportList;

public class ProfitTest {
	@Test
	public void test(){
		ReportList reportlist=new ReportList("hyj14","141250047","141250047");
		MockReportMessage reportmessage1 = new MockReportMessage(300,200,100);
		MockReportMessage reportmessage2 = new MockReportMessage(400,200,200);
		reportlist.add(reportmessage1);
		reportlist.add(reportmessage2);
		assertEquals(reportlist.getProfit(),300);
	}
}
