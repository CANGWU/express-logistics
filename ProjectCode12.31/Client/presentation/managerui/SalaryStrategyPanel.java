package managerui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Work;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import strategysl.SalaryStrategy;
import strategysl.SalaryStrategyController;
import strategyslservice.SalaryStrategyService;
import twaver.TWaverUtil;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.SalaryVO;

public class SalaryStrategyPanel {
	private static FreeTabbedPane tab;
	private static SalaryStrategyService salaryStrategyService;
	private static FreeReportPage salaryReportPage;
	private static String userId;

	public static FreePagePane createSalaryStrategyPage(FreeTabbedPane tab,String id) {
		userId=id;
		try {
			salaryStrategyService=new SalaryStrategyController();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		SalaryStrategyPanel.tab=tab;
		return createReportPage();
	}
	
	public  void setSalaryStrategyService(SalaryStrategyService salaryStrategyService){
		this.salaryStrategyService=salaryStrategyService;
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("职位");
		model.addColumn("基本工资");
		model.addColumn("职位津贴");
		model.addColumn("职位提成");
		ArrayList<SalaryVO>salarys = null;
		ResultMessage resultMessage=null;
		
        try {
		salarys=salaryStrategyService.getSalaryStrategy();
		resultMessage=ResultMessage.SUCCESS;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultMessage=ResultMessage.FAIL;
		}
        if(resultMessage==ResultMessage.SUCCESS)
		for (SalaryVO vo:salarys) {
			Vector row = new Vector();
			row.add(vo.getWork());
			row.add(vo.getBaseWage());
			row.add(vo.getAllowance());
			row.add(vo.getCommission());
			model.addRow(row);
		}else
			JOptionPane.showMessageDialog(null, "查找失败");

		salaryReportPage = new FreeReportPage();
		salaryReportPage.getTable().setModel(model);
		salaryReportPage.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
		FreeToolbarButton makeSalary;
		makeSalary=createButton("/free/test/refresh.png", "增加/修改薪水策略", true);
		salaryReportPage.getRightToolBar().add(makeSalary);


		JLabel work=new JLabel("职位");
		JLabel baseWage=new JLabel("基本工资");
		JLabel allowance=new JLabel("职位津贴");
		JLabel commission=new JLabel("职位提成");
		JComboBox workCombo=new JComboBox();
		workCombo.addItem(Work.Courier);
		workCombo.addItem(Work.Officer);
		workCombo.addItem(Work.Finance);
		workCombo.addItem(Work.Manager);
		workCombo.addItem(Work.TransOffice);
		workCombo.addItem(Work.Stock);
		workCombo.addItem(Work.Admin);
		workCombo.addItem(Work.Driver);
		JTextField baseWageField=new JTextField(4);
		JTextField allowanceField=new JTextField(4);
		JTextField commissionField=new JTextField(4);
		
		FreeToolBar leftToolBar=salaryReportPage.getLeftToolBar();
		leftToolBar.add(work);
		leftToolBar.add(workCombo);
		leftToolBar.add(baseWage);
		leftToolBar.add(baseWageField);
		leftToolBar.add(allowance);
		leftToolBar.add(allowanceField);
		leftToolBar.add(commission);
		leftToolBar.add(commissionField);
		
		makeSalary.addMouseListener(new MouseListener() {

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
					
               SalaryVO vo = new SalaryVO();
               vo.setWork((Work) workCombo.getSelectedItem());
               vo.setBaseWage(Double.valueOf(baseWageField.getText()));
               vo.setAllowance(Double.valueOf(allowanceField.getText()));
               vo.setCommission(Double.valueOf(commissionField.getText()));
               ResultMessage resultMessage=null;
               try {
				resultMessage=salaryStrategyService.saveChange(vo);
				Work work;
				for(int i=0;i<model.getRowCount();i++){
					work = (Work) model.getValueAt(i, 0);
					if(work.equals(workCombo.getSelectedItem())){
						model.removeRow(i);
						Vector row = new Vector();
						row.add(vo.getWork());
						row.add(vo.getBaseWage());
						row.add(vo.getAllowance());
						row.add(vo.getCommission());
						model.insertRow(i-1, row);
						break;
					}
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resultMessage=ResultMessage.FAIL;
			}
               if(resultMessage==ResultMessage.SUCCESS){
            	   JOptionPane.showMessageDialog(null, "更改成功");
               }else{
            	   JOptionPane.showMessageDialog(null, "更改失败");
               }
               
  	    	  LogService ls=new LogManagementController();
  	    	  ls.addMessage(userId, "制定工资策略");
			}
		});
		
		

		return salaryReportPage;
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
