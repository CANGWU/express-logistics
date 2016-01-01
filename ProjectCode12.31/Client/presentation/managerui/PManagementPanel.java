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
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import twaver.TWaverUtil;
import usersl.LogManagementController;
import userslservice.LogService;
import vo.StaffVO;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;
import pamanagementsl.PManagementController;
import pamanagementslservice.PManagementService;
import sun.swing.SwingUtilities2.Section;

public class PManagementPanel extends JPanel{
	public static FreePagePane addStaffPanel,deleteStaffPanel,fixStaffPanel,seekStaffPanel;
	public static FreeTabbedPane tab;
	private static PManagementService pManagementService;
	private static MaskFormatter maskWorkNumber;
	private static MaskFormatter maskPhoneNumber;
	private static MaskFormatter maskWorkPlanceNumber;
	private static MaskFormatter maskIDNumber;
	private static String userId;
	//private static 
	


	public static FreeReportPage  createPManagementPage(FreeTabbedPane tab,String id){
           userId=id;
			pManagementService=new PManagementController();

        try {
			initMask();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PManagementPanel.tab=tab;		
		return createReportPage();
	}
	
	
	private static void initMask() throws ParseException {
		// TODO Auto-generated method stub
		maskWorkNumber=new MaskFormatter("#########");
		maskWorkNumber.setPlaceholderCharacter('0');
		maskPhoneNumber=new MaskFormatter("###########");
		maskPhoneNumber.setPlaceholderCharacter('0');
		maskIDNumber=new MaskFormatter("##################");
		maskIDNumber.setPlaceholderCharacter('0');
		maskWorkPlanceNumber=new MaskFormatter("######");
		maskWorkPlanceNumber.setPlaceholderCharacter('0');
		
		
	}

	private static void createAddStaffPanel(){
		addStaffPanel=new FreePagePane();
		JLabel workNumber=new JLabel("工作编号");
		JLabel name=new JLabel("姓名");
		JLabel work=new JLabel("职位");
		JLabel workPlaceNumber=new JLabel("工作单位编号");
		JLabel idNumber=new JLabel("身份证号");
		JLabel phoneNumber=new JLabel("手机号码");
		JLabel address=new JLabel("居住地址");
		JLabel sex=new JLabel("性别");
		JLabel page=new JLabel("工资");
		JFormattedTextField workNumberField=new JFormattedTextField(maskWorkNumber);
		workNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);		
		JTextField nameField=new JTextField(20);
		JComboBox workCombo=new JComboBox();
		workCombo.addItem(Work.Courier);
		workCombo.addItem(Work.Officer);
		workCombo.addItem(Work.Finance);
		workCombo.addItem(Work.Manager);
		workCombo.addItem(Work.TransOffice);
		workCombo.addItem(Work.Stock);
		workCombo.addItem(Work.Admin);
		workCombo.addItem(Work.Driver);
		//JTextField workPlaceNumberField=new JTextField(6);
		JFormattedTextField workPlaceNumberField=new JFormattedTextField(maskWorkPlanceNumber);
		workPlaceNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);

