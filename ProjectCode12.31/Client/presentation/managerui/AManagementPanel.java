package managerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;
import pamanagementsl.AManagementController;
import pamanagementslservice.AManagementService;
import twaver.TWaverUtil;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.AgencyVO;

public class AManagementPanel extends JPanel{
	public static FreePagePane addAgencyPanel,deleteAgencyPanel,fixAgencyPanel,seekAgencyPanel;
	public static FreeReportPage addStaffPanel,fixStaffPanel;
	public static FreeTabbedPane tab;
	private static AManagementService aManagementService;
	private static MaskFormatter maskIDNumber;
	private static MaskFormatter maskPhoneNumber;
	private static MaskFormatter maskLeader;
	private static MaskFormatter maskStaffNumber;
	private static String userId;
	
	
	


	public static FreeReportPage  createAManagementPage(FreeTabbedPane tab,String Id){
		userId=Id;
		try {
			aManagementService=new AManagementController(DataFactory.create());
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			initMask();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AManagementPanel.tab=tab;		
		return createReportPage();
	}

	private static void initMask() throws ParseException {
		// TODO Auto-generated method stub
		maskIDNumber=new MaskFormatter("######");
		maskIDNumber.setPlaceholderCharacter('0');
		maskPhoneNumber=new MaskFormatter("###########");
		maskPhoneNumber.setPlaceholderCharacter('0');
		maskStaffNumber=new MaskFormatter("#########");
		maskStaffNumber.setPlaceholderCharacter('0');
		
		
	}

	private static void createAddAgencyPanel(){
		addAgencyPanel=new FreePagePane();
		JLabel idNumber=new JLabel("机构编号");
		JLabel name=new JLabel("机构名");
		JLabel phoneNumber=new JLabel("电话号码");
		JLabel address=new JLabel("地址");
		JLabel leader=new JLabel("负责人");
		JLabel staff=new JLabel("员工编号");
		JTextField nameField=new JTextField(20);
		JFormattedTextField idNumberField = new JFormattedTextField(maskIDNumber);
		idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		//idField.setInputVerifier(new FormattedTextFieldVerifier());		
		JFormattedTextField phoneNumberField=new JFormattedTextField(maskPhoneNumber);
		phoneNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		JTextField addressField=new JTextField(20);
		JTextField leaderField=new JTextField(20);
		JTextArea staffField=new JTextArea(3, 20);
		staffField.setLineWrap(true);
		JScrollPane scrollPane=new JScrollPane(staffField);
		scrollPane.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(20,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel,idNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,phoneNumber,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,address,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,leader,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel, staff, constraints, 0, 5, 1, 1);


		BaseUI.myAdd(bpanel,idNumberField,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,nameField,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,phoneNumberField,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,addressField,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,leaderField,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel, scrollPane, constraints, 1, 5, 1, 1);

		//		JButton addStaff=new JButton("添加人员");
		//		//addOrder.addActionListener(arg0);
		//		addStaff.addMouseListener(new MouseAdapter(){
		//		    @Override
		//		    public void mouseClicked(MouseEvent arg0) 
		//		    {   
		//		    	String title="添加人员";                
		//                try{
		//                 FreePagePane pagePane = FreeUtil.getPagePane(addStaffPanel);
		//                 tab.setSelectedComponent(pagePane);
		//                }catch(Exception ex){
		//                    createAddStaffPanel();
		//             	    tab.addTab(title, ManagerUI.createPage(addStaffPanel));
		//                    FreePagePane pagePane = FreeUtil.getPagePane(addStaffPanel);
		//                    tab.setSelectedComponent(pagePane);
		//                }
		//
		//             
		//		    }
		//		});
		JButton submit=new JButton("提交");
		//		BaseUI.myAdd(bpanel, addStaff, constraints, 0, 6, 2, 1);
		BaseUI.myAdd(bpanel,submit,constraints,0,6,2,1);
		submit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(nameField.getText().equals("")||addressField.getText().equals("")||leaderField.getText().equals("")||staffField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "信息填写不完整！");
					return;
				}
				
				AgencyVO agencyVO=new AgencyVO();
				ResultMessage resultMessage=null;
                try {
					
			
				agencyVO.setIDNumber(idNumberField.getText());
				agencyVO.setAddress(addressField.getText());
				agencyVO.setName(nameField.getText());
				agencyVO.setPhoneNumber(phoneNumberField.getText());
				agencyVO.setLeader(leaderField.getText());
				ArrayList<String>staff=new ArrayList<String>();
				String[]strings=staffField.getText().split("\n");

				for(String string:strings)
					staff.add(string);

				agencyVO.setStaff(staff);
            	} catch (Exception e) {
					// TODO: handle exception
            		JOptionPane.showMessageDialog(null, "信息填写不完整！");
				}

				try {
					resultMessage=aManagementService.saveChange(agencyVO);
				} catch (Exception e) {
					// TODO: handle exception
					resultMessage=ResultMessage.FAIL;
				}
				
				if (resultMessage==ResultMessage.SUCCESS) {
					JOptionPane.showMessageDialog(null, "添加操作成功");
					tab.remove(FreeUtil.getPagePane(addAgencyPanel));
					
	     	    	  LogService ls=new LogManagementController();
	     	    	  ls.addMessage(userId, "增加机构");
				}else
					JOptionPane.showMessageDialog(null, "添加操作失败,请检查网络连接或者存在雷同ID");

			}
		});

		addAgencyPanel.add(bpanel);
	}



	private static void createDeleteAgencyPanel(){
		deleteAgencyPanel=new FreePagePane();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel idNumber=new JLabel("机构编号");
		JFormattedTextField idNumberField = new JFormattedTextField(maskIDNumber);
		idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		BaseUI.myAdd(bpanel,idNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idNumberField,constraints,1,0,1,1);

		JButton submit=new JButton("查询被删除的机构编号");
		JButton sure=new JButton("确认删除");
		BaseUI.myAdd(bpanel,submit,constraints,0,2,2,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){

				ResultMessage resultMessage=ResultMessage.SUCCESS;
				AgencyVO agencyVO=null;

				try {
					agencyVO=aManagementService.select(idNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					resultMessage=ResultMessage.FAIL;
				}

				if(agencyVO!=null){
					bpanel.remove(submit);
					bpanel.remove(idNumberField);
					String id=agencyVO.getIDNumber();
					idNumber.setText("机构编号:  "+agencyVO.getIDNumber());
					JLabel name=new JLabel("机构名：  "+agencyVO.getName());
					JLabel phoneNumber=new JLabel("电话号码:  "+agencyVO.getPhoneNumber());
					JLabel address=new JLabel("地址:  "+agencyVO.getAddress());
					JLabel leader=new JLabel("负责人:  "+agencyVO.getLeader());

					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,leader,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,sure,constraints,0,5,1,1);
					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//delete the TransportPO
							ResultMessage resultMessage=null;

							try {
								resultMessage=aManagementService.delete(id);
							} catch (Exception e) {
								// TODO: handle exception
								resultMessage =ResultMessage.FAIL;
							}
							if (resultMessage==ResultMessage.SUCCESS) {
								JOptionPane.showMessageDialog(null, "删除操作成功");
								tab.remove(FreeUtil.getPagePane(deleteAgencyPanel));
								
				     	    	  LogService ls=new LogManagementController();
				     	    	  ls.addMessage(userId, "删除机构");
							}else
								JOptionPane.showMessageDialog(null, "删除操作失败，请检查网络连接或者输入机构ID");

						}
					});

				}else{
					JOptionPane.showMessageDialog(null, "查找失败");
				}
			}
		});

		deleteAgencyPanel.add(bpanel);
	}

	private static void createFixAgencyPanel(){
		fixAgencyPanel=new FreePagePane();

		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(20,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel idNumber=new JLabel("机构编号");
		JFormattedTextField idNumberField=new JFormattedTextField(maskIDNumber);
		idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		JButton submit=new JButton("查询被修改的机构信息");
		JButton fixStaff=new JButton("修改人员");
		JButton sure=new JButton("确认修改");
		BaseUI.myAdd(bpanel,idNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idNumberField,constraints,1,0,1,1);

		BaseUI.myAdd(bpanel,submit,constraints,0,2,2,1);

		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){   

				ResultMessage resultMessage=ResultMessage.SUCCESS;
				AgencyVO agencyVO=null;

				try {
					agencyVO=aManagementService.select(idNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if(agencyVO!=null){
					bpanel.remove(submit);
					bpanel.remove(idNumberField);
					idNumber.setText("机构编号:  "+idNumberField.getText());
					JLabel name=new JLabel("机构名");
					JLabel phoneNumber=new JLabel("电话号码");
					JLabel address=new JLabel("地址");
					JLabel leader=new JLabel("负责人");
					JLabel staff=new JLabel("员工编号");
					JTextField nameField=new JTextField(agencyVO.getName(),20);
					JFormattedTextField phoneNumberField=new JFormattedTextField(maskPhoneNumber);
					phoneNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
					phoneNumberField.setText(agencyVO.getPhoneNumber());
					JTextField addressField=new JTextField(agencyVO.getAddress(),20);
					JTextField leaderField=new JTextField(agencyVO.getLeader(),20);
					JTextArea staffField=new JTextArea(3, 20);
					staffField.setLineWrap(true);
					JScrollPane scrollPane=new JScrollPane(staffField);
					scrollPane.setHorizontalScrollBarPolicy( 
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
					scrollPane.setVerticalScrollBarPolicy( 
							JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
					ArrayList<String>strings=agencyVO.getStaff();
					String string="";
					for(String s:strings)
						string=string+s+"\n";
					staffField.setText(string);


					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,leader,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel, staff, constraints, 0, 5, 1, 1);

					BaseUI.myAdd(bpanel,nameField,constraints,1,1,1,1);
					BaseUI.myAdd(bpanel,phoneNumberField,constraints,1,2,1,1);
					BaseUI.myAdd(bpanel,addressField,constraints,1,3,1,1);
					BaseUI.myAdd(bpanel,leaderField,constraints,1,4,1,1);
					BaseUI.myAdd(bpanel, scrollPane, constraints, 1, 5, 1, 1);



					//	BaseUI.myAdd(bpanel, fixStaff, constraints, 0, 5, 2, 1);
					BaseUI.myAdd(bpanel, sure, constraints,0, 6, 2, 1);

					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//fix the AgencgVO
							if(nameField.getText().equals("")||addressField.getText().equals("")||leaderField.getText().equals("")||staffField.getText().equals("")){
								JOptionPane.showMessageDialog(null, "信息填写不完整！");
								return;
							}
							
							AgencyVO agencyVO=new AgencyVO();
							ResultMessage resultMessag=null;

							agencyVO.setIDNumber(idNumberField.getText());
							agencyVO.setAddress(addressField.getText());
							agencyVO.setName(nameField.getText());
							agencyVO.setPhoneNumber(phoneNumberField.getText());
							agencyVO.setLeader(leaderField.getText());
							ArrayList<String>staff=new ArrayList<String>();
							String[]strings=staffField.getText().split("\n");

							for(String string:strings)
								staff.add(string);

							agencyVO.setStaff(staff);

							try {
								resultMessag=aManagementService.saveChange(agencyVO);
							} catch (Exception e2) {
								// TODO: handle exception
								resultMessag=ResultMessage.FAIL;
							}
							
							if (resultMessag==ResultMessage.SUCCESS) {
								JOptionPane.showMessageDialog(null, "修改操作成功");
								tab.remove(FreeUtil.getPagePane(fixAgencyPanel));
								
				     	    	  LogService ls=new LogManagementController();
				     	    	  ls.addMessage(userId, "修改机构");
							}else
								JOptionPane.showMessageDialog(null, "修改操作失败，请检查网络连接或者输入");


						}
					});

					//				fixStaff.addMouseListener(new MouseAdapter(){
					//				    @Override
					//				    public void mouseClicked(MouseEvent arg0) 
					//				    {   
					//				    	String title="修改人员";                
					//		                try{
					//		                 FreePagePane pagePane = FreeUtil.getPagePane(fixStaffPanel);
					//		                 tab.setSelectedComponent(pagePane);
					//		                }catch(Exception ex){
					//		                    createFixStaffPage();
					//		             	    tab.addTab(title, ManagerUI.createPage(fixStaffPanel));
					//		                    FreePagePane pagePane = FreeUtil.getPagePane(fixStaffPanel);
					//		                    tab.setSelectedComponent(pagePane);
					//		                }
					//
					//		             
					//				    }
					//				});

				}else{
					JOptionPane.showMessageDialog(null, "查找失败");
				}
			}

		});

		fixAgencyPanel.add(bpanel);


	}

	private static void createSeekAgencyPanel(){
		seekAgencyPanel=new FreePagePane();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);


		JLabel idNumber=new JLabel("机构编号");
		//JTextField idNumberField=new JTextField(9);
		JFormattedTextField idNumberField=new JFormattedTextField(maskIDNumber);
		idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		
		BaseUI.myAdd(bpanel,idNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idNumberField,constraints,1,0,1,1);

		JButton submit=new JButton("查询机构信息");
		JButton sure=new JButton("确认信息");
		BaseUI.myAdd(bpanel,submit,constraints,0,5,2,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				ResultMessage resultMessage=ResultMessage.SUCCESS;
				AgencyVO agencyVO=null;

				try {
					agencyVO=aManagementService.select(idNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}


				if(agencyVO!=null){
					bpanel.remove(submit);
					bpanel.remove(idNumberField);

					idNumber.setText("机构编号：  "+agencyVO.getIDNumber());
					JLabel name=new JLabel("机构名:  "+agencyVO.getName());
					JLabel phoneNumber=new JLabel("电话号码:  "+agencyVO.getPhoneNumber());
					JLabel address=new JLabel("地址:  "+agencyVO.getAddress());
					JLabel leader=new JLabel("负责人:  "+agencyVO.getLeader());

					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,leader,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,sure,constraints,0,5,1,1);    

					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//check the TransportPO
							tab.remove(FreeUtil.getPagePane(seekAgencyPanel));
							
			     	    	  LogService ls=new LogManagementController();
			     	    	  ls.addMessage(userId, "查找机构");
						}
					});
				}else{
					JOptionPane.showMessageDialog(null, "查找失败,请检查网络连接或者输入机构ID");
				}
			}
		});

		seekAgencyPanel.add(bpanel);
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("机构编号");
		model.addColumn("机构名");
		model.addColumn("联系方式");
		model.addColumn("负责人");

		ResultMessage resultMessage=ResultMessage.SUCCESS;
		ArrayList<AgencyVO>agencyVOs=new ArrayList<AgencyVO>();

		try {
			agencyVOs=aManagementService.getAllAgency();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resultMessage=ResultMessage.FAIL;
		}

		if(agencyVOs!=null)
			for (AgencyVO agencyVO:agencyVOs) {
				Vector row = new Vector();
				row.add(agencyVO.getIdNumber());
				row.add(agencyVO.getName());
				row.add(agencyVO.getPhoneNumber());
				row.add(agencyVO.getLeader());
				model.addRow(row);
			}else
				JOptionPane.showMessageDialog(null, "查找失败");

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
		setupPageToolbar(page);

		return page;
	}

	public static void createFixStaffPage(){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("工作编号");
		model.addColumn("姓名");;

		//此处还有读取功能未实现

		fixStaffPanel=new FreeReportPage();
		FreeToolbarButton add=createButton("/free/test/add.png", "增加人员", true);
		FreeToolbarButton delete=createButton("/free/test/update.png", "删除人员", true);
		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);

		JLabel workNumber=new JLabel("工作编号");
		JTextField workNumberFiled=new JTextField(9);
		JLabel name=new JLabel("姓名");
		JTextField nameFiled=new JTextField(10);


		fixStaffPanel.getRightToolBar().add(add);
		fixStaffPanel.getRightToolBar().add(delete);
		fixStaffPanel.getRightToolBar().add(finish);
		FreeToolBar leftToolBar=fixStaffPanel.getLeftToolBar();
		leftToolBar.add(workNumber);
		leftToolBar.add(workNumberFiled);
		leftToolBar.add(name);
		leftToolBar.add(nameFiled);

		fixStaffPanel.getTable().setModel(model);
		fixStaffPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());

		add.addMouseListener(new MouseAdapter(){
			//add the Number

		});
		finish.addMouseListener(new MouseAdapter(){
			//finish

		});


	}


	private static void createAddStaffPanel(){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("工作编号");
		model.addColumn("姓名");;

		//此处还有读取功能未实现

		addStaffPanel=new FreeReportPage();
		FreeToolbarButton add=createButton("/free/test/add.png", "增加人员", true);
		FreeToolbarButton delete=createButton("/free/test/update.png", "删除人员", true);
		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);

		JLabel workNumber=new JLabel("工作编号");
		JTextField workNumberFiled=new JTextField(9);
		JLabel name=new JLabel("姓名");
		JTextField nameFiled=new JTextField(10);


		addStaffPanel.getRightToolBar().add(add);
		addStaffPanel.getRightToolBar().add(delete);
		addStaffPanel.getRightToolBar().add(finish);
		FreeToolBar leftToolBar=addStaffPanel.getLeftToolBar();
		leftToolBar.add(workNumber);
		leftToolBar.add(workNumberFiled);
		leftToolBar.add(name);
		leftToolBar.add(nameFiled);

		addStaffPanel.getTable().setModel(model);
		addStaffPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());

		add.addMouseListener(new MouseAdapter(){
			//add the Number

		});
		finish.addMouseListener(new MouseAdapter(){
			//finish

		});



	}

	public static void setupPageToolbar(FreePagePane page) {
		FreeToolbarButton addAgency,deleteAgency,fixAgency,seekAgency;
		addAgency=createButton("/free/test/add.png", "增加机构", true);
		deleteAgency=createButton("/free/test/update.png", "删除机构", true);
		fixAgency=createButton("/free/test/refresh.png", "修改机构信息", true);
		seekAgency=createButton("/free/test/print.png", "查找机构", true);
		page.getRightToolBar().add(addAgency);
		page.getRightToolBar().add(deleteAgency);
		page.getRightToolBar().add(fixAgency);
		page.getRightToolBar().add(seekAgency);

		addAgency.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=addAgency.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(addAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createAddAgencyPanel();
					tab.addTab(title, ManagerUI.createPage(addAgencyPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		deleteAgency.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=deleteAgency.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(deleteAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createDeleteAgencyPanel();
					tab.addTab(title, ManagerUI.createPage(deleteAgencyPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(deleteAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		fixAgency.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=fixAgency.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(fixAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createFixAgencyPanel();
					tab.addTab(title, ManagerUI.createPage(fixAgencyPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(fixAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});

		seekAgency.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=seekAgency.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(seekAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createSeekAgencyPanel();
					tab.addTab(title, ManagerUI.createPage(seekAgencyPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(seekAgencyPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});

	}
	public static FreeToolbarButton createButton(String icon, String tooltip, boolean rover) {
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

