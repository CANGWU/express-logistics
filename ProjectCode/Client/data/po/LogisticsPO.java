package po;

import java.util.ArrayList;

public class LogisticsPO {
    String ordernumber;
    ArrayList<String> logisticsMessage=new ArrayList<String>();
    
    
    
    public LogisticsPO(String ordernumber,ArrayList<String>logisticsMessage){
    	this.logisticsMessage=logisticsMessage;
    	this.ordernumber=ordernumber;
    }
    
    
    public ArrayList<String> getLogisticsMessage(){
		return logisticsMessage;
    	
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
