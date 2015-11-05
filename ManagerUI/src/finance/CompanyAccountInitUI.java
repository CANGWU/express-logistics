package finance;

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


public class CompanyAccountInitUI extends JPanel{
	JButton accountinit;
	JButton check;
	JList list;
	JLabel info;
	public CompanyAccountInitUI(){
		init();
	}
	
	private void init(){
		accountinit = new JButton("账目初始化");
		check=new JButton("账目查看");
		info=new JLabel("账目信息");

		this.setLayout(new BorderLayout());
		//容器
        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,accountinit,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,check,constraints,0,1,1,1);
		
		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,100);
		
		BaseUI.myAdd(lpanel,info,constraints,0,0,1,1);
	
		
		String nation[] ={"1","2","3","4"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);

        this.add(bpanel,BorderLayout.WEST);
	}
}
