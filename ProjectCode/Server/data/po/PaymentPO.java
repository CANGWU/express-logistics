package po;

import enums.DocumentCondition;
import enums.PaymentType;

public class PaymentPO {
    String receiver;
    PaymentType type;
    double numberOfPayment;
    DocumentCondition dCondition;
<<<<<<< HEAD
    String nameOfWriter;
    
    
    public PaymentPO(String receiver,PaymentType type,double numberOfPayment
    		,DocumentCondition dCondition,String nameOfWriter){
=======
    
    public PaymentPO(String receiver,PaymentType type,double numberOfPayment
    		,DocumentCondition dCondition){
>>>>>>> origin/master
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
    	this.dCondition = dCondition;
<<<<<<< HEAD
    	this.nameOfWriter = nameOfWriter;
    }
    
    public String getNameOfWriter(){
    	return nameOfWriter;
    }
    
    public void setNameOfWriter(String nameOfWriter){
    	this.nameOfWriter = nameOfWriter;
=======
>>>>>>> origin/master
    }

	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
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
