package checkui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import checksl.CheckController;
import checkslservice.CheckService;
import dataserviceimpl.DataFactory;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import receivesl.Deliver;
import receivesl.Receive;
import twaver.TWaverUtil;
import vo.DeliverVO;
import vo.LogisticsVO;
import vo.OrderVO;

public class LogisticsPanel {
    public static FreeReportPage createReportPage(String ordernumber) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("历史物流信息");
 
        

        try {
        	CheckService cc=new CheckController(DataFactory.create());
            LogisticsVO logistics=cc.orderNumberCheck(ordernumber);

			
	        for (int i = 0; i < logistics.getLogisticsMessage().size(); i++) {
	            Vector row = new Vector();
	            row.add(logistics.getLogisticsMessage().get(i));
	            model.addRow(row);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}




        FreeReportPage page = new FreeReportPage();
        page.getTable().setModel(model);
        page.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
        setupPageToolbar(page);

        return page;
    }
    public static void setupPageToolbar(FreePagePane page) {


        
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
