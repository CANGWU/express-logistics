package main;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BaseUI {

	
	
	public static void myAdd(JPanel p, JComponent c,GridBagConstraints constraints,int x, int y, int w, int h){
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.fill = GridBagConstraints.BOTH;
		p.add(c,constraints);
	}
}
