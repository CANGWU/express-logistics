import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AuditUI extends JPanel {
	public AuditUI(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		
		audit = new JButton("单据审判");
		audits = new JButton("多单据审判");
		this.setLayout(new BorderLayout());
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel, audit, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, audits, constraints, 0, 1, 1, 1);
		this.add(bpanel, BorderLayout.WEST);
		this.setVisible(true);
		
	}  
	
	
	JButton audit;
	JButton audits;

	
	
}
