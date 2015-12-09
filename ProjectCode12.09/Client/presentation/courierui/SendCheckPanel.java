package courierui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import dataserviceimpl.DataFactory;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import receivesl.Deliver;
import receivesl.Receive;
import twaver.TWaverUtil;
import vo.DeliverVO;
import vo.OrderVO;

public class SendCheckPanel {
    public static FreeReportPage createReportPage(String courierId) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("快递单号");
        model.addColumn("收件人姓名");
        model.addColumn("收件人地址");
        model.addColumn("收件人单位");
        model.addColumn("收件人电话");
        model.addColumn("收件人手机");
        
        Deliver dc=new Deliver();
        Receive rc=new Receive();
        try {
			DeliverVO delivervo=dc.getDeliver(courierId);
			ArrayList<OrderVO> orderlist=new ArrayList<OrderVO>();
			for(int i=0;i<delivervo.getOrder().size();i++){
				orderlist.add(rc.getOrder(delivervo.getOrder().get(i)));
			}
			
	        for (int i = 0; i < orderlist.size(); i++) {
	            Vector row = new Vector();
	            row.add(orderlist.get(i).getOrdernumber());
	            row.add(orderlist.get(i).getReceiver().getName());
	            row.add(orderlist.get(i).getReceiver().getAddress());
	            row.add(orderlist.get(i).getReceiver().getWorkPlace());
	            row.add(orderlist.get(i).getReceiver().getPhoneNumber());
	            row.add(orderlist.get(i).getReceiver().getTelNumber());
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
//  	  FreeToolbarButton addUser,deleteUser,fixUser,seekUser;
//  	  addUser=createButton("/free/test/add.png", "增加用户", true);
//        deleteUser=createButton("/free/test/update.png", "删除用户", true);
//        fixUser=createButton("/free/test/refresh.png", "修改用户", true);
//        seekUser=createButton("/free/test/print.png", "查找用户", true);
//        page.getRightToolBar().add(addUser);
//        page.getRightToolBar().add(deleteUser);
//        page.getRightToolBar().add(fixUser);
//        page.getRightToolBar().add(seekUser);
//        

        
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
