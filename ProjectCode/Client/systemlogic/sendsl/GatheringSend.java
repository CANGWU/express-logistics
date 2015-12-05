package sendsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import po.ReceiptsPO;
import dataservice.DataFactoryService;
import vo.ReceiptsVO;

public class GatheringSend {
	
	private DataFactoryService Data;
	private getCouriers getCouriers;
	private String Code;
	
	public GatheringSend(DataFactoryService d,getCouriers c,String code){
		Data = d;
		getCouriers = c;
		Code = code;
	}


	public ArrayList<ReceiptsVO> receiptsNew(String Date) {
		// TODO Auto-generated method stub
		
		ArrayList<String> ordernumbers;
		double fee;
		
		ArrayList<ReceiptsVO> vos = new ArrayList<ReceiptsVO>();
		ArrayList<ReceiptsPO> pos = new ArrayList<ReceiptsPO>();
		ArrayList<OrderPO> Orders ;
		ArrayList<String> couriers = getCouriers.getCouriers(Code);
		for(int i = 0;i<couriers.size();i++){
			
			ordernumbers = new ArrayList<String>();
			fee = 0;
			
			try {
				Orders = Data.getSendData().findForGathering(couriers.get(i), Date);
			
			for(int j = 0;j<Orders.size();j++){
				ordernumbers.add(Orders.get(j).getOrdernumber());
				fee= fee + Orders.get(j).getBill().getTotalfee();
			}
			
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ReceiptsVO vo = new ReceiptsVO(Date,fee,couriers.get(i),(String[])ordernumbers.toArray());
			vos.add(vo);
			
			ReceiptsPO po = new ReceiptsPO(Date,fee,couriers.get(i),ordernumbers);				
			pos.add(po);
			

			
		}
		for(int i =0;i<pos.size();i++){
			
			try {
				Data.getSendData().insertReceiptsPO(pos.get(i));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vos;
	}

}
