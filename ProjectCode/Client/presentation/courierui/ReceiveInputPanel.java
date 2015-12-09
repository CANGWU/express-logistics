package courierui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dataserviceimpl.DataFactory;
import receivesl.Receive;
import free.BaseUI;

public class ReceiveInputPanel extends JPanel{
	
	public static JTabbedPane tab;
	

	public static ReceiveInputPanel  createOrderInputPanel(JTabbedPane tab){
	    MaskFormatter orderformatter=null;
		try {
			orderformatter = new MaskFormatter("###########");
		    orderformatter.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ReceiveInputPanel panel=new ReceiveInputPanel();
		
		JLabel orderNumber=new JLabel("收件编号（订单号）：");
	    JFormattedTextField orderNumberfie = new JFormattedTextField(orderformatter);
		
		JLabel receiverName=new JLabel("收件人姓名：");
		JTextField receiverNamefie=new JTextField(20);
		
		JLabel receivedate=new JLabel("收件日期：");
		JTextField receivedatefie=new JTextField(20);
	    Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	    String timeOfReceive=sdf.format(dt); 
	    receivedatefie.setText(timeOfReceive);
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(10,0,10,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,orderNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,orderNumberfie,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,receiverName,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,receiverNamefie,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,receivedate,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,receivedatefie,constraints,1,2,1,1);
		
		JButton submit=new JButton("确定");
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
		    	if(orderNumberfie.equals("000000000")||receiverNamefie.getText().equals("")||receivedatefie.equals("")){
		    		  JOptionPane.showMessageDialog(null, "请输入收件完整信息");
		    	}else{
		    		Receive rc=new Receive();
		    		try {
						rc.addExpress(receiverNamefie.getText(), receivedatefie.getText(), orderNumberfie.getText());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }
		});    
		
		
		BaseUI.myAdd(bpanel,submit,constraints,0,3,1,1);

	    
		panel.add(bpanel);
		
		
		
		
		return panel;
		
	}

}
