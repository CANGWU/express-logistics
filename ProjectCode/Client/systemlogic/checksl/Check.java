package checksl;

import po.LogisticsPO;
import data.DataFactory;
import dataservice.CheckDataService;
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
		
		return vo;		
	}
	
	
	public LogisticsVO changePO(LogisticsPO po){
		LogisticsVO tempVo=new LogisticsVO(po.getOrdernumber());
		for(int i=0;i<po.getLogisticsMessage().size();i++){
			tempVo.addMessage(po.getLogisticsMessage().get(i));
		}
		
		return tempVo;
		
	}
	
	static Check creatCheck(DataFactory datafactory){
		if(check==null)
			check = new Check(datafactory);	
		
		 return check;
	}

}
