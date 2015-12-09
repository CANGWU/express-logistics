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

public class DriverManagementPanel {
	public static JPanel addDriverPanel, deleteDriverPanel, fixDriverPanel,
			seekDriverPanel;
	public static JTabbedPane tab;

	public static FreeReportPage createDriverManagementPage(JTabbedPane tab) {
		DriverManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("司机编号");
		model.addColumn("姓名");
		model.addColumn("出生日期");
		model.addColumn("身份证号");
		model.addColumn("手机");
		model.addColumn("性别");
		model.addColumn("行驶证期限");
		model.addColumn("所属单位");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("00001");
			row.add("王五");
			row.add("2015/12/06");
			row.add("440000199911116666");
			row.add("18366666666");
			row.add("男");
			row.add("2015/12/07");
			row.add("00002");

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
		FreeToolbarButton addDriver, deleteDriver, fixDriver, seekDriver;
		addDriver = createButton("/free/test/add.png", "增加司机", true);
		deleteDriver = createButton("/free/test/update.png", "删除司机", true);
		fixDriver = createButton("/free/test/refresh.png", "修改司机", true);
		seekDriver = createButton("/free/test/print.png", "查找司机", true);
		page.getRightToolBar().add(addDriver);
		page.getRightToolBar().add(deleteDriver);
		page.getRightToolBar().add(fixDriver);
		page.getRightToolBar().add(seekDriver);

		addDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addDriver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addDriverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddDriverPanel();
					tab.addTab(title, OfficerUI.createPage(addDriverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addDriverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteDriver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteDriverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteDriverPanel();
					tab.addTab(title, OfficerUI.createPage(deleteDriverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteDriverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixDriver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixDriverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixDriverPanel();
					tab.addTab(title, OfficerUI.createPage(fixDriverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixDriverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekDriver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekDriver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekDriverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekDriverPanel();
					tab.addTab(title, OfficerUI.createPage(seekDriverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekDriverPanel);
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
		addDriverPanel = new JPanel();
		JLabel driverID = new JLabel("司机编号");
		JLabel name = new JLabel("姓名");
		JLabel birthday = new JLabel("出生日期");
		JLabel identityCard = new JLabel("身份证号");
		JLabel mobilePhone = new JLabel("手机");
		JLabel sex = new JLabel("性别");
		JLabel timeOfLicense = new JLabel("行驶证期限");
		JLabel hallID = new JLabel("所属单位");
		JTextField driverIDfield = new JTextField(10);
		JTextField namefield = new JTextField(10);
		JTextField birthdayfield = new JTextField(10);
		JTextField identityCardfield = new JTextField(10);
		JTextField mobilePhonefield = new JTextField(10);
		JTextField timeOfLicensefield = new JTextField(10);
		JTextField hallIDfield = new JTextField(10);
		
		JComboBox sexCombo = new JComboBox();
		sexCombo.addItem("男");
		sexCombo.addItem("女");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, timeOfLicense, constraints, 0, 6, 1, 1);
		BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);

		BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, sexCombo, constraints, 1, 5, 1, 1);
		BaseUI.myAdd(bpanel, timeOfLicensefield, constraints, 1, 6, 1, 1);
		BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);

		JButton submit = new JButton("提交");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		addDriverPanel.add(bpanel);
	}

	private static void createDeleteDriverPanel() {
		deleteDriverPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel driverID = new JLabel("司机编号");
		JTextField driverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除司机信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认删除");
				bpanel.remove(driverID);
				bpanel.remove(driverIDfield);
				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel timeOfLicense = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JLabel driverIDfield = new JLabel("00001");
				JLabel namefield = new JLabel("王五");
				JLabel birthdayfield = new JLabel("2015/12/06");
				JLabel identityCardfield = new JLabel("440000199911116666");
				JLabel mobilePhonefield = new JLabel("18366666666");
				JLabel sexfield = new JLabel("男");
				JLabel timeOfLicensefield = new JLabel("2015/12/07");
				JLabel hallIDfield = new JLabel("00002");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicense, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicensefield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);

			}
		});

		deleteDriverPanel.add(bpanel);
	}

	private static void createFixDriverPanel() {
		fixDriverPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel driverID = new JLabel("司机编号");
		JTextField driverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改司机信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel timeOfLicense = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JTextField driverIDfield = new JTextField(10);
				JTextField namefield = new JTextField(10);
				JTextField birthdayfield = new JTextField(10);
				JTextField identityCardfield = new JTextField(10);
				JTextField mobilePhonefield = new JTextField(10);
				JTextField timeOfLicensefield = new JTextField(10);
				JTextField hallIDfield = new JTextField(10);
				
				JComboBox sexCombo = new JComboBox();
				sexCombo.addItem("男");
				sexCombo.addItem("女");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicense, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexCombo, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicensefield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);

				submit.setText("确认修改");
			}

		});

		fixDriverPanel.add(bpanel);

	}

	private static void createSeekDriverPanel() {
		seekDriverPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel driverID = new JLabel("司机编号");
		JTextField driverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改司机信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认");
				bpanel.remove(driverID);
				bpanel.remove(driverIDfield);
				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel timeOfLicense = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JLabel driverIDfield = new JLabel("00001");
				JLabel namefield = new JLabel("王五");
				JLabel birthdayfield = new JLabel("2015/12/06");
				JLabel identityCardfield = new JLabel("440000199911116666");
				JLabel mobilePhonefield = new JLabel("18366666666");
				JLabel sexfield = new JLabel("男");
				JLabel timeOfLicensefield = new JLabel("2015/12/07");
				JLabel hallIDfield = new JLabel("00002");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicense, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, timeOfLicensefield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);
			}
		});

		seekDriverPanel.add(bpanel);
	}
}
