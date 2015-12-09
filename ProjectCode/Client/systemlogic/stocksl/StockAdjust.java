package stocksl;

import java.text.DecimalFormat;
import java.util.ArrayList;

import po.StockPO;
import dataservice.DataFactoryService;
import enums.ResultMessage;
import enums.WarningMessage;
import vo.AreaVO;

public class StockAdjust {
	
	private DataFactoryService Data;
	private StockChange Change;
	private String ToAdjust;
	private int row;
	private int shelf;
	private int seats;
	private AreaVO vo1,vo2,vo3,vo4;
	private AreaVO[] areas = {vo1,vo2,vo3,vo4};
	
	public StockAdjust(DataFactoryService d,int num,int row,int shelf,int seats,StockChange Change){
		Data = d;
		this.row = row;
		this.shelf = shelf;
		this.seats = seats;
		this.Change = Change;
	}
	
	
//	public AreaVO[] getAreas() {
//		// TODO Auto-generated method stub
//		ArrayList<String> AreaSeats1= new ArrayList<String>();
//		ArrayList<String> AreaSeats2= new ArrayList<String>();
//		ArrayList<String> AreaSeats3= new ArrayList<String>();
//		ArrayList<String> AreaSeats4= new ArrayList<String>();
//
//		StockPO po;
//		double emptyP1,emptyP2,emptyP3,emptyP4;
//		int a1=0,a2=0,a3=0,a4=0,e1=0,e2=0,e3=0,e4=0;
//		for(int i = 0;i<row;i++)
//			for(int j=0;j<shelf;j++)
//				for(int m = 0;m<seats;m++){
//					po = Data.getStockDate().findposition(i, j, m);
//					if(po.getArea().equals("航运区")){
//						if(po.isEmpty())
//							e1++;
//						a1++;
//						AreaSeats1.add(Integer.toString(po.getRow())+","+Integer.toString(po.getShelf())+","+Integer.toString(po.getSeat()));
//					}
//					if(po.getArea().equals("铁运区")){
//						if(po.isEmpty())
//							e2++;
//						a2++;
//						AreaSeats2.add(Integer.toString(po.getRow())+","+Integer.toString(po.getShelf())+","+Integer.toString(po.getSeat()));
//					}
//					if(po.getArea().equals("汽运区")){
//						if(po.isEmpty())
//							e3++;
//						a3++;
//						AreaSeats3.add(Integer.toString(po.getRow())+","+Integer.toString(po.getShelf())+","+Integer.toString(po.getSeat()));
//					}
//					if(po.getArea().equals("机动区")){
//						if(po.isEmpty())
//							e4++;
//						a4++;
//						AreaSeats4.add(Integer.toString(po.getRow())+","+Integer.toString(po.getShelf())+","+Integer.toString(po.getSeat()));
//					}
//					
//					emptyP1=e1/a1;
//					emptyP2=e2/a2;
//					emptyP3=e3/a3;
//					emptyP4=e4/a4;
//					
//					DecimalFormat df = new DecimalFormat("#.00");
//					vo1 = new AreaVO("航运区",(String[])AreaSeats1.toArray(),df.format(emptyP1*100)+"%");
//					vo2 = new AreaVO("铁运区",(String[])AreaSeats2.toArray(),df.format(emptyP2*100)+"%");
//					vo3 = new AreaVO("汽运区",(String[])AreaSeats3.toArray(),df.format(emptyP3*100)+"%");
//					vo4 = new AreaVO("机动区",(String[])AreaSeats4.toArray(),df.format(emptyP4*100)+"%");
//
//					
//				}	
//					
//		return areas;
//	}

	
	public AreaVO selectArea(String name) {
		// TODO Auto-generated method stub
		if(name.equals("航运区"))
			return vo1;
		if(name.equals("铁运区"))
			return vo2;
		if(name.equals("汽运区"))
			return vo3;
		else if(name.equals("机动区"))
			return vo4;
		else
			return null;
	}


//	public WarningMessage range(String adjustrange) {
//		// TODO Auto-generated method stub
//		
//		ToAdjust = Change.getWarningArea();
//		
//		WarningMessage wm = WarningMessage.NORMAL;
//		
//		String begin,end;
//		begin = adjustrange.split("-")[0];
//		end = adjustrange.split("-")[1];
//		
//		begin = begin.substring(0,begin.length());
//		end = end.substring(0,end.length());
//		
//		int rowB,shelfB,seatB,rowE,shelfE,seatE;
//		int r,sh,s;
//		
//		rowB = Integer.parseInt(begin.split(",")[0]);
//		shelfB = Integer.parseInt(begin.split(",")[1]);
//		seatB = Integer.parseInt(begin.split(",")[2]);
//		rowE = Integer.parseInt(end.split(",")[0]);
//		shelfE = Integer.parseInt(end.split(",")[1]);
//		seatE = Integer.parseInt(end.split(",")[2]);
//		
//		int change1=0,change2=0,change3=0,change4=0;
//		r=rowB;
//		sh = shelfB;
//		s = seatB;
//		StockPO po=null;
//		do{
//			try{
//			po = Data.getStockDate().findposition(r, sh, s);
//			}catch(Exception e){
//			}
//			if(po.isEmpty()){
//				if(po.getArea().equals("航运区"))
//					change1--;
//				if(po.getArea().equals("铁运区"))
//					change2--;
//				if(po.getArea().equals("汽运区"))
//					change3--;
//				if(po.getArea().equals("机动区"))
//					change4--;
//			
//				po.setArea(ToAdjust);
//				
//				if(po.getArea().equals("航运区"))
//					change1++;
//				if(po.getArea().equals("铁运区"))
//					change2++;
//				if(po.getArea().equals("汽运区"))
//					change3++;
//				if(po.getArea().equals("机动区"))
//					change4++;
//			}
//			try{
//				Data.getStockDate().update(po);
//			}catch(Exception e){
//				wm = WarningMessage.FAIL;
//			}
//			
//			s++;
//			if(s>seats){
//				s = 0;
//				sh++;
//				if(sh>shelf){
//					sh = 0;
//					r++;
//				}
//			}
//			
//			
//		}while(r!=rowE&&sh!=shelfE&&s!=seatE);
//		
//		
//		
//		ResultMessage rm = Change.setArea(change1, change2, change3, change4);
//		if(rm == ResultMessage.FAIL)
//			wm = WarningMessage.WARNING;
//		return wm;
//	}

}
