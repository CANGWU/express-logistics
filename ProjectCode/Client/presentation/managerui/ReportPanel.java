package managerui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.sun.glass.ui.TouchInputSupport;

import enums.ResultMessage;
import financeslservice.BalanceService;
import financeslservice.CostService;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import po.PaymentPO;
import reportslservice.ReportService;
import twaver.TWaverUtil;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.ReportVO;

public class ReportPanel {
	private static FreeTabbedPane tab;
	private static ReportService reportService;

	public static FreePagePane createReportPage(FreeTabbedPane tab) {
		// TODO Auto-generated method stub
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
        page.setDescription("总收益：                        " + "总支出：                      " + "总利润：                           ");
        
        FreeToolbarButton seek=createButton("/free/test/print.png", "获取经营情况表", true);
        page.getRightToolBar().add(seek);
        
        JLabel idNumber=new JLabel("营业厅编号");
        JTextField idNumberField=new JTextField(6);
        JLabel beginDate=new JLabel("开始时间");
        JTextField beginDateFiled=new JTextField(10);
        JLabel overDate=new JLabel("结束时间");
        JTextField overDateFiled=new JTextField(10);
        FreeToolBar leftToolBar=page.getLeftToolBar();
        leftToolBar.add(idNumber);
        leftToolBar.add(idNumberField);
        leftToolBar.add(beginDate);
        leftToolBar.add(beginDateFiled);
        leftToolBar.add(overDate);
        leftToolBar.add(overDateFiled);
        
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
				try {
					reportVO=reportService.addMessage(idNumberField.getText(), idNumberField.getText(), idNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					resultMessage=ResultMessage.FAIL;
				}
				//paymentVOs=reportVO.getPayList();
				
				
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