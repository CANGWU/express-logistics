package po;

import enums.PaymentType;

public class PaymentPO {
    String receiver;
    PaymentType type;
    double numberOfPayment;
    
    public PaymentPO(String receiver,PaymentType type,double numberOfPayment){
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
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
	public String getReceiver(){
		return receiver;
	}
}
