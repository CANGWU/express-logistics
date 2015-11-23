package checksl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import po.LogisticsPO;
import dataservice.CheckDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import usersl.LogList;
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
	    po=checkdata.find(ordernumber);
		vo=this.changePO(po);
		
		this.log();

		
		return vo;		
	}
	
	
	public void log(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		LogList loglist=LogList.creatLogList(datafactory);
		
		ResultMessage message=loglist.logCreate(time, null, null, "ÎïÁ÷²éÑ¯");
	}
	
	
	public LogisticsVO changePO(LogisticsPO po){
		LogisticsVO tempVo=new LogisticsVO(po.getOrdernumber());
		for(int i=0;i<po.getLogisticsMessage().size();i++){
			tempVo.addMessage(po.getLogisticsMessage().get(i));
		}
		
		return tempVo;
		
	}
	
	public static Check creatCheck(DataFactory datafactory){
		if(check==null)
			check = new Check(datafactory);	
		
		 return check;
	}

}
