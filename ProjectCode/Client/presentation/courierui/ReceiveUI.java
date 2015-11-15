package courierui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.BaseUI;

public class ReceiveUI extends JPanel {
	JButton receive;
	JList list;
	JLabel ordernumber;
	JLabel time;
	JLabel state;
	public ReceiveUI(){
		init();
	}
	
	private void init(){
        receive = new JButton("新增收件单");
        ordernumber=new JLabel("订单号");
        time=new JLabel("送达时间");
        state=new JLabel("收件人");
        
		this.setLayout(new BorderLayout());
		//容器
        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,receive,constraints,0,0,1,1);
		
		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,100);
		
		BaseUI.myAdd(lpanel,ordernumber,constraints,0,0,1,1);
		BaseUI.myAdd(lpanel,time,constraints,1,0,1,1);
		BaseUI.myAdd(lpanel,state,constraints,2,0,1,1);
		
		String nation[] ={"0000000001","0000000002","0000000003","0000000004"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
        this.add(bpanel,BorderLayout.WEST);
	}
}
