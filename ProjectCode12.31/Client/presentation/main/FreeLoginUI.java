package main;

import adminui.AdminUI;
import checksl.CheckController;
import checkui.CheckUI;

import com.sun.awt.AWTUtilities;

import courierui.CourierUI;
import dataserviceimpl.DataFactory;
import enums.LoginResult;
import enums.ResultMessage;
import financeui.FinanceUI;
import free.FreeLoadingUI;
import free.FreePasswordField;
import free.FreeTextField;
import free.FreeUtil;
import managerui.ManagerUI;
import transportui.TransportUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

import officerui.OfficerUI;
import twaver.TWaverUtil;
import twaver.swing.LabelValueLayout;
import usersl.Login;

public class FreeLoginUI extends JFrame {

	DataFactory datafactory=null;
    private ImageIcon loginButtonIcon = FreeUtil.getImageIcon("login_button.png");
    private ImageIcon loginButtonRoverIcon = FreeUtil.getImageIcon("login_button_rover.png");
    private ImageIcon loginButtonPressedIcon = FreeUtil.getImageIcon("login_button_pressed.png");
    private ImageIcon closeButtonIcon = FreeUtil.getImageIcon("login_close.png");
    private ImageIcon closeButtonRoverIcon = FreeUtil.getImageIcon("login_close_rover.png");
    private ImageIcon closeButtonPressedIcon = FreeUtil.getImageIcon("login_close_pressed.png");
    private JButton btnLogin = createTransparentButton(loginButtonIcon, loginButtonRoverIcon, loginButtonPressedIcon);
    private JButton btnClose = createTransparentButton(closeButtonIcon, closeButtonRoverIcon, closeButtonPressedIcon);
    private JButton btnCheck=new JButton("进入物流查询页面");
    private ImageIcon logoIcon = FreeUtil.getImageIcon("login_logo.png");
    private String logoRoverURL = FreeUtil.getImageURL("login_logo_rover.png");
    private ImageIcon logoRoverIcon = TWaverUtil.getImageIcon(logoRoverURL);
    private ImageIcon leftTopIcon = FreeUtil.getImageIcon("login_left_top.png");
    private ImageIcon leftIcon = FreeUtil.getImageIcon("login_left.png");
    private ImageIcon rightIcon = FreeUtil.getImageIcon("login_right.png");
    private int width = loginButtonIcon.getIconWidth();
    private int height = loginButtonIcon.getIconHeight() + leftIcon.getIconHeight() + logoIcon.getIconHeight();
    private JLabel logoLabel = createDraggableLabel(logoIcon);
    private FreePasswordField accountfield;
    private JPasswordField codefield;
    private boolean isLogin=true;
   
