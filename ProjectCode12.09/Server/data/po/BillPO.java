package po;

import java.io.Serializable;

public class BillPO implements Serializable{
     double moneyReceived;
     double totalfee;
     double change;
    
     
    public BillPO(double moneyReceived,double totalfee,double change){
    	this.moneyReceived=moneyReceived;
    	this.totalfee=totalfee;
    	this.change=change;
    }
     
	public double getMoneyReceived() {
		return moneyReceived;
	}
	public void setMoneyReceived(double moneyReceived) {
		this.moneyReceived = moneyReceived;
	}
	public double getTotalfee() {
		return totalfee;
	}
	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
     
}
