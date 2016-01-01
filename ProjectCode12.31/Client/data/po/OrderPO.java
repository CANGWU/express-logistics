package po;

import java.io.Serializable;

import enums.DocumentCondition;
import vo.*;

public class OrderPO implements Serializable{
	private ReceiverPO receiver;
	private SenderPO sender;
	private BillPO bill;
	private GoodsPO goods;
	private String timeOfSend;
	private String dueOfReceive;
	private String ordernumber;
	private String nameOfCourier;
	private String receivetime;
	private DocumentCondition dCondition;
	
	




	public OrderPO(String _timeOfSend, String _dueOfReceive,
			String _ordernumber, String _nameOfCourier, SenderVO _sender,
			ReceiverVO _receiver, BillVO _bill, GoodsVO _goods,
			DocumentCondition dCondition) {
		timeOfSend = _timeOfSend;
		ordernumber = _ordernumber;
		nameOfCourier = _nameOfCourier;
		dueOfReceive = _dueOfReceive;
		receiver = new ReceiverPO(_receiver.getName(), _receiver.getAddress(),
				_receiver.getWorkPlace(), _receiver.getTelNumber(),
				_receiver.getPhoneNumber());
		sender = new SenderPO(_sender.getName(), _sender.getAddress(),
				_sender.getWorkPlace(), _sender.getTelNumber(),
				_sender.getPhoneNumber());
		goods = new GoodsPO(_goods.getNumberOfGoods(), _goods.getWeight(),
				_goods.getVolume(), _goods.getNameOfGoods(), _goods.getSize(),
				_goods.getExpressType(), _goods.getPacking());
		bill = new BillPO(_bill.getMoneyReceived(), _bill.getTotalfee(),
				_bill.getChange());
		this.dCondition = dCondition;
	}

	public OrderPO(ReceiverPO receiver, SenderPO sender, BillPO bill,
			GoodsPO goods, String timeOfSend, String dueOfReceive,
			String ordernumber, String nameOfCourier, String receivertime,
			DocumentCondition dCondition) {
		this.sender=sender;
		this.receiver = receiver;
		this.bill = bill;
		this.goods = goods;
		this.timeOfSend = timeOfSend;
		this.dueOfReceive = dueOfReceive;
		this.ordernumber = ordernumber;
		this.nameOfCourier = nameOfCourier;
		this.receivetime = receivertime;
		this.dCondition = dCondition;

	}

	public ReceiverPO getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverPO receiver) {
		this.receiver = receiver;
	}

	public SenderPO getSender() {
		return sender;
	}

	public void setSender(SenderPO sender) {
		this.sender = sender;
	}

	public BillPO getBill() {
		return bill;
	}

	public void setBill(BillPO bill) {
		this.bill = bill;
	}

	public GoodsPO getGoods() {
		return goods;
	}

	public void setGoods(GoodsPO goods) {
		this.goods = goods;
	}

	public String getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}

	public String getTimeOfSend() {
		return timeOfSend;
	}

	public void setTimeOfSend(String timeOfSend) {
		this.timeOfSend = timeOfSend;
	}

	public String getDueOfReceive() {
		return dueOfReceive;
	}

	public void setDueOfReceive(String dueOfReceive) {
		this.dueOfReceive = dueOfReceive;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getNameOfCourier() {
		return nameOfCourier;
	}

	public void setNameOfCourier(String nameOfCourier) {
		this.nameOfCourier = nameOfCourier;
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}

}
