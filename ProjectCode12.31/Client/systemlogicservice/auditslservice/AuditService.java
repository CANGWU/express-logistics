package auditslservice;

import java.util.ArrayList;

import enums.ResultMessage;
import vo.DeliverVO;
import vo.IoputVO;
import vo.OrderVO;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.TransportVO;




public interface AuditService {
//	public ArrayList<DocumentVO> Initialize(String id);
//	public void saveChange(DocumentVO vo);
	public ArrayList<TransportVO> getTransport();
	public ArrayList<DeliverVO> getDeliver();
	public ArrayList<PaymentVO> getPayment();
	public ArrayList<ReceiptsVO> getReceipts();
	public ArrayList<OrderVO> getOrder();
//	public ResultMessage saveTransport();
//	public ResultMessage saveDeliver();
//	public ResultMessage savePayment();
//	public ResultMessage saveOutput();
//	public ResultMessage saveInput();
//	public ResultMessage saveOrder();
//	public ArrayList<IoputVO> getOutput();
//	public ArrayList<IoputVO> getInput();
	public ResultMessage saveReceipts();
	public ResultMessage saveAll();
	
	
	
}
