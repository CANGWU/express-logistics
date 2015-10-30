package vo;

public class ReceiptsVO {
      
	String date;
	double fee;
	String courier;
	String[] ordernumbers;
	
	public ReceiptsVO(String date,double fee,String courier,String[] ordernumbers){
		this.date=date;
		this.fee=fee;
		this.courier=courier;
		this.ordernumbers=ordernumbers;
		
		
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
