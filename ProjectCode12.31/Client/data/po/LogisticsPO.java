package po;

import java.io.Serializable;
import java.util.ArrayList;

import vo.LogisticsVO;

public class LogisticsPO implements Serializable{
    String ordernumber;
    ArrayList<String> logisticsMessage=new ArrayList<String>();
    
    
    
    public LogisticsPO(String ordernumber){
    	this.ordernumber=ordernumber;
    }
    
    public LogisticsPO(LogisticsVO vo){
    	this.ordernumber=vo.getOrdernumber();
    	this.logisticsMessage=vo.getLogisticsMessage();
    }
    
    
    public void setLogisticsMessage(ArrayList<String> logisticsMessage){
    	this.logisticsMessage=logisticsMessage;
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
