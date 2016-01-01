package managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.ui.TouchInputSupport;

import dataserviceimpl.DataFactory;
import dateChoose.DateChooser;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import pamanagementsl.AManagementController;
import pamanagementslservice.AManagementService;
import po.LogPO;
import twaver.TWaverUtil;
import usersl.LogManagement;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.AgencyVO;
import vo.LogVO;

public class LogPanel {
	public static FreeTabbedPane tab;
	public static LogService logService;
	public static AManagementService aManagementService;
	public static ArrayList<AgencyVO>agencyVOs;
    public static String userId;

	public static FreePagePane createLogPage(FreeTabbedPane tab,String Id) {
        userId=Id;
			logService=LogManagement.creatCheck();

		LogPanel.tab=tab;
		try {
			aManagementService = new AManagementController(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		agencyVOs = aManagementService.getAllAgency();
		// TODO Auto-generated method stub
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("操作时间");
		model.addColumn("操作地址");
		model.addColumn("操作账户");
		model.addColumn("操作内容");

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
		FreeToolbarButton checkLog;
		checkLog=createButton("/free/test/print.png", "查询日志", true);
		page.getRightToolBar().add(checkLog);
		JLabel time=new JLabel("时间");
//		JTextField timeField=new JTextField(10);
		DateChooser timeField = new DateChooser(page,10);
		JLabel office=new JLabel("操作地址");
//		JTextField officeFiled=new JTextField(9);
		JComboBox officeFiled = new JComboBox();
		for(AgencyVO vo : agencyVOs){
			officeFiled.addItem(vo.getName());
		}

		FreeToolBar leftToolBar=page.getLeftToolBar();
		leftToolBar.add(time);
		leftToolBar.add(timeField);
		leftToolBar.add(office);
		leftToolBar.add(officeFiled);
		checkLog.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				while(model.getRowCount()>0){
					model.removeRow(model.getRowCount()-1);
					}
            ArrayList<LogVO>logs=logService.logmessage(agencyVOs.get(officeFiled.getSelectedIndex()).getIdNumber(), timeField.getText());
            for(LogVO vo:logs){
            	Vector row=new Vector();
            	row.add(vo.getTime());
            	row.add(vo.getOffice());
            	row.add(vo.getUseuId());
            	row.add(vo.getLogmessage());
            	model.addRow(row);
            }
	    	  LogService ls=new LogManagementController();
	    	  ls.addMessage(userId, "日志查看");
			}
		});


		return page;
	}

//	public static void setupPageToolbar(FreePagePane page) {
//		FreeToolbarButton checkLog;
//		checkLog=createButton("/free/test/print.png", "查询日志", true);
//		page.getRightToolBar().add(checkLog);
//		JLabel time=new JLabel("时间");
//		JTextField timeField=new JTextField(10);
//		JLabel office=new JLabel("操作地址");
//		JTextField officeFiledFiled=new JTextField(9);
//
//		FreeToolBar leftToolBar=page.getLeftToolBar();
//		leftToolBar.add(time);
//		leftToolBar.add(timeField);
//		leftToolBar.add(office);
//		leftToolBar.add(officeFiledFiled);
//		checkLog.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//
//	}

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
