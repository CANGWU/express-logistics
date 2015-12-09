package financesl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptsPO;
import dataservice.SendDataService;
import dataserviceimpl.DataFactory;
import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class Balance {
	
	static Balance balance;
	 DataFactory datafactory;
	
	private Balance(){
		try {
			this.datafactory=DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime,String office) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	public ArrayList<ReceiptsVO> getBalanceMessage(String date, String office) {
		// TODO Auto-generated method stub
		SendDataService sds=datafactory.getSendData();
		ArrayList<ReceiptsPO> polist=null;
		try {
			polist = sds.findReceipts(date, office);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ReceiptsVO> volist=new ArrayList<ReceiptsVO>();
		
		for(int i=0;i<polist.size();i++){
			volist.add(new ReceiptsVO(polist.get(i)));
		}
		
		return null;
	}


	public double getTotalMoney(ArrayList<ReceiptsVO> list) {
		// TODO Auto-generated method stub
		double totalMoney=0.0;
		
		for(int i=0;i<list.size();i++){
			totalMoney+=list.get(i).getFee();
		}
		return totalMoney;
	}
	
	
	public static Balance createBalance(){
		if(balance==null){
			balance=new Balance();
		}
		
		return balance;
	}

}
