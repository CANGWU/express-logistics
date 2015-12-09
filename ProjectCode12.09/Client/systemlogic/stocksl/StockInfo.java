package stocksl;

import ioputsl.IoputCalculation;

import java.io.FileOutputStream;
import java.io.OutputStream;

import po.StockPO;
import dataservice.DataFactoryService;
import enums.ResultMessage;
import vo.StockInfoVO;
import vo.StockInitializeVO;

public class StockInfo {
	
	private DataFactoryService Data;
	private StockChange Change;
	private IoputCalculation io;
	
	
	public StockInfo(DataFactoryService d,StockChange Change,IoputCalculation io){
		Data = d;
		this.Change = Change;
		this.io = io;
	}


	public StockInfoVO show(String[] time) {
		// TODO Auto-generated method stub
		int seatEmptySum = Change.getEmptySeats();
		int stockSum = Change.getStockSum();
		int seatSum = Change.getSeatSum();
		int ins = io.getInputs(time);
		int outs = io.getOutputs(time);
		
		
		
		StockInfoVO vo = new StockInfoVO(ins,outs,seatSum,seatEmptySum,stockSum);
		
		return vo;
	}


	public ResultMessage initialize(StockInitializeVO vo) {
		// TODO Auto-generated method stub
		ResultMessage rm = ResultMessage.SUCCESS;
		StockPO po;
		String AreaName = null;
		int Num;
		int row =0;
		int shelf=0;
		int seat=0;
		Num = vo.getRowall()*vo.getSeat()*vo.getShelf();
		for(int i=0;i<Num;i++){
			if(row<=vo.getArea1()[1]&&row>=vo.getArea1()[0]){
				AreaName = "航运区";
			}
			if(row<=vo.getArea2()[1]&&row>=vo.getArea2()[0]){
				AreaName = "铁运区";
			}
			if(row<=vo.getArea3()[1]&&row>=vo.getArea3()[0]){
				AreaName = "汽运区";
			}
			if(row<=vo.getArea4()[1]&&row>=vo.getArea4()[0]){
				AreaName = "机动区";
			}
			
			for(shelf=0;shelf<vo.getShelf();shelf++)
				for(seat=0;seat<vo.getSeat();seat++){
					po = new StockPO(i,AreaName,row,shelf,seat,true);
					try{
					Data.getStockDate().insert(po);
					}catch(Exception e){
						rm = ResultMessage.FAIL;
					}
				}

			
			row++;
				
		}
		
		int s1 = (-vo.getArea1()[1]+vo.getArea1()[0]+1)*shelf*seat;
		int s2 = (-vo.getArea2()[1]+vo.getArea2()[0]+1)*shelf*seat;
		int s3 = (-vo.getArea3()[1]+vo.getArea3()[0]+1)*shelf*seat;
		int s4 = (-vo.getArea4()[1]+vo.getArea4()[0]+1)*shelf*seat;
		
		
		Change.initialize(s1, s2, s3, s4);
		
		return rm;
	}

	public ResultMessage check() {
		// TODO Auto-generated method stub
		String[] title = {"区名","排","架","位","快递编号","入库时间","目的地"};
		
		try{
		OutputStream os = new FileOutputStream("盘点。xls");
		}catch(Exception e){
			
		}
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		
		
		return null;
	}

}
