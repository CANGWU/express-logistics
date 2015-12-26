package po;

import vo.PaymentVO;

import java.io.Serializable;

import enums.DocumentCondition;
import enums.PaymentType;


public class PaymentPO implements Serializable{
	String auditnumber;
    String receiver;
    PaymentType type;
    double numberOfPayment;
    String accountname;
    DocumentCondition condition;
    private String nameOfWriter;
    private String remarks;
    


	public String getNameOfWriter() {
		return nameOfWriter;
	}

	public void setNameOfWriter(String nameOfWriter) {
		this.nameOfWriter = nameOfWriter;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getReceiver() {
		return receiver;
	}

	public DocumentCondition getCondition() {
		return condition;
	}

	public void setCondition(DocumentCondition condition) {
		this.condition = condition;
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
	
	public String getAuditnumber() {
		return auditnumber;
	}

	public void setAuditnumber(String auditnumber) {
		this.auditnumber = auditnumber;
	}

	public PaymentPO(String receiver,PaymentType type,double numberOfPayment,String accountname){
    	this.receiver=receiver;
    	this.type=type;
    	this.numberOfPayment=numberOfPayment;
    	this.accountname=accountname;
        this.condition=DocumentCondition.handing;
    }
	
	public PaymentPO(){};

	
	public PaymentPO(PaymentVO vo){
		this.receiver=new String(vo.getReceiver());
		this.type=vo.getType();
		this.numberOfPayment=vo.getNumberOfPayment();
		this.accountname=vo.getAccountname();
        this.condition=DocumentCondition.handing;
        this.nameOfWriter=vo.getNameOfWriter();
        this.accountname=vo.getAccountname();
        this.remarks=vo.getRemarks();
        this.auditnumber=vo.getAuditnumber();
	}
}
