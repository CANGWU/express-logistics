package manangerUI;
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

public class LogUI extends JPanel {
	JButton logcheck;
	JList list;
	JLabel type;
	JLabel person;
	JLabel workplace;
	JLabel time;
	public LogUI(){
		init();
	}
	
	private void init(){
        logcheck = new JButton("日志查看");
        type=new JLabel("操作类型");
        person=new JLabel("操作人员");
        workplace=new JLabel("操作地点");
        time=new JLabel("操作时间");

		this.setLayout(new BorderLayout());
		//容器
        
		JPanel bpanel = new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);

		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,logcheck,constraints,0,0,1,1);

		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,70);
		
		BaseUI.myAdd(lpanel,type,constraints,0,0,1,1);
		BaseUI.myAdd(lpanel,person,constraints,1,0,1,1);
		BaseUI.myAdd(lpanel,workplace,constraints,2,0,1,1);
		BaseUI.myAdd(lpanel,time,constraints,3,0,1,1);
	
		
		String nation[] ={"1","2","3","4"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
        this.add(bpanel,BorderLayout.WEST);
	}
}