    private JPanel inputPane = new JPanel() {

        private String backgroundImageURL = FreeUtil.getImageURL("login_background.png");
        private TexturePaint paint = FreeUtil.createTexturePaint(backgroundImageURL);

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(paint);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
    };
    private MouseAdapter moveWindowListener = new MouseAdapter() {

        private Point lastPoint = null;

        @Override
        public void mousePressed(MouseEvent e) {
            lastPoint = e.getLocationOnScreen();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point point = e.getLocationOnScreen();
            int offsetX = point.x - lastPoint.x;
            int offsetY = point.y - lastPoint.y;
            Rectangle bounds = FreeLoginUI.this.getBounds();
            bounds.x += offsetX;
            bounds.y += offsetY;
            FreeLoginUI.this.setBounds(bounds);
            lastPoint = point;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == logoLabel) {
                logoLabel.setIcon(logoRoverIcon);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == logoLabel) {
                logoLabel.setIcon(logoIcon);
            }
        }
    };

    public FreeLoginUI() {
        init();
    }

    private void init() {
    	try {
			datafactory=DataFactory.create();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        AWTUtilities.setWindowOpaque(this, false);

        JPanel centerPane = new JPanel(new BorderLayout());
        centerPane.add(btnLogin, BorderLayout.SOUTH);
        this.setContentPane(centerPane);
        this.setSize(width, height);
        TWaverUtil.centerWindow(this);

        btnLogin.addActionListener(new ActionListener() {

           
			public void actionPerformed(ActionEvent e) {
                if(isLogin){
    				LoginResult result=check(accountfield.getText(),codefield.getText());
    				
    				if(result==null){
    					
    				}else if(result==LoginResult.WrongAccount){
                        accountfield.setText("账号错误");
                    }else if(result==LoginResult.WrongCode){
                        codefield.setText("密码错误");
                    }else{
                    	 login(result);
                    }
                }else{
                	CheckController cc=null;
					try {
						cc = new CheckController(DataFactory.create());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                
                	if(cc.orderNumberCheck(accountfield.getText())==null){
                		accountfield.setText("订单号不存在");
                	}else{
                		login(LoginResult.Check);
                	}
                	
                	
                }

            }
        });


        btnClose.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnClose.setToolTipText("Close");

        JPanel topPane = new JPanel(new BorderLayout());

        logoLabel.setOpaque(false);
        topPane.setOpaque(false);

        logoLabel.addMouseListener(moveWindowListener);
        logoLabel.addMouseMotionListener(moveWindowListener);
        topPane.addMouseListener(moveWindowListener);
        topPane.addMouseMotionListener(moveWindowListener);

        topPane.add(logoLabel, BorderLayout.CENTER);
        topPane.add(createDraggableLabel(this.leftTopIcon), BorderLayout.WEST);
        topPane.add(btnClose, BorderLayout.EAST);

        centerPane.add(createDraggableLabel(this.leftIcon), BorderLayout.WEST);
        centerPane.add(createDraggableLabel(this.rightIcon), BorderLayout.EAST);
        centerPane.add(topPane, BorderLayout.NORTH);
        centerPane.add(inputPane, BorderLayout.CENTER);

        inputPane.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        inputPane.setLayout(new LabelValueLayout(10, 50, false));
//        inputPane.add(createInputLabel("Server:"));
//        inputPane.add(new FreeTextField("localhost"));
//        inputPane.add(createInputLabel("Company:"));
//        inputPane.add(new FreeSearchTextField());

        
        JLabel accountLabel=createInputLabel("账号:");
        inputPane.add(accountLabel);
        accountfield=new FreePasswordField();
        inputPane.add(accountfield);
        JLabel codeLabel=createInputLabel("密码:");
        inputPane.add(codeLabel);
        codefield=new JPasswordField();
        codefield.setEchoChar('*');
        inputPane.add(codefield);
        
        
        
//        inputPane.add(createInputLabel("Language:"));
//        inputPane.add(new FreeTextField(TWaverUtil.getLocale().toString()));
          JLabel adjustLabel=new JLabel();
          inputPane.add(adjustLabel);

//        JCheckBox cbRememberMe = new JCheckBox("Remember me");
//        cbRememberMe.setOpaque(false);
//        setupComponent(cbRememberMe);
//        inputPane.add(cbRememberMe);

        inputPane.addMouseListener(moveWindowListener);
        inputPane.addMouseMotionListener(moveWindowListener);
        
//        btnCheck.addMouseListener(new );
        inputPane.add(btnCheck);
        btnCheck.addActionListener(new ActionListener() {

            
			public void actionPerformed(ActionEvent e) {
				
				 if(e.getSource() instanceof JButton){
					 JButton button=(JButton) e.getSource();
					 if(button.getText().equals("进入物流查询页面")){
							inputPane.remove(codeLabel);
							inputPane.remove(codefield);
							accountLabel.setText("订单单号：");
							accountfield.setText("");
							inputPane.remove(btnCheck);
							btnCheck.setText("返回登录页面");
							inputPane.add(btnCheck);
							isLogin=false;
							repaint();
					 }else{
						 inputPane.remove(btnCheck);
						 inputPane.remove(adjustLabel);
						 accountLabel.setText("账号:");
							accountfield.setText("");
						 inputPane.add(codeLabel);
						 inputPane.add(codefield);
						 inputPane.add(adjustLabel);
						 btnCheck.setText("进入物流查询页面");
						 inputPane.add(btnCheck);
						 isLogin=true;
						 repaint();
					 }
				 }

			}
        });	
    }

    private JButton createTransparentButton(ImageIcon icon, ImageIcon roverIcon, ImageIcon pressedIcon) {
        JButton button = new JButton();
        button.setBorder(null);
        button.setMargin(null);
        button.setOpaque(false);
        button.setIcon(icon);
        button.setRolloverEnabled(true);
        button.setRolloverIcon(roverIcon);
        button.setPressedIcon(pressedIcon);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setRequestFocusEnabled(false);

        return button;
    }

    private JLabel createDraggableLabel(ImageIcon icon) {
        JLabel label = new JLabel(icon);
        label.addMouseListener(moveWindowListener);
        label.addMouseMotionListener(moveWindowListener);
        return label;
    }

    private JLabel createInputLabel(String text) {
        JLabel label = new JLabel(text);
        setupComponent(label);
        return label;
    }

    private void setupComponent(JComponent c) {
        c.setFont(FreeUtil.FONT_14_BOLD);
        c.setForeground(FreeUtil.DEFAULT_TEXT_COLOR);
    }

    protected void login(LoginResult result) {
        final FreeLoadingUI loadingUI = FreeLoadingUI.createInstance(this);
        AWTUtilities.setWindowOpacity(this, 0.8f);

        Thread thread = new Thread() {

            @Override
            public void run() {
            	StaffUI staffUI=null;
                boolean isInServer=true;
                switch(result){
                  case Admin:
                      staffUI=new AdminUI(accountfield.getText());
                	  break;
                  case Courier:
                	  staffUI=new CourierUI(accountfield.getText());
                	  break;
                  case Finance:
                	  staffUI=new FinanceUI(accountfield.getText());
                	  break;
                  case TransOffice:
                	  staffUI=new TransportUI(accountfield.getText());
                	  break;
                  case Manager:
                	  staffUI=new ManagerUI(accountfield.getText());
                	  break;
                  case Check:
                	  staffUI=new CheckUI(accountfield.getText());
                	  break;
                  case Officer:
                	  staffUI=new OfficerUI(accountfield.getText());
                	  break;
                  case NoServer:
                	  isInServer=false;
	         	      JOptionPane.showMessageDialog(null, "服务端未开启"); 
                	  break;
                  
                }
                     if(isInServer){
                         staffUI.setVisible(true);
                         dispose();
                         loadingUI.dispose();                    	 
                     }else{
                         loadingUI.dispose();   
                     }


            }
        };
        thread.start();
        loadingUI.setVisible(true);
    }
    
    private LoginResult check(String account,String code){
    	
    	Login login=Login.creatLogin(datafactory);
    	
    	String[] list=new String[2];
    	LoginResult result=null;
    	int accountLength=9;
    	list[0]=account;
    	list[1]=code;
    	
    	if(list[0].length()!=accountLength){
    		accountfield.setText("请输入9位账号");
    	}else{
    		 result=login.login(list);
    	}
    	

    	
		return result;
    }

    public static void main(String[] args) {
//    	if(System.getSecurityManager()==null) 
//        { 
//    		System.setSecurityManager(new RMISecurityManager()); 
 //       } 
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                FreeUtil.setupLookAndFeel();
                FreeLoginUI ui = new FreeLoginUI();
                ui.setVisible(true);
            }
        });
    }
}
