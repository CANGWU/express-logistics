package auditslservice;

import java.util.ArrayList;

import vo.PaymentVO;
import vo.TransportVO;

public interface AuditInfo {
	
	public ArrayList<TransportVO> getTransport();
	public ArrayList<PaymentVO> getPayment();

}
