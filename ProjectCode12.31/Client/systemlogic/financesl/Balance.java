package financesl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import po.ReceiptsPO;
import dataservice.SendDataService;
import dataserviceimpl.DataFactory;
import vo.ReceiptsVO;
import financeslservice.BalanceService;

public class Balance {

	static Balance balance;
	DataFactory datafactory;

	private Balance() {
		try {
			this.datafactory = DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	public ArrayList<ReceiptsVO> getBalanceMessage(String starttime,
			String endtime, String office) {

		SendDataService sds = datafactory.getSendData();
		ArrayList<ReceiptsVO> volist = new ArrayList<ReceiptsVO>();
		ArrayList<ReceiptsPO> polist = new ArrayList<ReceiptsPO>();

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			start.setTime(sdf.parse(starttime));
			end.setTime(sdf.parse(endtime));

			for (Calendar date = start; !date.after(end); date.add(
					Calendar.DATE, 1)) {
				polist = sds.findReceipts(date.toString(), office);
				for (Iterator<ReceiptsPO> i = polist.iterator(); i.hasNext();)
					volist.add(new ReceiptsVO(i.next()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return volist;
	}

	public ArrayList<ReceiptsVO> getBalanceMessage(String date, String office) {
		// TODO Auto-generated method stub
		SendDataService sds = datafactory.getSendData();
		ArrayList<ReceiptsPO> polist = null;
		try {
			polist = sds.findReceipts(date, office);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ReceiptsVO> volist = new ArrayList<ReceiptsVO>();

		for (int i = 0; i < polist.size(); i++) {
			volist.add(new ReceiptsVO(polist.get(i)));
		}

		return volist;
	}

	public double getTotalMoney(ArrayList<ReceiptsVO> list) {
		// TODO Auto-generated method stub
		double totalMoney = 0.0;

		for (int i = 0; i < list.size(); i++) {
			totalMoney += list.get(i).getFee();
		}
		return totalMoney;
	}

	public static Balance createBalance() {
		if (balance == null) {
			balance = new Balance();
		}

		return balance;
	}

}
