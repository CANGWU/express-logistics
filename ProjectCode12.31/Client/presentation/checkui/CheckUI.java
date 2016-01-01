package checkui;

import free.*;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;

import main.FreeLoginUI;
import main.StaffInfoPanel;
import main.StaffUI;
import twaver.TWaverUtil;

public class CheckUI extends StaffUI{

    private String menuBarXML = "/free/menubar.xml";
    private String toolbarXML = "/free/toolbar.xml";
    private String outlookPaneXML = "/checkui/checkoutlook.xml";
    private String ordernumber;
    private ActionListener defaultAction = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            command(command);
        }
    };
    private String productName = "快递物流系统";
    private String companyName = "33";
    private FreeMenuBar menubar = FreeUtil.loadMenuBar(menuBarXML, defaultAction);
    private FreeContentPane contentPane = new FreeContentPane();
    private FreeStatusBar statusBar = new FreeStatusBar();
    private FreeMemoryBar memoryBar = new FreeMemoryBar();
    private FreeStatusMessageLabel lbStatusMessage = new FreeStatusMessageLabel();
    private FreeStatusTimeLabel lbStatusTime = new FreeStatusTimeLabel();
    private FreeStatusLabel lbServer = createStatusLabel("218.83.152.220", "/free/test/server.png");
    private FreeStatusLabel lbUser = createStatusLabel("admin", "/free/test/user.png");
    private FreeStatusLabel lbVersion = createStatusLabel("v3.0.0", null);
    private FreeOutlookPane outlookPane = new FreeOutlookPane();
    private FreeTabbedPane tab = new FreeTabbedPane();
    private static FreePagePane logisticsPage=null;


    public CheckUI(String ordernumber) {
    	this.ordernumber=ordernumber;
        initSwing();
        initOutlookPane();
        initTab();
      //  initStatusBar();
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
     //   centerPane.add(shortcutPane, BorderLayout.EAST);
        centerPane.add(outlookPane, BorderLayout.WEST);
        contentPane.add(centerPane, BorderLayout.CENTER);
        centerPane.add(tab, BorderLayout.CENTER);
        lbStatusMessage.setText("Server is connected");
    }

    private void initOutlookPane() {
    	//   FreeUtil.loadOutlookToolBar(toolbarXML, outlookPane.getHeader(), defaultAction);
         MouseListener barActionListener = new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                Object source = e.getSource();
                if(e.getSource() instanceof JLabel){

                	JLabel label=(JLabel) source;
//                	FreeOutlookBar bar=(FreeOutlookBar) label.getParent();
//                	bar.setSelected(true);
                	String title=label.getText();
                	

                		
                        try{
                               tab.setSelectedComponent(logisticsPage);

                           }catch(Exception ex){
                        	   logisticsPage=LogisticsPanel.createReportPage(ordernumber);
                               tab.add(title, logisticsPage);
                               tab.setSelectedComponent(logisticsPage);
                           }


 

                    
                }
            }
        };

           ActionListener shortcutAction = defaultAction;
          FreeUtil.loadOutlookPane(outlookPaneXML, outlookPane,barActionListener, shortcutAction);
    }
    

	


		
	


    private void initTab() {
        //double click tab title, shink left/right side bars.
        tab.addMouseListener(new MouseAdapter() {

            private boolean isMaximized() {
                return outlookPane.isShrinked();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    TabbedPaneUI ui = tab.getUI();
                    int tabIndex = ui.tabForCoordinate(tab, e.getX(), e.getY());
                    //only when tab header is clicked.
                    if (tabIndex != -1) {
                        boolean maxed = isMaximized();
                        outlookPane.setShrink(!maxed);
                    }
                }
            }
        });
 	   logisticsPage=LogisticsPanel.createReportPage(ordernumber);
       tab.add("物流信息查看", logisticsPage);
       tab.setSelectedComponent(logisticsPage);
        
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
        statusBar.getRightPane().add(createStatusLabel("Powered by " + productName, null));
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
                                lbStatusMessage.setText("Server connection is slow");
                            }
                            if (i == 2) {
                                lbStatusMessage.setRedLight();
                                lbStatusMessage.setText("Server connection is broken");
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
//        setupPageToolbar(page);
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

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//
//            public void run() {
//                FreeUtil.setupLookAndFeel();
//                AdminUI shell = new AdminUI();
//                shell.setVisible(true);
//            }
//        });
//    }
}
