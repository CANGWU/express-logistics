package po;

<<<<<<< HEAD
=======
import vo.PaymentVO;
>>>>>>> origin/master
import enums.DocumentCondition;
import enums.PaymentType;

public class PaymentPO {
    String receiver;
    PaymentType type;
    double numberOfPayment;
<<<<<<< HEAD
    DocumentCondition dCondition;
    String nameOfWriter;
    
    
    public PaymentPO(String receiver,PaymentType type,double numberOfPayment
    		,DocumentCondition dCondition,String nameOfWriter){
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
    	this.dCondition = dCondition;
    	this.nameOfWriter = nameOfWriter;
    }
    
    public String getNameOfWriter(){
    	return nameOfWriter;
    }
    
    public void setNameOfWriter(String nameOfWriter){
    	this.nameOfWriter = nameOfWriter;
    }

	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
	}
=======
    String accountname;
    DocumentCondition condition;
    
    public StaffPO getReceiver() {
		return receiver;
	}

	public DocumentCondition getCondition() {
		return condition;
	}

	public void setCondition(DocumentCondition condition) {
		this.condition = condition;
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

>>>>>>> origin/master

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
	public String getReceiver(){
		return receiver;
=======
	
	public PaymentPO(StaffPO receiver,PaymentType type,double numberOfPayment,String accountname){
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
    	this.accountname=accountname;
        this.condition=DocumentCondition.handing;
    }
	
	public PaymentPO(PaymentVO vo){
		this.receiver=new StaffPO(vo.getReceiver());
		this.type=vo.getType();
		this.numberOfPayment=vo.getNumberOfPayment();
		this.accountname=vo.getAccountname();
        this.condition=DocumentCondition.handing;
>>>>>>> origin/master
	}
}
