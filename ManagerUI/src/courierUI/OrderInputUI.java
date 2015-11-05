package courierUI;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.BaseUI;

public class OrderInputUI extends JPanel{
	JButton newOrder;
	JButton orderCheck;
	JList list;
	JLabel ordernumber;
	JLabel time;
	JLabel state;
	
	public OrderInputUI(){
		init();
	}
	
	private void init(){
        newOrder = new JButton("新增订单");
        orderCheck=new JButton("订单查看");
        ordernumber=new JLabel("订单号");
        time=new JLabel("收货时间");
        state=new JLabel("运输状态");
        
        

		this.setLayout(new BorderLayout());
		//容器
		

        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,newOrder,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel, orderCheck, constraints, 0, 1, 1, 1);
		
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
        
        this.initAction();
        
	}
	
	private void initAction(){
		newOrder.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				OrderDialog dialog=new OrderDialog();
			}
			
		});
	}
       
}


class OrderDialog extends JDialog{
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14,j15,j16,j17,j18,j19,j20,totalfee,change,ordernumber,dueofreceive,due;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15,jtf18;
    GridBagLayout g;
    GridBagConstraints c;
    JButton computefee,end;
    JComboBox expresstype;
    
    public OrderDialog(){
    	this.initLayout();
    	this.initJLabel();
        this.initJTextField();
        this.initJButton();
        this.initJComboBox();
    	//this.initJTextField();
    	//this.initJButton();
    	//this.initJComboBox();
    	this.setModal(true);
    	this.pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((screenSize.width-this.getWidth())/2, (screenSize.height-this.getHeight())/2, this.getWidth(), this.getHeight());
        
        this.setResizable(false);
    	this.setVisible(true);
    }
    
    public void initLayout(){
    	g=new GridBagLayout();
        c=new GridBagConstraints();
    	this.setLayout(g);
    }
    
    public void initJLabel(){
        j1=new JLabel("寄件人姓名");
        j2=new JLabel("寄件人住址");
        j3=new JLabel("寄件人单位");
        j4=new JLabel("寄件人电话");
        j5=new JLabel("寄件人手机");
        j6=new JLabel("收件人姓名");
        j7=new JLabel("收件人住址");
        j8=new JLabel("收件人单位");
        j9=new JLabel("收件人电话");
        j10=new JLabel("收件人手机");
        j11=new JLabel("货物件数");
        j12=new JLabel("货物重量");
        j13=new JLabel("货物体积");
        j14=new JLabel("货物名称");
        j15=new JLabel("货物尺寸");
        j16=new JLabel("快递类型");
        j17=new JLabel("应收金额");
        j18=new JLabel("实收金额");
        j19=new JLabel("找零金额");
        j20=new JLabel("订单号码");
    	dueofreceive=new JLabel("预计到达日期：");
    	
        
 

        this.add(g,c,j1,0,1,1,1);
        this.add(g,c,j2,0,2,1,1);
        this.add(g,c,j3,0,3,1,1);
        this.add(g,c,j4,0,4,1,1);
        this.add(g,c,j5,0,5,1,1);
        this.add(g,c,j6,2,1,1,1);
        this.add(g,c,j7,2,2,1,1);
        this.add(g,c,j8,2,3,1,1);
        this.add(g,c,j9,2,4,1,1);
        this.add(g,c,j10,2,5,1,1);
        this.add(g,c,j11,0,6,1,1);
        this.add(g,c,j12,0,7,1,1);
        this.add(g,c,j13,0,8,1,1);
        this.add(g,c,j14,0,9,1,1);
        this.add(g,c,j15,0,10,1,1);
        this.add(g,c,j16,2,6,1,1);
        this.add(g,c,j17,2,7,1,1);
        this.add(g,c,j18,2,8,1,1);
        this.add(g,c,j19,2,9,1,1);
        this.add(g,c,j20,2,10,1,1);
    	this.add(g,c,dueofreceive,2,11,1,1);
        
    }
    
    public void initJTextField(){
    	jtf1=new JTextField(20);
    	jtf2=new JTextField(20);
    	jtf3=new JTextField(20);
    	jtf4=new JTextField(20);
    	jtf5=new JTextField(20);
    	jtf6=new JTextField(20);
    	jtf7=new JTextField(20);
    	jtf8=new JTextField(20);
    	jtf9=new JTextField(20);
    	jtf10=new JTextField(20);
    	jtf11=new JTextField(20);
    	jtf12=new JTextField(20);
    	jtf13=new JTextField(20);
    	jtf14=new JTextField(20);
    	jtf15=new JTextField(20);
    	jtf18=new JTextField(20);

       	this.add(g,c,jtf1,1,1,1,1);
      	this.add(g,c,jtf2,1,2,1,1);
      	this.add(g,c,jtf3,1,3,1,1);
      	this.add(g,c,jtf4,1,4,1,1);
      	this.add(g,c,jtf5,1,5,1,1);
      	this.add(g,c,jtf6,3,1,1,1);
      	this.add(g,c,jtf7,3,2,1,1);
      	this.add(g,c,jtf8,3,3,1,1);
      	this.add(g,c,jtf9,3,4,1,1);
      	this.add(g,c,jtf10,3,5,1,1);
      	this.add(g,c,jtf11,1,6,1,1);
      	this.add(g,c,jtf12,1,7,1,1);
      	this.add(g,c,jtf13,1,8,1,1);
      	this.add(g,c,jtf14,1,9,1,1);
      	this.add(g,c,jtf15,1,10,1,1);
      	this.add(g,c,jtf18,3,8,1,1);

       	
    }
    public void initJButton(){
    	computefee=new JButton("确定");
    	end=new JButton("取消");   	
    	
    	this.add(g,c,computefee,3,12,1,1);
    	this.add(g,c,end,3,13,1,1);
    }	
    
    public void initJComboBox(){
    	String[] typeOfExpress={"经济快递","标准快递","特快"};
    	expresstype=new JComboBox(typeOfExpress);
    	
    	this.add(g,c,expresstype,3,6,1,1);
    	
    	
    }
    
    public void add(GridBagLayout g,GridBagConstraints c,JComponent jc,int x ,int y,int gw,int gh)
    {
    c.gridx=x;
    c.gridy=y;
    c.anchor=GridBagConstraints.WEST;
    c.gridwidth=gw;
    c.gridheight=gh;
    g.setConstraints(jc,c);
    add(jc);
    }
        
}
