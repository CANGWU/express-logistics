package presentation;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import sendsl.*;
import sendslservice.OrderInputCheckMessage;
import vo.*;

public class OrderView extends JPanel {
    JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12,j13,j14,j15,j16,j17,j18,j19,j20,totalfee,change,ordernumber,dueofreceive,due;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9,jtf10,jtf11,jtf12,jtf13,jtf14,jtf15,jtf18;
    JButton computefee,end;
    JComboBox expresstype;
    OrderVO order;
    BillVO bill;
    GridBagLayout g;
    GridBagConstraints c;
    Send send=new Send();
    OrderInputCheckMessage message;
    JFrame frame;
    
    public OrderView(JFrame frame){
    	this.setSize(800, 600);
    	this.initLayout();
    	this.initJLabel();
    	this.initJTextField();
    	this.initJButton();
    	this.initJComboBox();
    	this.setVisible(true);
    	this.frame=frame;
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
    	computefee=new JButton("计算所需费用");
    	end=new JButton("取消");   	
    	
    	this.add(g,c,computefee,3,12,1,1);
    	this.add(g,c,end,3,13,1,1);
    	
    	computefee.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				  if(computefee.getText().equals("计算所需费用")){
					  computeFee();
				  }else{
					  if(computefee.getText().equals("确认收款")){
						  computeChange();
					  }else{
						  if(computefee.getText().equals("完成订单输入")){
							  end();
							  frame.dispose();
						  }
					  }
				  }
			}
    		
    	});
    	end.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
                  frame.dispose();
			}
    		
    	});
    }
    
    public void initJComboBox(){
    	String[] typeOfExpress={"经济快递","标准快递","特快"};
    	expresstype=new JComboBox(typeOfExpress);
    	
    	this.add(g,c,expresstype,3,6,1,1);
    	
    	
    }
    
    
    
  
    
    public void computeFee(){
    	String[] list=new String[16];
    	list[0]=jtf1.getText();
    	list[1]=jtf2.getText();
    	list[2]=jtf3.getText();
    	list[3]=jtf4.getText();
    	list[4]=jtf5.getText();
    	list[5]=jtf6.getText();
    	list[6]=jtf7.getText();
    	list[7]=jtf8.getText();
    	list[8]=jtf9.getText();
    	list[9]=jtf10.getText();
    	list[10]=jtf11.getText();
    	list[11]=jtf12.getText();
    	list[12]=jtf13.getText();
    	list[13]=jtf14.getText();
    	list[14]=jtf15.getText();
    	list[15]= expresstype.getSelectedItem().toString();
    	
    	message=send.inputcheck(list);
    	System.out.println("hh");
    	System.out.println(message);
    	switch(message){
    	    case SUCCESS:
    	    	order=send.calculate(list);
    	    	bill=send.setBill(order);
    	    	totalfee=new JLabel(""+bill.getTotalfee());
    	    	this.add(g,c,totalfee,3,7,1,1);
    	 
    	    	due=new JLabel(send.computedue(order));   	
    	        this.add(g,c,due,3,11,1,1);
    	        
    	    	order.setDueOfReceive(due.getText());
    	    	computefee.setText("确认收款");
    	    	this.repaint();
    	    	break;
    	    case WRONG_NAME:
    	    	JOptionPane.showMessageDialog(null, "寄件人、收件人姓名不能为空","寄件人、收件人姓名不能为空",JOptionPane.ERROR_MESSAGE);
    	    	break;
    	    case WRONG_TEL:
    	    	JOptionPane.showMessageDialog(null, "请输入正确的11位电话号码（3位区号+8位号码）","请输入正确的11位电话号码（3位区号+8位号码）",JOptionPane.ERROR_MESSAGE);
    	    	break;
    	    case WRONG_PHONE:
    	    	JOptionPane.showMessageDialog(null, "请输入正确的11位手机号码","请输入正确的11位手机号码",JOptionPane.ERROR_MESSAGE);
    	    	break;
    	    case WRONG_NUM:
    	    	JOptionPane.showMessageDialog(null, "请输入数字形式的货物数目、重量和体积","请输入数字形式的货物数目、重量和体积",JOptionPane.ERROR_MESSAGE);
    	    	break;
    	}
    	
    	
    	


    }
    
    public void computeChange(){
    	double cash=0.0;
    	try{
    		       cash=Double.parseDouble(jtf18.getText());
    		    	bill=send.getchange(cash, bill);
    		    	if(bill.getChange()>=0){
    		        	change=new JLabel(""+bill.getChange());
    		        	this.add(g,c,change,3,9,1,1);
    		        	ordernumber=new JLabel(send.computeOrdernumber());
    		        	order.setOrdernumber(ordernumber.getText());
    		        	this.add(g,c,ordernumber,3,10,1,1);
    		        	computefee.setText("完成订单输入");
    		        	this.remove(end);
    		        	this.repaint();
    		    	}else{
    			    	JOptionPane.showMessageDialog(null, "所收现金不足","所收现金不足",JOptionPane.ERROR_MESSAGE);
   		    	}
    	}catch(Exception e){
    		JOptionPane.showMessageDialog(null, "请输入正确的所收金额","请输入正确的所收",JOptionPane.ERROR_MESSAGE);
    	}


    	


    	
    	

    }
    
    public void end(){
    	send.orderend(bill, order);
    	JOptionPane.showMessageDialog(null, "订单成功输入");
 
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
