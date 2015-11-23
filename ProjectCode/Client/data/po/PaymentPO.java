package po;

import enums.PaymentType;


public class PaymentPO {
    StaffPO receiver;
    PaymentType type;
    double numberOfPayment;
    String accountname;
    
    public StaffPO getReceiver() {
		return receiver;
	}

	public void setReceiver(StaffPO receiver) {
		this.receiver = receiver;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public PaymentPO(StaffPO receiver,PaymentType type,double numberOfPayment,String accountname){
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
    	this.accountname=accountname;
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
}
