package auditsl;

import java.util.ArrayList;

import po.IoputPO;
import po.OrderPO;
import po.PaymentPO;
import po.SalaryPO;
import po.StaffPO;
import po.TransportPO;
import enums.DocumentType;
import vo.DocumentVO;
import vo.IoputVO;
import vo.OrderVO;
import vo.PaymentVO;
import vo.StaffVO;
import vo.TransportVO;

public class Audit {
	
	private AuditInfo Send,Transport,Receive,Finance,InputStock,OutputStock;
	
	private ArrayList<OrderPO> Order;
	private ArrayList<TransportPO> Trans;
	private ArrayList<PaymentPO> Payment;
	private ArrayList<IoputPO> Input,Output;
	
	
	public Audit(AuditInfo Send,AuditInfo Transport,AuditInfo Receive,AuditInfo Finance,AuditInfo InputStock,AuditInfo OutputStock){
		this.Send = Send;
		this.Transport = Transport;
		this.Receive = Receive;
		this.Finance = Finance;
		this.InputStock = InputStock;
		this.OutputStock = OutputStock;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<DocumentVO> Initialize(){
		
		int i;
		
		ArrayList<DocumentVO> DVO = new ArrayList<DocumentVO>();
		
		Order = (ArrayList<OrderPO>)Send.getAuditInfo();
		Trans = (ArrayList<TransportPO>)Transport.getAuditInfo();
		Payment = (ArrayList<PaymentPO>)Finance.getAuditInfo();
		Input = (ArrayList<IoputPO>)InputStock.getAuditInfo();
		Output = (ArrayList<IoputPO>)OutputStock.getAuditInfo();
		
		ArrayList<OrderVO> OrderVO = new ArrayList<OrderVO>();
		
		//Orders
		for(i = 0;i<Order.size();i++){
			OrderPO po = Order.get(i);
			OrderVO vo = new OrderVO(po.getTimeOfSend(),po.getNameOfCourier(),po.getSender().getName(),po.getSender().getAddress(),po.getSender().getWorkPlace(),po.getSender().getTelNumber(),po.getSender().getPhoneNumber(),po.getReceiver().getName(),po.getReceiver().getAddress(),po.getReceiver().getWorkPlace(),po.getReceiver().getTelNumber(),po.getReceiver().getPhoneNumber(),
					po.getGoods().getNumberOfGoods(),po.getGoods().getWeight(),po.getGoods().getVolume(),po.getGoods().getNameOfGoods(),po.getGoods().getSize(),po.getGoods().getExpressType(),po.getGoods().getPacking(),po.getdCondition());
			
			OrderVO.add(vo);
		}
		DVO.add(new DocumentVO(DocumentType.Order,OrderVO));
		
		
		//Trans
		ArrayList<TransportVO> TransportVO = new ArrayList<TransportVO>();
		for(i = 0;i<Trans.size();i++){
			TransportPO po = Trans.get(i);
			TransportVO vo = new TransportVO();
			TransportVO.add(vo);
		}
		DVO.add(new DocumentVO(DocumentType.Transport,TransportVO));
		
		
		//Payments
		ArrayList<PaymentVO> PaymentVO = new ArrayList<PaymentVO>();
		for(i = 0;i<Trans.size();i++){
				PaymentPO po = Payment.get(i);
				StaffPO spo = po.getReceiver();
				StaffVO svo = new StaffVO(spo.getName(),spo.getWork(),spo.getWorkNumber(),spo.getWorkPlaceNumber(),spo.getBirthDate(),spo.getIDNumber(),spo.getPhoneNumber(),spo.getAddress(),spo.getSex(),spo.getPage());
				PaymentVO vo = new PaymentVO(svo,po.getType());
				PaymentVO.add(vo);
			}
			DVO.add(new DocumentVO(DocumentType.Payment,PaymentVO));
			
		//Ioputs
		ArrayList<IoputVO> InputVO = new ArrayList<IoputVO>();
		for(i = 0;i<Input.size();i++){
			IoputPO po = Input.get(i);
			IoputVO vo = new IoputVO(po.getID(),po.getInputDate(),po.getTime(),po.getDestination(),po.getPositon(),po.getIoput(),po.getCondition(),po.getdCondition(),po.getNameOfWriter());
			InputVO.add(vo);
			}
		DVO.add(new DocumentVO(DocumentType.Ioput,InputVO));
		
		ArrayList<IoputVO> OutputVO = new ArrayList<IoputVO>();
		for(i = 0;i<Output.size();i++){
			IoputPO po = Output.get(i);
			IoputVO vo = new IoputVO(po.getID(),po.getOutputDate(),po.getTime(),po.getDestination(),po.getTransport(),po.getReceiptID(),po.getIoput(),po.getCondition(),po.getdCondition(),po.getNameOfWriter());
			OutputVO.add(vo);
			}
		DVO.add(new DocumentVO(DocumentType.Ioput,OutputVO));
		
		
		
		return DVO;
	}

	public void saveChange(DocumentVO vo) {
		// TODO Auto-generated method stub
		int i;
		
		switch (vo.getType()){
		case Order:{
			@SuppressWarnings("unchecked")
			ArrayList<OrderVO> OrderVO = (ArrayList<OrderVO>)vo.getList();
			Order = new ArrayList<OrderPO>();
			
			for(i = 0;i<OrderVO.size();i++){
				OrderVO Ordervo = OrderVO.get(i);
				OrderPO po = new OrderPO(Ordervo.getTimeOfSend(),Ordervo.getDueOfReceive(),Ordervo.getOrdernumber(),Ordervo.getNameOfCourier(),Ordervo.getSender(),Ordervo.getReceiver(),Ordervo.getBill(),Ordervo.getGoods(),Ordervo.getdCondition());
				
				Order.add(po);
			}
			Send.EndAudit(Order);
			
		}
		case Transport:{
			@SuppressWarnings("unchecked")
			ArrayList<TransportVO> TransportVO = (ArrayList<TransportVO>)vo.getList();
			Trans = new ArrayList<TransportPO>();
			
			for(i = 0;i<TransportVO.size();i++){
				TransportVO Transvo = TransportVO.get(i);
				TransportPO po = new TransportPO(Transvo.getSign(),Transvo.getID(),Transvo.getDeparture(),Transvo.getDestination(),Transvo.getTime(),Transvo.getTraffic(),Transvo.getfare(),Transvo.getMember(),Transvo.getOrder(),Transvo.getCondition(),Transvo.getdCondition(),Transvo.getNameOfWriter());
				
				Trans.add(po);
			}
			Transport.EndAudit(Trans);
			
		}
		case Payment:{
			@SuppressWarnings("unchecked")
			ArrayList<PaymentVO> PaymentVO = (ArrayList<PaymentVO>)vo.getList();
			Payment = new ArrayList<PaymentPO>();
			
			for(i = 0;i<PaymentVO.size();i++){
				PaymentVO Paymentvo = PaymentVO.get(i);
				PaymentPO po = new PaymentPO(Paymentvo.getReceiver().getName(),Paymentvo.getType(),Paymentvo.getNumberOfPayment(),Paymentvo.getCondition(),Paymentvo.getNameOfWritter());
				
				Payment.add(po);
			}
			Finance.EndAudit(Payment);
			
		}
		case Ioput:{
			@SuppressWarnings("unchecked")
			ArrayList<IoputVO> IoputVO = (ArrayList<IoputVO>)vo.getList();
			Input = new ArrayList<IoputPO>();
			Output =  new ArrayList<IoputPO>();
			
			for(i = 0;i<IoputVO.size();i++){
				IoputVO Ioputvo = IoputVO.get(i);
				switch (Ioputvo.getIoput()){
					case in:{
						IoputPO po = new IoputPO(Ioputvo.getId(),Ioputvo.getInputdate(),Ioputvo.getTime(),Ioputvo.getDestination(),Ioputvo.getPosition(),Ioputvo.getIoput(),Ioputvo.getdCondition(),Ioputvo.getNameOfWriter());
						Input.add(po);
						break;
					}
					case out:{
						IoputPO po = new IoputPO(Ioputvo.getId(),Ioputvo.getOutputdate(),Ioputvo.getTime(),Ioputvo.getDestination(),Ioputvo.getTransport(),Ioputvo.getReceiptID(),Ioputvo.getIoput(),Ioputvo.getCondition(),Ioputvo.getdCondition(),Ioputvo.getNameOfWriter());
						Output.add(po);
						break;
					}
				}

			}
			InputStock.EndAudit(Input);
			OutputStock.EndAudit(Output);
		}
		}
		
		
		
		
		
		
	}


}
