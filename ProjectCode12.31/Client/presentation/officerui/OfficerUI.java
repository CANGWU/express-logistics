package officerui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.TabbedPaneUI;

import main.FreeLoginUI;
import main.StaffInfoPanel;
import main.StaffUI;
import free.FreeContentPane;
import free.FreeGarbageCollectButton;
import free.FreeMemoryBar;
import free.FreeMenuBar;
import free.FreeOutlookPane;
import free.FreePagePane;
import free.FreeStatusBar;
import free.FreeStatusLabel;
import free.FreeStatusMessageLabel;
import free.FreeStatusTimeLabel;
import free.FreeTabbedPane;
import free.FreeUtil;
import officerui.DeliverManagementPanel;
import officerui.ConsigneeManagementPanel;
import officerui.DriverManagementPanel;
import officerui.VehicleManagementPanel;
import officerui.EntruckManagementPanel;
import officerui.GatherManagementPanel;
import twaver.TWaverUtil;

public class OfficerUI extends StaffUI {

	private String menuBarXML = "/free/menubar.xml";
	private String toolbarXML = "/free/toolbar.xml";
	private String outlookPaneXML = "/officerui/officeroutlook.xml";
	private ActionListener defaultAction = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			command(command);
		}
	};
	private String productName = "快递物流系统";
	private String companyName = "33";
	private String userId;
	private FreeMenuBar menubar = FreeUtil.loadMenuBar(menuBarXML,
			defaultAction);
	private FreeContentPane contentPane = new FreeContentPane();
	private FreeStatusBar statusBar = new FreeStatusBar();
	private FreeMemoryBar memoryBar = new FreeMemoryBar();
	private FreeStatusMessageLabel lbStatusMessage = new FreeStatusMessageLabel();
	private FreeStatusTimeLabel lbStatusTime = new FreeStatusTimeLabel();
	private FreeStatusLabel lbServer = createStatusLabel("218.83.152.220",
			"/free/test/server.png");
	private FreeStatusLabel lbUser = createStatusLabel("admin",
			"/free/test/user.png");
	private FreeStatusLabel lbVersion = createStatusLabel("v3.0.0", null);
	private FreeOutlookPane outlookPane = new FreeOutlookPane();
	private FreeTabbedPane tab = new FreeTabbedPane();
	private boolean isUserManagementExist = false;
	private boolean isDeliverManagementExist = false;
	private static FreePagePane userManagementPage = null;
	private static FreePagePane deliverManagementPage = null;
	private static FreePagePane entruckManagementPage = null;
	private static FreePagePane vehicleManagementPage = null;
	private static FreePagePane driverManagementPage = null;
	private static FreePagePane gatherManagementPage = null;
	private static FreePagePane consigneeManagementPage = null;
	private static FreePagePane userInfoPage=null;
	
	
	public OfficerUI(String userId) {
		this.userId=userId;
		initSwing();
		initOutlookPane();
		initTab();
		initStatusBar();
		initMockers();
	}

	private void initSwing() {
		this.setTitle(productName + " ——by " + companyName);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 768);
		this.setIconImage(TWaverUtil.getImage("/free/test/logo.png"));

		this.setContentPane(contentPane);
		TWaverUtil.centerWindow(this);
		contentPane.add(menubar, BorderLayout.NORTH);
		contentPane.add(statusBar, BorderLayout.SOUTH);

		JPanel centerPane = new JPanel(new BorderLayout());
		centerPane.setOpaque(true);
		centerPane.setBackground(FreeUtil.CONTENT_PANE_BACKGROUND);
		centerPane.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
		// centerPane.add(shortcutPane, BorderLayout.EAST);
		centerPane.add(outlookPane, BorderLayout.WEST);
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.add(tab, BorderLayout.CENTER);
		lbStatusMessage.setText("Server is connected");
	}

	private void initOutlookPane() {
		// FreeUtil.loadOutlookToolBar(toolbarXML, outlookPane.getHeader(),
		// defaultAction);
		MouseListener barActionListener = new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				Object source = e.getSource();
				if (e.getSource() instanceof JLabel) {

					JLabel label = (JLabel) source;
					// FreeOutlookBar bar=(FreeOutlookBar) label.getParent();
					// bar.setSelected(true);
					String title = label.getText();
					if (title.equals("个人信息")) {
                        try{
                            tab.setSelectedComponent(userInfoPage);

                           }catch(Exception ex){
                        	   userInfoPage=StaffInfoPanel.createStaffInfoPage(tab,userId);
                               tab.add(title, userInfoPage);
                               tab.setSelectedComponent(userInfoPage);
                           }
					} else if (title.equals("派件管理")) {

						try {
							tab.setSelectedComponent(deliverManagementPage);
						} catch (Exception ex) {
							deliverManagementPage = DeliverManagementPanel
									.createDeliverManagementPage(tab);
							tab.add(title, deliverManagementPage);
							tab.setSelectedComponent(deliverManagementPage);
						}

					} else if (title.equals("装车管理")) {

						try {
							tab.setSelectedComponent(entruckManagementPage);
						} catch (Exception ex) {
							entruckManagementPage = EntruckManagementPanel
									.createEntruckManagementPage(tab);
							tab.add(title, entruckManagementPage);
							tab.setSelectedComponent(entruckManagementPage);
						}

					} else if (title.equals("车辆信息管理")) {

						try {
							tab.setSelectedComponent(vehicleManagementPage);
						} catch (Exception ex) {
							vehicleManagementPage = VehicleManagementPanel
									.createVehicleManagementPage(tab);
							tab.add(title, vehicleManagementPage);
							tab.setSelectedComponent(vehicleManagementPage);
						}

					} else if (title.equals("司机信息管理")) {

						try {
							tab.setSelectedComponent(driverManagementPage);
						} catch (Exception ex) {
							driverManagementPage = DriverManagementPanel
									.createDriverManagementPage(tab);
							tab.add(title, driverManagementPage);
							tab.setSelectedComponent(driverManagementPage);
						}

					} else if (title.equals("收款管理")) {

						try {
							tab.setSelectedComponent(gatherManagementPage);
						} catch (Exception ex) {
							gatherManagementPage = GatherManagementPanel
									.createGatherManagementPage(tab);
							tab.add(title, gatherManagementPage);
							tab.setSelectedComponent(gatherManagementPage);
						}

					} else if (title.equals("收件管理")) {

						try {
							tab.setSelectedComponent(consigneeManagementPage);
						} catch (Exception ex) {
							consigneeManagementPage = ConsigneeManagementPanel
									.createConsigneeManagementPage(tab);
							tab.add(title, consigneeManagementPage);
							tab.setSelectedComponent(consigneeManagementPage);
						}

					}

				}
			}
		};

		ActionListener shortcutAction = defaultAction;
		FreeUtil.loadOutlookPane(outlookPaneXML, outlookPane,
				barActionListener, shortcutAction);
	}

	private void initTab() {
		// double click tab title, shrink left/right side bars.
		tab.addMouseListener(new MouseAdapter() {

			private boolean isMaximized() {
				return outlookPane.isShrinked();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() > 1) {
					TabbedPaneUI ui = tab.getUI();
					int tabIndex = ui.tabForCoordinate(tab, e.getX(), e.getY());
					// only when tab header is clicked.
					if (tabIndex != -1) {
						boolean maxed = isMaximized();
						outlookPane.setShrink(!maxed);
					}
				}
			}
		});
		
 	   userInfoPage=StaffInfoPanel.createStaffInfoPage(tab,userId);
       tab.add("个人信息", userInfoPage);
       tab.setSelectedComponent(userInfoPage);
	}

	private void initStatusBar() {
		statusBar.getLeftPane().add(lbStatusMessage, BorderLayout.CENTER);
		statusBar.addSeparator();
		statusBar.getRightPane().add(memoryBar);
		statusBar.addSeparator();
		statusBar.getRightPane().add(new FreeGarbageCollectButton());
		statusBar.addSeparator();
		statusBar.getRightPane().add(lbServer);
		statusBar.addSeparator();
		statusBar.getRightPane().add(lbUser);
		statusBar.addSeparator();
		statusBar.getRightPane().add(lbStatusTime);
		statusBar.addSeparator();
		statusBar.getRightPane().add(lbVersion);
		statusBar.addSeparator();
		statusBar.getRightPane().add(
				createStatusLabel("Powered by " + productName, null));
	}

	public void setServer(String server) {
		lbServer.setText(server);
	}

	public void setUser(String username) {
		lbUser.setText(username);
	}

	public void setVersion(String version) {
		lbVersion.setText(version);
	}

	private void initMockers() {

		Thread thread = new Thread() {

			@Override
			public void run() {
				while (true) {
					for (int i = 0; i < 3; i++) {
						try {
							Thread.sleep(5000);
							if (i == 0) {
								lbStatusMessage.setGreenLight();
								lbStatusMessage.setText("Server is connected");
							}
							if (i == 1) {
								lbStatusMessage.setOrangeLight();
								lbStatusMessage
										.setText("Server connection is slow");
							}
							if (i == 2) {
								lbStatusMessage.setRedLight();
								lbStatusMessage
										.setText("Server connection is broken");
							}
						} catch (InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		};
		thread.start();
	}

	public static FreePagePane createPage(JComponent pageContent) {
		FreePagePane page = new FreePagePane(pageContent);
		// setupPageToolbar(page);
		return page;
	}

	private FreeStatusLabel createStatusLabel(String text, String imageURL) {
		if (imageURL != null) {
			return new FreeStatusLabel(text, TWaverUtil.getIcon(imageURL));
		} else {
			return new FreeStatusLabel(text);
		}
	}

	public void command(String action) {
		String message = "Perform action " + action + ".";
		this.lbStatusMessage.setText(message);
        if(action.equals("登出")){
        	dispose();
            FreeLoginUI ui = new FreeLoginUI();
            ui.setVisible(true);
        }
	}

}
