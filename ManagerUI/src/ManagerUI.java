import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



//

public class ManagerUI extends JFrame{
	
	
	public ManagerUI(){
		super("快递物流系统");
		init();
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

private void layoutUI(){
	//实现页面内的翻页
	JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
	//容器，只是方便布局
	Container container = this.getLayeredPane();
	 //暂未实现！！！
	 JPanel statusBar = new JPanel();
	 JPanel informationBar = new JPanel();
	 //
	 JPanel aM = new AManagementUI();
	 JPanel pM = new PManagementUI();
	 JPanel report = new ReportUI();
	 JPanel audit = new AuditUI();
	 JPanel constant = new ConstantUI();
	 JPanel salary = new SalaryStrategyUI();
	 JPanel log = new LogIUI();
	 tab.add("人员管理", aM);
	 tab.add("机构管理", pM);
	 tab.add("统计报表", report);
	 tab.add("审判单据", audit);
	 tab.add("制定常量", constant);
	 tab.add("薪水策略", salary);
	 tab.add("日志查看", log);
	 
	 
	 //暂未实现
	 statusBar.add(new JLabel("状态栏(未实现)"));
	 informationBar.add(new JLabel("总经理消息(未实现)"));
	 //
	container.setLayout(new BorderLayout());
	container.add(tab, BorderLayout.WEST);
	container.add(statusBar, BorderLayout.SOUTH);
	container.add(informationBar, BorderLayout.NORTH);
}


public static void main(String[]args){
	ManagerUI m = new ManagerUI();
}
}
