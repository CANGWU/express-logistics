package officerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.Sex;
import enums.Work;
import pamanagementsl.DManagementController;
import pamanagementslservice.DManagementService;
import twaver.TWaverUtil;
import vo.DeliverVO;
import vo.DriverVO;
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
	private static DataFactory dataFactory;
	private static DriverVO drivervo;
	private static DManagementService driver;

	public static FreeReportPage createDriverManagementPage(JTabbedPane tab) {
		try {
			dataFactory = DataFactory.create();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		driver = new DManagementController(dataFactory);
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
		model.addColumn("家庭地址");
		model.addColumn("薪酬");

		ArrayList<DriverVO> driverList = driver.getAllDriver();
		for (Iterator<DriverVO> i = driverList.iterator(); i.hasNext();) {
			Vector row = new Vector();
			drivervo = i.next();
			row.add(drivervo.getWorkNumber());
			row.add(drivervo.getName());
			row.add(drivervo.getBirthDate());
			row.add(drivervo.getIdNumber());
			row.add(drivervo.getPhoneNumber());
			row.add(drivervo.getSex());
			row.add(drivervo.getDriverYear());
			row.add(drivervo.getWorkPlaceNumber());
			row.add(drivervo.getAddress());
			row.add(drivervo.getPage());
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
		JLabel driverYear = new JLabel("行驶证期限");
		JLabel hallID = new JLabel("所属单位");
		JLabel address = new JLabel("家庭住址");
		JLabel page = new JLabel("薪酬");
		JTextField driverIDfield = new JTextField(10);
		JTextField namefield = new JTextField(10);
		JTextField birthdayfield = new JTextField(10);
		JTextField identityCardfield = new JTextField(10);
		JTextField mobilePhonefield = new JTextField(10);
		JTextField driverYearfield = new JTextField(10);
		JTextField hallIDfield = new JTextField(10);
		JTextField addressfield = new JTextField(10);
		JTextField pagefield = new JTextField(10);
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
		BaseUI.myAdd(bpanel, driverYear, constraints, 0, 6, 1, 1);
		BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);
		BaseUI.myAdd(bpanel, address, constraints, 0, 8, 1, 1);
		BaseUI.myAdd(bpanel, page, constraints, 0, 9, 1, 1);

		BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, sexCombo, constraints, 1, 5, 1, 1);
		BaseUI.myAdd(bpanel, driverYearfield, constraints, 1, 6, 1, 1);
		BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);
		BaseUI.myAdd(bpanel, addressfield, constraints, 1, 8, 1, 1);
		BaseUI.myAdd(bpanel, pagefield, constraints, 1, 9, 1, 1);

		JButton submit = new JButton("提交");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					drivervo = new DriverVO(namefield.getText(), Work.Driver,
							driverIDfield.getText(), hallIDfield.getText(),
							birthdayfield.getText(), identityCardfield
									.getText(), mobilePhonefield.getText(),
							addressfield.getText(), Sex.male, Integer
									.parseInt(driverYearfield.getText()),
							Integer.parseInt(pagefield.getText()));
					if (sexCombo.getSelectedIndex()==1)
						drivervo.setSex(Sex.female);
					driver.save(drivervo);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		/***********************************************/
		BaseUI.myAdd(bpanel, submit, constraints, 0, 10, 2, 1);

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
		BaseUI.myAdd(bpanel, submit, constraints, 0, 10, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bpanel.remove(submit);
				bpanel.remove(driverID);
				bpanel.remove(driverIDfield);

				drivervo = driver.select(driverIDfield.getText());

				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel driverYear = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JLabel address = new JLabel("家庭住址");
				JLabel page = new JLabel("薪酬");

				JLabel driverIDfield = new JLabel(drivervo.getWorkNumber());
				JLabel namefield = new JLabel(drivervo.getName());
				JLabel birthdayfield = new JLabel(drivervo.getBirthDate());
				JLabel identityCardfield = new JLabel(drivervo.getIdNumber());
				JLabel mobilePhonefield = new JLabel(drivervo.getPhoneNumber());
				JLabel sexfield = new JLabel(drivervo.getSex().toString());
				JLabel driverYearfield = new JLabel(drivervo.getDriverYear()
						+ "");
				JLabel hallIDfield = new JLabel(drivervo.getWorkPlaceNumber());
				JLabel addressfield = new JLabel(drivervo.getAddress());
				JLabel pagefield = new JLabel(drivervo.getPage() + "");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYear, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);
				BaseUI.myAdd(bpanel, address, constraints, 0, 8, 1, 1);
				BaseUI.myAdd(bpanel, page, constraints, 0, 9, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYearfield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);
				BaseUI.myAdd(bpanel, addressfield, constraints, 1, 8, 1, 1);
				BaseUI.myAdd(bpanel, pagefield, constraints, 1, 9, 1, 1);

				JButton delete = new JButton("确认删除");
				BaseUI.myAdd(bpanel, delete, constraints, 0, 10, 2, 1);
				delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							driver.delete(driverIDfield.getText());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});

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

		JButton submit = new JButton("修改司机信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 10, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bpanel.remove(driverID);
				bpanel.remove(driverIDfield);
				bpanel.remove(submit);

				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel driverYear = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JLabel address = new JLabel("家庭住址");
				JLabel page = new JLabel("薪酬");
				JTextField driverIDfield = new JTextField(10);
				JTextField namefield = new JTextField(10);
				JTextField birthdayfield = new JTextField(10);
				JTextField identityCardfield = new JTextField(10);
				JTextField mobilePhonefield = new JTextField(10);
				JTextField driverYearfield = new JTextField(10);
				JTextField hallIDfield = new JTextField(10);
				JTextField addressfield = new JTextField(10);
				JTextField pagefield = new JTextField(10);

				JComboBox sexCombo = new JComboBox();
				sexCombo.addItem("男");
				sexCombo.addItem("女");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYear, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);
				BaseUI.myAdd(bpanel, address, constraints, 0, 8, 1, 1);
				BaseUI.myAdd(bpanel, page, constraints, 0, 9, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexCombo, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYearfield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);
				BaseUI.myAdd(bpanel, addressfield, constraints, 0, 8, 1, 1);
				BaseUI.myAdd(bpanel, pagefield, constraints, 0, 9, 1, 1);

				JButton fix = new JButton("确认修改");
				fix.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							drivervo = new DriverVO(namefield.getText(),
									Work.Driver, driverIDfield.getText(),
									hallIDfield.getText(), birthdayfield
											.getText(), identityCardfield
											.getText(), mobilePhonefield
											.getText(), addressfield.getText(),
									Sex.male, Integer.parseInt(driverYearfield
											.getText()), Integer
											.parseInt(pagefield.getText()));
							if (sexCombo.getSelectedIndex()==1)
								drivervo.setSex(Sex.female);
							driver.saveChange(drivervo);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
				BaseUI.myAdd(bpanel, fix, constraints, 0, 10, 2, 1);
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
		BaseUI.myAdd(bpanel, submit, constraints, 0, 10, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drivervo = driver.select(driverIDfield.getText());
				submit.setText("确认");
				bpanel.remove(driverID);
				bpanel.remove(driverIDfield);
				JLabel driverID = new JLabel("司机编号");
				JLabel name = new JLabel("姓名");
				JLabel birthday = new JLabel("出生日期");
				JLabel identityCard = new JLabel("身份证号");
				JLabel mobilePhone = new JLabel("手机");
				JLabel sex = new JLabel("性别");
				JLabel driverYear = new JLabel("行驶证期限");
				JLabel hallID = new JLabel("所属单位");
				JLabel address = new JLabel("家庭住址");
				JLabel page = new JLabel("薪酬");

				JLabel driverIDfield = new JLabel(drivervo.getWorkNumber());
				JLabel namefield = new JLabel(drivervo.getName());
				JLabel birthdayfield = new JLabel(drivervo.getBirthDate());
				JLabel identityCardfield = new JLabel(drivervo.getIdNumber());
				JLabel mobilePhonefield = new JLabel(drivervo.getPhoneNumber());
				JLabel sexfield = new JLabel(drivervo.getSex().toString());
				JLabel driverYearfield = new JLabel(drivervo.getDriverYear()
						+ "");
				JLabel hallIDfield = new JLabel(drivervo.getWorkPlaceNumber());
				JLabel addressfield = new JLabel(drivervo.getAddress());
				JLabel pagefield = new JLabel(drivervo.getPage() + "");

				BaseUI.myAdd(bpanel, driverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthday, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCard, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhone, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, sex, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYear, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 7, 1, 1);
				BaseUI.myAdd(bpanel, address, constraints, 0, 8, 1, 1);
				BaseUI.myAdd(bpanel, page, constraints, 0, 9, 1, 1);

				BaseUI.myAdd(bpanel, driverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, birthdayfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, identityCardfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, mobilePhonefield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, sexfield, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, driverYearfield, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 7, 1, 1);
				BaseUI.myAdd(bpanel, addressfield, constraints, 1, 8, 1, 1);
				BaseUI.myAdd(bpanel, pagefield, constraints, 1, 9, 1, 1);
			}
		});

		seekDriverPanel.add(bpanel);
	}
}
