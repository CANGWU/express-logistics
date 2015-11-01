
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class AManagementUI extends JPanel{
	
	public AManagementUI(){
		init();
	}
	
	//初始化
	public void init(){
        add = new JButton("添加人员");
		del = new JButton("删除人员");
		update = new JButton("修改人员");
		seek = new JButton("查找人员");
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
//		this.setLayout(new GridLayout(4,1));
//      this.add(add);
//		this.add(del);
//		this.add(update);
//		this.add(seek);
//		this.setVisible(true);
	}
	
	JButton add;
	JButton del;
	JButton update;
	JButton seek;
	
}

