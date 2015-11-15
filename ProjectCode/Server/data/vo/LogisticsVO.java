package vo;

import java.util.ArrayList;

public class LogisticsVO {
    String ordernumber;
    ArrayList<String> logisticsMessage=new ArrayList<String>();
    
    
    
    public LogisticsVO(String ordernumber){
    	this.ordernumber=ordernumber;
    }
    
    public void addMessage(String newmessgae){
    	logisticsMessage.add(newmessgae);
    }
    
    
    
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	
    
}
