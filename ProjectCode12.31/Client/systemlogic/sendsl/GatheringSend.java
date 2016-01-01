package sendsl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import pamanagementsl.PManagementController;
import po.OrderPO;
import po.ReceiptsPO;
import po.StaffPO;
import dataservice.DataFactoryService;
import dataservice.PManagementDataService;
import dataservice.SendDataService;
import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.ResultMessage;
import enums.Work;
import vo.ReceiptsVO;
import vo.StaffVO;

public class GatheringSend {

	private DataFactoryService datafactory;
	private PManagementDataService pData;
	private SendDataService sendData;

	public GatheringSend() {
		try {
			datafactory = DataFactory.create();
			pData = datafactory.getPManagementData();
			sendData = datafactory.getSendData();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ReceiptsVO> newReceipts(String date, String workplace)
			throws RemoteException {

		ArrayList<String> ordernumbers;
		double fee;

		ArrayList<ReceiptsVO> vos = new ArrayList<ReceiptsVO>();
		ArrayList<ReceiptsPO> pos = new ArrayList<ReceiptsPO>();
		ArrayList<OrderPO> Orders = new ArrayList<OrderPO>();
		ArrayList<String> couriers = new ArrayList<String>();

		ArrayList<StaffPO> members = pData.findMember(Work.Courier, workplace);
		for (Iterator<StaffPO> i = members.iterator(); i.hasNext();)
			couriers.add(i.next().getWorkNumber());

		for (int i = 0; i < couriers.size(); i++) {

			ordernumbers = new ArrayList<String>();
			fee = 0;
			Orders = sendData.findForGathering(couriers.get(i), date);

			for (int j = 0; j < Orders.size(); j++) {
				ordernumbers.add(Orders.get(j).getOrdernumber());
				fee = fee + Orders.get(j).getBill().getTotalfee();
			}

			PManagementController pmc = new PManagementController();
			StaffVO tempvo = pmc.select(couriers.get(i));

			ReceiptsVO vo = new ReceiptsVO(date, fee, couriers.get(i),
					ordernumbers, tempvo.getWorkPlaceNumber(),
					DocumentCondition.handing);
			vos.add(vo);

			ReceiptsPO po = new ReceiptsPO(date, fee, couriers.get(i),
					ordernumbers, tempvo.getWorkPlaceNumber(),
					DocumentCondition.handing);
			pos.add(po);
		}

		for (Iterator<ReceiptsPO> k = pos.iterator(); k.hasNext();)
			sendData.insertReceiptsPO(k.next());

		return vos;
	}

	public ReceiptsVO findReceipt(String Date, String courier)
			throws RemoteException {
		ReceiptsPO po = sendData.findReceipt(Date, courier);
		ReceiptsVO vo = new ReceiptsVO(po.getDate(), po.getFee(),
				po.getCourier(), po.getOrdernumbers(), po.getOffice(),
				po.getdCondition());
		return vo;
	}

	public ArrayList<ReceiptsVO> findReceipts(String Date, String office) {
		ArrayList<ReceiptsVO> voList = new ArrayList<ReceiptsVO>();
		try {
			ArrayList<ReceiptsPO> poList = sendData.findReceipts(Date, office);
			ReceiptsPO po;
			for (Iterator<ReceiptsPO> i = poList.iterator(); i.hasNext();) {
				po = i.next();
				voList.add(new ReceiptsVO(po.getDate(), po.getFee(), po
						.getCourier(), po.getOrdernumbers(), po.getOffice(), po
						.getdCondition()));
			}
		} catch (RemoteException e) {
		}
		return voList;
	}

	public ResultMessage updateReceipts(ReceiptsVO vo) throws RemoteException {
		ReceiptsPO po = new ReceiptsPO(vo.getDate(), vo.getFee(),
				vo.getCourier(), vo.getOrdernumbers(), vo.getOffice(),
				vo.getdCondition());
		return sendData.updateReceiptsPO(po);
	}

	public ResultMessage deleteReceipts(String Date, String courier)
			throws RemoteException {
		return sendData.deleteReceiptsPO(Date, courier);
	}
}
