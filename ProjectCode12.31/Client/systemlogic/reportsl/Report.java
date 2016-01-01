package reportsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import pamanagementsl.PManagementController;
import po.PaymentPO;
import po.StaffPO;
import reportslservice.ReportService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import financeslservice.BalanceService;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.ReportVO;
import vo.StaffVO;

public class Report implements ReportService {
	DataFactoryService dataFactory;
	FinanceDataService financeData;
	BalanceService balance;

	public Report(DataFactoryService DataFactory, BalanceService balance) {
		this.dataFactory = dataFactory;
		try {
			financeData = dataFactory.getFinanceData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.balance = balance;
	}

	@Override
	public ReportVO addMessage(String id, String beginTime, String endTime) {
		ReportVO reportvo = new ReportVO(id, beginTime, endTime);
		reportvo.setIncomeList(balance
				.getBalanceMessage(id, beginTime, endTime));

		ArrayList<PaymentPO> paymentpolist=null;
		try {
			paymentpolist = financeData.findsPaymentPO(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<PaymentVO> paymentvolist = new ArrayList<PaymentVO>();
		PaymentPO paymentpo;
		PaymentVO paymentvo;
		String receiverpo;

		for (int i = 0; i < paymentpolist.size(); i++) {
			paymentpo = paymentpolist.get(i);
			receiverpo = paymentpo.getReceiver();
			PManagementController pmc=new PManagementController();
			
			paymentvo = new PaymentVO(receiverpo, paymentpo.getType());
			paymentvo.setAccountname(paymentpo.getAccountname());
			paymentvo.setNumberOfPayment(paymentpo.getNumberOfPayment());
			reportvo.getPayList().add(paymentvo);
		}
		return reportvo;
	}

	@Override
	public void caculate(ReportVO reportvo) {
		long income = 0;
		long pay = 0;
		long profit = income - pay;
		ArrayList<PaymentVO> paymentvolist = reportvo.getPayList();
		ArrayList<ReceiptsVO> receiptsvolist = reportvo.getIncomeList();
		for (int i = 0; i < paymentvolist.size(); i++)
			pay += paymentvolist.get(i).getNumberOfPayment();
		for (int i = 0; i < receiptsvolist.size(); i++)
			income += receiptsvolist.get(i).getFee();
		reportvo.setIncome(income);
		reportvo.setPay(pay);
		reportvo.setProfit(profit);
	}

	@Override
	public void exportReport(ReportVO reportvo) {

	}

	@Override
	public void printReport(ReportVO reportvo) {

	}

	@Override
	public void endReport() {

	}

}
