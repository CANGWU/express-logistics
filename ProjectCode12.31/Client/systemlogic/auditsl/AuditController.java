package auditsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import auditslservice.AuditService;
import dataservice.DataFactoryService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import financesl.CostController;
import po.ReceiptsPO;
import receivesl.Deliver;
import sendsl.SendController;
import strategysl.Constant;
import strategysl.ConstantController;
import transportsl.Transport;
import transportsl.TransportController;
import twaver.base.A.A.A;
import vo.DeliverVO;
import vo.IoputVO;
import vo.OrderVO;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.TransportVO;

public class AuditController implements AuditService {

	private AuditInfo send, transport, deliver, finance,  gSend ,inputStock,
	outputStock;
	
	
    private DataFactoryService dataFactoryService;
	private ArrayList<OrderVO> order;
	private ArrayList<TransportVO> trans;
	private ArrayList<PaymentVO> payment;
	private ArrayList<ReceiptsVO> receipts;
	private ArrayList<IoputVO> inPut,outPut;
	private ArrayList<DeliverVO> del;

	public AuditController() {
		// TODO Auto-generated constructor stub
		try {
			dataFactoryService = DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConstantController constantController = new ConstantController();
		transport = new TransportController(new Transport(dataFactoryService,constantController));
		deliver = new Deliver();
	    send = new SendController();
	    finance = new CostController();
//	    gSend = new 
	}


	@Override
	public ArrayList<TransportVO> getTransport() {
		// TODO Auto-generated method stub
		trans = (ArrayList<TransportVO>) transport.getAuditInfo();
		return trans;
	}

	@Override
	public ArrayList<DeliverVO> getDeliver() {
		// TODO Auto-generated method stub
		del = (ArrayList<DeliverVO>) deliver.getAuditInfo();
		return del;
	}

	@Override
	public ArrayList<PaymentVO> getPayment() {
		// TODO Auto-generated method stub
		payment = (ArrayList<PaymentVO>) finance.getAuditInfo();
		return payment;
	}

	@Override
	public ArrayList<OrderVO> getOrder() {
		// TODO Auto-generated method stub
		order = (ArrayList<OrderVO>) send.getAuditInfo();
		return order;
	}

//	@Override
//	public ArrayList<IoputVO> getInput() {
//		// TODO Auto-generated method stub
//		inPut = (ArrayList<IoputVO>) inputStock.getAuditInfo();
//		return inPut;
//	}
//	
//	
//	@Override
//	public ArrayList<IoputVO> getOutput() {
//		// TODO Auto-generated method stub
//		outPut = (ArrayList<IoputVO>) outputStock.getAuditInfo();
//		return outPut;
//	}
	
	@Override
	public ArrayList<ReceiptsVO> getReceipts() {
		// TODO Auto-generated method stub
		receipts = (ArrayList<ReceiptsVO>) gSend.getAuditInfo();
		return receipts;
	}



	public ResultMessage saveTransport() {
		// TODO Auto-generated method stub
		return transport.EndAudit(trans);
	}


	public ResultMessage saveDeliver() {
		// TODO Auto-generated method stub
		return deliver.EndAudit(del);
	}



	public ResultMessage savePayment() {
		// TODO Auto-generated method stub
		return finance.EndAudit(payment);

	}



	public ResultMessage saveOutput() {
		// TODO Auto-generated method stub
		return outputStock.EndAudit(outPut);
	}



	public ResultMessage saveInput() {
		// TODO Auto-generated method stub
		return inputStock.EndAudit(inPut);
			
	}



	public ResultMessage saveOrder() {
		// TODO Auto-generated method stub
		return send.EndAudit(order);
			
	}


	@Override
	public ResultMessage saveReceipts() {
		// TODO Auto-generated method stub
		return gSend.EndAudit(receipts);
	}


	@Override
	public ResultMessage saveAll() {
		// TODO Auto-generated method stub
		saveDeliver();
		savePayment();
		saveOrder();
		saveReceipts();
		saveTransport();
		return ResultMessage.SUCCESS;
	
	}





}
