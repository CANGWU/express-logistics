package vo;

import po.BillPO;

public class BillVO {
     double moneyReceived;
     double totalfee;
     double change;
    
     
     
	public BillVO(BillPO bill) {
		// TODO Auto-generated constructor stub
		this.moneyReceived=bill.getMoneyReceived();
		this.totalfee=bill.getTotalfee();
		this.change=bill.getChange();
	}
	public BillVO() {
		// TODO Auto-generated constructor stub
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
