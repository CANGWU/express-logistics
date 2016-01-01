package managerui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import auditsl.AuditController;
import auditslservice.AuditService;
import courierui.OrderInputPanel;
import dataserviceimpl.DataFactory;
import dateChoose.DateChooser;
import enums.Condition;
import enums.DocumentCondition;
import enums.Packing;
import enums.PaymentType;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import financesl.AccountManagementController;
import financesl.CostController;
import financeui.CostPanel;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeTable;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;
import jdk.internal.dynalink.beans.StaticClass;
import main.StaffInfoPanel;
import pamanagementsl.AManagementController;
import pamanagementsl.PManagementController;
import pamanagementslservice.AManagementService;
import sendsl.SendController;
import strategysl.ConstantController;
import transportsl.Transport;
import transportsl.TransportController;
import transportslservice.TransportService;
import transportui.TransportManagementPanel;
import transportui.TransportUI;
import twaver.TWaverUtil;
import twaver.base.A.E.a;
import usersl.UserManagementController;
import vo.AccountVO;
import vo.AgencyVO;
import vo.BillVO;
import vo.DeliverVO;
import vo.GoodsVO;
import vo.IoputVO;
import vo.OrderVO;
import vo.PaymentVO;
import vo.ReceiptsVO;
import vo.ReceiverVO;
import vo.SenderVO;
import vo.TransportVO;


public class AuditPanel {
	private static FreeTabbedPane tab;
	private static AuditService auditService;
	private static ArrayList<OrderVO> Order;
	private static ArrayList<TransportVO> Trans;
	private static ArrayList<PaymentVO> Payment;
	private static ArrayList<ReceiptsVO> Receipts;
	private static ArrayList<DeliverVO> delivers;
	private static ArrayList<IoputVO> Input, Output;
	private static int orderNum;
	private static int transNum;
	private static int paymentNum;
	private static int receiptsNum;
	private static int deliverNum;
		

	private static int inputNum;
	private static int outputNum;



	public static FreePagePane createAuditPage(FreeTabbedPane tab) {
		// TODO Auto-generated method stub
		AuditPanel.setTab(tab);
		auditService = new AuditController();
		return createReportPage();
	}

