 package courierui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import sendsl.SendController;
import sendslservice.SendService;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.BillVO;
import vo.OrderVO;
import enums.DocumentCondition;
import enums.Packing;
import free.BaseUI;
import free.FreePagePane;
import free.FreeUtil;

public class OrderInputPanel extends JPanel{
	
	public static JTabbedPane tab;
	private static  OrderVO ordervo=null;
	private static  BillVO billvo=null;
	private static  SendService sc=null;
	private static ArrayList<String> packstrlist=new ArrayList<String>();
	private static ArrayList<Packing> packlist=new ArrayList<Packing>();
	private static ArrayList<String> citieslist=new ArrayList<String>();
	private static ArrayList<String> expresstypelist=new ArrayList<String>();

	

	

	
	public static OrderInputPanel  createOrderInputPanel(String courierId){
		packstrlist.add("纸箱");
		packstrlist.add("木箱");
		packstrlist.add("快递袋");
		
		packlist.add(Packing.Carton);
		packlist.add(Packing.Wood);
		packlist.add(Packing.Bag);
		
		citieslist.add("北京市");
		citieslist.add("上海市");
		citieslist.add("广州市");
		citieslist.add("南京市");
		
		expresstypelist.add("经济快递");
		expresstypelist.add("标准快递");
		expresstypelist.add("特快");
		
		
	    MaskFormatter mobilephoneformatter=null;
		try {
			mobilephoneformatter = new MaskFormatter("###########");
		    mobilephoneformatter.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    OrderInputPanel.tab=tab;		
	    OrderInputPanel panel=new OrderInputPanel();
	    JLabel sendername,senderaddress,senderworkplace,senderphone,sendermobilephone;
	    JTextField sendernamefie,senderaddressfie,senderworkplacefie,senderphonefie;
	    JFormattedTextField sendermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel receivername,receiveraddress,receiverworkplace,receiverphone,receivermobilephone;
	    JTextField receivernamefie,receiveraddressfie,receiverworkplacefie,receiverphonefie;
	    JFormattedTextField receivermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel  numberOfGoods,weight,vol,nameOfGoods,size;
	    JTextField numberOfGoodsfie,weightfie,volfie,nameOfGoodsfie,sizefie;
	    JLabel typeOfPackage;
		JComboBox packageCombo;
	    JLabel totalFee,receiveFee,changeFee;
	    JLabel dueOfReceive;
	    JLabel typeOfExpress;
	    JComboBox expressCombo;
	    JLabel ordernumber;
	    JLabel ordernumberfie;
	    JComboBox sendercitybox=new JComboBox();
	    JComboBox receivercitybox=new JComboBox();
	    for(int i=0;i<citieslist.size();i++){
	    	sendercitybox.addItem(citieslist.get(i));
	    	receivercitybox.addItem(citieslist.get(i));
	    	}
	   
	    

	    
	    ordernumber=new JLabel("订单号码：");
	    ordernumberfie=new JLabel("待计算");
	    sendername=new JLabel("寄件人姓名：");
	    senderaddress=new JLabel("寄件人地址：");
	    senderworkplace=new JLabel("寄件人单位：");
	    senderphone=new JLabel("寄件人电话：");
	    sendermobilephone=new JLabel("寄件人手机：");
	    sendernamefie=new JTextField(20);
	    senderaddressfie=new JTextField(20);
	    senderworkplacefie=new JTextField(20);
	    senderphonefie=new JTextField(20);
//	    sendermobilephonefie=new JTextField(20);
	    receivername=new JLabel("收件人姓名：");
	    receiveraddress=new JLabel("收件人地址：");
	    receiverworkplace=new JLabel("收件人单位：");
	    receiverphone=new JLabel("收件人电话：");
	    receivermobilephone=new JLabel("收件人手机：");
	    receivernamefie=new JTextField(20);
	    receiveraddressfie=new JTextField(20);
	    receiverworkplacefie=new JTextField(20);
	    receiverphonefie=new JTextField(20);
//	    receivermobilephonefie=new JTextField(20);
	    numberOfGoods=new JLabel("货物件数：");
	    weight=new JLabel("货物重量：");
	    vol=new JLabel("货物体积：");
	    nameOfGoods=new JLabel("内件品名：");
	    size=new JLabel("货物尺寸：");
	    numberOfGoodsfie=new JTextField(20);
	    weightfie=new JTextField(20);
	    volfie=new JTextField(20);
	    nameOfGoodsfie=new JTextField(20);
	    sizefie=new JTextField(20);
	    typeOfPackage=new JLabel("包装类型");
	    packageCombo=new JComboBox();
	    for(int i=0;i<packstrlist.size();i++){
	        packageCombo.addItem(packstrlist.get(i));
	    }

	    totalFee=new JLabel("总费用：");
	    JLabel totalFeefie=new JLabel("待计算");
	    receiveFee=new JLabel("所收费用：");
	    JTextField receiveFeefie=new JTextField(20);
	    changeFee=new JLabel("找零：");
	    JLabel changeFeefie=new JLabel("待计算");
	    dueOfReceive=new JLabel("预期到达日期：");
	    JLabel dueOfReceivefie=new JLabel("待计算");
	    typeOfExpress=new JLabel("快递类型");
	    expressCombo=new JComboBox();
        for(int i=0;i<expresstypelist.size();i++){
        	expressCombo.addItem(expresstypelist.get(i));
        }
	    
	    
	    
	    
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(10,0,10,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		
	    JPanel senderaddresspanel=new JPanel();
	    JPanel receiveraddresspanel=new JPanel();
	    senderaddresspanel.add(sendercitybox);
	    senderaddresspanel.add(senderaddressfie);
	    receiveraddresspanel.add(receivercitybox);
	    receiveraddresspanel.add(receiveraddressfie);
		BaseUI.myAdd(bpanel,sendername,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,senderaddress,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,senderworkplace,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,senderphone,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephone,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,sendernamefie,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,senderaddresspanel,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,senderworkplacefie,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,senderphonefie,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephonefie,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,receivername,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,receiveraddress,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,receiverworkplace,constraints,2,2,1,1);
		BaseUI.myAdd(bpanel,receiverphone,constraints,2,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephone,constraints,2,4,1,1);
		BaseUI.myAdd(bpanel,receivernamefie,constraints,3,0,1,1);
		BaseUI.myAdd(bpanel,receiveraddresspanel,constraints,3,1,1,1);
		BaseUI.myAdd(bpanel,receiverworkplacefie,constraints,3,2,1,1);
		BaseUI.myAdd(bpanel,receiverphonefie,constraints,3,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephonefie,constraints,3,4,1,1);
		
		BaseUI.myAdd(bpanel,numberOfGoods,constraints,0,5,1,1);
		BaseUI.myAdd(bpanel,weight,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,vol,constraints,0,7,1,1);
		BaseUI.myAdd(bpanel,nameOfGoods,constraints,0,8,1,1);
		BaseUI.myAdd(bpanel,size,constraints,0,9,1,1);
		BaseUI.myAdd(bpanel,numberOfGoodsfie,constraints,1,5,1,1);
		BaseUI.myAdd(bpanel,weightfie,constraints,1,6,1,1);
		BaseUI.myAdd(bpanel,volfie,constraints,1,7,1,1);
		BaseUI.myAdd(bpanel,nameOfGoodsfie,constraints,1,8,1,1);
		BaseUI.myAdd(bpanel,sizefie,constraints,1,9,1,1);
		
		BaseUI.myAdd(bpanel,typeOfPackage,constraints,2,5,1,1);
		BaseUI.myAdd(bpanel,typeOfExpress,constraints,2,6,1,1);
		BaseUI.myAdd(bpanel,totalFee,constraints,2,7,1,1);
		BaseUI.myAdd(bpanel,receiveFee,constraints,2,8,1,1);
		BaseUI.myAdd(bpanel,changeFee,constraints,2,9,1,1);
		BaseUI.myAdd(bpanel,packageCombo,constraints,3,5,1,1);
		BaseUI.myAdd(bpanel,expressCombo,constraints,3,6,1,1);
		BaseUI.myAdd(bpanel,totalFeefie,constraints,3,7,1,1);
		BaseUI.myAdd(bpanel,receiveFeefie,constraints,3,8,1,1);
		BaseUI.myAdd(bpanel,changeFeefie,constraints,3,9,1,1);
		
		BaseUI.myAdd(bpanel,ordernumber,constraints,0,10,1,1);
		BaseUI.myAdd(bpanel,ordernumberfie,constraints,1,10,1,1);
		BaseUI.myAdd(bpanel,dueOfReceive,constraints,2,10,1,1);
		BaseUI.myAdd(bpanel,dueOfReceivefie,constraints,3,10,1,1);
		
		weightfie.setText("(单位：千克)");
		volfie.setText("(单位：立方厘米)");
		sizefie.setText("(单位：厘米*厘米*厘米)");
		
		JButton submit=new JButton("计算费用");
		
        JPanel submitpanel=new JPanel();
        submitpanel.add(submit);
		BaseUI.myAdd(bpanel,submitpanel,constraints,1,11,4,1);
		
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
		      if(submit.getText().equals("计算费用")){
		    	  if(sendernamefie.getText().equals("")||senderaddress.getText().equals("")||senderworkplacefie.getText().equals("")||sendermobilephonefie.getText().equals("000000000")
		    			  ||receivernamefie.getText().equals("")||receiveraddress.getText().equals("")||receiverworkplacefie.getText().equals("")||receivermobilephonefie.getText().equals("000000000")
		    			  ||numberOfGoodsfie.getText().equals("")||weightfie.getText().equals("(单位：千克)")||volfie.getText().equals("(单位：立方厘米)")||nameOfGoodsfie.getText().equals("")||sizefie.getText().equals("(单位：厘米*厘米*厘米)")){
		    		  JOptionPane.showMessageDialog(null, "请输入收件人、寄件人、货物完整信息");
		    		  
		    	  }else{
			    	    Date dt = new Date();   
			    	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
			    	    String timeOfSend=sdf.format(dt);
			    	    try{
				    	    int _numberOfGoods=Integer.parseInt(numberOfGoodsfie.getText());
				    	    double _vol=Double.parseDouble(volfie.getText());
				    	    double _weight=Double.parseDouble(weightfie.getText());
				    	    String saddress=sendercitybox.getSelectedItem().toString()+senderaddressfie.getText();
				    	    String raddress=receivercitybox.getSelectedItem().toString()+receiveraddressfie.getText();
				    	    ordervo=new OrderVO(timeOfSend,courierId,sendernamefie.getText(),saddress,senderworkplacefie.getText(),senderphonefie.getText(),sendermobilephonefie.getText()
				    			  ,receivernamefie.getText(),raddress,receiverworkplacefie.getText(),receiverphonefie.getText(),receivermobilephonefie.getText(),_numberOfGoods,_weight,_vol,nameOfGoodsfie.getText(),sizefie.getText()
				    			  ,expressCombo.getSelectedItem().toString(),changePackingStr(packageCombo.getSelectedItem().toString()),DocumentCondition.handing);
				    	  
				    	    sc=new SendController();

				    	    ordervo=sc.calculate(ordervo);
				    	    billvo=sc.setBill(ordervo);

				    	    totalFeefie.setText(billvo.getTotalfee()+"");
				    	    String _dueOfReceive=sc.computedue(ordervo);
				    	    dueOfReceivefie.setText(_dueOfReceive);
				    	    ordervo.setDueOfReceive(_dueOfReceive);
				    	    String _ordernumber=sc.computeOrdernumber();
				    	    ordernumberfie.setText(_ordernumber);
				    	    ordervo.setOrdernumber(_ordernumber);
				    	    
	                        submit.setText("计算找零");
			    	    }catch(NumberFormatException e){
			    	    	JOptionPane.showMessageDialog(null, "请输入正确规格的货物件数（整数），货物体积（小数），货物重量（小数）。");
			    	    }

		    	  }
		      }else if(submit.getText().equals("计算找零")){
		    	    if(receiveFeefie.getText().equals("")){
		    	    	JOptionPane.showMessageDialog(null, "请输入所收金额");
		    	    }else{
		    	        billvo=sc.getchange(Double.parseDouble(receiveFeefie.getText()), billvo);
			    	    if(billvo.getChange()<0){
			    	    	 JOptionPane.showMessageDialog(null, "所收金额不足，请重新输入收入金额");
			    	    }else{
					    	changeFeefie.setText(billvo.getChange()+"");
				    	  	submit.setText("确认订单");	
			    	    }
		    	    }
	


		      }
		      else if(submit.getText().equals("确认订单")){
		    	  
		    	  sc.orderend(billvo, ordervo);
	    	      JOptionPane.showMessageDialog(null, "新建订单成功");
	    	      
	    	      
     	    	  LogService ls=new LogManagementController();
     	    	  ls.addMessage(courierId, "订单输入");
	    	      
		      }
		    }
		});    
		
		
	    
		panel.add(bpanel);
		
	    return panel;
	}
	
	private static Packing changePackingStr(String packing){
		
		int index=packstrlist.indexOf(packing);
		return packlist.get(index);
		
	}

}
