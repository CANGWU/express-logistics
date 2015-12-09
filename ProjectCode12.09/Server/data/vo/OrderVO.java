package vo;

import po.OrderPO;
import enums.DocumentCondition;
import enums.Packing;

public class OrderVO {
	private ReceiverVO receiver;
	private SenderVO sender;
	private BillVO bill;
	private GoodsVO goods;
	private String timeOfSend;
	private String dueOfReceive;
	private String ordernumber;
	private String nameOfCourier;
	private String receivetime;
	private DocumentCondition documentCondition;

	public OrderVO(String _timeOfSend, String _nameOfCourier,
			String sendername, String senderaddress, String senderworkplace,
			String sendertelnumber, String senderphonenumber,
			String receivername, String receiveraddress,
			String receiverworkplace, String receivertelnumber,
			String receiverphonenumber, int _numberOfGoods, double _weight,
			double _volume, String _nameOfGoods, String _size,
			String _expressType, Packing _packing,
			DocumentCondition _documentCondition) {
		timeOfSend = _timeOfSend;
		nameOfCourier = _nameOfCourier;
		receiver = new ReceiverVO(receivername, receiveraddress,
				receiverworkplace, receivertelnumber, receiverphonenumber);
		sender = new SenderVO(sendername, senderaddress, senderworkplace,
				sendertelnumber, senderphonenumber);
		goods = new GoodsVO(_numberOfGoods, _weight, _volume, _nameOfGoods,
				_size, _expressType, _packing);
		bill = new BillVO();
		documentCondition = _documentCondition;
	}

	public OrderVO(OrderPO po) {
		// TODO Auto-generated constructor stub
          this.receiver=new ReceiverVO(po.getReceiver());
          this.sender=new SenderVO(po.getSender());
          this.bill=new BillVO(po.getBill());
          this.documentCondition=po.getdCondition();
          this.dueOfReceive=po.getDueOfReceive();
          this.goods=new GoodsVO(po.getGoods());
          this.ordernumber=po.getOrdernumber();
          this.timeOfSend=po.getTimeOfSend();
          this.nameOfCourier=po.getNameOfCourier();
          this.receivetime=po.getReceivetime();
          
	}

	public ReceiverVO getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverVO receiver) {
		this.receiver = receiver;
	}

	public SenderVO getSender() {
		return sender;
	}

	public void setSender(SenderVO sender) {
		this.sender = sender;
	}

	public BillVO getBill() {
		return bill;
	}

	public void setBill(BillVO bill) {
		this.bill = bill;
	}

	public GoodsVO getGoods() {
		return goods;
	}

	public void setGoods(GoodsVO goods) {
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

	public DocumentCondition getDocumentCondition() {
		return documentCondition;
	}

	public void setDocumentCondition(DocumentCondition documentCondition) {
		this.documentCondition = documentCondition;
	}

}
