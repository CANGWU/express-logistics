package Junit_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import auditsl.Decument;
import auditsl.DecumentList;
import mockaudit.MockAuditInfo;
import vo.PaymentVO;
import vo.TransportVO;

public class DecumentListTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		MockAuditInfo auditInfo = new MockAuditInfo(new TransportVO(null, null, null, null, null, null, 0, null, null, null), new PaymentVO(null, null));
		ArrayList<TransportVO> transports = new ArrayList<TransportVO>();
		ArrayList<PaymentVO> payments = new ArrayList<PaymentVO>();
		transports.add(auditInfo.getTransportVO());
		payments.add(auditInfo.getPaymentVO());
		Decument decument1 = new Decument(transports);
		Decument decument2 = new Decument(payments);
		DecumentList decumentList = new DecumentList();
		decumentList.addDecument(decument1);
		decumentList.addDecument(decument2);
		assertEquals(null,decumentList.getDecument(null));
	}

}
