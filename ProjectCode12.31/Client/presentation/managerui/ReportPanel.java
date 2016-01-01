package managerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.sun.glass.ui.TouchInputSupport;

import dataserviceimpl.DataFactory;
import dateChoose.DateChooser;
import enums.ResultMessage;
import financesl.Balance;
import financesl.BalanceController;
import financeslservice.BalanceService;
import financeslservice.CostService;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import pamanagementsl.AManagementController;
import pamanagementslservice.AManagementService;
import po.PaymentPO;
import reportsl.Report;
import reportslservice.ReportService;
import twaver.TWaverUtil;
import twaver.base.A.E.b;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.AgencyVO;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.ReportVO;

public class ReportPanel {
	private static FreeTabbedPane tab;
	private static ReportService reportService;
	private static AManagementService aManagementService;
	public static ArrayList<AgencyVO>agencyVOs;
    private static String userId;

	public static FreePagePane createReportPage(FreeTabbedPane tab,String Id) {
	   userId=Id;
		// TODO Auto-generated method stub
		try {
			reportService=new Report(DataFactory.create(), new BalanceController());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			aManagementService = new AManagementController(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		agencyVOs = aManagementService.getAllAgency();
		ReportPanel.tab=tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("单据类型");
		model.addColumn("付款类型");
		model.addColumn("数额");
		model.addColumn("日期");
		model.addColumn("收款人/付款人");

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);

		FreeToolbarButton seek=createButton("/free/test/print.png", "获取经营情况表", true);
		page.getRightToolBar().add(seek);

		JLabel idNumber=new JLabel("营业厅编号");
		MaskFormatter maskWorkPlaceNumber = null;
		try {
			maskWorkPlaceNumber = new MaskFormatter("######");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		maskWorkPlaceNumber.setPlaceholderCharacter('0');
//		JFormattedTextField idNumberField=new JFormattedTextField(maskWorkPlaceNumber);
//	    idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);	
		JComboBox idNumberFiled = new JComboBox();
		for(AgencyVO vo : agencyVOs){
			idNumberFiled.addItem(vo.getName());
		}
		JLabel beginDate=new JLabel("开始");
		DateChooser beginDateFiled=new DateChooser(page,10);		
		JLabel overDate=new JLabel("结束");
		DateChooser overDateField=new DateChooser(page,10);
		FreeToolBar leftToolBar=page.getLeftToolBar();
		leftToolBar.add(idNumber);
		leftToolBar.add(idNumberFiled);
		leftToolBar.add(beginDate);
		leftToolBar.add(beginDateFiled);
		leftToolBar.add(overDate);
		leftToolBar.add(overDateField);

		ArrayList<PaymentVO>paymentVOs;
		ArrayList<ReceiptsVO>receiptsVOs;


		seek.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				ResultMessage resultMessage=ResultMessage.SUCCESS;
				ReportVO reportVO=null;
				ArrayList<PaymentVO>paymentVOs=null;
				ArrayList<ReceiptsVO>receiptsVOs=null;

				try {
					reportVO=reportService.addMessage(agencyVOs.get(idNumberFiled.getSelectedIndex()).getIdNumber(), beginDateFiled.getText(), overDateField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					resultMessage=ResultMessage.FAIL;
				}
				if(resultMessage==ResultMessage.FAIL){
					JOptionPane.showMessageDialog(null, "查找失败，请检查网络连接或者营业厅ID");
					return;
				}
				paymentVOs=reportVO.getPayList();
				receiptsVOs=reportVO.getIncomeList();
				page.setDescription("总收益: "+reportVO.getIncome() + "  总支出: "+reportVO.getPay() + "  总利润:  "+reportVO.getProfit());
				for(PaymentVO vo:paymentVOs){
					Vector row=new Vector();
					row.add("付款单");
					row.add(vo.getType());
					row.add(vo.getNumberOfPayment());
					row.add("-");
					row.add(vo.getReceiver());
					model.addRow(row);
				}
				for(ReceiptsVO vo:receiptsVOs){
					Vector row=new Vector();
					row.add("收款单");
					row.add("-");
					row.add(vo.getFee());
					row.add(vo.getDate());
					row.add(vo.getCourier());
					model.addRow(row);
				}
   	    	  LogService ls=new LogManagementController();
   	    	  ls.addMessage(userId, "统计报表");
			}
		});

		return page;
	}


	public static FreeToolbarButton createButton(String icon, String tooltip, boolean rover) {
		FreeToolbarButton button = null;
		if (rover) {
			button = new FreeToolbarRoverButton();
		} else {
			button = new FreeToolbarButton();
		}
		button.setIcon(TWaverUtil.getIcon(icon));
		button.setToolTipText(tooltip);

		return button;
	}

}