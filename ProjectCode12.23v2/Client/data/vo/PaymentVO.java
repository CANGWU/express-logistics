package vo;


import po.PaymentPO;
import enums.DocumentCondition;
import enums.PaymentType;



public class PaymentVO {
    private String receiver;
    private PaymentType type;
    private double numberOfPayment;
    private String accountname;
    private DocumentCondition condition;
    private String nameOfWriter;
    private String remarks;

    
    public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public DocumentCondition getCondition() {
		return condition;
	}

	public void setCondition(DocumentCondition condition) {
		this.condition = condition;
	}

	public PaymentVO(String receiver,PaymentType type){
    	this.setReceiver(receiver);
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

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public String getNameOfWriter() {
		return nameOfWriter;
	}

	public void setNameOfWriter(String nameOfWriter) {
		this.nameOfWriter = nameOfWriter;
	}



	

}
