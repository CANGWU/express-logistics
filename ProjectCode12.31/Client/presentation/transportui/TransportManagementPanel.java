package transportui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import javax.sound.midi.VoiceStatus;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.xml.crypto.Data;

import com.sun.corba.se.spi.ior.Identifiable;
import com.sun.jmx.remote.util.OrderClassLoaders;
import com.sun.org.apache.xml.internal.security.Init;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import dataservice.AManagementDataService;
import dataservice.DataFactoryService;
import dataserviceimpl.DataFactory;
import dateChoose.DateChooser;
import dateChoose.DateChooserJButton;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import twaver.TWaverUtil;
import twaver.base.A.A.A;
import twaver.base.A.E.a;
import twaver.base.A.E.c;
import twaver.base.A.E.f;
import twaver.base.A.E.i;
import vo.AgencyVO;
import vo.TransportVO;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeTabbedPane;
import free.FreeToolBar;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;
import main.StaffInfoPanel;
import pamanagementsl.AManagementController;
import strategysl.Constant;
import strategysl.ConstantController;
import sun.misc.ConditionLock;
import sun.swing.SwingUtilities2.Section;
import transportsl.Transport;
import transportsl.TransportController;
import transportslservice.TransportService;

public class TransportManagementPanel extends FreePagePane{
	public static TransportService transportService;
	public static JPanel deleteTransportPanel,seekTransportPanel, addTransportPanel,fixTransportPanel;
	public static FreeReportPage addOrderPanel,fixOrderPanel,seekOrderPanel;
	public static FreeTabbedPane tab;
	public static MaskFormatter maskIDNumber;
	public static MaskFormatter maskTranfficNumber;
	public static MaskFormatter maskTranfficID;
	public static MaskFormatter maskTime;
	public static MaskFormatter maskOrderNumber;
	private static DataFactory dataFactory;
	private static ConstantController constantController;
	private static AManagementController aManagementData;
	private static Transport transport;
	private static String dateString;
	private static ArrayList<AgencyVO> agencys;
//	private static JPanel 
	//		private static ArrayList<String> order;
	//		private static ArrayList<Condition> condition;
	//	

