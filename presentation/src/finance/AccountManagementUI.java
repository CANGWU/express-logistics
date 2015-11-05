package finance;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import main.BaseUI;


public class AccountManagementUI extends JPanel {

	JButton add;
	JButton delete;
	JButton fix;
	JButton seek;
	JList list;
	JLabel accountname;
	JLabel money;
	
	public AccountManagementUI(){
		init();
	}
	
	private void init(){
		add = new JButton("添加账户");
		delete=new JButton("删除账户");
		fix=new JButton("修改账户信息");
		seek=new JButton("查看账户信息");
		accountname=new JLabel("账户名称");
		money=new JLabel("账户余额");

		this.setLayout(new BorderLayout());
		//容器
        
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,add,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,delete,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,fix,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,seek,constraints,0,3,1,1);

		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,100);
		
		BaseUI.myAdd(lpanel,accountname,constraints,0,0,1,1);
		BaseUI.myAdd(lpanel,money,constraints,1,0,1,1);
	
		
		String nation[] ={"工资1","工资2","奖金1","租金1"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
        this.add(bpanel,BorderLayout.WEST);
	}
 
}
