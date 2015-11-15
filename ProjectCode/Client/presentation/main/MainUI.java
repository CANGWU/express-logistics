package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import courierui.CourierUI;
import financeui.FinanceUI;
import manangerui.ManagerUI;

public class MainUI extends JFrame{

	public static void main(String[]args){
		//ManagerUI m = new ManagerUI();
		CourierUI c=new CourierUI();
		//FinanceUI f=new FinanceUI();
		//MainUI mainui=new MainUI();
		}
	
	public MainUI(){
		this.init();
	}
	
	
	public void init(){
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e) {
			    super.windowClosing(e);
			    System.exit(0);
			   }});
			  layoutUI();
			  this.setVisible(true);
	}
	
	
	public void layoutUI(){
		Container container = this.getLayeredPane();
		
		JLabel label1=new JLabel("���������ѯ���");
		JLabel label2=new JLabel("������11λ�����ţ�");
		JLabel label3=new JLabel("������Ա��¼���");
		JLabel label4=new JLabel("�˺ţ�");
		JLabel label5=new JLabel("���룺");
		JButton login=new JButton("��¼");
		JButton check=new JButton("��ѯ");
		JLabel systemname=new JLabel("���������Ϣ��ѯϵͳ");
		
		JTextField orderinput=new JTextField(20);
		JTextField account=new JTextField(20);
		JTextField code=new JTextField(20);
		JSeparator sep1=new JSeparator();
		sep1.setOrientation(SwingConstants.VERTICAL);
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,systemname,constraints,0,0,4,1);
		BaseUI.myAdd(bpanel,label1,constraints,0,1,2,1);
		BaseUI.myAdd(bpanel,label2,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,orderinput,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,check,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,sep1,constraints,3,1,1,5);
		BaseUI.myAdd(bpanel,label3,constraints,4,1,2,1);
		BaseUI.myAdd(bpanel,label4,constraints,4,3,1,1);
		BaseUI.myAdd(bpanel,account,constraints,5,3,1,1);
		BaseUI.myAdd(bpanel,label5,constraints,4,4,1,1);
		BaseUI.myAdd(bpanel,code,constraints,5,4,1,1);
		BaseUI.myAdd(bpanel,login,constraints,5,5,1,1);
		container.setLayout(new BorderLayout());
		container.add(bpanel,BorderLayout.CENTER);
		
	}
	
	
	
	

}



