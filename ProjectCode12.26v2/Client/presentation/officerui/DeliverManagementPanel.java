package officerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import auditsl.AuditInfo;
import main.StaffInfoPanel;
import receivesl.Deliver;
import receiveslservice.DeliverService;
import transportui.TransportUI;
import twaver.TWaverUtil;
import twaver.base.A.F.E;
import vo.DeliverVO;
import enums.DocumentCondition;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;

public class DeliverManagementPanel extends JPanel {
	public static JPanel addDeliverPanel, deleteDeliverPanel, fixDeliverPanel,
			seekDeliverPanel;
	public static JTabbedPane tab;
	private static FreePagePane seekExpressPage;
	private static DeliverVO delivervo;
	private static DeliverService deliver;
	private static AuditInfo audit;
	private static String userid;

	public static FreeReportPage createDeliverManagementPage(JTabbedPane tab) {
		deliver = new Deliver();
		audit = new Deliver();
		userid = StaffInfoPanel.userVO.getAccountnumber();
		DeliverManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("派送日期");
		model.addColumn("派件单号");
		model.addColumn("派送员");
		model.addColumn("营业厅业务员");
		ArrayList<DeliverVO> voList = new ArrayList<DeliverVO>();
		try {
			voList = deliver.findDWithdCondition(userid,
					DocumentCondition.handing);
		} catch (Exception e) {

		}
		for (Iterator<DeliverVO> i = voList.iterator(); i.hasNext();) {
			delivervo = i.next();
			Vector row = new Vector();
			row.add(delivervo.getTime());
			row.add(delivervo.getID());
			row.add(delivervo.getMember().get(0));
			row.add(delivervo.getWriter());
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
		FreeToolbarButton addDeliver, deleteDeliver, fixDeliver, seekDeliver;
		addDeliver = createButton("/free/test/add.png", "增加派件单", true);
		deleteDeliver = createButton("/free/test/update.png", "删除派件单", true);
		fixDeliver = createButton("/free/test/refresh.png", "修改派件单", true);
		seekDeliver = createButton("/free/test/print.png", "查找用户", true);
		page.getRightToolBar().add(addDeliver);
		page.getRightToolBar().add(deleteDeliver);
		page.getRightToolBar().add(fixDeliver);
		page.getRightToolBar().add(seekDeliver);

		addDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addDeliver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addDeliverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddDeliverPanel();
					tab.addTab(title, OfficerUI.createPage(addDeliverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addDeliverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteDeliver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteDeliverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteDeliverPanel();
					tab.addTab(title, OfficerUI.createPage(deleteDeliverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteDeliverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixDeliver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixDeliverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixDeliverPanel();
					tab.addTab(title, OfficerUI.createPage(fixDeliverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixDeliverPanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekDeliver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekDeliver.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekDeliverPanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekDeliverPanel();
					tab.addTab(title, OfficerUI.createPage(seekDeliverPanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekDeliverPanel);
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

	private static void createAddDeliverPanel() {
		addDeliverPanel = new JPanel();
		delivervo = new DeliverVO();
		ArrayList<String> memberList = new ArrayList<String>();
		ArrayList<String> orderList = new ArrayList<String>();

		JLabel deliverID = new JLabel("派件单号");
		JLabel date = new JLabel("派送日期");
		JButton addCourier = new JButton("添加派送员");
		JLabel officer = new JLabel("营业厅业务员");
		JButton addExpress = new JButton("添加快件");

		JTextField deliverIDfield = new JTextField(10);
		JTextField datefield = new JTextField(10);
		JTextField addCourierfield = new JTextField(10);
		JTextField officerfield = new JTextField(10);
		JTextField addExpressfield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, date, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, addCourier, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, officer, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, addExpress, constraints, 0, 4, 1, 1);

		BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, datefield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, addCourierfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, officerfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, addExpressfield, constraints, 1, 4, 1, 1);

		addExpress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!orderList.contains(addExpressfield.getText()))
					orderList.add(addExpressfield.getText());
			}
		});
		/***********************************************/

		addCourier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!memberList.contains(addCourier.getText()))
					memberList.add(addCourierfield.getText());
			}
		});
		/***********************************************/

