package vo;


import po.PaymentPO;
import enums.DocumentCondition;
import enums.PaymentType;



public class PaymentVO {
    private StaffVO receiver;
    private PaymentType type;
    private double numberOfPayment;
    private String accountname;
    private DocumentCondition condition;
    private String nameOfWritter;

    
    public DocumentCondition getCondition() {
		return condition;
	}

	public void setCondition(DocumentCondition condition) {
		this.condition = condition;
	}

	public PaymentVO(StaffVO receiver,PaymentType type){
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

	public String getNameOfWritter() {
		return nameOfWritter;
	}

	public void setNameOfWriter(String nameOfWritter) {
		this.nameOfWritter = nameOfWritter;
	}

}
