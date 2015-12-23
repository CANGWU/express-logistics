package vo;

import po.ReceiptsPO;

public class ReceiptsVO {
      
	String date;
	double fee;
	String courier;
	String[] ordernumbers;
	String office;
	
	public ReceiptsVO(String date,double fee,String courier,String[] ordernumbers,String office){
		this.date=date;
		this.fee=fee;
		this.courier=courier;
		this.ordernumbers=ordernumbers;
		this.office=office;
		
	}
	
	public ReceiptsVO(ReceiptsPO po){
		this.date=po.getDate();
		this.fee=po.getFee();
		this.courier=po.getCourier();
		this.ordernumbers=po.getOrdernumbers();
		this.office=po.getOffice();
	}

	public String getDate() {
		return date;
	}

	public void setData(String date) {
		this.date = date;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String[] getOrdernumbers() {
		return ordernumbers;
	}

	public void setOrdernumbers(String[] ordernumbers) {
		this.ordernumbers = ordernumbers;
	}
	
}
