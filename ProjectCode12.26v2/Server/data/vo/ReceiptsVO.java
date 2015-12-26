package vo;

import java.util.ArrayList;

import enums.DocumentCondition;
import po.ReceiptsPO;

public class ReceiptsVO {
      
	String date;
	double fee;
	String courier;
	ArrayList<String> ordernumbers;
	String office;
	DocumentCondition dCondition;
	
	

	public ReceiptsVO(String date,double fee,String courier,ArrayList<String> ordernumbers,String office, DocumentCondition dCondition){
		this.date=date;
		this.fee=fee;
		this.courier=courier;
		this.ordernumbers=ordernumbers;
		this.office=office;
		this.dCondition = dCondition;
		
	}
	
	public ReceiptsVO(ReceiptsPO po){
		this.date=po.getDate();
		this.fee=po.getFee();
		this.courier=po.getCourier();
		this.ordernumbers=po.getOrdernumbers();
		this.office=po.getOffice();
	}
	
	public DocumentCondition getdCondition() {
		return dCondition;
	}

	public void setdCondition(DocumentCondition dCondition) {
		this.dCondition = dCondition;
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

	public ArrayList<String> getOrdernumbers() {
		return ordernumbers;
	}

	public void setOrdernumbers(ArrayList<String> ordernumbers) {
		this.ordernumbers = ordernumbers;
	}
	
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office=office;
	}
}
