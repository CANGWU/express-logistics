package financeui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.PaymentType;
import enums.ResultMessage;
import pamanagementsl.PManagementController;
import usersl.LogManagementController;
import usersl.UserManagementController;
import userslservice.LogService;
import vo.AccountVO;
import vo.PaymentVO;
import vo.ReceiverVO;
import vo.StaffVO;
import financesl.AccountManagementController;
import financesl.CostController;
import free.BaseUI;

public class CostPanel extends JPanel {
	private static PaymentVO payment;
	private static ArrayList<String> paymentTypeStrlist=new ArrayList<String>();
	private static ArrayList<PaymentType> paymentTypelist=new ArrayList<PaymentType>();
	
	
	public static CostPanel createCostPanel(String userId){
		paymentTypeStrlist.add("租金");
		paymentTypeStrlist.add("运费");
		paymentTypeStrlist.add("工资");
		paymentTypeStrlist.add("奖金");
		
		paymentTypelist.add(PaymentType.Rent);
		paymentTypelist.add(PaymentType.TransFee);
		paymentTypelist.add(PaymentType.Salary);
		paymentTypelist.add(PaymentType.Bonus);
		
		
		
		CostPanel panel=new CostPanel();
		
		JLabel paymentType=new JLabel("付款条目:");
		JComboBox paymentTypeCombo=new JComboBox();
		paymentTypeCombo.addItem("工资");
		paymentTypeCombo.addItem("运费");
		paymentTypeCombo.addItem("租金");
		paymentTypeCombo.addItem("奖金");

		JLabel date=new JLabel("付款日期:");
	    Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	    String timeOfPayment=sdf.format(dt);
		JLabel datefield=new JLabel(timeOfPayment);
	    
	    
		JLabel payman=new JLabel("付款人:");
		UserManagementController umc=new UserManagementController();
		JLabel paymanfield=new JLabel(umc.select(userId).getName());
		
		JLabel paymentfee=new JLabel("付款金额:");
		JTextField paymentfeefield2=new JTextField(20);
		
		JLabel auditnumber=new JLabel("付款单编号：");
		JLabel auditnumberfield=new JLabel("待计算");
		
		JLabel account=new JLabel("付款账户:");
		JComboBox accountCombo=new JComboBox();

		AccountManagementController amc=new AccountManagementController();
		ArrayList<AccountVO> list=amc.getAllAccount();
		for(int i=0;i<list.size();i++){
			accountCombo.addItem(list.get(i).getName());
		}
		
		JLabel receiver=new JLabel("收款人:");
		JTextField receiverfield=new JTextField(20);
		JLabel remarks=new JLabel("备注:");
		JTextField remarksfield=new JTextField(20);
		
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,date,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,datefield,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,payman,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,paymanfield,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,auditnumber,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,auditnumberfield,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,paymentType,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,paymentTypeCombo,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,receiver,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,receiverfield,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,account,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,accountCombo,constraints,3,0,1,1);
		
		BaseUI.myAdd(bpanel,paymentfee,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,paymentfeefield2,constraints,3,1,1,1);
		
		PManagementController pc=new PManagementController();
		CostController cc=new CostController();



		 
		
		BaseUI.myAdd(bpanel,remarks,constraints,2,2,1,1);
		BaseUI.myAdd(bpanel,remarksfield,constraints,3,2,1,1);
		
		
		JButton submit=new JButton("计算金额和付款单编号");	
		BaseUI.myAdd(bpanel,submit,constraints,1,11,1,1);
		
		
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
		    	
		    	if(submit.getText().equals("计算金额和付款单编号")){
		    		if(!receiverfield.getText().equals("")){
			    		payment=cc.setPayment(changePayToType(paymentTypeCombo.getSelectedItem().toString()), receiverfield.getText());
			    		payment.setNameOfWriter(paymanfield.getText());
			    		if(paymentTypeCombo.getSelectedItem().equals("工资")||paymentTypeCombo.getSelectedItem().equals("运费")){		    			
			    			payment=cc.computePayment(payment);
			    			paymentfeefield2.setText(payment.getNumberOfPayment()+"");
			    		}else{
			    	        try{
				    			double fee=Double.parseDouble(paymentfeefield2.getText());	
				    			payment=cc.computePayment(payment,fee);
			    	        }catch(NumberFormatException e){
			         	    	JOptionPane.showMessageDialog(null, "请输入正确的租金金额"); 
			    	        }
			    		}
			    		auditnumberfield.setText(cc.computeAuditNumber());
			    		payment.setAuditnumber(auditnumberfield.getText());
			    		submit.setText("确认支付");	
			    		
		    		}else{
	         	    	JOptionPane.showMessageDialog(null, "请输入收款人"); 
		    		}
		    	}else{
			    	 AccountVO accountvo=amc.findAccount(accountCombo.getSelectedItem().toString());
			    	 
			    	 payment.setRemarks(remarksfield.getText());
			    	 payment.setCondition(DocumentCondition.handing);

		             ResultMessage result=null;
		             System.out.println(payment.getAuditnumber());
		             result=cc.payPayment(payment, accountvo);
		             if(result==ResultMessage.SUCCESS){
		         	    	JOptionPane.showMessageDialog(null, "支付成功"); 
		         	    	submit.setText("计算金额和付款单编号");
		         	    	paymentfeefield2.setText("");
		         	    	remarksfield.setText("");
		         	    	
		       	    	  LogService ls=new LogManagementController();
		     	    	  ls.addMessage(userId, "成本管理");
		             }else{
		         	    	JOptionPane.showMessageDialog(null, "支付失败，请确认账户余额"); 
		             }
		    	}
		    	
		    	

	             
		    }
		});
		
		panel.add(bpanel);
		
		return panel;
	}
	
	
	private static PaymentType changePayToType(String payment){
		
		int index=paymentTypeStrlist.indexOf(payment);
		return paymentTypelist.get(index);
		
	}
}