		JButton submit = new JButton("提交");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					delivervo = deliver.newDeliver(deliverIDfield.getText(),
							officerfield.getText(), datefield.getText(),
							memberList, orderList, delivervo);
					System.out.println(deliver.saveDeliver(delivervo));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		/***********************************************/
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		addDeliverPanel.add(bpanel);
	}

	private static void createDeleteDeliverPanel() {
		deleteDeliverPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel deliverID = new JLabel("派件单号");
		JTextField deliverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除派件单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String memberString = "";
				try {
					delivervo = deliver.getDeliver(deliverIDfield.getText());
					ArrayList<String> memberList = delivervo.getMember();
					for (Iterator<String> i = memberList.iterator(); i
							.hasNext();)
						memberString = memberString + i.next() + "\r\n";
				} catch (Exception e) {
					e.printStackTrace();
				}

				bpanel.remove(submit);
				bpanel.remove(deliverID);
				bpanel.remove(deliverIDfield);

				JLabel deliverID = new JLabel("派件单号");
				JLabel date = new JLabel("派送日期");
				JLabel courier = new JLabel("派送员");
				JLabel officer = new JLabel("营业厅业务员");
				JButton delete = new JButton("确认删除");
				JButton seekExpress = new JButton("查询快件");

				JLabel deliverIDfield = new JLabel(delivervo.getID());
				JLabel datefield = new JLabel(delivervo.getTime());
				JLabel courierfield = new JLabel(memberString);
				JLabel officerfield = new JLabel(delivervo.getWriter());

				BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, date, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, courier, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, delete, constraints, 0, 5, 2, 1);

				BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, datefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 3, 1, 1);

				seekExpress.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String title = "查询快件";
						createSeekExpressPage();
						try {
							FreePagePane pagePane = FreeUtil
									.getPagePane(seekExpressPage);
							tab.setSelectedComponent(pagePane);
						} catch (Exception ex) {
							tab.addTab(title,
									OfficerUI.createPage(seekExpressPage));
							FreePagePane pagePane = FreeUtil
									.getPagePane(seekExpressPage);
							tab.setSelectedComponent(pagePane);
						}
					}
				});
				/***********************************************/

				delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							deliver.deleteDeliver(delivervo.getID());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
			}
		});

		deleteDeliverPanel.add(bpanel);
	}

	private static void createFixDeliverPanel() {
		fixDeliverPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel deliverID = new JLabel("派件单号");
		JTextField deliverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("修改派件单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bpanel.remove(submit);
				bpanel.remove(deliverID);
				bpanel.remove(deliverIDfield);

				ArrayList<String> orderList = new ArrayList<String>();
				ArrayList<String> memberList = new ArrayList<String>();

				JLabel deliverID = new JLabel("派件单号");
				JLabel date = new JLabel("派送日期");
				JButton addCourier = new JButton("添加派送员");
				JLabel officer = new JLabel("营业厅业务员");
				JButton addExpress = new JButton("添加快件");
				JButton fix = new JButton("确认修改");

				JTextField deliverIDfield = new JTextField(10);
				JTextField datefield = new JTextField(10);
				JTextField addCourierfield = new JTextField(10);
				JTextField officerfield = new JTextField(10);
				JTextField addExpressfield = new JTextField(10);

				BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, date, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, addCourier, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, addExpress, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, fix, constraints, 0, 5, 2, 1);

				BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, datefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, addCourierfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, addExpressfield, constraints, 1, 4, 1, 1);

				addExpress.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!orderList.contains(addExpressfield.getText()))
							orderList.add(addExpressfield.getText());
					}
				});
				/***********************************************/

				addCourier.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (!memberList.contains(addCourier.getText()))
							memberList.add(addCourierfield.getText());
					}
				});
				/***********************************************/
				fix.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							delivervo = deliver.newDeliver(
									deliverIDfield.getText(),
									officerfield.getText(),
									datefield.getText(), memberList, orderList,
									delivervo);
							System.out.println(deliver.saveDeliver(delivervo));
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
			}
		});

		fixDeliverPanel.add(bpanel);

	}

	private static void createSeekDeliverPanel() {
		seekDeliverPanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel deliverID = new JLabel("派件单号");
		JTextField deliverIDfield = new JTextField(10);
		BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询派件单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String memberString = "";
				try {
					delivervo = deliver.getDeliver(deliverID.getText());
					ArrayList<String> memberList = delivervo.getMember();
					for (Iterator<String> i = memberList.iterator(); i
							.hasNext();)
						memberString = memberString + i.next() + " ";
				} catch (Exception e) {
					e.printStackTrace();
				}
				submit.setText("确认");
				bpanel.remove(deliverID);
				bpanel.remove(deliverIDfield);
				JLabel deliverID = new JLabel("派件单号");
				JLabel date = new JLabel("派送日期");
				JLabel courier = new JLabel("派送员");
				JLabel officer = new JLabel("营业厅业务员");

				JButton seekExpress = new JButton("查询快件");
				seekExpress.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						String title = "查询快件";
						createSeekExpressPage();
						try {
							FreePagePane pagePane = FreeUtil
									.getPagePane(seekExpressPage);
							tab.setSelectedComponent(pagePane);
						} catch (Exception ex) {
							tab.addTab(title,
									OfficerUI.createPage(seekExpressPage));
							FreePagePane pagePane = FreeUtil
									.getPagePane(seekExpressPage);
							tab.setSelectedComponent(pagePane);
						}
					}
				});
				/***********************************************/

				JLabel deliverIDfield = new JLabel(delivervo.getID());
				JLabel datefield = new JLabel(delivervo.getTime());
				JLabel courierfield = new JLabel(memberString);
				JLabel officerfield = new JLabel(delivervo.getWriter());

				BaseUI.myAdd(bpanel, deliverID, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, date, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, courier, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, officer, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, seekExpress, constraints, 0, 4, 1, 1);

				BaseUI.myAdd(bpanel, deliverIDfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, datefield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, officerfield, constraints, 1, 3, 1, 1);
			}
		});

		seekDeliverPanel.add(bpanel);
	}

	private static void createSeekExpressPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("派送日期");
		model.addColumn("派件单号");
		model.addColumn("订单号");
		model.addColumn("营业厅业务员");

		ArrayList<String> orderList = delivervo.getOrder();

		for (Iterator<String> i = orderList.iterator(); i.hasNext();) {
			Vector row = new Vector();
			row.add(delivervo.getTime());
			row.add(delivervo.getID());
			row.add(i.next());
			row.add(delivervo.getWriter());
			model.addRow(row);
		}

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created "
				+ new Date().toString());
		setupPageToolbar(page);

		seekExpressPage = page;
	}
}
