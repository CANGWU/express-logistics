package audittest;

import java.util.ArrayList;

import auditsl.Decument;
import auditsl.DecumentList;
import mockaudit.MockAuditInfo;
import vo.PaymentVO;
import vo.TransportVO;

public class AuditTest {
	public void  test(){
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
		
		
		
	}
	

}
