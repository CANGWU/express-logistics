package stocksl;

import po.StockPO;
import dataservice.DataFactoryService;
import enums.ResultMessage;
import enums.WarningMessage;

public class StockChange implements IoputStock {
	
	private String WarningArea = null;
	private int seats1,seats2,seats3,seats4;
	private int filled1,filled2,filled3,filled4;
	private double EP1,EP2,EP3,EP4;
	
	
	private DataFactoryService Data;
	private StockPO po;
	public StockChange(DataFactoryService d){
		Data = d;
	}

	@Override
	public ResultMessage Input(int row,int shelf,int seat,String id,String date) {
		// TODO Auto-generated method stub
		ResultMessage rm = ResultMessage.SUCCESS;
		try{
			po = Data.getStockDate().findposition(row, shelf, seat);
			if(po.isEmpty()){
				po.setEmpty(false);
				po.setID(id);
				po.setInputDate(date);
				if(po.getArea().equals("航运区"))
					filled1++;
				if(po.getArea().equals("铁运区"))
					filled2++;
				if(po.getArea().equals("汽运区"))
					filled3++;
				if(po.getArea().equals("机动区"))
					filled4++;
				
				
				try{
				Data.getStockDate().update(po);
				}catch(Exception e){
					rm = ResultMessage.FAIL;
				}
				
				
				
			}
			else
				rm = ResultMessage.FAIL;
		}catch(Exception e){
			rm = ResultMessage.FAIL;
		}
		
		return rm;
	}

	@Override
	public ResultMessage Output(int row,int shelf,int seat) {
		// TODO Auto-generated method stub
		ResultMessage rm = ResultMessage.SUCCESS;
		try{
			po = Data.getStockDate().findposition(row, shelf, seat);
			if(!po.isEmpty()){
			
				
				 po.setEmpty(true);
					if(po.getArea().equals("航运区"))
						filled1--;
					if(po.getArea().equals("铁运区"))
						filled2--;
					if(po.getArea().equals("汽运区"))
						filled3--;
					if(po.getArea().equals("机动区"))
						filled4--;
				
				 
				try{
				Data.getStockDate().update(po);
				}catch(Exception e){
					rm = ResultMessage.FAIL;
				}
			
			
			}
			else
				rm = ResultMessage.FAIL;
			
		}catch(Exception e){
			rm = ResultMessage.FAIL;
		}
		
		
		return rm;
	}
	
	public ResultMessage initialize(int s1,int s2,int s3,int s4){
		seats1 = s1;
		seats2 = s2;
		seats3 = s3;
		seats4 = s4;
		
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage setArea(int change1,int change2,int change3,int change4){
		
		ResultMessage rm;
		

			seats1 = seats1 + change1;
			seats2 = seats2 + change2;
			seats3 = seats3 + change3;
			seats4 = seats4 + change4;
			
			EP1 = filled1/seats1;
			EP2 = filled2/seats2;
			EP3 = filled3/seats3;
			EP4 = filled4/seats4;
			
			if(EP1<=0.9&&EP2<=0.9&&EP3<=0.9&&EP4<=0.9)
				rm =  ResultMessage.SUCCESS;
			else 
				rm = ResultMessage.FAIL;
		
		return rm;
		
	}
	
	public WarningMessage StockSafe(){
		
		WarningMessage wm = WarningMessage.WARNING;
		
		
		EP1 = filled1/seats1;
		EP2 = filled2/seats2;
		EP3 = filled3/seats3;
		EP4 = filled4/seats4;
		
		if(EP1<=0.9&&EP2<=0.9&&EP3<=0.9&&EP4<=0.9)
			wm = WarningMessage.NORMAL;
		else if(EP1>0.9)
			WarningArea = "航运区";
		else if(EP2>0.9)
			WarningArea = "铁运区";
		else if(EP3>0.9)
			WarningArea = "汽运区";
		else if(EP4>0.9)
			WarningArea = "机动区";
			
		return wm;
	}
	
	public String getWarningArea(){
		return WarningArea;
	}
	
	public int getStockSum(){
		int StockSum = filled1+filled2+filled3+filled4;
		return StockSum;
	}
	
	public int getEmptySeats(){
		int Emptys= seats1+seats2+seats3+seats4-filled1-filled2-filled3-filled4;
		return Emptys;
	}

	public int getSeatSum() {
		// TODO Auto-generated method stub
		int Seats = seats1+seats2+seats3+seats4;
		return Seats;
	}
	

}
