package ioputsl;

import java.text.SimpleDateFormat;
import java.util.Date;

import dataservice.DataFactoryService;
import po.IoputPO;
import enums.DocumentCondition;
import enums.Ioput;
import enums.Position;
import enums.ResultMessage;
import enums.WarningMessage;
import vo.InMessageVO;
import stocksl.IoputStock;

public class InputStock {
	private IoputStock Stock;
	private InputMessage Message;
	private IoputPO PO;
	private DataFactoryService Data;
	private int row,shelf,seat;
	
	public InputStock(IoputStock stock,InputMessage im,DataFactoryService d){
		Stock = stock;
		Message = im;
		Data = d;
	}
	
	
	public InMessageVO showInputInfo(String id) {
		// TODO Auto-generated method stub
		
		InMessageVO vo;
		// get信息
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
		String idate = df.format(new Date());
		String t = tf.format(new Date());
		Position des = Message.getInputMessage(id).getDestination();
		
		PO = new IoputPO(id, idate, t, des, null, Ioput.in,DocumentCondition.handing);
		
		
		//打包VO
		vo = new InMessageVO(PO.getID(),PO.getInputDate(),PO.getDestination());
		
		return vo;
	}

	public WarningMessage position(String position) {
		// TODO Auto-generated method stub
		
		//解析坐标
		String[] p = position.split(",");
		row = Integer.parseInt(p[0]);
		shelf = Integer.parseInt(p[1]);
		seat = Integer.parseInt(p[2]);
		
		
		//更改库存
		WarningMessage wm = WarningMessage.FAIL;
		ResultMessage rm;
		rm = Stock.Input(row, shelf, seat,PO.getID(),PO.getInputDate());
		if(rm == ResultMessage.SUCCESS){
			
			wm = Stock.StockSafe();

			//储存入库单(AUDITx
			IoputPO po = new IoputPO(PO.getID(),PO.getInputDate(),PO.getTime(),PO.getDestination(),position,Ioput.in,DocumentCondition.handing);
			
			try{
			Data.getIoputData().insert(po);
			}catch(Exception e){
				
			}

		}
		
			return wm;
	}

}
