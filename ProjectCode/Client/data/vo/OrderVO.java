package vo;

public class OrderVO {
    ReceiverVO receiver;
    SenderVO sender;
    BillVO bill;
    GoodsVO goods;
    String timeOfSend;
    String dueOfReceive;
    String ordernumber;
    String nameOfCourier;
    String receivetime;
    
    public OrderVO(String _timeOfSend,String _nameOfCourier,String sendername,String senderaddress,String senderworkplace,String sendertelnumber,String senderphonenumber,String receivername,String receiveraddress,String receiverworkplace,String receivertelnumber,String receiverphonenumber,int _numberOfGoods, double _weight, double _volume, String _nameOfGoods, String _size, String _expressType){
    	timeOfSend=_timeOfSend; 
    	nameOfCourier=_nameOfCourier;
    	receiver=new ReceiverVO(receivername,receiveraddress,receiverworkplace,receivertelnumber,receiverphonenumber);
    	sender=new SenderVO(sendername,senderaddress,senderworkplace,sendertelnumber,senderphonenumber);
    	goods=new GoodsVO(_numberOfGoods, _weight, _volume, _nameOfGoods, _size, _expressType);
    	bill=new BillVO();

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
	

     
}
