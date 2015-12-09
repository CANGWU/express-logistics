package free;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import twaver.TWaverUtil;
import free.BaseUI;

public class UserManagementPanel extends JPanel {
	public static JPanel addUserPanel, deleteUserPanel, fixUserPanel,
			seekUserPanel;
	public static JTabbedPane tab;

	public static FreeReportPage createUserManagementPage(JTabbedPane tab) {
		UserManagementPanel.tab = tab;
		return createReportPage();
	}

	private static void createAddUserPanel() {
		addUserPanel = new JPanel();
		JLabel account = new JLabel("账号");
		JLabel name = new JLabel("姓名");
		JLabel code = new JLabel("密码");
		JLabel privileges = new JLabel("权限");
		JLabel work = new JLabel("工作岗位");
		JTextField accountfield = new JTextField(10);
		JTextField namefield = new JTextField(20);
		JTextField codefield = new JTextField(20);
		JComboBox privilegesCombo = new JComboBox();
		privilegesCombo.addItem("低");
		privilegesCombo.addItem("高");
		JComboBox workCombo = new JComboBox();
		workCombo.addItem("快递员");
		workCombo.addItem("营业厅业务员");
		workCombo.addItem("中转中心业务员");
		workCombo.addItem("中转中心仓库管理员");
		workCombo.addItem("财务人员");
		workCombo.addItem("管理员");
		workCombo.addItem("总经理");
		workCombo.addItem("司机");

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, privilegesCombo, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, workCombo, constraints, 1, 4, 1, 1);

		JButton submit = new JButton("提交");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		addUserPanel.add(bpanel);
	}

	private static void createDeleteUserPanel() {
		deleteUserPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("账号");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除用户信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认删除");
				bpanel.remove(account);
				bpanel.remove(accountfield);
				JLabel account = new JLabel("账号");
				JLabel name = new JLabel("姓名");
				JLabel code = new JLabel("密码");
				JLabel privileges = new JLabel("权限");
				JLabel work = new JLabel("工作岗位");
				JLabel accountfield = new JLabel();
				JLabel namefield = new JLabel();
				JLabel codefield = new JLabel();
				JLabel privilegesfield = new JLabel();
				JLabel workfield = new JLabel();

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workfield, constraints, 1, 4, 1, 1);
			}
		});

		deleteUserPanel.add(bpanel);
	}

	private static void createFixUserPanel() {
		fixUserPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("账号");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询修改用户信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JLabel account = new JLabel("账号");
				JLabel name = new JLabel("姓名");
				JLabel code = new JLabel("密码");
				JLabel privileges = new JLabel("权限");
				JLabel work = new JLabel("工作岗位");
				JTextField accountfield = new JTextField(10);
				JTextField namefield = new JTextField(20);
				JTextField codefield = new JTextField(20);
				JComboBox privilegesCombo = new JComboBox();
				privilegesCombo.addItem("低");
				privilegesCombo.addItem("高");
				JComboBox workCombo = new JComboBox();
				workCombo.addItem("快递员");
				workCombo.addItem("营业厅业务员");
				workCombo.addItem("中转中心业务员");
				workCombo.addItem("中转中心仓库管理员");
				workCombo.addItem("财务人员");
				workCombo.addItem("管理员");
				workCombo.addItem("总经理");
				workCombo.addItem("司机");

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesCombo, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workCombo, constraints, 1, 4, 1, 1);

				submit.setText("确认修改");
			}

		});

		fixUserPanel.add(bpanel);

	}

	private static void createSeekUserPanel() {
		seekUserPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel account = new JLabel("账号");
		JTextField accountfield = new JTextField(10);
		BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询用户信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				submit.setText("确认");
				bpanel.remove(account);
				bpanel.remove(accountfield);
				JLabel account = new JLabel("账号");
				JLabel name = new JLabel("姓名");
				JLabel code = new JLabel("密码");
				JLabel privileges = new JLabel("权限");
				JLabel work = new JLabel("工作岗位");
				JLabel accountfield = new JLabel();
				JLabel namefield = new JLabel();
				JLabel codefield = new JLabel();
				JLabel privilegesfield = new JLabel();
				JLabel workfield = new JLabel();

				BaseUI.myAdd(bpanel, account, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, name, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, code, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, privileges, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, work, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, accountfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, namefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, codefield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, privilegesfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, workfield, constraints, 1, 4, 1, 1);
			}
		});

		seekUserPanel.add(bpanel);
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("账号");
		model.addColumn("姓名");
		model.addColumn("密码");
		model.addColumn("权限");
		model.addColumn("工作岗位");

		for (int i = 0; i < 100; i++) {
			Vector row = new Vector();
			row.add("000000001");
			row.add("张三");
			row.add("123456");
			row.add("低");
			row.add("快递员");
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
		FreeToolbarButton addUser, deleteUser, fixUser, seekUser;
		addUser = createButton("/free/test/add.png", "增加用户", true);
		deleteUser = createButton("/free/test/update.png", "删除用户", true);
		fixUser = createButton("/free/test/refresh.png", "修改用户", true);
		seekUser = createButton("/free/test/print.png", "查找用户", true);
		page.getRightToolBar().add(addUser);
		page.getRightToolBar().add(deleteUser);
		page.getRightToolBar().add(fixUser);
		page.getRightToolBar().add(seekUser);

		addUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(addUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddUserPanel();
					tab.addTab(title, Shell.createPage(addUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteUserPanel();
					tab.addTab(title, Shell.createPage(deleteUserPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(fixUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixUserPanel();
					tab.addTab(title, Shell.createPage(fixUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(fixUserPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekUser.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil.getPagePane(seekUserPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekUserPanel();
					tab.addTab(title, Shell.createPage(seekUserPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(seekUserPanel);
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

}
