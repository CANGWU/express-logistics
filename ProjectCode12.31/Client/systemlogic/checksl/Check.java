package checksl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.LogisticsPO;
import dataservice.CheckDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import vo.LogisticsVO;

public class Check {
	static Check check;
	DataFactory datafactory;
	LogisticsVO vo;
	LogisticsPO po;
	
	
	private Check(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	
	public LogisticsVO orderNumberCheck(String ordernumber){
		
		CheckDataService checkdata=datafactory.getCheckData();
	    try {
			po=checkdata.find(ordernumber);
			vo=new LogisticsVO(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		

		
		return vo;		
	}
	
	public ResultMessage add(LogisticsVO vo){
		CheckDataService checkdata=datafactory.getCheckData();
		
		LogisticsPO PO=new LogisticsPO(vo);
		
		try {
			return checkdata.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
	}
	
	public ResultMessage update(LogisticsVO vo){
		CheckDataService checkdata=datafactory.getCheckData();
		
		LogisticsPO PO=new LogisticsPO(vo);
		try {
			return checkdata.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	
//	public void log(){
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String time=format.format(date);
//		
//		LogList loglist=LogList.creatLogList(datafactory);
//		
//		ResultMessage message=loglist.logCreate(time, null, null, "ÎïÁ÷²éÑ¯");
//	}
	
	

	
	public static Check creatCheck(DataFactory datafactory){
		if(check==null)
			check = new Check(datafactory);	
		
		 return check;
	}

}