	public static FreeReportPage  createTransportManagementPage(FreeTabbedPane tab){
		try {
			dataFactory=DataFactory.create();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		constantController=new ConstantController();
		transport=new Transport(dataFactory,constantController);
		transportService=new TransportController(transport);

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		dateString = formatter.format(currentTime);

		aManagementData = new AManagementController(dataFactory);
		agencys = aManagementData.getAllAgency();


		try {

			initMaskFormatter();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TransportManagementPanel.tab=tab;		
		return createReportPage();
	}

	private static void initMaskFormatter() throws ParseException {
		// TODO Auto-generated method stub
		maskIDNumber=new MaskFormatter("#####################");
		maskTranfficNumber=new MaskFormatter("#####################");
		maskIDNumber.setPlaceholderCharacter('0');

		maskTranfficNumber.setPlaceholderCharacter('0');
		//时间还需要整理
		maskTime=new MaskFormatter("####*##*##");
		maskTime.setPlaceholderCharacter('0');
		maskOrderNumber=new MaskFormatter("##########");
		maskOrderNumber.setPlaceholderCharacter('0');

	}

	private static void createAddTransportPanel(){

		addTransportPanel=new FreePagePane();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(5,0,2,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);
		bpanel.setFont(new java.awt.Font("宋体", java.awt.Font.PLAIN, 14));



		TransportVO vo = new TransportVO();
		ArrayList<String>order=new ArrayList<String>();
		ArrayList<Condition>condition=new ArrayList<Condition>();

		JLabel sign=new JLabel("单据类型");


		JLabel id=new JLabel("中转|装运单编号");

		JLabel tranfficId=new JLabel("载具编号");
		JLabel tranfficNumber=new JLabel("载运编号");
		JLabel nameOfWriter=new JLabel("拟写人");
		JLabel departure=new JLabel("出发地/到达地");
		//			JLabel destination=new JLabel("到达地");
		JLabel tranffic=new JLabel("运输方式");
		JLabel fare=new JLabel("费用");
		JLabel time=new JLabel("填写日期");
		JLabel dCondition=new JLabel("提交状态");
		JLabel member=new JLabel("押运人员");
		JLabel fareField = new JLabel();
		JFormattedTextField idField = new JFormattedTextField(maskIDNumber);
		idField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		idField.setInputVerifier(new FormattedTextFieldVerifier());

		JComboBox signCombo=new JComboBox();
		signCombo.addItem(TransportType.Load);
		signCombo.addItem(TransportType.Reception);

		idField.setText(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6)+dateString+signCombo.getSelectedIndex());
		JTextField nameOfWriterField=new JTextField(20);
		nameOfWriterField.setText(StaffInfoPanel.userVO.getName());


		JTextField tranfficIdField=new JTextField(10);

		JFormattedTextField tranfficNumberField = new JFormattedTextField(maskTranfficNumber);
		tranfficNumberField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		tranfficNumberField.setInputVerifier(new FormattedTextFieldVerifier());
		tranfficNumberField.setText(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6)+dateString);

		DateChooser timeField=new DateChooser(bpanel);
		JTextArea memberField=new JTextArea(2, 20);
		memberField.setLineWrap(true);
		JScrollPane scrollPane=new JScrollPane(memberField);
		scrollPane.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

		JComboBox departureCombo=new JComboBox();
		for(AgencyVO vo2 : agencys){
			departureCombo.addItem(vo2.getName());
		}


		signCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				idField.setText(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6)+dateString+signCombo.getSelectedIndex());
				if(signCombo.getSelectedIndex()==0){
					id.setText("装车单编号");	
					tranfficNumber.setText("载运编号");
					departure.setText("到达地");  

				}else{
					id.setText("中转单编号"); 	
					tranfficNumber.setText("装车单编号");
					departure.setText("出发地");

				}
			}
		});
		//			JComboBox destinationCombo=new JComboBox();
		//			destinationCombo.addItem(Position.Beijing);
		//			destinationCombo.addItem(Position.Shanghai);
		//			destinationCombo.addItem(Position.Nanjing);
		//			destinationCombo.addItem(Position.Guangzhou);
		JComboBox tranfficCombo=new JComboBox();
		tranfficCombo.addItem(Traffic.Air);
		tranfficCombo.addItem(Traffic.Train);
		tranfficCombo.addItem(Traffic.Car);

		tranfficCombo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(signCombo.getSelectedItem().equals(TransportType.Load)){
					vo.setDeparture(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));
					vo.setDestination(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
				}else {
					vo.setDeparture(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
					vo.setDestination(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));

				}


				vo.setTrafficType((Traffic) tranfficCombo.getSelectedItem());
				double k=transportService.addFare(vo);
				String fare=""+k;
				vo.setFare(k);
				fareField.setText(fare);
			}
		});


		JComboBox dConditionCombo=new JComboBox();
		dConditionCombo.addItem(DocumentCondition.draft);
		dConditionCombo.addItem(DocumentCondition.handing);


		BaseUI.myAdd(bpanel,id,constraints,0,1,1,1);
		BaseUI.myAdd(bpanel, sign, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel,tranfficId,constraints,0,2,1,1);
		BaseUI.myAdd(bpanel,tranfficNumber,constraints,0,3,1,1);
		BaseUI.myAdd(bpanel,nameOfWriter,constraints,0,4,1,1);
		BaseUI.myAdd(bpanel,departure,constraints,0,5,1,1);
		//			BaseUI.myAdd(bpanel,destination,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,tranffic,constraints,0,6,1,1);
		BaseUI.myAdd(bpanel,fare,constraints,0,7,1,1);
		BaseUI.myAdd(bpanel,time,constraints,0,8,1,1);
		BaseUI.myAdd(bpanel,dCondition,constraints,0,9,1,1);
		BaseUI.myAdd(bpanel, member, constraints, 0, 10, 1, 1);

		BaseUI.myAdd(bpanel,idField,constraints,1,1,1,1);
		BaseUI.myAdd(bpanel, signCombo, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel,tranfficIdField,constraints,1,2,1,1);
		BaseUI.myAdd(bpanel,tranfficNumberField,constraints,1,3,1,1);
		BaseUI.myAdd(bpanel,nameOfWriterField,constraints,1,4,1,1);
		BaseUI.myAdd(bpanel,departureCombo,constraints,1,5,1,1);
		//BaseUI.myAdd(bpanel,destinationCombo,constraints,1,6,1,1);
		BaseUI.myAdd(bpanel,tranfficCombo,constraints,1,6,1,1);
		BaseUI.myAdd(bpanel, fareField, constraints, 1, 7, 1, 1);
		BaseUI.myAdd(bpanel,timeField,constraints,1,8,1,1);
		BaseUI.myAdd(bpanel,dConditionCombo,constraints,1,9,1,1);
		BaseUI.myAdd(bpanel, scrollPane, constraints, 1, 10, 1, 1);

		JButton addOrder=new JButton("添加订单");
		//addOrder.addActionListener(arg0);
		addOrder.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title="添加订单";   
				//					if(signCombo.getSelectedIndex()==0){
				//						
				//					}
				//					else{
				//						TransportVO vo = null;
				//						try {
				//							vo = transportService.getTransport(tranfficNumberField.getText());
				//						} catch (Exception e) {
				//							// TODO Auto-generated catch block
				//							e.printStackTrace();
				//						}
				//						order = vo.getOrder();
				//						condition = vo.getCondition();		
				//					}
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(addOrderPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					//						if(signCombo.getSelectedIndex()==0)
					createAddOrderPage(order,condition);
					//						else 
					//						createAddOrderPage(tranfficNumberField.getText());
					tab.addTab(title, TransportUI.createPage(addOrderPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addOrderPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


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
				if(memberField.getText().equals("")||tranfficIdField.getText().equals("")||tranfficNumberField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "信息填写不完整");
					return;
				}

				ResultMessage resultMessage;
				String[]s=memberField.getText().split("\n");
				ArrayList<String>member=new ArrayList<String>();
				for(String s1:s)
					member.add(s1);
				vo.setID(idField.getText());
				vo.setSign((TransportType) signCombo.getSelectedItem());
				vo.setTrafficID(tranfficIdField.getText());
				vo.setTransportID(tranfficNumberField.getText());
				vo.setWriter(nameOfWriterField.getText());
				vo.setTime(timeField.getText());
				vo.setMember(member);
				vo.setDocumentCondition((DocumentCondition)dConditionCombo.getSelectedItem());
				vo.setCondition(condition);
				vo.setOrder(order);
				try {

					resultMessage=transportService.saveTransport(vo);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}
				if(resultMessage==ResultMessage.SUCCESS){
					JOptionPane.showMessageDialog(null, "添加操作成功"); 
					tab.remove(FreeUtil.getPagePane(addTransportPanel));
				}else{
					JOptionPane.showMessageDialog(null, "添加操作失败,请检查网络连接或者单据ID是否雷同"); 
				}
			}

			//TransportUI.setMockers(resultMessage);
		});
		BaseUI.myAdd(bpanel, addOrder, constraints, 0, 11, 2, 1);
		BaseUI.myAdd(bpanel,submit,constraints,0,12,2,1);


		addTransportPanel.add(bpanel);
	}



	private static void createDeleteTransportPanel(){
		deleteTransportPanel=new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(15,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);


		JLabel id=new JLabel("中转|装运单编号");
		JFormattedTextField idField = new JFormattedTextField(maskIDNumber);
		idField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		idField.setInputVerifier(new FormattedTextFieldVerifier());

		BaseUI.myAdd(bpanel,id,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idField,constraints,1,0,1,1);

		JButton submit=new JButton("查询被删除的中转|装运单编号");


		JButton sure=new JButton("确认删除");
		BaseUI.myAdd(bpanel,submit,constraints,1,1,1,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){ 
				TransportVO vo = null;
				ResultMessage resultMessage=null;
				try {
					vo=transportService.getTransport(idField.getText());
					if(vo!=null)
						resultMessage=ResultMessage.SUCCESS;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if(resultMessage!=ResultMessage.FAIL){
					bpanel.remove(submit);
					bpanel.remove(idField);

					JLabel sign =  new JLabel("单据类型：     " + vo.getSign());
					JLabel id=new JLabel("中转|装运单编号:  " + vo.getID());
					JLabel tranfficId=new JLabel("载具编号:  "+vo.getTrafficID());
					JLabel tranfficNumber=new JLabel("载运编号:  "+vo.getTransportID());
					JLabel nameOfWriter=new JLabel("拟写人:  "+vo.getWriter());
					if(vo.getSign().equals(TransportType.Load)){
						JLabel destination=new JLabel("到达地:  "+vo.getDestination());
						BaseUI.myAdd(bpanel,destination,constraints,0,5,1,1);

					}
					else {
						JLabel departure=new JLabel("出发地:  "+vo.getDeparture());
						BaseUI.myAdd(bpanel,departure,constraints,0,5,1,1);

					}
					JLabel tranffic=new JLabel("运输方式:  "+vo.getTrafficType());
					JLabel fare=new JLabel("费用:  "+vo.getfare());
					JLabel time=new JLabel("填写日期:  "+vo.getTime());
					JLabel dCondition=new JLabel("提交状态:  "+vo.getDocumentCondition());

					BaseUI.myAdd(bpanel, sign, constraints, 0, 1, 1, 1);
					BaseUI.myAdd(bpanel,id,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,tranfficId,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,tranfficNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,nameOfWriter,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,tranffic,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,fare,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,time,constraints,0,8,1,1);
					BaseUI.myAdd(bpanel,dCondition,constraints,0,9,1,1);
					BaseUI.myAdd(bpanel, sure, constraints, 0, 10, 1, 1);
					String transportID=vo.getID();
					sure.addMouseListener(new MouseAdapter(){
						ResultMessage resultMessage=null;
						public void mouseClicked(MouseEvent arg0){
							try {
								resultMessage=transportService.deleteTransport(transportID);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								resultMessage=ResultMessage.FAIL;
							}
							if(resultMessage==ResultMessage.SUCCESS){
								JOptionPane.showMessageDialog(null, "删除操作成功"); 
								tab.remove(FreeUtil.getPagePane(deleteTransportPanel));
							}else{
								JOptionPane.showMessageDialog(null, "删除操作失败，请检查网络连接"); 
							}
						}
					});
				}else{
					JOptionPane.showMessageDialog(null, "查询失败，请检查网络连接或者单据ID"); 
				}
			}
		});

		deleteTransportPanel.add(bpanel);
	}

	private static void createFixTransportPanel(){
		fixTransportPanel=new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(5,0,2,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel id=new JLabel("中转|装运单编号");
		JFormattedTextField idField = new JFormattedTextField(maskIDNumber);
		idField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		idField.setInputVerifier(new FormattedTextFieldVerifier());
		BaseUI.myAdd(bpanel,id,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idField,constraints,1,0,1,1);

		JButton submit=new JButton("查询被修改中转|装运单信息");
		JButton sure=new JButton("确认修改");
		JButton fixOrder=new JButton("修改订单");

		BaseUI.myAdd(bpanel,submit,constraints,1,1,1,1);

		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){

				TransportVO transportVO=null;
				ResultMessage resultMessage=null;
				try {
					transportVO=transportService.getTransport(idField.getText());
					if(transportVO!=null)
						resultMessage=ResultMessage.SUCCESS;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}//

				if (resultMessage!=ResultMessage.FAIL){

					ArrayList<String>order=transportVO.getOrder();
					ArrayList<Condition>condition=transportVO.getCondition();

					bpanel.remove(submit);
					bpanel.remove(idField);
					JLabel sign=new JLabel("单据类型:  "+ transportVO.getSign());
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
					JFormattedTextField tranfficNumberField = new JFormattedTextField(maskTranfficNumber);
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
					//						JComboBox signCombo=new JComboBox();
					//						signCombo.addItem(TransportType.Load);
					//						signCombo.addItem(TransportType.Reception);
					//						signCombo.setSelectedItem(transportVO.getSign());
					JComboBox departureCombo=new JComboBox();
					for(AgencyVO vo2 : agencys){
						departureCombo.addItem(vo2.getName());
					}
					//						for(AgencyVO vo2 : agencys){
					//							if(vo2.getIdNumber().equals(transportVO.getDeparture()))
					//						departureCombo.setSelectedIndex();
					//						}
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
					//						
					//						signCombo.addItemListener(new ItemListener() {
					//							
					//							@Override
					//							public void itemStateChanged(ItemEvent e) {
					//								// TODO Auto-generated method stub
					//								idField.setText(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6)+dateString+signCombo.getSelectedIndex());
					//
					//							}
					//						});;
					//				



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
							if(vo.getSign().equals(TransportType.Load)){
								vo.setDeparture(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));
								vo.setDestination(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
							}else {
								vo.setDeparture(agencys.get(departureCombo.getSelectedIndex()).getIDNumber());
								vo.setDestination(StaffInfoPanel.userVO.getAccountnumber().substring(0, 6));

							}


							vo.setTrafficType((Traffic) tranfficCombo.getSelectedItem());
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

					//						BaseUI.myAdd(bpanel, signCombo, constraints, 1, 2, 1, 1);
					BaseUI.myAdd(bpanel,tranfficIdField,constraints,1,2,1,1);
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


					//						JButton calFare=new JButton("计算运费");
					//						BaseUI.myAdd(bpanel, calFare, constraints, 1, 8, 1, 1);
					//						calFare.addMouseListener(new MouseListener() {
					//	
					//							@Override
					//							public void mouseReleased(MouseEvent e) {
					//								// TODO Auto-generated method stub
					//	
					//							}
					//	
					//							@Override
					//							public void mousePressed(MouseEvent e) {
					//								// TODO Auto-generated method stub
					//	
					//							}
					//	
					//							@Override
					//							public void mouseExited(MouseEvent e) {
					//								// TODO Auto-generated method stub
					//	
					//							}
					//	
					//							@Override
					//							public void mouseEntered(MouseEvent e) {
					//								// TODO Auto-generated method stub
					//	
					//							}
					//	
					//							@Override
					//							public void mouseClicked(MouseEvent e) {
					//								// TODO Auto-generated method stub
					//								vo.setDeparture((Position) departureCombo.getSelectedItem());
					//								vo.setDestination((Position) destinationCombo.getSelectedItem());
					//								vo.setTrafficType((Traffic) tranfficCombo.getSelectedItem());
					//								double k=transportService.addFare(vo);
					//								String fare=""+k;
					//								vo.setFare(k);
					//								calFare.setText(fare);
					//							}
					//						});
					//	
					//	
					fixOrder.addMouseListener(new MouseAdapter(){
						@Override
						public void mouseClicked(MouseEvent arg0) {   
							String title="修改订单";                
							try{
								FreePagePane pagePane = FreeUtil.getPagePane(fixOrderPanel);
								tab.setSelectedComponent(pagePane);
							}catch(Exception ex){
								createFixOrderPage(order, condition);
								tab.addTab(title, TransportUI.createPage(fixOrderPanel));
								FreePagePane pagePane = FreeUtil.getPagePane(fixOrderPanel);
								tab.setSelectedComponent(pagePane);
							}


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

							//								vo.setSign((TransportType) signCombo.getSelectedItem());
							vo.setTrafficID(tranfficIdField.getText());
							vo.setTransportID(tranfficNumberField.getText());
							vo.setWriter(nameOfWriterField.getText());
							vo.setTime(timeField.getText());
							vo.setMember(member);
							vo.setDocumentCondition((DocumentCondition) dConditionCombo.getSelectedItem());
							vo.setCondition(condition);
							vo.setOrder(order);
							try {

								resultMessage=transportService.updateTransport(vo);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								resultMessage=ResultMessage.FAIL;

							}
							if(resultMessage==ResultMessage.SUCCESS){
								JOptionPane.showMessageDialog(null, "修改操作成功"); 
								tab.remove(FreeUtil.getPagePane(fixTransportPanel));
							}else{
								JOptionPane.showMessageDialog(null, "修改操作失败，请检查网络连接"); 
							}
							//TransportUI.setMockers(resultMessage);
						}
					});

				}else{
					JOptionPane.showMessageDialog(null, "查询失败，请检查网络连接或者单据ID");
				}


			}
		});


		fixTransportPanel.add(bpanel);

	}

	private static void createSeekTransportPanel(){
		seekTransportPanel=new JPanel();
		GridBagLayout gb=new GridBagLayout(); 
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets=new Insets(15,0,5,0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);


		JLabel id=new JLabel("中转|装运单编号");
		JFormattedTextField idField = new JFormattedTextField(maskIDNumber);
		idField.setFocusLostBehavior(JFormattedTextField.COMMIT);
		idField.setInputVerifier(new FormattedTextFieldVerifier());
		BaseUI.myAdd(bpanel,id,constraints,0,0,1,1);
		BaseUI.myAdd(bpanel,idField,constraints,1,0,1,1);

		JButton submit=new JButton("查询中转|装运单信息");
		JButton sure=new JButton("确认信息");
		BaseUI.myAdd(bpanel,submit,constraints,1,1,1,1);
		submit.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){ 
				TransportVO vo = null;
				ResultMessage resultMessage=ResultMessage.SUCCESS;
				try {
					vo=transportService.getTransport(idField.getText());
					resultMessage=ResultMessage.SUCCESS;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resultMessage=ResultMessage.FAIL;
				}

				if(resultMessage!=ResultMessage.FAIL){
					bpanel.remove(id);
					bpanel.remove(submit);
					bpanel.remove(idField);

					JLabel sign =  new JLabel("单据类型：     " + vo.getSign());
					JLabel id=new JLabel("中转|装运单编号:  " + vo.getID());
					JLabel tranfficId=new JLabel("载具编号:  "+vo.getTrafficID());
					JLabel tranfficNumber=new JLabel("载运编号:  "+vo.getTransportID());
					JLabel nameOfWriter=new JLabel("拟写人:  "+vo.getWriter());
					if(vo.getSign().equals(TransportType.Load)){
						JLabel destination=new JLabel("到达地:  "+vo.getDestination());
						BaseUI.myAdd(bpanel,destination,constraints,0,5,1,1);

					}
					else {
						JLabel departure=new JLabel("出发地:  "+vo.getDeparture());
						BaseUI.myAdd(bpanel,departure,constraints,0,5,1,1);

					}
					JLabel tranffic=new JLabel("运输方式:  "+vo.getTrafficType());
					JLabel fare=new JLabel("费用:  "+vo.getfare());
					JLabel time=new JLabel("填写日期:  "+vo.getTime());
					JLabel dCondition=new JLabel("提交状态:  "+vo.getDocumentCondition());

					BaseUI.myAdd(bpanel, sign, constraints, 0, 0, 1, 1);
					BaseUI.myAdd(bpanel,id,constraints,0,1,1,1);
					BaseUI.myAdd(bpanel,tranfficId,constraints,0,2,1,1);
					BaseUI.myAdd(bpanel,tranfficNumber,constraints,0,3,1,1);
					BaseUI.myAdd(bpanel,nameOfWriter,constraints,0,4,1,1);
					BaseUI.myAdd(bpanel,tranffic,constraints,0,6,1,1);
					BaseUI.myAdd(bpanel,fare,constraints,0,7,1,1);
					BaseUI.myAdd(bpanel,time,constraints,0,8,1,1);
					BaseUI.myAdd(bpanel,dCondition,constraints,0,9,1,1);
					BaseUI.myAdd(bpanel, sure, constraints, 0, 11, 1, 1);
					JButton seekOrder = new JButton("查看订单");
					BaseUI.myAdd(bpanel, seekOrder , constraints, 0, 10, 2, 1);
					String idnumber = vo.getID();
					seekOrder.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent arg0){
							//check the TransportPO
							String title="查看订单";                
							try{
								FreePagePane pagePane = FreeUtil.getPagePane(seekOrderPanel);
								tab.setSelectedComponent(pagePane);
							}catch(Exception ex){
								createSeekOrderPage(idnumber);
								tab.addTab(title, TransportUI.createPage(seekOrderPanel));
								FreePagePane pagePane = FreeUtil.getPagePane(seekOrderPanel);
								tab.setSelectedComponent(pagePane);
							}


						}

					

					});

					sure.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent arg0){
							//check the TransportPO
							tab.remove(FreeUtil.getPagePane(seekTransportPanel));
						}
					});
				}else{
					JOptionPane.showMessageDialog(null, "查询失败，请检查网络连接或者单据ID");
				}
			}
		});

		seekTransportPanel.add(bpanel);
	}


	//展示层的删除功能未完成！！！
	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("中转单|装运单编号");
		model.addColumn("拟写人");
		model.addColumn("单据状态");
		model.addColumn("时间");
		model.addColumn("运输方式");
		model.addColumn("单据类型");
		ArrayList<TransportVO>vos=null;
		ResultMessage resultMessage=null;


		//nameOfWriter 没添加
		try {
			vos=transportService.getTransportList(StaffInfoPanel.userVO.getName(), DocumentCondition.draft);
			resultMessage=ResultMessage.SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMessage=ResultMessage.FAIL;
		}

		if(resultMessage==ResultMessage.SUCCESS)
			for (TransportVO vo:vos) {
				Vector row = new Vector();
				row.add(vo.getID());
				row.add(vo.getWriter());
				row.add(DocumentCondition.draft);
				row.add(vo.getTime());
				row.add(vo.getTrafficType());
				row.add(vo.getSign());
				model.addRow(row);
			}else {
				JOptionPane.showMessageDialog(null, "查找失败");
			}

		FreeReportPage page = new FreeReportPage();
		page.getTable().setModel(model);
		page.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
		setupPageToolbar(page);

		return page;
	}

	public static void createFixOrderPage(ArrayList<String>order,ArrayList<Condition>condition){
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
		JFormattedTextField orderNumberFiled = new JFormattedTextField(maskOrderNumber);
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
				tab.remove(FreeUtil.getPagePane(fixOrderPanel));
			}
		});


	}


	public static void createSeekOrderPage(String id){
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("快递单号");
		model.addColumn("快递状态");
		TransportVO vo = null;
		try {
			vo = transportService.getTransport(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i=0;i<vo.getOrder().size();i++){
			Vector row = new Vector();
			row.add(vo.getOrder().get(i));
			row.add(vo.getCondition().get(i));
			model.addRow(row);
		}


		seekOrderPanel=new FreeReportPage();
		//		FreeToolbarButton add=createButton("/free/test/add.png", "增加订单", true);
		//		FreeToolbarButton delete=createButton("/free/test/update.png", "删除订单", true);
		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);
		//	
		//		JLabel orderNumber=new JLabel("订单号");
		//		JFormattedTextField orderNumberFiled = new JFormattedTextField(maskOrderNumber);
		//		orderNumberFiled.setFocusLostBehavior(JFormattedTextField.COMMIT);
		//		orderNumberFiled.setInputVerifier(new FormattedTextFieldVerifier());
		//		JLabel con=new JLabel("货物状态");
		//		JComboBox conditionCombo=new JComboBox();
		//		conditionCombo.addItem(Condition.perfect);
		//		conditionCombo.addItem(Condition.damage);
		//		conditionCombo.addItem(Condition.lost);

		//		fixOrderPanel.getRightToolBar().add(add);
		//		fixOrderPanel.getRightToolBar().add(delete);
		seekOrderPanel.getRightToolBar().add(finish);
		//		FreeToolBar leftToolBar=fixOrderPanel.getLeftToolBar();
		//		leftToolBar.add(orderNumber);
		//		leftToolBar.add(orderNumberFiled);
		//		leftToolBar.add(con);
		//		leftToolBar.add(conditionCombo);
		//	
		seekOrderPanel.getTable().setModel(model);
		seekOrderPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());

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
				tab.remove(FreeUtil.getPagePane(fixOrderPanel));
			}
		});


	}

	private static void createAddOrderPage(ArrayList<String> order, ArrayList<Condition> condition) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("快递单号");
		model.addColumn("快递状态");;

		for(int i=0;i<order.size();i++){
			Vector row = new Vector();
			row.add(order.get(i));
			row.add(condition.get(i));
			model.addRow(row);
		}

		addOrderPanel=new FreeReportPage();
		FreeToolbarButton add=createButton("/free/test/add.png", "增加订单", true);
		FreeToolbarButton delete=createButton("/free/test/update.png", "删除订单", true);
		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);

		JLabel orderNumber=new JLabel("订单号");
		JFormattedTextField orderNumberFiled = new JFormattedTextField(maskOrderNumber);
		orderNumberFiled.setFocusLostBehavior(JFormattedTextField.COMMIT);
		orderNumberFiled.setInputVerifier(new FormattedTextFieldVerifier());

		JLabel conditionLabel=new JLabel("货物状态");
		JComboBox conditionCombo=new JComboBox();
		conditionCombo.addItem(Condition.perfect);
		conditionCombo.addItem(Condition.damage);
		conditionCombo.addItem(Condition.lost);

		addOrderPanel.getRightToolBar().add(add);
		addOrderPanel.getRightToolBar().add(delete);
		addOrderPanel.getRightToolBar().add(finish);
		FreeToolBar leftToolBar=addOrderPanel.getLeftToolBar();
		leftToolBar.add(orderNumber);
		leftToolBar.add(orderNumberFiled);
		leftToolBar.add(conditionLabel);
		leftToolBar.add(conditionCombo);

		addOrderPanel.getTable().setModel(model);
		addOrderPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());

		add.addMouseListener(new MouseListener() {

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
				//addOrderPanel
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
				///addOrderPanel.
				tab.remove(FreeUtil.getPagePane(addOrderPanel));			}
		});


	}

	//	protected static void createAddOrderPage(String id) {
	//		DefaultTableModel model = new DefaultTableModel();
	//		model.addColumn("快递单号");
	//		model.addColumn("快递状态");
	//		TransportVO vo = null;
	//		try {
	//			 vo = transportService.getTransport(id);
	//			 if(order.indexOf(vo.getOrder().get(0))==-1&&vo.getCondition().equals(DocumentCondition.audited)){
	//					order = vo.getOrder();
	//					condition = vo.getCondition();	
	//					}
	//		} catch (Exception e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//			JOptionPane.showMessageDialog(null, "装车单查询失败");
	//		} 
	//		
	//		
	//		
	//	
	//		for(int i=0;i<order.size();i++){
	//			Vector row = new Vector();
	//			row.add(order.get(i));
	//			row.add(condition.get(i));
	//			model.addRow(row);
	//		}
	//	
	//		addOrderPanel=new FreeReportPage();
	//		FreeToolbarButton add=createButton("/free/test/add.png", "增加订单", true);
	//		FreeToolbarButton delete=createButton("/free/test/update.png", "删除订单", true);
	//		FreeToolbarButton finish=createButton("/free/test/print.png", "结束添加", true);
	//	
	//		JLabel orderNumber=new JLabel("订单号");
	//		JFormattedTextField orderNumberFiled = new JFormattedTextField(maskOrderNumber);
	//		orderNumberFiled.setFocusLostBehavior(JFormattedTextField.COMMIT);
	//		orderNumberFiled.setInputVerifier(new FormattedTextFieldVerifier());
	//	
	//		JLabel conditionLabel=new JLabel("货物状态");
	//		JComboBox conditionCombo=new JComboBox();
	//		conditionCombo.addItem(Condition.perfect);
	//		conditionCombo.addItem(Condition.damage);
	//		conditionCombo.addItem(Condition.lost);
	//	
	//		addOrderPanel.getRightToolBar().add(add);
	//		addOrderPanel.getRightToolBar().add(delete);
	//		addOrderPanel.getRightToolBar().add(finish);
	//		FreeToolBar leftToolBar=addOrderPanel.getLeftToolBar();
	//		leftToolBar.add(orderNumber);
	//		leftToolBar.add(orderNumberFiled);
	//		leftToolBar.add(conditionLabel);
	//		leftToolBar.add(conditionCombo);
	//	
	//		addOrderPanel.getTable().setModel(model);
	//		addOrderPanel.setDescription("All Work Order Items by Part Number. Created " + new Date().toString());
	//	
	//		add.addMouseListener(new MouseListener() {
	//	
	//			@Override
	//			public void mouseReleased(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mousePressed(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseExited(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseEntered(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseClicked(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//				//addOrderPanel
	//				String  orderNumber;
	//				int i;
	//				for(i=0;i<model.getRowCount();i++){
	//					orderNumber = (String) model.getValueAt(i, 0);
	//					if(orderNumber.equals(orderNumberFiled.getText())){					
	//						JOptionPane.showMessageDialog(null, "订单已存在");
	//						return;
	//					}
	//				}
	//				Vector row = new Vector();
	//				order.add(orderNumberFiled.getText());
	//				row.add(orderNumberFiled.getText());
	//				orderNumberFiled.setText("");
	//				condition.add((Condition) conditionCombo.getSelectedItem());
	//				row.add(conditionCombo.getSelectedItem());
	//				model.addRow(row);
	//			}
	//		});
	//	
	//		delete.addMouseListener(new MouseListener() {
	//	
	//			@Override
	//			public void mouseReleased(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mousePressed(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseExited(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseEntered(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseClicked(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//				String  orderNumber;
	//				int i;
	//				int bRowCount=model.getRowCount();
	//				for(i=0;i<bRowCount;i++){
	//					orderNumber = (String) model.getValueAt(i, 0);
	//					if(orderNumber.equals(orderNumberFiled.getText())){
	//						model.removeRow(i);
	//						order.remove(i);
	//						condition.remove(i);
	//						orderNumberFiled.setText("");
	//
	//						break;
	//					}
	//				}
	//				if(i==bRowCount){
	//					JOptionPane.showMessageDialog(null, "查询失败");
	//				}
	//			}
	//		}); 
	//	
	//		finish.addMouseListener(new MouseListener() {
	//	
	//			@Override
	//			public void mouseReleased(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mousePressed(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseExited(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseEntered(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//	
	//			}
	//	
	//			@Override
	//			public void mouseClicked(MouseEvent arg0) {
	//				// TODO Auto-generated method stub
	//				///addOrderPanel.
	//				tab.remove(FreeUtil.getPagePane(addOrderPanel));			}
	//		});
	//	
	//		
	//	}
	public static void setupPageToolbar(FreePagePane page) {
		FreeToolbarButton addTransport,deleteTransport,fixTransport,seekTransport;
		addTransport=createButton("/free/test/add.png", "增加中转|装运单", true);
		deleteTransport=createButton("/free/test/update.png", "删除中转|装运单", true);
		fixTransport=createButton("/free/test/refresh.png", "修改中转|装运单", true);
		seekTransport=createButton("/free/test/print.png", "查找中转|装运单", true);
		page.getRightToolBar().add(addTransport);
		page.getRightToolBar().add(deleteTransport);
		page.getRightToolBar().add(fixTransport);
		page.getRightToolBar().add(seekTransport);

		addTransport.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=addTransport.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(addTransportPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createAddTransportPanel();
					tab.addTab(title, TransportUI.createPage(addTransportPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(addTransportPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		deleteTransport.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=deleteTransport.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(deleteTransportPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createDeleteTransportPanel();
					tab.addTab(title, TransportUI.createPage(deleteTransportPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(deleteTransportPanel);
					tab.setSelectedComponent(pagePane);
				}


			}
		});


		fixTransport.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=fixTransport.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(fixTransportPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createFixTransportPanel();
					tab.addTab(title, TransportUI.createPage(fixTransportPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(fixTransportPanel);
					tab.setSelectedComponent(pagePane);

				}


			}
		});

		seekTransport.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{   
				String title=seekTransport.getToolTipText();                
				try{
					FreePagePane pagePane = FreeUtil.getPagePane(seekTransportPanel);
					tab.setSelectedComponent(pagePane);
				}catch(Exception ex){
					createSeekTransportPanel();
					tab.addTab(title, TransportUI.createPage(seekTransportPanel));
					FreePagePane pagePane = FreeUtil.getPagePane(seekTransportPanel);
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
