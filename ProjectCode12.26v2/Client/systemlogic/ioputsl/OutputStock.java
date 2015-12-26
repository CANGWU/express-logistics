package ioputsl;

import java.text.SimpleDateFormat;
import java.util.Date;

import po.IoputPO;
import dataservice.DataFactoryService;
import enums.Condition;
import enums.DocumentCondition;
import enums.Ioput;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import stocksl.IoputStock;
import vo.OutMessageVO;

public class OutputStock {
	
	private IoputStock Stock;
	private OutputMessage Message;
	private IoputPO PO;
	private DataFactoryService Data;
	int row,shelf,seat;
	
	
	public OutputStock(IoputStock Stock,OutputMessage OutputMessage,DataFactoryService DataFactory){
		this.Stock = Stock;
		Message = OutputMessage;
		Data = DataFactory;
	}
	
	public OutMessageVO showOutputInfo(String id) {
		// TODO Auto-generated method stub
		
		OutMessageVO vo;

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
		String idate = df.format(new Date());
		String t = tf.format(new Date());
		Position des = Message.getOutputMessage(id).getDestination();
		Traffic trans = Message.getOutputMessage(id).getTraffic();
		String rID = Message.getOutputMessage(id).getID();
		
		PO = new IoputPO(id, idate, t, des,trans,rID, Ioput.out,null,DocumentCondition.draft);
		
		
		
		vo = new OutMessageVO(PO.getID(),PO.getOutputDate(),PO.getDestination(),PO.getTransport(),PO.getReceiptID());
		if(Stock.Output(row, shelf, seat)==ResultMessage.SUCCESS)
		try{
		Data.getIoputData().insert(PO);
		}catch (Exception e){
			
		}
		
		return vo;
	}

	public ResultMessage report(String id) {
		// TODO Auto-generated method stub


		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
		String idate = df.format(new Date());
		String t = tf.format(new Date());
		Position des = Message.getOutputMessage(id).getDestination();
		Traffic trans = Message.getOutputMessage(id).getTraffic();
		String rID = Message.getOutputMessage(id).getID();
		
		PO = new IoputPO(id, idate, t, des,trans,rID, Ioput.out,Condition.lost,DocumentCondition.draft);
		
		
		if(Stock.Output(row, shelf, seat)==ResultMessage.SUCCESS)
		try{
			Data.getIoputData().insert(PO);
		}catch(Exception e){
			
		}
		
		return ResultMessage.SUCCESS;
	}

}
