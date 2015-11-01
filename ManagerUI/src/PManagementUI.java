import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PManagementUI extends JPanel {
	public PManagementUI(){
		init();
	}
	
	//初始化
	public void init(){
        add = new JButton("添加机构");
		del = new JButton("删除机构");
		update = new JButton("修改机构");
		seek = new JButton("查找机构");
		this.setLayout(new BorderLayout());
		//容器

	
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		BaseUI.myAdd(bpanel,add,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,del,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,update,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,seek,constraints,0,3,1,1);
        this.add(bpanel,BorderLayout.WEST);

	}
	//这个方法可以抽象出来！！！
	
	JButton add;
	JButton del;
	JButton update;
	JButton seek;

}
