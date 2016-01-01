package officerui;

import java.awt.Color;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import auditsl.AuditInfo;
import main.StaffInfoPanel;
import dataserviceimpl.DataFactory;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Traffic;
import enums.TransportType;
import strategysl.Constant;
import strategysl.ConstantController;
import transportsl.Transport;
import transportsl.TransportController;
import transportslservice.TransportService;
import twaver.TWaverUtil;
import vo.DeliverVO;
import vo.TransportVO;
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
	private static FreePagePane seekExpressPage;
	public static TransportService transportController;
	private static AuditInfo audit;
	private static DataFactory dataFactory;
	private static ConstantController constantController;
	private static Transport transport;
	private static String userid;
	private static TransportVO transportvo;

	public static FreeReportPage createEntruckManagementPage(JTabbedPane tab) {
		EntruckManagementPanel.tab = tab;
		try {
			dataFactory = DataFactory.create();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

		constantController = new ConstantController();
		transport = new Transport(dataFactory, constantController);
		transportController = new TransportController(transport);
		userid = StaffInfoPanel.userVO.getAccountnumber();
		audit = new TransportController(transport);
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		ArrayList<TransportVO> transportList = new ArrayList<TransportVO>();
		ArrayList<String> memberList = new ArrayList<String>();
		try {
			transportList = transportController.getTransportList(userid,
					DocumentCondition.handing);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		model.addColumn("装车日期");
		model.addColumn("装车单编号");
		model.addColumn("汽运编号");
		model.addColumn("到达地");
		model.addColumn("车辆编号");
		model.addColumn("营业厅营业员");
		model.addColumn("运费");

		for (Iterator<TransportVO> i = transportList.iterator(); i.hasNext();) {
			transportvo = i.next();
			memberList = transportvo.getMember();
			String member = "";
			Vector row = new Vector();
			row.add(transportvo.getTime());
			row.add(transportvo.getID());
			row.add(transportvo.getTransportID());
			row.add(transportvo.getDestination());
			row.add(transportvo.getTrafficID());
			row.add(transportvo.getWriter());
			row.add(transportvo.getfare());
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
					createAddEntruckPanel();
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
					createDeleteEntruckPanel();
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
					createFixEntruckPanel();
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
					createSeekEntruckPanel();
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

	private static void createAddEntruckPanel() {
		addEntruckPanel = new JPanel();

		JLabel date = new JLabel("装车日期");
		JLabel entruckID = new JLabel("装车单编号");
		JLabel transportID = new JLabel("汽运编号");
		JLabel destination = new JLabel("到达地");
		JLabel vehicleID = new JLabel("车辆编号");
		JLabel member = new JLabel("相关人员");
		JButton express = new JButton("添加快件");
		JLabel condition = new JLabel("货物到达状态");

		date.setOpaque(true);
		date.setBackground(Color.lightGray);
		date.setFont(new java.awt.Font("Dialog", 1, 15));
		entruckID.setOpaque(true);
		entruckID.setBackground(Color.lightGray);
		entruckID.setFont(new java.awt.Font("Dialog", 1, 15));
		transportID.setOpaque(true);
		transportID.setBackground(Color.lightGray);
		transportID.setFont(new java.awt.Font("Dialog", 1, 15));
		destination.setOpaque(true);
		destination.setBackground(Color.lightGray);
		destination.setFont(new java.awt.Font("Dialog", 1, 15));
		vehicleID.setOpaque(true);
		vehicleID.setBackground(Color.lightGray);
		vehicleID.setFont(new java.awt.Font("Dialog", 1, 15));
		member.setOpaque(true);
		member.setBackground(Color.lightGray);
		member.setFont(new java.awt.Font("Dialog", 1, 15));
		condition.setOpaque(true);
		condition.setBackground(Color.lightGray);
		condition.setFont(new java.awt.Font("Dialog", 1, 15));

		JTextField datefield = new JTextField(10);
		JTextField entruckIDfield = new JTextField(10);
		JTextField transportIDfield = new JTextField(10);
		JTextField destinationfield = new JTextField(10);
		JTextField vehicleIDfield = new JTextField(10);

		JTextArea memberfield = new JTextArea(4, 10);
		JScrollPane memberscroll = new JScrollPane(memberfield);
		memberscroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		memberscroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		JTextField expressfield = new JTextField(10);
		JComboBox conditionfield = new JComboBox();
		conditionfield.addItem("完整");
		conditionfield.addItem("损坏");
		conditionfield.addItem("丢失");
		ArrayList<String> orderList = new ArrayList<String>();
		ArrayList<Condition> conditionList = new ArrayList<Condition>();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(20, 0, 20, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, express, constraints, 0, 6, 1, 1);
		BaseUI.myAdd(bpanel, condition, constraints, 0, 7, 1, 1);

		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, memberscroll, constraints, 1, 5, 1, 1);
		BaseUI.myAdd(bpanel, expressfield, constraints, 1, 6, 1, 1);
		BaseUI.myAdd(bpanel, conditionfield, constraints, 1, 7, 1, 1);

		express.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!orderList.contains(expressfield.getText())) {
					orderList.add(expressfield.getText());
					switch (conditionfield.getSelectedIndex()) {
					case 0:
						conditionList.add(Condition.perfect);
						break;
					case 1:
						conditionList.add(Condition.damage);
						break;
					case 2:
						conditionList.add(Condition.lost);
						break;
					}
				}
				String[] orderString = new String[orderList.size()];
				for (int i = 0; i < orderList.size(); i++)
					orderString[i] = orderList.get(i) + conditionList.get(i);
				JList cList = new JList(orderString);
				BaseUI.myAdd(bpanel, cList, constraints, 2, 6, 1, 1);
			}
		});
		/***********************************************/

		JButton submit = new JButton("提交");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					ArrayList<String> memberList = new ArrayList<String>();
					String[] memberString = memberfield.getText().split("\n");
					for (int i = 0; i < memberString.length; i++)
						memberList.add(memberString[i]);

					transportvo = transportController.newTransport(
							TransportType.Entruck, entruckIDfield.getText(),
							entruckIDfield.getText().substring(0, 6),
							destinationfield.getText().substring(0, 6),
							transportIDfield.getText(), datefield.getText(),
							vehicleIDfield.getText(), Traffic.Car, 0,
							memberList, orderList, conditionList,
							DocumentCondition.handing, userid);
					transportvo.setFare(transportController
							.addFare(transportvo));
					transportController.saveTransport(transportvo);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		/***********************************************/
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		addEntruckPanel.add(bpanel);
	}

	private static void createDeleteEntruckPanel() {
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
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					transportvo = transportController
							.getTransport(entruckIDfield.getText());
					ArrayList<String> memberList = transportvo.getMember();
					String[] memberString = new String[memberList.size()];
					for (int i = 0; i < memberList.size(); i++)
						memberString[i] = memberList.get(i);
					JList memberfield = new JList(memberString);
					BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				bpanel.remove(submit);
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

				date.setOpaque(true);
				date.setBackground(Color.lightGray);
				date.setFont(new java.awt.Font("Dialog", 1, 15));
				entruckID.setOpaque(true);
				entruckID.setBackground(Color.lightGray);
				entruckID.setFont(new java.awt.Font("Dialog", 1, 15));
				transportID.setOpaque(true);
				transportID.setBackground(Color.lightGray);
				transportID.setFont(new java.awt.Font("Dialog", 1, 15));
				destination.setOpaque(true);
				destination.setBackground(Color.lightGray);
				destination.setFont(new java.awt.Font("Dialog", 1, 15));
				vehicleID.setOpaque(true);
				vehicleID.setBackground(Color.lightGray);
				vehicleID.setFont(new java.awt.Font("Dialog", 1, 15));
				member.setOpaque(true);
				member.setBackground(Color.lightGray);
				member.setFont(new java.awt.Font("Dialog", 1, 15));
				fee.setOpaque(true);
				fee.setBackground(Color.lightGray);
				fee.setFont(new java.awt.Font("Dialog", 1, 15));

				JLabel datefield = new JLabel(transportvo.getTime());
				JLabel entruckIDfield = new JLabel(transportvo.getID());
				JLabel transportIDfield = new JLabel(transportvo
						.getTransportID());
				JLabel destinationfield = new JLabel(transportvo
						.getDestination());
				JLabel vehicleIDfield = new JLabel(transportvo.getTrafficID());
				JLabel feefield = new JLabel(transportvo.getfare() + "");

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
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

				JButton delete = new JButton("确认删除");
				BaseUI.myAdd(bpanel, delete, constraints, 0, 8, 2, 1);

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
							transportController.deleteTransport(entruckIDfield
									.getText());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
			}
		});

		deleteEntruckPanel.add(bpanel);
	}

	private static void createFixEntruckPanel() {
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
				String memberString = "";
				String orderString = "";
				ArrayList<String> orderList;
				ArrayList<String> memberList;
				try {
					transportvo = transportController
							.getTransport(entruckIDfield.getText());
					memberList = transportvo.getMember();
					orderList = transportvo.getOrder();
					for (Iterator<String> i = memberList.iterator(); i
							.hasNext();)
						memberString = memberString + i.next() + "\r\n";
					for (Iterator<String> i = orderList.iterator(); i.hasNext();)
						orderString = orderString + i.next() + "\r\n";
				} catch (Exception e) {
					e.printStackTrace();
				}

				bpanel.remove(submit);
				bpanel.remove(entruckID);
				bpanel.remove(entruckIDfield);

				JLabel date = new JLabel("装车日期");
				JLabel entruckID = new JLabel("装车单编号");
				JLabel transportID = new JLabel("汽运编号");
				JLabel destination = new JLabel("到达地");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel member = new JLabel("相关人员");
				JLabel express = new JLabel("添加快件");
				JLabel condition = new JLabel("货物到达状态");

				date.setOpaque(true);
				date.setBackground(Color.lightGray);
				date.setFont(new java.awt.Font("Dialog", 1, 15));
				entruckID.setOpaque(true);
				entruckID.setBackground(Color.lightGray);
				entruckID.setFont(new java.awt.Font("Dialog", 1, 15));
				transportID.setOpaque(true);
				transportID.setBackground(Color.lightGray);
				transportID.setFont(new java.awt.Font("Dialog", 1, 15));
				destination.setOpaque(true);
				destination.setBackground(Color.lightGray);
				destination.setFont(new java.awt.Font("Dialog", 1, 15));
				vehicleID.setOpaque(true);
				vehicleID.setBackground(Color.lightGray);
				vehicleID.setFont(new java.awt.Font("Dialog", 1, 15));
				member.setOpaque(true);
				member.setBackground(Color.lightGray);
				member.setFont(new java.awt.Font("Dialog", 1, 15));
				express.setOpaque(true);
				express.setBackground(Color.lightGray);
				express.setFont(new java.awt.Font("Dialog", 1, 15));
				condition.setOpaque(true);
				condition.setBackground(Color.lightGray);
				condition.setFont(new java.awt.Font("Dialog", 1, 15));

				JTextField datefield = new JTextField(10);
				JLabel entruckIDfield = new JLabel(transportvo.getID());
				JTextField transportIDfield = new JTextField(10);
				JTextField destinationfield = new JTextField(10);
				JTextField vehicleIDfield = new JTextField(10);

				JTextArea memberfield = new JTextArea(4, 10);
				JScrollPane memberscroll = new JScrollPane(memberfield);
				memberscroll
						.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				memberscroll
						.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				JTextArea expressfield = new JTextArea(4, 10);
				JScrollPane expressscroll = new JScrollPane(expressfield);
				expressscroll
						.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				expressscroll
						.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

				datefield.setText(transportvo.getTime());
				transportIDfield.setText(transportvo.getTransportID());
				destinationfield.setText(transportvo.getDestination());
				vehicleIDfield.setText(transportvo.getTrafficID());
				memberfield.setText(memberString);
				expressfield.setText(orderString);

				JComboBox addConditionfield = new JComboBox();
				addConditionfield.addItem("完整");
				addConditionfield.addItem("损坏");
				addConditionfield.addItem("丢失");

				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, destination, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, member, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, express, constraints, 0, 6, 1, 1);
				BaseUI.myAdd(bpanel, condition, constraints, 0, 7, 1, 1);

				BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, entruckIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, transportIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, destinationfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, memberscroll, constraints, 1, 5, 1, 1);
				BaseUI.myAdd(bpanel, expressscroll, constraints, 1, 6, 1, 1);
				BaseUI.myAdd(bpanel, addConditionfield, constraints, 1, 7, 1, 1);

				JButton fix = new JButton("确认修改");
				BaseUI.myAdd(bpanel, fix, constraints, 0, 8, 2, 1);
				fix.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						ArrayList<String> orderList = new ArrayList<String>();
						ArrayList<String> memberList = new ArrayList<String>();
						ArrayList<Condition> conditionList = new ArrayList<Condition>();

						String[] memberString = memberfield.getText().split(
								"\n");
						String[] expressString = expressfield.getText().split(
								"\n");
						for (int i = 0; i < memberString.length; i++)
							memberList.add(memberString[i]);
						for (int i = 0; i < expressString.length; i++) {
							orderList.add(expressString[i]);
							conditionList.add(Condition.perfect);
						}
						try {
							transportvo = transportController.newTransport(
									TransportType.Entruck, entruckIDfield
											.getText(), entruckIDfield
											.getText().substring(0, 6),
									destinationfield.getText(),
									transportIDfield.getText(), datefield
											.getText(), vehicleIDfield
											.getText(), Traffic.Car, 0,
									memberList, orderList, conditionList,
									DocumentCondition.handing, userid);
							transportvo.setFare(transportController
									.addFare(transportvo));
							transportController.saveTransport(transportvo);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
			}

		});

		fixEntruckPanel.add(bpanel);

	}

	private static void createSeekEntruckPanel() {
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

		JButton submit = new JButton("查询装车单信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 8, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					transportvo = transportController
							.getTransport(entruckIDfield.getText());
					ArrayList<String> memberList = transportvo.getMember();
					String[] memberString = new String[memberList.size()];
					for (int i = 0; i < memberList.size(); i++)
						memberString[i] = memberList.get(i);
					JList memberfield = new JList(memberString);
					BaseUI.myAdd(bpanel, memberfield, constraints, 1, 5, 1, 1);
				} catch (Exception e) {
					e.printStackTrace();
				}
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

				date.setOpaque(true);
				date.setBackground(Color.lightGray);
				date.setFont(new java.awt.Font("Dialog", 1, 15));
				entruckID.setOpaque(true);
				entruckID.setBackground(Color.lightGray);
				entruckID.setFont(new java.awt.Font("Dialog", 1, 15));
				transportID.setOpaque(true);
				transportID.setBackground(Color.lightGray);
				transportID.setFont(new java.awt.Font("Dialog", 1, 15));
				destination.setOpaque(true);
				destination.setBackground(Color.lightGray);
				destination.setFont(new java.awt.Font("Dialog", 1, 15));
				vehicleID.setOpaque(true);
				vehicleID.setBackground(Color.lightGray);
				vehicleID.setFont(new java.awt.Font("Dialog", 1, 15));
				member.setOpaque(true);
				member.setBackground(Color.lightGray);
				member.setFont(new java.awt.Font("Dialog", 1, 15));
				fee.setOpaque(true);
				fee.setBackground(Color.lightGray);
				fee.setFont(new java.awt.Font("Dialog", 1, 15));
				
				JLabel datefield = new JLabel(transportvo.getTime());
				JLabel entruckIDfield = new JLabel(transportvo.getID());
				JLabel transportIDfield = new JLabel(transportvo
						.getTransportID());
				JLabel destinationfield = new JLabel(transportvo
						.getDestination());
				JLabel vehicleIDfield = new JLabel(transportvo.getTrafficID());
				JLabel feefield = new JLabel(transportvo.getfare() + "");

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
				BaseUI.myAdd(bpanel, feefield, constraints, 1, 6, 1, 1);

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
			}

		});

		seekEntruckPanel.add(bpanel);
	}

	private static void createSeekExpressPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("装车日期");
		model.addColumn("装车单编号");
		model.addColumn("汽运编号");
		model.addColumn("车辆编号");
		model.addColumn("订单号");
		model.addColumn("到达地");
		model.addColumn("货物到达状态");
		model.addColumn("运费");

		ArrayList<String> orderList = transportvo.getOrder();
		ArrayList<Condition> conditionList = transportvo.getCondition();

		for (int i = 0; i < orderList.size(); i++) {
			Vector row = new Vector();
			row.add(transportvo.getTime());
			row.add(transportvo.getID());
			row.add(transportvo.getTransportID());
			row.add(transportvo.getTrafficID());
			row.add(orderList.get(i));
			row.add(transportvo.getDestination());
			row.add(conditionList.get(i));
			row.add(transportvo.getfare());
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
