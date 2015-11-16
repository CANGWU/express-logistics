package reportsl;

import java.util.ArrayList;

public class ReportList {
	private String id;
	private String beginTime;
	private String endTime;
	ArrayList<ReportMessage> list;
	
	public ReportList(String id, String beginTime, String endTime){
		this.id=id;
		this.beginTime=beginTime;
		this.endTime=endTime;
		list=new ArrayList<ReportMessage>();
	}
	
	public void add(ReportMessage reportmessage){
		list.add(reportmessage);
	}
	
	public long getIncome(){
		int income=0;
		for(int i=0;i<this.list.size();i++)
			income+=list.get(i).income;
		return income;
	}
	
	public long getPay(){
		int pay=0;
		for(int i=0;i<this.list.size();i++)
			pay+=list.get(i).pay;
		return pay;
	}
	
	public long getProfit(){
		int profit=0;
		for(int i=0;i<this.list.size();i++)
			profit+=(list.get(i).income-list.get(i).pay);
		return profit;
	}
}
