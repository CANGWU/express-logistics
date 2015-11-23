package vo;

import po.PaymentPO;
import enums.PaymentType;


public class PaymentVO {
    StaffVO receiver;
    PaymentType type;
    double numberOfPayment;
    String accountname;
    
    public PaymentVO(StaffVO receiver,PaymentType type){
    	this.receiver=receiver;
    	this.type=type;
    }

	public StaffVO getReceiver() {
		return receiver;
	}

	public void setReceiver(StaffVO receiver) {
		this.receiver = receiver;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public double getNumberOfPayment() {
		return numberOfPayment;
	}

	public void setNumberOfPayment(double numberOfPayment) {
		this.numberOfPayment = numberOfPayment;
	}
	
	public PaymentPO changeToPO(){
		PaymentPO po=new PaymentPO(this.receiver.changeToPO(),this.type,this.numberOfPayment,this.accountname);
		return po;
	}
}
