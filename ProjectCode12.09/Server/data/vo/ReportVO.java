package vo;

import java.util.ArrayList;

public class ReportVO {
	private String id;
	private String beginTime;
	private String endTime;
	private long income;
	private long pay;
	private long profit;
	private ArrayList<PaymentVO> payList;
	private ArrayList<ReceiptsVO> incomeList;
	
	
	public ReportVO(String id,String beginTime,String endTime){
		this.id=id;
		this.beginTime=beginTime;
		this.endTime=endTime;
		payList=new ArrayList<PaymentVO>();
		incomeList=new ArrayList<ReceiptsVO>();
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
	
	public void setPayList(ArrayList<PaymentVO> paylist){
		this.payList=paylist;
	}
	
	public ArrayList<PaymentVO> getPayList(){
		return payList;
	}
	
	public void setIncomeList(ArrayList<ReceiptsVO> receiptslist){
		this.incomeList=receiptslist;
	}
	
	public ArrayList<ReceiptsVO> getIncomeList(){
		return incomeList;
	}
}
