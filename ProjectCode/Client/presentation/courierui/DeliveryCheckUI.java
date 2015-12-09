package courierui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.BaseUI;

public class DeliveryCheckUI extends JPanel{
	JButton check;
	JList list;
	JLabel ordernumber;
	JLabel time;
	JLabel state;
	
	public DeliveryCheckUI(){
		init();
	}
	
	private void init(){
        check = new JButton("派件单查看");
        ordernumber=new JLabel("订单号");
        time=new JLabel("预期送达时间");
        state=new JLabel("运输状态");
        
		this.setLayout(new BorderLayout());
		//容器
		

        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,check,constraints,0,0,1,1);
		
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
        
        
        this.initAciton();
	}
	
	private void initAciton(){
		check.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
