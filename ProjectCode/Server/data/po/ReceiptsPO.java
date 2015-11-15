package po;

public class ReceiptsPO {
      
	String data;
	double fee;
	String courier;
	String[] ordernumbers;
	
	public ReceiptsPO(String data,double fee,String courier,String[] ordernumbers){
		this.data=data;
		this.fee=fee;
		this.courier=courier;
		this.ordernumbers=ordernumbers;
		
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
