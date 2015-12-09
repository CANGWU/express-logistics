package mockaudit;

import vo.PaymentVO;
import vo.TransportVO;

import java.util.ArrayList;

import auditslservice.AuditInfo;

public class MockAuditInfo implements AuditInfo{
	TransportVO transport;
	PaymentVO payment;
	
	
	public MockAuditInfo(TransportVO transport, PaymentVO payment){
		this.transport = transport;
		this.payment = payment;
				
	}
	
	
	public TransportVO getTransportVO(){
		return transport;
	}
	
	public PaymentVO getPaymentVO(){
		return payment;
	}


	@Override
	public ArrayList<TransportVO> getTransport() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<PaymentVO> getPayment() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
