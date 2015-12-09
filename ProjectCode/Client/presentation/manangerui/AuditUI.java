package manangerui;
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

public class AuditUI extends JPanel {
	public AuditUI(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		audit = new JButton("单据审判");
		audits = new JButton("多单据审判");
		number=new JLabel("单据编号");
		place=new JLabel("单据生成地");
		type=new JLabel("单据类型");
		
		this.setLayout(new BorderLayout());
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel, audit, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, audits, constraints, 0, 1, 1, 1);
		
		
		
		JPanel lpanel=new JPanel();
		lpanel.setLayout(gb);
		constraints.insets=new Insets(0,0,0,100);
		
		BaseUI.myAdd(lpanel,number,constraints,0,0,1,1);
		BaseUI.myAdd(lpanel,place,constraints,1,0,1,1);
		BaseUI.myAdd(lpanel,type,constraints,2,0,1,1);
	
	
		
		String nation[] ={"1","2","3","4"};
		list=new JList(nation);
		this.add(new JScrollPane(list));
		
		
		this.add(lpanel,BorderLayout.NORTH);
		this.add(list,BorderLayout.CENTER);
		this.add(bpanel, BorderLayout.WEST);
		this.setVisible(true);
		
	}  
	
	
	JButton audit;
	JButton audits;
	JList list;
	JLabel number;
	JLabel place;
	JLabel type;
	
	
}
