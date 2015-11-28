package vo;

<<<<<<< HEAD
=======
import po.PaymentPO;
import enums.DocumentCondition;
import enums.PaymentType;

>>>>>>> origin/master

public class PaymentVO {
    StaffVO receiver;
    PaymentType type;
    double numberOfPayment;
<<<<<<< HEAD
=======
    String accountname;
    DocumentCondition condition;
>>>>>>> origin/master
    
    public DocumentCondition getCondition() {
		return condition;
	}

	public void setCondition(DocumentCondition condition) {
		this.condition = condition;
	}

	public PaymentVO(StaffVO receiver,PaymentType type){
    	this.receiver=receiver;
    	this.type=type;
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
<<<<<<< HEAD
=======
	
>>>>>>> origin/master
}
