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

public class EntruckManagementPanel {
	public static JPanel addEntruckPanel, deleteEntruckPanel, fixEntruckPanel,
			seekEntruckPanel;
	public static JTabbedPane tab;

	public static FreeReportPage createEntruckManagementPage(JTabbedPane tab) {
		EntruckManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("装车日期");
		model.addColumn("装车单编号");
		model.addColumn("汽运编号");
		model.addColumn("到达地");
		model.addColumn("车辆编号");
		model.addColumn("相关人员");
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
		FreeToolbarButton addEntruck, deleteEntruck, fixEntruck, seekEntruck;
		addEntruck = createButton("/free/test/add.png", "增加装车单", true);
		deleteEntruck = createButton("/free/test/update.png", "删除装车单", true);
		fixEntruck = createButton("/free/test/refresh.png", "修改装车单", true);
		seekEntruck = createButton("/free/test/print.png", "查找装车单", true);
		page.getRightToolBar().add(addEntruck);
		page.getRightToolBar().add(deleteEntruck);
		page.getRightToolBar().add(fixEntruck);
		page.getRightToolBar().add(seekEntruck);

		addEntruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addEntruck.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addEntruckPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddDriverPanel();
					tab.addTab(title, OfficerUI.createPage(addEntruckPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addEntruckPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteEntruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteEntruck.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteEntruckPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteDriverPanel();
					tab.addTab(title, OfficerUI.createPage(deleteEntruckPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteEntruckPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixEntruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixEntruck.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixEntruckPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixDriverPanel();
					tab.addTab(title, OfficerUI.createPage(fixEntruckPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixEntruckPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekEntruck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekEntruck.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekEntruckPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekDriverPanel();
					tab.addTab(title, OfficerUI.createPage(seekEntruckPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekEntruckPanel);
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

		addEntruckPanel = new JPanel();
		JLabel date = new JLabel("装车日期");
		JLabel entruckID = new JLabel("装车单编号");
		JLabel transportID = new JLabel("汽运编号");
		JLabel destination = new JLabel("到达地");
		JLabel vehicleID = new JLabel("车辆编号");
		JLabel member = new JLabel("相关人员");
		JLabel fee = new JLabel("运费");
		JButton addExpress = new JButton("添加快件");

		JTextField datefield = new JTextField(10);
		JTextField entruckIDfield = new JTextField(10);
		JTextField transportIDfield = new JTextField(10);
		JTextField destinationfield = new JTextField(10);
		JTextField vehicleIDfield = new JTextField(10);
		JTextField memberfield = new JTextField(10);
		JTextField feefield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
		BaseUI.myAdd(bpanel, addExpress, constraints, 0, 7, 1, 1);

		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
		BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

		JButton submit = new JButton("提交");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		addEntruckPanel.add(bpanel);
	}

	private static void createDeleteDriverPanel() {
		deleteEntruckPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel entruckID = new JLabel("装车单编号");
		JTextField entruckIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除装车单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认删除");
				bpanel.remove(entruckID);
				bpanel.remove(entruckIDfield);
				JLabel date = new JLabel("装车日期");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel transportID = new JLabel("汽运编号");
				JLabel destination = new JLabel("到达地");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel member = new JLabel("相关人员");
				JLabel fee = new JLabel("运费");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel();
				JLabel entruckIDfield = new JLabel();
				JLabel transportIDfield = new JLabel();
				JLabel destinationfield = new JLabel();
				JLabel vehicleIDfield = new JLabel();
				JLabel memberfield = new JLabel();
				JLabel feefield = new JLabel();

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);
			}
		});

		deleteEntruckPanel.add(bpanel);
	}

	private static void createFixDriverPanel() {
		fixEntruckPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel entruckID = new JLabel("装车单编号");
		JTextField entruckIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改装车单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel date = new JLabel("装车日期");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel transportID = new JLabel("汽运编号");
				JLabel destination = new JLabel("到达地");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel member = new JLabel("相关人员");
				JLabel fee = new JLabel("运费");
				JButton addExpress = new JButton("添加快件");

				JTextField datefield = new JTextField(10);
				JTextField entruckIDfield = new JTextField(10);
				JTextField transportIDfield = new JTextField(10);
				JTextField destinationfield = new JTextField(10);
				JTextField vehicleIDfield = new JTextField(10);
				JTextField memberfield = new JTextField(10);
				JTextField feefield = new JTextField(10);

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, addExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

				submit.setText("确认修改");
			}

		});

		fixEntruckPanel.add(bpanel);

	}

	private static void createSeekDriverPanel() {
		seekEntruckPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel entruckID = new JLabel("装车单编号");
		JTextField entruckIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改装车单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认");
				bpanel.remove(entruckID);
				bpanel.remove(entruckIDfield);
				JLabel date = new JLabel("装车日期");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel transportID = new JLabel("汽运编号");
				JLabel destination = new JLabel("到达地");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel member = new JLabel("相关人员");
				JLabel fee = new JLabel("运费");
				JButton seekExpress = new JButton("查询快件");

				JLabel datefield = new JLabel();
				JLabel entruckIDfield = new JLabel();
				JLabel transportIDfield = new JLabel();
				JLabel destinationfield = new JLabel();
				JLabel vehicleIDfield = new JLabel();
				JLabel memberfield = new JLabel();
				JLabel feefield = new JLabel();

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);
			}
		});

		seekEntruckPanel.add(bpanel);
	}
}