	private static FreePagePane createReportPage() {
		// TODO Auto-generated method stub
		Order = auditService.getOrder();
		Trans = auditService.getTransport();
		Payment = auditService.getPayment();
		Receipts = auditService.getReceipts();

//		Input = auditService.getInput();
//		Output = auditService.getOutput();

		 orderNum = Order.size();
		 transNum = Trans.size();
		 paymentNum = Payment.size();
		 receiptsNum = Receipts.size();
		 deliverNum = delivers.size();

//		 inputNum = Input.size();
//		 outputNum = Output.size();



		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("选择");;
		model.addColumn("单据编号");
		model.addColumn("单据类型");
		model.addColumn("状态");
		//model.addColumn("收款人/付款人");


		FreeReportPage page = new FreeReportPage();
		FreeTable table=(FreeTable) page.getTable();
		table.setModel(model);


		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));



		for(int i=0;i<Order.size();i++){
			OrderVO vo = Order.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getOrdernumber());
			row.add("快递订单");
			row.add(vo.getDocumentCondition());
			model.addRow(row);
		}

		for(int i=0;i<Trans.size();i++){
			TransportVO vo = Trans.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getID());
			row.add("运输单");
			row.add(vo.getDocumentCondition());
			model.addRow(row);
		}


		for(int i=0;i<Payment.size();i++){
			PaymentVO vo = Payment.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getAuditnumber());
			row.add("付款单");
			row.add(vo.getCondition());
			model.addRow(row);
		}

		for(int i=0;i<Receipts.size(); i++){
			ReceiptsVO vo = Receipts.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add("--");
			row.add("收款单");
			row.add(vo.getdCondition());
			model.addRow(row);
		}
		
		
		for(int i=0;i<delivers.size(); i++){
			DeliverVO vo = delivers.get(i);
			Vector row=new Vector();
			row.add(new Boolean(false));
			row.add(vo.getID());
			row.add("派件单");
			row.add(vo.getDocumentCondition());
			model.addRow(row);
		}



		//		for(int i=0;i<10;i++){
		//			//IoputVO vo = Output.get(i);
		//			Vector row=new Vector();
		//			row.add(new Boolean(false));
		//			row.add("dd");
		//			row.add("22");
		//			row.add("handing");
		//			model.addRow(row);
		//		}


		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int selectRows=table.getSelectedRows().length;// 取得用户所选行的行数
				//JOptionPane.showMessageDialog(null, selectRows);
				int columnIndex = table.columnAtPoint(arg0.getPoint()); //获取点击的列
				if(selectRows==1&&columnIndex!=0){
					int selectRow = table.getSelectedRow();
					String id = (String) model.getValueAt(selectRow,1);
					String type = (String) model.getValueAt(selectRow,2);
					if(type.equals("快递订单")){
						String title = type;              
							OrderVO vo = Order.get(selectRow);
							JPanel panel = createOrderFixPanel(vo);
							tab.addTab(title, panel);
							FreePagePane pagePane = FreeUtil.getPagePane(panel);
							tab.setSelectedComponent(pagePane);
					}else if(type.equals("运输单")){
						String title= type;
						TransportVO vo = Trans.get(selectRow - orderNum);
						JPanel panel = createTransportFixPanel(vo, selectRow - orderNum);
						tab.addTab(title, panel);
						FreePagePane pagePane = FreeUtil.getPagePane(panel);
						tab.setSelectedComponent(pagePane);

					}else if(type.equals("付款单")){
						String title = type;
						PaymentVO vo = Payment.get(selectRow - orderNum - transNum);
						JPanel panel = createPaymentFixPanel(vo, selectRow - orderNum - transNum);
						tab.addTab(title, panel);
						FreePagePane pagePane = FreeUtil.getPagePane(panel);
						tab.setSelectedComponent(pagePane);
					}else if(type.equals("收款单")){
						String title = type;
						ReceiptsVO vo = Receipts.get(selectRow - orderNum - transNum - paymentNum);
						JPanel panel = createReceiptsFixPanel(vo, selectRow - orderNum - transNum - paymentNum);
						tab.addTab(title, panel);
						FreePagePane pagePane = FreeUtil.getPagePane(panel);

					}else if(type.equals("派件单")){
						String title = type;
						DeliverVO vo = delivers.get(selectRow - orderNum - transNum - paymentNum - receiptsNum);
						JPanel panel = createDeliverFixPanel(vo, selectRow - orderNum - transNum - paymentNum - receiptsNum);
						tab.addTab(title, panel);
						FreePagePane pagePane = FreeUtil.getPagePane(panel);
						
					}else if(type.equals("入库单")){



					}else if(type.equals("出库单")){


					}

				}else if(selectRows>1){


				}

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
				if(arg0.getClickCount() == 1){
					int columnIndex = table.columnAtPoint(arg0.getPoint()); //获取点击的列
					int rowIndex = table.rowAtPoint(arg0.getPoint()); //获取点击的行

					if(columnIndex == 0) {//第0列时，执行代码
						if(table.getValueAt(rowIndex,columnIndex) == null){ //如果未初始化，则设置为false
							table.setValueAt(false, rowIndex, columnIndex);
						}

						if(((Boolean)table.getValueAt(rowIndex,columnIndex)).booleanValue()){ //原来选中
							table.setValueAt(false, rowIndex, 0); //点击后，取消选中
						}
						else {//原来未选中
							table.setValueAt(true, rowIndex, 0);
						}
					}
				}
			}
		});

		FreeToolbarButton seek=createButton("/free/test/print.png", "单据审判", true);
		seek.addMouseListener(new MouseListener() {

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
				for(int i=0;i<model.getRowCount();i++){

					if((boolean) model.getValueAt(i, 0)){
						if(i<orderNum){
							OrderVO vo = Order.get(i);
							vo.setDocumentCondition(DocumentCondition.audited);
							Order.set(i, vo);
						}else if(i<(orderNum+transNum)){
							TransportVO vo = Trans.get(i-orderNum);
							vo.setDocumentCondition(DocumentCondition.audited);
							Trans.set(i-orderNum, vo);
						}else if(i<(orderNum+transNum+paymentNum)){
							PaymentVO vo = Payment.get(i-orderNum-transNum);
							vo.setCondition(DocumentCondition.audited);
							Payment.set(i-orderNum-transNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum)){

							ReceiptsVO vo = Receipts.get(i-orderNum-transNum-paymentNum);
							vo.setdCondition(DocumentCondition.audited);
							Receipts.set(i-orderNum-transNum-paymentNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum+deliverNum)){

							DeliverVO vo = delivers.get(i-orderNum-transNum-paymentNum-receiptsNum);
							vo.setDocumentCondition(DocumentCondition.audited);
							delivers.set(i-orderNum-transNum-paymentNum-receiptsNum, vo);
						}
						//				}else if(i<(orderNum+transNum+paymentNum+inputNum+receiptsNum)){
						//					IoputVO vo = Input.get(i-orderNum-transNum-paymentNum-receiptsNum);
						////					vo.set;
						//					Input.set(i-orderNum-transNum-paymentNum-receiptsNum, vo);
						//					
						//				}else{
						//					IoputVO vo = Output.get(i-orderNum-transNum-paymentNum-inputNum-receiptsNum);
						////					vo.set;
						//					Output.set(i-orderNum-transNum-paymentNum-inputNum-receiptsNum, vo);	
						model.setValueAt(DocumentCondition.audited, i, 3);
					}else{ 
						if(i<orderNum){
							OrderVO vo = Order.get(i);
							vo.setDocumentCondition(DocumentCondition.handing);
							Order.set(i, vo);
						}else if(i<(orderNum+transNum)){
							TransportVO vo = Trans.get(i-orderNum);
							vo.setDocumentCondition(DocumentCondition.handing);
							Trans.set(i-orderNum, vo);
						}else if(i<(orderNum+transNum+paymentNum)){
							PaymentVO vo = Payment.get(i-orderNum-transNum);
							vo.setCondition(DocumentCondition.handing);
							Payment.set(i-orderNum-transNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum)){
							ReceiptsVO vo = Receipts.get(i-orderNum-transNum-paymentNum);
							vo.setdCondition(DocumentCondition.handing);
							Receipts.set(i-orderNum-transNum-paymentNum, vo);
						}else if(i<(orderNum+transNum+paymentNum+receiptsNum+deliverNum)){

							DeliverVO vo = delivers.get(i-orderNum-transNum-paymentNum-receiptsNum);
							vo.setDocumentCondition(DocumentCondition.handing);
							delivers.set(i-orderNum-transNum-paymentNum-receiptsNum, vo);
						}
						//				}else if(i<(orderNum+transNum+paymentNum+inputNum)){
						//					IoputVO vo = Input.get(i-orderNum-transNum-paymentNum);
						////					vo.set;
						//					Input.set(i-orderNum-transNum-paymentNum, vo);
						//					
						//				}else{
						//					IoputVO vo = Output.get(i-orderNum-transNum-paymentNum-inputNum);
						////					vo.set;
						//					Output.set(i-orderNum-transNum-paymentNum-inputNum, vo);	
						//				}
						model.setValueAt(DocumentCondition.handing, i, 3);
                        
					}
				}
				
				auditService.saveAll();

			}
		});
		page.getRightToolBar().add(seek);
		return page;
	}


	protected static JPanel createDeliverFixPanel(DeliverVO vo, int selectRow) {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	protected static JPanel createReceiptsFixPanel(ReceiptsVO vo, int selectRow) {
		JPanel fixGatherPanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel date = new JLabel("收款日期:  " + vo.getDate());
		JLabel courier = new JLabel("快递员:  "+ vo.getCourier());
//		JTextField datefield = new JTextField(10);
//		JTextField courierfield = new JTextField(10);
		BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
//		BaseUI.myAdd(bpanel, datefield, constraints, 1, 0, 1, 1);
//		BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);

		JButton submit = new JButton("保存修改");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 5, 2, 1);
		
		JLabel officer = new JLabel("收款人：  " + vo.getOffice());
		BaseUI.myAdd(bpanel, officer, constraints, 0, 3, 1, 1);

//
//		submit.addMouseListener(new MouseAdapter() {
//			@Override
////			public void mouseClicked(MouseEvent arg0) {
//				JLabel date = new JLabel("收款日期");
//				JLabel courier = new JLabel("快递员");
				JLabel fee = new JLabel("收款金额:  " + vo.getFee());
//				JButton addExpress = new JButton("添加快件");
//				JTextField datefield = new JTextField(10);
//				JTextField courierfield = new JTextField(10);
//				JTextField feefield = new JTextField(10);
			

//				BaseUI.myAdd(bpanel, date, constraints, 0, 0, 1, 1);
//				BaseUI.myAdd(bpanel, courier, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, fee, constraints, 0, 2, 1, 1);
//				BaseUI.myAdd(bpanel, addExpress, constraints, 0, 3, 1, 1);

//				BaseUI.myAdd(Panel, datefield, constraints, 1, 0, 1, 1);
//				BaseUI.myAdd(bpanel, courierfield, constraints, 1, 1, 1, 1);
//				BaseUI.myAdd(bpanel, feefield, constraints, 1, 2, 1, 1);


				submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						tab.remove(fixGatherPanel);
					}
				});