		//JTextField idNumberField=new JTextField(23);
		JFormattedTextField idNumberField=new JFormattedTextField(maskIDNumber);
		idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);

		//JTextField phoneField=new JTextField(11);
		JFormattedTextField phoneField=new JFormattedTextField(maskPhoneNumber);
		phoneField.setFocusLostBehavior(JFormattedTextField.COMMIT);

		JTextField addressField=new JTextField(20);
		JComboBox sexCombo=new JComboBox();
		sexCombo.addItem(Sex.male);
		sexCombo.addItem(Sex.female);
		JTextField pageField=new JTextField(5);

		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(15,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel,workNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,work,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,workPlaceNumber,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,idNumber,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,phoneNumber,constraints,0,5,1,1);
		BaseUI.myAdd(bpanel,address,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,sex,constraints,0,7,1,1);
		BaseUI.myAdd(bpanel,page,constraints,0,8,1,1);


		BaseUI.myAdd(bpanel,workNumberField,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,nameField,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,workCombo,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,workPlaceNumberField,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,idNumberField,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,phoneField,constraints,1,5,1,1);
		BaseUI.myAdd(bpanel,addressField,constraints,1,6,1,1);
		BaseUI.myAdd(bpanel,sexCombo,constraints,1,7,1,1);
		BaseUI.myAdd(bpanel,pageField,constraints,1,8,1,1);


		JButton submit=new JButton("提交");
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
				ResultMessage resultMessage=null;
				StaffVO staffVO=new StaffVO();
				if(nameField.getText().equals("")||addressField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "填写信息不完整！");
					return  ;
				}
				
				
				try{
				staffVO.setWorkNumber(workNumberField.getText());
				staffVO.setName(nameField.getText());
				staffVO.setWork((Work) workCombo.getSelectedItem());
				staffVO.setWorkPlaceNumber(workPlaceNumberField.getText());
				staffVO.setIdNumber(idNumberField.getText());
				staffVO.setPhoneNumber(phoneField.getText());
				staffVO.setAddress(addressField.getText());
				staffVO.setSex((Sex) sexCombo.getSelectedItem());
				staffVO.setPage(Double.valueOf(pageField.getText()));
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "填写信息不完整！");
					return;
				}
           
				try{
					resultMessage=pManagementService.save(staffVO);
				}catch(Exception e){
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if (resultMessage==ResultMessage.SUCCESS) {
					JOptionPane.showMessageDialog(null, "添加操作成功");
					tab.remove(FreeUtil.getPagePane(addStaffPanel));
					
	     	    	  LogService ls=new LogManagementController();
	     	    	  ls.addMessage(userId, "增加人员");
				}else
					JOptionPane.showMessageDialog(null, "添加操作失败，请检查网络连接或者存在雷同ID信息");
			}
		});
		BaseUI.myAdd(bpanel,submit,constraints,1,9,1,1);
		addStaffPanel.add(bpanel);
	}



	private static void createDeleteStaffPanel(){
		deleteStaffPanel=new FreePagePane();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(20,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);


		JLabel workNumber=new JLabel("工作编号");
		JFormattedTextField workNumberField=new JFormattedTextField(maskWorkNumber);
		workNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		BaseUI.myAdd(bpanel,workNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,workNumberField,constraints,1,0,1,1);

		JButton submit=new JButton("查询被删除的工作编号");
		JButton sure=new JButton("确认删除");
		BaseUI.myAdd(bpanel,submit,constraints,0,2,2,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){  
				ResultMessage resultMessage=ResultMessage.SUCCESS;
				StaffVO staffVO=null;
				try {
					staffVO=pManagementService.select(workNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if(staffVO!=null){
					bpanel.remove(submit);
					bpanel.remove(workNumberField);
					String workID=staffVO.getWorkNumber();
					workNumber.setText("工作编号:  "+staffVO.getWorkNumber());
					JLabel name=new JLabel("姓名:  "+staffVO.getName());
					JLabel work=new JLabel("职位:  "+staffVO.getWork());
					JLabel workPlaceNumber=new JLabel("工作单位编号:  "+staffVO.getWorkPlaceNumber());
					JLabel idNumber=new JLabel("身份证号:  "+staffVO.getIdNumber());
					JLabel phoneNumber=new JLabel("手机号码:  "+staffVO.getPhoneNumber());
					JLabel address=new JLabel("居住地址:  "+staffVO.getAddress());
					JLabel sex=new JLabel("性别:  "+staffVO.getSex());
					JLabel page=new JLabel("工资:  "+staffVO.getPage());

					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,work,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,workPlaceNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,idNumber,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,5,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,sex,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,page,constraints,0,8,1,1);
					BaseUI.myAdd(bpanel, sure, constraints, 1,9,1,1);
					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//delete the TransportPO
							ResultMessage resultMessage=null;
							try {
								resultMessage=pManagementService.delete(workID);

							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								resultMessage =ResultMessage.FAIL;
							}
							if (resultMessage==ResultMessage.SUCCESS) {
								JOptionPane.showMessageDialog(null, "删除操作成功");
								tab.remove(FreeUtil.getPagePane(deleteStaffPanel));
								
				     	    	  LogService ls=new LogManagementController();
				     	    	  ls.addMessage(userId, "删除人员");
							}else
								JOptionPane.showMessageDialog(null, "删除操作失败,请检查网络连接或者输入人员ID");
						}
					});
				}else{
					JOptionPane.showMessageDialog(null, "查找失败");
				}
				
			}
		});

		deleteStaffPanel.add(bpanel);
	}

	private static void createFixStaffPanel(){
		fixStaffPanel=new FreePagePane();

		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(15,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel workNumber=new JLabel("工作编号");
		//JTextField workNumberField=new JTextField(9);
		JFormattedTextField workNumberField=new JFormattedTextField(maskWorkNumber);
		workNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		BaseUI.myAdd(bpanel,workNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,workNumberField,constraints,1,0,1,1);

		JButton submit=new JButton("查询被修改人员信息");
		JButton sure=new JButton("确认修改");
		BaseUI.myAdd(bpanel,submit,constraints,0,2,2,1);

		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){ 
				ResultMessage resultMessage=null;
				StaffVO staffVO=null;
				try {
					staffVO=pManagementService.select(workNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if(staffVO!=null){
					bpanel.remove(submit);
					bpanel.remove(workNumberField);
					workNumber.setText("工作编号"+workNumberField.getText());
					JLabel name=new JLabel("姓名");
					JLabel work=new JLabel("职位");
					JLabel workPlaceNumber=new JLabel("工作单位编号");
					JLabel idNumber=new JLabel("身份证号");
					JLabel phoneNumber=new JLabel("手机号码");
					JLabel address=new JLabel("居住地址");
					JLabel sex=new JLabel("性别");
					JLabel page=new JLabel("工资");
					JTextField nameField=new JTextField(staffVO.getName(),20);
					JComboBox workCombo=new JComboBox();
					workCombo.addItem(Work.Courier);
					workCombo.addItem(Work.Officer);
					workCombo.addItem(Work.Finance);
					workCombo.addItem(Work.Manager);
					workCombo.addItem(Work.TransOffice);
					workCombo.addItem(Work.Stock);
					workCombo.addItem(Work.Admin);
					workCombo.addItem(Work.Driver);
					workCombo.setSelectedItem(staffVO.getWork());
//					JTextField workPlaceNumberField=new JTextField(staffVO.getWorkPlaceNumber(),6);
//					JTextField idNumberField=new JTextField(staffVO.getIdNumber(),23);
//					JTextField phoneField=new JTextField(staffVO.getPhoneNumber(),11);
					JFormattedTextField workPlaceNumberField=new JFormattedTextField(maskWorkPlanceNumber);
					workPlaceNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
					workPlaceNumberField.setText(staffVO.getWorkPlaceNumber());
					JFormattedTextField idNumberField=new JFormattedTextField(maskIDNumber);
					idNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
					idNumberField.setText(staffVO.getIdNumber());
					JFormattedTextField phoneField=new JFormattedTextField(phoneNumber);
					phoneField.setFocusLostBehavior(JFormattedTextField.COMMIT);
					phoneField.setText(staffVO.getPhoneNumber());
					
					JTextField addressField=new JTextField(staffVO.getAddress(),20);
					JComboBox sexCombo=new JComboBox();
					sexCombo.addItem(Sex.male);
					sexCombo.addItem(Sex.female);
					sexCombo.setSelectedItem(staffVO.getSex());
					JTextField pageField=new JTextField(5);
					pageField.setText(String.valueOf(staffVO.getPage()));

					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,work,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,workPlaceNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,idNumber,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,5,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,sex,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,page,constraints,0,8,1,1);

					BaseUI.myAdd(bpanel,nameField,constraints,1,1,1,1);
					BaseUI.myAdd(bpanel,workCombo,constraints,1,2,1,1);
					BaseUI.myAdd(bpanel,workPlaceNumberField,constraints,1,3,1,1);
					BaseUI.myAdd(bpanel,idNumberField,constraints,1,4,1,1);
					BaseUI.myAdd(bpanel,phoneField,constraints,1,5,1,1);
					BaseUI.myAdd(bpanel,addressField,constraints,1,6,1,1);
					BaseUI.myAdd(bpanel,sexCombo,constraints,1,7,1,1);
					BaseUI.myAdd(bpanel,pageField,constraints,1,8,1,1);
					BaseUI.myAdd(bpanel, sure, constraints,1,9,1,1);

					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//fix the TransportPO
							if(nameField.getText().equals("")||addressField.getText().equals("")){
								JOptionPane.showMessageDialog(null, "填写信息不完整！");
								return  ;
							}
							ResultMessage resultMessage=null;

							StaffVO staffVO=new StaffVO();
							try {
								
							staffVO.setWorkNumber(workNumberField.getText());
							staffVO.setName(nameField.getText());
							staffVO.setWork((Work) workCombo.getSelectedItem());
							staffVO.setWorkPlaceNumber(workPlaceNumberField.getText());
							staffVO.setIdNumber(idNumberField.getText());
							staffVO.setPhoneNumber(phoneField.getText());
							staffVO.setAddress(addressField.getText());
							staffVO.setSex((Sex) sexCombo.getSelectedItem());
							staffVO.setPage(Double.valueOf(pageField.getText()));
							} catch (Exception e) {
								// TODO: handle exception
								JOptionPane.showMessageDialog(null, "信息填写不完整！");
								return;
							}
							try{
								resultMessage=pManagementService.saveChange(staffVO);
							}catch(Exception e){
								e.printStackTrace();
								resultMessage=ResultMessage.FAIL;
							}
							if (resultMessage==ResultMessage.SUCCESS) {
								JOptionPane.showMessageDialog(null, "修改操作成功");
								tab.remove(FreeUtil.getPagePane(fixStaffPanel));
								
								
				     	    	  LogService ls=new LogManagementController();
				     	    	  ls.addMessage(userId, "修改人员");
							}else
								JOptionPane.showMessageDialog(null, "修改操作失败，请检查网络连接");
						}
					});	
				}else{
					JOptionPane.showMessageDialog(null, "查找失败，请检查网络连接或者输入人员ID");
				}
			}

		});

		fixStaffPanel.add(bpanel);


	}

	private static void createSeekStaffPanel(){
		seekStaffPanel=new FreePagePane();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(20,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);


		JLabel workNumber=new JLabel("工作编号");
//		JTextField workNumberField=new JTextField(9);
		JFormattedTextField workNumberField=new JFormattedTextField(maskWorkNumber);
		workNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);

		BaseUI.myAdd(bpanel,workNumber,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,workNumberField,constraints,1,0,1,1);

		JButton submit=new JButton("查询人员信息");
		JButton sure=new JButton("确认信息");
		BaseUI.myAdd(bpanel,submit,constraints,0,5,2,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){   

				ResultMessage resultMessage=ResultMessage.SUCCESS;
				StaffVO staffVO=null;
				try {
					staffVO=pManagementService.select(workNumberField.getText());
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}
				if(staffVO!=null){
					bpanel.remove(submit);
					bpanel.remove(workNumberField);
					workNumber.setText("工作编号:  "+staffVO.getWorkNumber());
					JLabel name=new JLabel("姓名:  "+staffVO.getName());
					JLabel work=new JLabel("职位:  "+staffVO.getWork());
					JLabel workPlaceNumber=new JLabel("工作单位编号:  "+staffVO.getWorkPlaceNumber());
					JLabel idNumber=new JLabel("身份证号:  "+staffVO.getIdNumber());
					JLabel phoneNumber=new JLabel("手机号码:  "+staffVO.getPhoneNumber());
					JLabel address=new JLabel("居住地址:  "+staffVO.getAddress());
					JLabel sex=new JLabel("性别:  "+staffVO.getSex());
					JLabel page=new JLabel("工资:  "+staffVO.getPage());

					BaseUI.myAdd(bpanel,name,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,work,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,workPlaceNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,idNumber,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,phoneNumber,constraints,0,5,1,1);
					BaseUI.myAdd(bpanel,address,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,sex,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,page,constraints,0,8,1,1);
					BaseUI.myAdd(bpanel, sure, constraints, 1,9, 1, 1);

					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//check the TransportPO
							tab.remove(FreeUtil.getPagePane(seekStaffPanel));
							
							
			     	    	  LogService ls=new LogManagementController();
			     	    	  ls.addMessage(userId, "查找人员");
						}
					});
				}else
					JOptionPane.showMessageDialog(null, "查找失败，请检查网络连接或者输入ID信息");
			}
		});

		seekStaffPanel.add(bpanel);
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("工作编号");
		model.addColumn("姓名");
		model.addColumn("性别");
		model.addColumn("联系方式");
		ResultMessage resultMessage=ResultMessage.SUCCESS;
		ArrayList<StaffVO>staffVOs=null;
		try {
			staffVOs=pManagementService.getAllStaff();

		} catch (Exception e) {
			// TODO: handle exception
			resultMessage=ResultMessage.FAIL;
		}

		if(staffVOs!=null)
			for (StaffVO vo:staffVOs) {
				Vector row = new Vector();
				row.add(vo.getWorkNumber());
				row.add(vo.getName());
				row.add(vo.getSex());
				row.add(vo.getPhoneNumber());
				model.addRow(row);
			}
		else
			JOptionPane.showMessageDialog(null, "查找失败");

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
		setupPageToolbar(page);

		return page;
	}




	public static void setupPageToolbar(FreePagePane page) {
		FreeToolbarButton addStaff,deleteStaff,fixStaff,seekStaff;
		addStaff=createButton("/free/test/add.png", "增加人员", true);
		deleteStaff=createButton("/free/test/update.png", "删除人员", true);
		fixStaff=createButton("/free/test/refresh.png", "修改人员", true);
		seekStaff=createButton("/free/test/print.png", "查找人员", true);
		page.getRightToolBar().add(addStaff);
		page.getRightToolBar().add(deleteStaff);
		page.getRightToolBar().add(fixStaff);
		page.getRightToolBar().add(seekStaff);

		addStaff.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=addStaff.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(addStaffPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createAddStaffPanel();
					tab.addTab(title, ManagerUI.createPage(addStaffPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addStaffPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		deleteStaff.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=deleteStaff.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(deleteStaffPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createDeleteStaffPanel();
					tab.addTab(title, ManagerUI.createPage(deleteStaffPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(deleteStaffPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		fixStaff.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=fixStaff.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(fixStaffPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createFixStaffPanel();
					tab.addTab(title, ManagerUI.createPage(fixStaffPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(fixStaffPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});

		seekStaff.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=seekStaff.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(seekStaffPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createSeekStaffPanel();
					tab.addTab(title, ManagerUI.createPage(seekStaffPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(seekStaffPanel);
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

