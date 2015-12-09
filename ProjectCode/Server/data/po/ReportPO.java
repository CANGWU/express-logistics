package po;

import java.io.Serializable;

public class ReportPO implements Serializable{
	private String id;
	private String beginTime;
	private String endTime;
	private long income;
	private long pay;
	private long profit;
	
	public ReportPO(String id,long income,long pay,long profit,String beginTime,String endTime){
		this.id=id;
		this.income=income;
		this.pay=pay;
		this.profit=profit;
		this.beginTime=beginTime;
		this.endTime=endTime;
	}
	
	public String getID(){
		return id;
	}
	public long getIncome(){
		return income;
	}
	public long getPay(){
		return pay;
	}
	public long getProfit(){
		return profit;
	}
	public String getBeginTime(){
		return beginTime;
	}
	public String getEndTime(){
		return endTime;
	}
	public void setID(String id){
		this.id=id;
	}
	public void setIncome(long income){
		this.income=income;
	}
	public void setPay(long pay){
		this.pay=pay;
	}
	public void setProfit(long profit){
		this.profit=profit;
	}
	public void setBeginTime(String beginTime){
		this.beginTime=beginTime;
	}
	public void setEndTime(String endTime){
		this.endTime=endTime;
	}
}