//		});

		fixGatherPanel.add(bpanel);
		return fixGatherPanel;

	}

	protected static JPanel createPaymentFixPanel(PaymentVO vo, int selectRow) {
		ArrayList<String> paymentTypeStrlist=new ArrayList<String>();
		ArrayList<PaymentType> paymentTypelist=new ArrayList<PaymentType>();
		paymentTypeStrlist.add("租金");
		paymentTypeStrlist.add("运费");
		paymentTypeStrlist.add("工资");
		paymentTypeStrlist.add("奖金");
		
		paymentTypelist.add(PaymentType.Rent);
		paymentTypelist.add(PaymentType.TransFee);
		paymentTypelist.add(PaymentType.Salary);
		paymentTypelist.add(PaymentType.Bonus);
		
		
		
		CostPanel panel=new CostPanel();
		
		JLabel paymentType=new JLabel("付款条目:  " + vo.getType());
//		JComboBox paymentTypeCombo=new JComboBox();
//		paymentTypeCombo.addItem("工资");
//		paymentTypeCombo.addItem("运费");
//		paymentTypeCombo.addItem("租金");
//		paymentTypeCombo.addItem("奖金");

		JLabel date=new JLabel("付款日期:");
	    Date dt = new Date();   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
	    String timeOfPayment=sdf.format(dt);
		JLabel datefield=new JLabel(timeOfPayment);
	    
	    
		JLabel payman=new JLabel("付款人:  " + vo.getNameOfWriter());
		UserManagementController umc=new UserManagementController();
		//JLabel paymanfield=new JLabel(umc.select(userId).getName());
		
		JLabel paymentfee=new JLabel("付款金额:");
		JTextField paymentfeefield2=new JTextField(20);
		paymentfeefield2.setText(vo.getNumberOfPayment() + "");
		
		JLabel auditnumber=new JLabel("付款单编号：");
		JLabel auditnumberfield=new JLabel("待计算");
		
		JLabel account=new JLabel("付款账户:");
		JComboBox accountCombo=new JComboBox();

		AccountManagementController amc=new AccountManagementController();
		ArrayList<AccountVO> list=amc.getAllAccount();
		
		for(int i=0;i<list.size();i++){
			accountCombo.addItem(list.get(i).getName());
		}
		accountCombo.setSelectedItem(vo.getAccountname());
		
		JLabel receiver=new JLabel("收款人:  " + vo.getReceiver());
//		JTextField receiverfield=new JTextField(20);
		JLabel remarks=new JLabel("备注:");
		JTextField remarksfield=new JTextField(20);
		remarksfield.setText(vo.getRemarks());
		
		
		
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(25,0,25,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,date,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,datefield,constraints,1,0,1,1);
		BaseUI.myAdd(bpanel,payman,constraints,0,1,1,1);
//		BaseUI.myAdd(bpanel,paymanfield,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel,auditnumber,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,auditnumberfield,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,paymentType,constraints,0,3,1,1);
//		BaseUI.myAdd(bpanel,paymentTypeCombo,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,receiver,constraints,0,4,1,1);
//		BaseUI.myAdd(bpanel,receiverfield,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,account,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,accountCombo,constraints,3,0,1,1);
		
		BaseUI.myAdd(bpanel,paymentfee,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,paymentfeefield2,constraints,3,1,1,1);
		
		PManagementController pc=new PManagementController();
		CostController cc=new CostController();



		 
		
		BaseUI.myAdd(bpanel,remarks,constraints,2,2,1,1);
		BaseUI.myAdd(bpanel,remarksfield,constraints,3,2,1,1);
		
		
		JButton submit=new JButton("计算金额和付款单编号");	
		BaseUI.myAdd(bpanel,submit,constraints,1,11,1,1);
		
		
		submit.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
		    	PaymentVO payment=cc.setPayment(vo.getType(), vo.getReceiver());
		    	if(submit.getText().equals("计算金额和付款单编号")){
		    		
		    
			    	
			    		payment.setNameOfWriter(vo.getNameOfWriter());
			    		if(vo.getType().equals(PaymentType.Salary)||vo.getType().equals(PaymentType.TransFee)){		    			
			    			payment=cc.computePayment(payment);
			    			paymentfeefield2.setText(payment.getNumberOfPayment()+"");
			    		}else{
			    	        try{
				    			double fee=Double.parseDouble(paymentfeefield2.getText());	
				    			payment=cc.computePayment(payment,fee);
			    	        }catch(NumberFormatException e){
			         	    	JOptionPane.showMessageDialog(null, "请输入正确的租金金额"); 
			    	        }
			    		}
			    		auditnumberfield.setText(cc.computeAuditNumber());
			    		payment.setAuditnumber(auditnumberfield.getText());
			    		submit.setText("确认修改支付");	
			    		
		    		
		    	}else{
			    	 AccountVO accountvo=amc.findAccount(accountCombo.getSelectedItem().toString());
			    	 
			    	 payment.setRemarks(remarksfield.getText());
			    	 payment.setCondition(DocumentCondition.handing);

		             ResultMessage result=null;
		             System.out.println(payment.getAuditnumber());
//		             result=cc.payPayment(payment, accountvo);
//		             if(result==ResultMessage.SUCCESS){
//		         	    	JOptionPane.showMessageDialog(null, "支付成功"); 
//		         	    	submit.setText("计算金额和付款单编号");
//		         	    	paymentfeefield2.setText("");
//		         	    	remarksfield.setText("");
//		             }else{
//		         	    	JOptionPane.showMessageDialog(null, "支付失败，请确认账户余额"); 
//		             }
		             Payment.set(selectRow, payment);
		             JOptionPane.showMessageDialog(null, "修改已保存");
		    	}
		    
		    }
		});
		
		panel.add(bpanel);
		
		return panel;
	}

	protected static JPanel createTransportFixPanel(TransportVO transportVO, int selectRow) {
		// TODO Auto-generated method stub
		JPanel fixTransportPanel=new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(5,0,2,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel id=new JLabel("中转|装运单编号：   " + transportVO.getID());
	

		BaseUI.myAdd(bpanel,id,constraints,0,0,1,1);


		JButton submit=new JButton("查询被修改中转|装运单信息");
		JButton sure=new JButton("确认修改");
		JButton fixOrder=new JButton("修改订单");

		BaseUI.myAdd(bpanel,submit,constraints,1,1,1,1);

					ArrayList<String>order=transportVO.getOrder();
					ArrayList<Condition>condition=transportVO.getCondition();
					JLabel sign=new JLabel("单据类型：   " + transportVO.getSign());
					id.setText("中转|装运单编号:  "+transportVO.getID());
					JLabel tranfficId=new JLabel("载具编号");
					JLabel tranfficNumber=new JLabel("载运编号");
					JLabel nameOfWriter=new JLabel("拟写人");
					JLabel departure=new JLabel("出发地/到达地");
					JLabel tranffic=new JLabel("运输方式");
					JLabel fare=new JLabel("费用");
					JLabel fareField = new JLabel();
					JLabel time=new JLabel("填写日期");
					JLabel dCondition=new JLabel("提交状态");
					JLabel member=new JLabel("押运人员");
					JTextField nameOfWriterField=new JTextField(transportVO.getWriter(),20);
					JTextField tranfficIdField=new JTextField(transportVO.getTrafficID(),10);
					JFormattedTextField tranfficNumberField = new JFormattedTextField(TransportManagementPanel.maskTranfficNumber);
					tranfficNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
					tranfficNumberField.setInputVerifier(new FormattedTextFieldVerifier());
		            tranfficNumberField.setText(transportVO.getTransportID());
					//JTextField tranfficNumberField=new JTextField(transportVO.getTransportID(),19);
					DateChooser timeField=new DateChooser(bpanel);
					
					
					timeField.setText(transportVO.getTime());
					JTextArea memberField=new JTextArea(2, 20);
					memberField.setLineWrap(true);
					JScrollPane scrollPane=new JScrollPane(memberField);
					scrollPane.setHorizontalScrollBarPolicy( 
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
					scrollPane.setVerticalScrollBarPolicy( 
							JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
					ArrayList<String>strings=transportVO.getMember();
					String string="";
					for(String s:strings)
						string=s+"\n"+string;
					memberField.setText(string);
//					JComboBox signCombo=new JComboBox();
//					signCombo.addItem(TransportType.Load);
//					signCombo.addItem(TransportType.Reception);
//					signCombo.setSelectedItem(transportVO.getSign());
					JComboBox departureCombo=new JComboBox();
					AManagementService aManagementData = null;
					try {
						aManagementData = new AManagementController(DataFactory.create());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 ArrayList<AgencyVO> agencys = aManagementData.getAllAgency();
					
					for(AgencyVO vo2 : agencys){
					departureCombo.addItem(vo2.getName());
					}
//					for(AgencyVO vo2 : agencys){
//						if(vo2.getIdNumber().equals(transportVO.getDeparture()))
//					departureCombo.setSelectedIndex();
//					}
					String place ;
					if(transportVO.getSign().equals(TransportType.Load))
						place=transportVO.getDestination();
						else 
						place=transportVO.getDeparture();	
					
					for(int i=0;i<agencys.size();i++){
						if(place.equals(agencys.get(i).getIDNumber())){
							departureCombo.setSelectedIndex(i);
							break;
						}	
					}
					
			
					
					
					
					JComboBox tranfficCombo=new JComboBox();
					tranfficCombo.addItem(Traffic.Air);
					tranfficCombo.addItem(Traffic.Train);
					tranfficCombo.addItem(Traffic.Car);
					tranfficCombo.setSelectedItem(transportVO.getTrafficType());
					TransportVO vo=new TransportVO();

					tranfficCombo.addItemListener(new ItemListener() {
						
						@Override
						public void itemStateChanged(ItemEvent e) {
							// TODO Auto-generated method stub
							if(transportVO.getSign().equals(TransportType.Load)){
							vo.setDeparture(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));
		                    vo.setDestination(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
							}else {
								vo.setDeparture(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
			                    vo.setDestination(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));
			                    
							}
		                    
		                    
		                    vo.setTrafficType((Traffic) tranfficCombo.getSelectedItem());
		                    ConstantController constantController=new ConstantController();
		        			Transport transport = null;
							try {
								transport = new Transport(DataFactory.create(),constantController);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		        			TransportService transportService=new TransportController(transport);
							double k=transportService.addFare(vo);
							String fare=""+k;
							vo.setFare(k);
							fareField.setText(fare);
						}
					});
					
					
					JComboBox dConditionCombo=new JComboBox();
					dConditionCombo.addItem(DocumentCondition.draft);
					dConditionCombo.addItem(DocumentCondition.handing);
					dConditionCombo.setSelectedItem(transportVO.getDocumentCondition());

					BaseUI.myAdd(bpanel,id,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel, sign, constraints, 0, 0, 1, 1);
					BaseUI.myAdd(bpanel,tranfficId,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,tranfficNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,nameOfWriter,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,departure,constraints,0,5,1,1);
					//BaseUI.myAdd(bpanel,destination,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,tranffic,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,fare,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,time,constraints,0,8,1,1);
					BaseUI.myAdd(bpanel,dCondition,constraints,0,9,1,1);
					BaseUI.myAdd(bpanel, member, constraints, 0, 10, 1, 1);

					//BaseUI.myAdd(bpanel, signCombo, constraints, 1, 2, 1, 1);
					BaseUI.myAdd(bpanel,tranfficIdField,constraints,1,1,1,1);
					BaseUI.myAdd(bpanel,tranfficNumberField,constraints,1,3,1,1);
					BaseUI.myAdd(bpanel,nameOfWriterField,constraints,1,4,1,1);
					BaseUI.myAdd(bpanel,departureCombo,constraints,1,5,1,1);
					//BaseUI.myAdd(bpanel,destinationCombo,constraints,1,6,1,1);
					BaseUI.myAdd(bpanel,tranfficCombo,constraints,1,6,1,1);
					BaseUI.myAdd(bpanel, fareField, constraints, 1, 7, 1, 1);
					BaseUI.myAdd(bpanel,timeField,constraints,1,8,1,1);
					BaseUI.myAdd(bpanel,dConditionCombo,constraints,1,9,1,1);
					BaseUI.myAdd(bpanel, scrollPane, constraints, 1, 10, 1, 1);
					BaseUI.myAdd(bpanel, fixOrder, constraints, 0, 11, 2, 1);
					BaseUI.myAdd(bpanel, sure, constraints,0, 12, 2, 1);



					fixOrder.addMouseListener(new MouseAdapter(){
						@Override
						public void mouseClicked(MouseEvent arg0) {   
							String title="修改订单";                
								FreeReportPage fixOrderPanel = createFixOrderPage(order, condition);
								tab.addTab(title, TransportUI.createPage(fixOrderPanel));
								FreePagePane pagePane = FreeUtil.getPagePane(fixOrderPanel);
								tab.setSelectedComponent(pagePane);
							}
					});

					sure.addMouseListener(new MouseListener() {

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
							if(memberField.getText().equals("")||tranfficIdField.getText().equals("")||tranfficNumberField.getText().equals("")){
								JOptionPane.showMessageDialog(null, "信息填写不完整");
								return;
							}
							// TODO Auto-generated method stub

							ResultMessage resultMessage;
							String[]s=memberField.getText().split("\n");
							ArrayList<String>member=new ArrayList<String>();
							for(String s1:s)
								member.add(s1);

							vo.setSign(transportVO.getSign());
							vo.setTrafficID(tranfficIdField.getText());
							vo.setTransportID(tranfficNumberField.getText());
							vo.setWriter(nameOfWriterField.getText());
							vo.setTime(timeField.getText());
							vo.setMember(member);
							vo.setDocumentCondition((DocumentCondition) dConditionCombo.getSelectedItem());
							vo.setCondition(condition);
							vo.setOrder(order);
//							try {
//
//								resultMessage=transportService.updateTransport(vo);
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//								resultMessage=ResultMessage.FAIL;
//					
//							}
							Trans.set(selectRow,vo);
							JOptionPane.showMessageDialog(null, "修改已保存");
							tab.remove(FreeUtil.getPagePane(fixTransportPanel));
//							if(resultMessage==ResultMessage.SUCCESS){
//								JOptionPane.showMessageDialog(null, "修改操作成功"); 
//								tab.remove(FreeUtil.getPagePane(fixTransportPanel));
//							}else{
//								JOptionPane.showMessageDialog(null, "修改操作失败，请检查网络连接"); 
//							}
							//TransportUI.setMockers(resultMessage);
						}
				});


		fixTransportPanel.add(bpanel);
		return fixTransportPanel;
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

	public static FreeTabbedPane getTab() {
		return tab;
	}

	public static void setTab(FreeTabbedPane tab) {
		AuditPanel.tab = tab;
	}


	public static JPanel createOrderFixPanel(OrderVO vo){
		
//		BillVO billvo = vo.getBill();
		SenderVO senderVO = vo.getSender();
		ReceiverVO receiverVO = vo.getReceiver();
		GoodsVO goodsVO = vo.getGoods();
	    ArrayList<String> packstrlist = new ArrayList<String>();
		ArrayList<Packing> packlist = new ArrayList<Packing>();
		packstrlist.add("纸箱");
		packstrlist.add("木箱");
		packstrlist.add("快递袋");
		
		packlist.add(Packing.Carton);
		packlist.add(Packing.Wood);
		packlist.add(Packing.Bag);
		
	    MaskFormatter mobilephoneformatter=null;
		try {
			mobilephoneformatter = new MaskFormatter("###########");
		    mobilephoneformatter.setPlaceholderCharacter('0');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    JPanel panel=new JPanel();
	    JLabel sendername,senderaddress,senderworkplace,senderphone,sendermobilephone;
//	    JTextField sendernamefie,senderaddressfie,senderworkplacefie,senderphonefie;
	    JFormattedTextField sendermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel receivername,receiveraddress,receiverworkplace,receiverphone,receivermobilephone;
//	    JTextField receivernamefie,receiveraddressfie,receiverworkplacefie,receiverphonefie;
	    JFormattedTextField receivermobilephonefie = new JFormattedTextField(mobilephoneformatter);
	    JLabel  numberOfGoods,weight,vol,nameOfGoods,size;
//	    JTextField numberOfGoodsfie,weightfie,volfie,nameOfGoodsfie,sizefie;
	    JLabel typeOfPackage;
//		JComboBox packageCombo;
	    JLabel totalFee,receiveFee,changeFee;
	    JLabel dueOfReceive;
	    JLabel typeOfExpress;
//	    JComboBox expressCombo;
	    JLabel ordernumber;
//	    JLabel ordernumberfie;

	    
	    ordernumber=new JLabel("订单号码：   " + vo.getOrdernumber());
//	    ordernumberfie=new JLabel("待计算");
	    sendername=new JLabel("寄件人姓名：   " + senderVO.getName());
	    senderaddress=new JLabel("寄件人地址：   " + senderVO.getAddress());
	    senderworkplace=new JLabel("寄件人单位：   " + senderVO.getAddress());
	    senderphone=new JLabel("寄件人电话：   " + senderVO.getTelNumber());
	    sendermobilephone=new JLabel("寄件人手机：   " + senderVO.getPhoneNumber());
//	    sendernamefie=new JTextField(20);
//	    senderaddressfie=new JTextField(20);
//	    senderworkplacefie=new JTextField(20);
//	    senderphonefie=new JTextField(20);
//	    sendermobilephonefie=new JTextField(20);
	    receivername=new JLabel("收件人姓名：   " + receiverVO.getName());
	    receiveraddress=new JLabel("收件人地址：   " + receiverVO.getAddress() );
	    receiverworkplace=new JLabel("收件人单位：   " + receiverVO.getWorkPlace());
	    receiverphone=new JLabel("收件人电话：   " + receiverVO.getTelNumber());
	    receivermobilephone=new JLabel("收件人手机：   " + receiverVO.getPhoneNumber());
//	    receivernamefie=new JTextField(20);
//	    receiveraddressfie=new JTextField(20);
//	    receiverworkplacefie=new JTextField(20);
//	    receiverphonefie=new JTextField(20);
//	    receivermobilephonefie=new JTextField(20);
	    numberOfGoods=new JLabel("货物件数：   " + goodsVO.getNumberOfGoods());
	    weight=new JLabel("货物重量：   " + goodsVO.getWeight());
	    vol=new JLabel("货物体积：   " + goodsVO.getVolume());
	    nameOfGoods=new JLabel("内件品名：   " + goodsVO.getNameOfGoods());
	    size=new JLabel("货物尺寸：   " + goodsVO.getSize());
//	    numberOfGoodsfie=new JTextField(20);
//	    weightfie=new JTextField(20);
//	    volfie=new JTextField(20);
//	    nameOfGoodsfie=new JTextField(20);
//	    sizefie=new JTextField(20);
	    typeOfPackage=new JLabel("包装类型：   " + goodsVO.getPacking());
//	    packageCombo=new JComboBox();
//	    for(int i=0;i<packstrlist.size();i++){
//	        packageCombo.addItem(packstrlist.get(i));
//	    }

	    totalFee=new JLabel("总费用：   " + vo.getBill().getTotalfee());
//	    JLabel totalFeefie=new JLabel("待计算");
//	    receiveFee=new JLabel("所收费用：");
//	    JTextField receiveFeefie=new JTextField(20);
//	    changeFee=new JLabel("找零：");
//	    JLabel changeFeefie=new JLabel("待计算");
	    dueOfReceive=new JLabel("预期到达日期：   " + vo.getDueOfReceive());
//	    JLabel dueOfReceivefie=new JLabel("待计算");
	    typeOfExpress=new JLabel("快递类型：   " + goodsVO.getExpressType());
//	    expressCombo=new JComboBox();
//	    expressCombo.addItem("经济快递");
//	    expressCombo.addItem("标准快递");
//	    expressCombo.addItem("特快");
	    
	    
	    
	    
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(10,0,10,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		
		BaseUI.myAdd(bpanel,sendername,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,senderaddress,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel,senderworkplace,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,senderphone,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephone,constraints,0,4,1,1);
//		BaseUI.myAdd(bpanel,sendernamefie,constraints,1,0,1,1);
//		BaseUI.myAdd(bpanel,senderaddressfie,constraints,1,1,1,1);
//		BaseUI.myAdd(bpanel,senderworkplacefie,constraints,1,2,1,1);
//		BaseUI.myAdd(bpanel,senderphonefie,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,sendermobilephonefie,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,receivername,constraints,2,0,1,1);
		BaseUI.myAdd(bpanel,receiveraddress,constraints,2,1,1,1);
		BaseUI.myAdd(bpanel,receiverworkplace,constraints,2,2,1,1);
		BaseUI.myAdd(bpanel,receiverphone,constraints,2,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephone,constraints,2,4,1,1);
//		BaseUI.myAdd(bpanel,receivernamefie,constraints,3,0,1,1);
//		BaseUI.myAdd(bpanel,receiveraddressfie,constraints,3,1,1,1);
//		BaseUI.myAdd(bpanel,receiverworkplacefie,constraints,3,2,1,1);
//		BaseUI.myAdd(bpanel,receiverphonefie,constraints,3,3,1,1);
		BaseUI.myAdd(bpanel,receivermobilephonefie,constraints,3,4,1,1);
		
		BaseUI.myAdd(bpanel,numberOfGoods,constraints,0,5,1,1);
		BaseUI.myAdd(bpanel,weight,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,vol,constraints,0,7,1,1);
		BaseUI.myAdd(bpanel,nameOfGoods,constraints,0,8,1,1);
		BaseUI.myAdd(bpanel,size,constraints,0,9,1,1);
//		BaseUI.myAdd(bpanel,numberOfGoodsfie,constraints,1,5,1,1);
//		BaseUI.myAdd(bpanel,weightfie,constraints,1,6,1,1);
//		BaseUI.myAdd(bpanel,volfie,constraints,1,7,1,1);
//		BaseUI.myAdd(bpanel,nameOfGoodsfie,constraints,1,8,1,1);
//		BaseUI.myAdd(bpanel,sizefie,constraints,1,9,1,1);
		
		BaseUI.myAdd(bpanel,typeOfPackage,constraints,2,5,1,1);
		BaseUI.myAdd(bpanel,typeOfExpress,constraints,2,6,1,1);
		BaseUI.myAdd(bpanel,totalFee,constraints,2,7,1,1);
//		BaseUI.myAdd(bpanel,receiveFee,constraints,2,8,1,1);
//		BaseUI.myAdd(bpanel,changeFee,constraints,2,9,1,1);
//		BaseUI.myAdd(bpanel,packageCombo,constraints,3,5,1,1);
//		BaseUI.myAdd(bpanel,expressCombo,constraints,3,6,1,1);
//		BaseUI.myAdd(bpanel,totalFeefie,constraints,3,7,1,1);
//		BaseUI.myAdd(bpanel,receiveFeefie,constraints,3,8,1,1);
//		BaseUI.myAdd(bpanel,changeFeefie,constraints,3,9,1,1);
		
		BaseUI.myAdd(bpanel,ordernumber,constraints,0,10,1,1);
//		BaseUI.myAdd(bpanel,ordernumberfie,constraints,1,10,1,1);
		BaseUI.myAdd(bpanel,dueOfReceive,constraints,2,10,1,1);
//		BaseUI.myAdd(bpanel,dueOfReceivefie,constraints,3,10,1,1);
		
//		weightfie.setText("(单位：千克)");
//		volfie.setText("(单位：立方厘米)");
//		sizefie.setText("(单位：厘米*厘米*厘米)");
//		
		JButton sure=new JButton("确定");
		
        JPanel submitpanel=new JPanel();
        submitpanel.add(sure);
		BaseUI.myAdd(bpanel,submitpanel,constraints,1,11,4,1);
		
		sure.addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent arg0) 
		    {
//		      if(sure.getText().equals("计算费用")){
//		    	  if(sendernamefie.getText().equals("")||senderaddress.getText().equals("")||senderworkplacefie.getText().equals("")||sendermobilephonefie.getText().equals("000000000")
//		    			  ||receivernamefie.getText().equals("")||receiveraddress.getText().equals("")||receiverworkplacefie.getText().equals("")||receivermobilephonefie.getText().equals("000000000")
//		    			  ||numberOfGoodsfie.getText().equals("")||weightfie.getText().equals("(单位：千克)")||volfie.getText().equals("(单位：立方厘米)")||nameOfGoodsfie.getText().equals("")||sizefie.getText().equals("(单位：厘米*厘米*厘米)")){
//		    		  JOptionPane.showMessageDialog(null, "请输入收件人、寄件人、货物完整信息");
//		    		  
//		    	  }else{
//			    	    Date dt = new Date();   
//			    	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
//			    	    String timeOfSend=sdf.format(dt); 
//			    	    int _numberOfGoods=Integer.parseInt(numberOfGoodsfie.getText());
//			    	    double _vol=Double.parseDouble(volfie.getText());
//			    	    double _weight=Double.parseDouble(weightfie.getText());
////			    	    ordervo=new OrderVO(timeOfSend,courierId,sendernamefie.getText(),senderaddressfie.getText(),senderworkplacefie.getText(),senderphonefie.getText(),sendermobilephonefie.getText()
////			    			  ,receivernamefie.getText(),receiveraddressfie.getText(),receiverworkplacefie.getText(),receiverphonefie.getText(),receivermobilephonefie.getText(),_numberOfGoods,_weight,_vol,nameOfGoodsfie.getText(),sizefie.getText()
////			    			  ,expressCombo.getSelectedItem().toString(),changePackingStr(packageCombo.getSelectedItem().toString()),DocumentCondition.handing);
//			    	    vo.setTimeOfSend(timeOfSend);
//			    	    vo.set
//			    	    
//			    	    
//			    	    sc=new SendController();
//			    	    ordervo=sc.calculate(ordervo);
//			    	    billvo=sc.setBill(ordervo);
//			    	    billvo=sc.getchange(Double.parseDouble(receiveFeefie.getText()), billvo);
//			    	    String _dueOfReceive=sc.computedue(ordervo);
//			    	    dueOfReceivefie.setText(_dueOfReceive);
//			    	    ordervo.setDueOfReceive(_dueOfReceive);
//			    	    String _ordernumber=sc.computeOrdernumber();
//			    	    ordernumberfie.setText(_ordernumber);
//			    	    ordervo.setOrdernumber(_ordernumber);
//			    	    
//			    	    sure.setText("确认订单");
//		    	  }
//		      }else if(sure.getText().equals("确认订单")){
//		    	  
//		    	  sc.orderend(billvo, ordervo);
//
//
//		      }
		    	tab.remove(FreeUtil.getPagePane(panel));
		    }
		});    
		
		
	    
		panel.add(bpanel);
		
	    return panel;
	}


	public static FreeReportPage createFixOrderPage(ArrayList<String>order,ArrayList<Condition>condition){
		FreeReportPage fixOrderPanel = new FreeReportPage();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("快递单号");
		model.addColumn("快递状态");
	
		for(int i=0;i<order.size();i++){
			Vector row = new Vector();
			row.add(order.get(i));
			row.add(condition.get(i));
			model.addRow(row);
		}
	
	
		fixOrderPanel=new FreeReportPage();
		FreeToolbarButton add=createButton("/free/test/add.png", "增加订单", true);
		FreeToolbarButton delete=createButton("/free/test/update.png", "删除订单", true);
		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);
	
		JLabel orderNumber=new JLabel("订单号");
		JFormattedTextField orderNumberFiled = new JFormattedTextField(TransportManagementPanel.maskOrderNumber);
		orderNumberFiled.setFocusLostBehavior(JFormattedTextField.COMMIT);
		orderNumberFiled.setInputVerifier(new FormattedTextFieldVerifier());
		JLabel con=new JLabel("货物状态");
		JComboBox conditionCombo=new JComboBox();
		conditionCombo.addItem(Condition.perfect);
		conditionCombo.addItem(Condition.damage);
		conditionCombo.addItem(Condition.lost);
	
		fixOrderPanel.getRightToolBar().add(add);
		fixOrderPanel.getRightToolBar().add(delete);
		fixOrderPanel.getRightToolBar().add(finish);
		FreeToolBar leftToolBar=fixOrderPanel.getLeftToolBar();
		leftToolBar.add(orderNumber);
		leftToolBar.add(orderNumberFiled);
		leftToolBar.add(con);
		leftToolBar.add(conditionCombo);
	
		fixOrderPanel.getTable().setModel(model);
		fixOrderPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
	
		add.addMouseListener(new MouseListener() {
	
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String  orderNumber;
				int i;
				for(i=0;i<model.getRowCount();i++){
					orderNumber = (String) model.getValueAt(i, 0);
					if(orderNumber.equals(orderNumberFiled.getText())){					
						JOptionPane.showMessageDialog(null, "订单已存在");
						return;
					}
				}
				Vector row = new Vector();
				order.add(orderNumberFiled.getText());
				row.add(orderNumberFiled.getText());
				orderNumberFiled.setText("");
				condition.add((Condition) conditionCombo.getSelectedItem());
				row.add(conditionCombo.getSelectedItem());
				model.addRow(row);
			}
		});
		delete.addMouseListener(new MouseListener() {
	
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
	
			}
	
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				String  orderNumber;
				int i;
				int bRowCount=model.getRowCount();
				for(i=0;i<bRowCount;i++){
					orderNumber = (String) model.getValueAt(i, 0);
					if(orderNumber.equals(orderNumberFiled.getText())){
						model.removeRow(i);
						order.remove(i);
						condition.remove(i);
						orderNumberFiled.setText("");

						break;
					}
				}
				if(i==bRowCount){
					JOptionPane.showMessageDialog(null, "查询失败");
				}
			}
		});
	
		finish.addMouseListener(new MouseListener() {
	
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
				//did not solve
				//tab.remove(FreeUtil.getPagePane(fixOrderPanel));
			}
		});
	
	  return fixOrderPanel;
	}
  


}
