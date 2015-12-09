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

public class ConsigneeManagementPanel {
	public static JPanel addConsigneePanel, deleteConsigneePanel,
			fixConsigneePanel, seekConsigneePanel;
	public static JTabbedPane tab;

	public static FreeReportPage createConsigneeManagementPage(JTabbedPane tab) {
		ConsigneeManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("到达日期");
		model.addColumn("营业厅到达单编号");
		model.addColumn("装车单编号");
		model.addColumn("车辆编号");
		model.addColumn("出发地");
		model.addColumn("接收员");
		model.addColumn("运费");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("2015/12/06");
			row.add("000001");
			row.add("000002");
			row.add("000003");
			row.add("000004");
			row.add("000005");
			row.add("666666");
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
		FreeToolbarButton addConsignee, deleteConsignee, fixConsignee, seekConsignee;
		addConsignee = createButton("/free/test/add.png", "增加营业厅到达单", true);
		deleteConsignee = createButton("/free/test/update.png", "删除营业厅到达单",
				true);
		fixConsignee = createButton("/free/test/refresh.png", "修改营业厅到达单", true);
		seekConsignee = createButton("/free/test/print.png", "查找营业厅到达单", true);
		page.getRightToolBar().add(addConsignee);
		page.getRightToolBar().add(deleteConsignee);
		page.getRightToolBar().add(fixConsignee);
		page.getRightToolBar().add(seekConsignee);

		addConsignee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addConsignee.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addConsigneePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddConsigneePanel();
					tab.addTab(title, OfficerUI.createPage(addConsigneePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addConsigneePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteConsignee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteConsignee.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteConsigneePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteConsigneePanel();
					tab.addTab(title, OfficerUI.createPage(deleteConsigneePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteConsigneePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixConsignee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixConsignee.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixConsigneePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixConsigneePanel();
					tab.addTab(title, OfficerUI.createPage(fixConsigneePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixConsigneePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekConsignee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekConsignee.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekConsigneePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekConsigneePanel();
					tab.addTab(title, OfficerUI.createPage(seekConsigneePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekConsigneePanel);
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

	private static void createAddConsigneePanel() {
		addConsigneePanel = new JPanel();
		JLabel date = new JLabel("到达日期");
		JLabel consigneeID = new JLabel("营业厅到达单");
		JLabel entruckID = new JLabel("装车单编号");
		JLabel vehicleID = new JLabel("车辆编号");
		JLabel departure = new JLabel("出发地");
		JLabel officer = new JLabel("接收员");
		JLabel fee = new JLabel("运费");
		JButton addExpress = new JButton("添加快件");

		JTextField datefield = new JTextField(10);
		JTextField consigneeIDfield = new JTextField(10);
		JTextField entruckIDfield = new JTextField(10);
		JComboBox entruckCombo = new JComboBox();
		entruckCombo.addItem("营业厅装车单");
		entruckCombo.addItem("中转中心中转单");
		JTextField vehicleIDfield = new JTextField(10);
		JTextField departurefield = new JTextField(20);
		JTextField officerfield = new JTextField(20);
		JTextField feefield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, departure, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, officer, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
		BaseUI.myAdd(bpanel, addExpress, constraints, 0, 7, 1, 1);

		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, entruckCombo, constraints, 2, 2, 1, 1);
		BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, departurefield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, officerfield, constraints, 1, 5, 1, 1);
		BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

		JButton submit = new JButton("提交");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		addConsigneePanel.add(bpanel);
	}

	private static void createDeleteConsigneePanel() {
		deleteConsigneePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel consigneeID = new JLabel("营业厅到达单编号");
		JTextField consigneeIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除营业厅到达单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认删除");
				bpanel.remove(consigneeID);
				bpanel.remove(consigneeIDfield);
				JLabel date = new JLabel("到达日期");
				JLabel consigneeID = new JLabel("营业厅到达单");
				JLabel entruckID = new JLabel("装车单");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel departure = new JLabel("出发地");
				JLabel officer = new JLabel("接收员");
				JLabel fee = new JLabel("运费");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel("2015/12/06");
				JLabel consigneeIDfield = new JLabel("000001");
				JLabel entruckIDfield = new JLabel("000002");
				JLabel vehicleIDfield = new JLabel("000003");
				JLabel departurefield = new JLabel("000004");
				JLabel officerfield = new JLabel("000005");
				JLabel feefield = new JLabel("666666");

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, departure, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, departurefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);
			}
		});

		deleteConsigneePanel.add(bpanel);
	}

	private static void createFixConsigneePanel() {
		fixConsigneePanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel consigneeID = new JLabel("营业厅到达单编号");
		JTextField consigneeIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改营业厅到达单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel date = new JLabel("到达日期");
				JLabel consigneeID = new JLabel("营业厅到达单");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel departure = new JLabel("出发地");
				JLabel officer = new JLabel("接收员");
				JLabel fee = new JLabel("运费");
				JButton addExpress = new JButton("添加快件");

				JTextField datefield = new JTextField(10);
				JTextField consigneeIDfield = new JTextField(10);
				JTextField entruckIDfield = new JTextField(10);
				JComboBox entruckCombo = new JComboBox();
				entruckCombo.addItem("营业厅装车单");
				entruckCombo.addItem("中转中心中转单");
				JTextField vehicleIDfield = new JTextField(10);
				JTextField departurefield = new JTextField(20);
				JTextField officerfield = new JTextField(20);
				JTextField feefield = new JTextField(10);

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, departure, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, addExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, entruckCombo, constraints, 2, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, departurefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

				submit.setText("确认修改");
			}

		});

		fixConsigneePanel.add(bpanel);

	}

	private static void createSeekConsigneePanel() {
		seekConsigneePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel consigneeID = new JLabel("营业厅到达单编号");
		JTextField consigneeIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询营业厅到达单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认");
				bpanel.remove(consigneeID);
				bpanel.remove(consigneeIDfield);
				JLabel date = new JLabel("到达日期");
				JLabel consigneeID = new JLabel("营业厅到达单");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel departure = new JLabel("出发地");
				JLabel officer = new JLabel("接收员");
				JLabel fee = new JLabel("运费");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel("2015/12/06");
				JLabel consigneeIDfield = new JLabel("000001");
				JLabel entruckIDfield = new JLabel("000002");
				JLabel vehicleIDfield = new JLabel("000003");
				JLabel departurefield = new JLabel("000004");
				JLabel officerfield = new JLabel("000005");
				JLabel feefield = new JLabel("666666");

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, departure, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, consigneeIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, departurefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);
			}
		});

		seekConsigneePanel.add(bpanel);
	}
}
