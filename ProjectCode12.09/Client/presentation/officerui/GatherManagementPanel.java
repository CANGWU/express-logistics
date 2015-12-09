package officerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import twaver.TWaverUtil;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;

public class GatherManagementPanel {
	public static JPanel addGatherPanel, deleteGatherPanel, fixGatherPanel,
			seekGatherPanel;
	public static JTabbedPane tab;

	public static FreeReportPage createGatherManagementPage(JTabbedPane tab) {
		GatherManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("收款日期");
		model.addColumn("收款金额");
		model.addColumn("快递员");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("2015/12/06");
			row.add("666666");
			row.add("000001");
			model.addRow(row);
		}

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created "
				+ new Date().toString());
		setupPageToolbar(page);

		return page;
	}

	public static void setupPageToolbar(FreePagePane page) {
		FreeToolbarButton addGather, deleteGather, fixGather, seekGather;
		addGather = createButton("/free/test/add.png", "增加收款单", true);
		deleteGather = createButton("/free/test/update.png", "删除收款单", true);
		fixGather = createButton("/free/test/refresh.png", "修改收款单", true);
		seekGather = createButton("/free/test/print.png", "查找收款单", true);
		page.getRightToolBar().add(addGather);
		page.getRightToolBar().add(deleteGather);
		page.getRightToolBar().add(fixGather);
		page.getRightToolBar().add(seekGather);

		addGather.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addGather.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addGatherPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddDriverPanel();
					tab.addTab(title, OfficerUI.createPage(addGatherPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addGatherPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteGather.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteGather.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteGatherPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteDriverPanel();
					tab.addTab(title, OfficerUI.createPage(deleteGatherPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteGatherPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixGather.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixGather.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixGatherPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixDriverPanel();
					tab.addTab(title, OfficerUI.createPage(fixGatherPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixGatherPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekGather.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekGather.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekGatherPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekDriverPanel();
					tab.addTab(title, OfficerUI.createPage(seekGatherPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekGatherPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

	}

	public static FreeToolbarButton createButton(String icon, String tooltip,
			boolean rover) {
		FreeToolbarButton button = null;
		if (rover) {
			button = new FreeToolbarRoverButton();
		} else {
			button = new FreeToolbarButton();
		}
		button.setIcon(TWaverUtil.getIcon(icon));
		button.setToolTipText(tooltip);

		return button;
	}

	private static void createAddDriverPanel() {
		addGatherPanel = new JPanel();
		JLabel date = new JLabel("收款日期");
		JLabel courier = new JLabel("快递员");
		JLabel fee = new JLabel("收款金额");
		JButton addExpress = new JButton("添加快件");
		JTextField datefield = new JTextField(10);
		JTextField courierfield = new JTextField(10);
		JTextField feefield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, fee, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, addExpress, constraints, 0, 3, 1, 1);

		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, feefield, constraints, 1, 2, 1, 1);

		JButton submit = new JButton("提交");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		addGatherPanel.add(bpanel);
	}

	private static void createDeleteDriverPanel() {
		deleteGatherPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel date = new JLabel("收款日期");
		JLabel courier = new JLabel("快递员");
		JTextField datefield = new JTextField(10);
		JTextField courierfield = new JTextField(10);
		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);

		JButton submit = new JButton("查询删除收款单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认删除");
				bpanel.remove(date);
				bpanel.remove(courier);
				bpanel.remove(datefield);
				bpanel.remove(courierfield);
				JLabel date = new JLabel("收款日期");
				JLabel courier = new JLabel("快递员");
				JLabel fee = new JLabel("收款金额");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel("2015/12/06");
				JLabel courierfield = new JLabel("666666");
				JLabel feefield = new JLabel("000001");

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 3, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 2, 1, 1);
			}
		});

		deleteGatherPanel.add(bpanel);
	}

	private static void createFixDriverPanel() {
		fixGatherPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel date = new JLabel("收款日期");
		JLabel courier = new JLabel("快递员");
		JTextField datefield = new JTextField(10);
		JTextField courierfield = new JTextField(10);
		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);

		JButton submit = new JButton("查询收款单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel date = new JLabel("收款日期");
				JLabel courier = new JLabel("快递员");
				JLabel fee = new JLabel("收款金额");
				JButton addExpress = new JButton("添加快件");
				JTextField datefield = new JTextField(10);
				JTextField courierfield = new JTextField(10);
				JTextField feefield = new JTextField(10);

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, addExpress, constraints, 0, 3, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 2, 1, 1);

				submit.setText("确认修改");
			}

		});

		fixGatherPanel.add(bpanel);

	}

	private static void createSeekDriverPanel() {
		seekGatherPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel date = new JLabel("收款日期");
		JLabel courier = new JLabel("快递员");
		JTextField datefield = new JTextField(10);
		JTextField courierfield = new JTextField(10);
		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);

		JButton submit = new JButton("查询收款单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认");
				bpanel.remove(date);
				bpanel.remove(courier);
				bpanel.remove(datefield);
				bpanel.remove(courierfield);
				JLabel date = new JLabel("收款日期");
				JLabel courier = new JLabel("快递员");
				JLabel fee = new JLabel("收款金额");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel("2015/12/06");
				JLabel courierfield = new JLabel("666666");
				JLabel feefield = new JLabel("000001");

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 3, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 2, 1, 1);
			}
		});

		seekGatherPanel.add(bpanel);
	}
}
