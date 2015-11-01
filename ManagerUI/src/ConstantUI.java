import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ConstantUI extends JPanel {
	
	public ConstantUI(){
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		newConstant = new JButton("新的常量");
	    this.setLayout(new BorderLayout());
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel, newConstant, constraints, 0, 0, 1, 1);
		this.add(bpanel, BorderLayout.WEST);
		this.setVisible(true);

		
	}

	
	JButton newConstant;
}
