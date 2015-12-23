package officerui;

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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dataserviceimpl.DataFactory;
import enums.Sex;
import enums.Work;
import pamanagementsl.CManagementController;
import pamanagementslservice.CManagementService;
import twaver.TWaverUtil;
import vo.CarVO;
import vo.DriverVO;
import free.BaseUI;
import free.FreePagePane;
import free.FreeReportPage;
import free.FreeToolbarButton;
import free.FreeToolbarRoverButton;
import free.FreeUtil;

public class VehicleManagementPanel {
	public static JPanel addVehiclePanel, deleteVehiclePanel, fixVehiclePanel,
			seekVehiclePanel;
	public static JTabbedPane tab;
	private static DataFactory dataFactory;
	private static CarVO carvo;
	private static CManagementService car;

	public static FreeReportPage createVehicleManagementPage(JTabbedPane tab) {
		try {
			dataFactory = DataFactory.create();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		car = new CManagementController(dataFactory);
		VehicleManagementPanel.tab = tab;
		return createReportPage();
	}

	private static FreeReportPage createReportPage() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("车辆代号");
		model.addColumn("车辆编号");
		model.addColumn("发动机号");
		model.addColumn("所属单位");
		model.addColumn("购买时间");
		model.addColumn("服役时间");
		model.addColumn("车辆图片");

		ArrayList<CarVO> carList = car.getAllCar();
		for (Iterator<CarVO> i = carList.iterator(); i.hasNext();) {
			Vector row = new Vector();
			carvo = i.next();
			row.add(carvo.getIDNumber());
			row.add(carvo.getLicenseNumber());
			row.add("00003");
			row.add(carvo.getWorkPlaceNumber());
			row.add("2015/12/06");
			row.add(carvo.getWorkYear());
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
		FreeToolbarButton addVehicle, deleteVehicle, fixVehicle, seekVehicle;
		addVehicle = createButton("/free/test/add.png", "增加车辆", true);
		deleteVehicle = createButton("/free/test/update.png", "删除车辆", true);
		fixVehicle = createButton("/free/test/refresh.png", "修改车辆", true);
		seekVehicle = createButton("/free/test/print.png", "查找车辆", true);
		page.getRightToolBar().add(addVehicle);
		page.getRightToolBar().add(deleteVehicle);
		page.getRightToolBar().add(fixVehicle);
		page.getRightToolBar().add(seekVehicle);

		addVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = addVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(addVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createAddVehiclePanel();
					tab.addTab(title, OfficerUI.createPage(addVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(addVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		deleteVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = deleteVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createDeleteVehiclePanel();
					tab.addTab(title, OfficerUI.createPage(deleteVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(deleteVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		fixVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = fixVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createFixVehiclePanel();
					tab.addTab(title, OfficerUI.createPage(fixVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(fixVehiclePanel);
					tab.setSelectedComponent(pagePane);
				}

			}
		});

		seekVehicle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = seekVehicle.getToolTipText();
				try {
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekVehiclePanel);
					tab.setSelectedComponent(pagePane);
				} catch (Exception ex) {
					createSeekVehiclePanel();
					tab.addTab(title, OfficerUI.createPage(seekVehiclePanel));
					FreePagePane pagePane = FreeUtil
							.getPagePane(seekVehiclePanel);
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

	private static void createAddVehiclePanel() {
		addVehiclePanel = new JPanel();
		JLabel vehicleMark = new JLabel("车辆代号");
		JLabel vehicleID = new JLabel("车辆编号");
		JLabel engineID = new JLabel("发动机号");
		JLabel hallID = new JLabel("所属单位");
		JLabel timeOfBuy = new JLabel("购买时间");
		JLabel workingTime = new JLabel("服役时间");
		JLabel picture = new JLabel("车辆图片");
		JTextField vehicleMarkfield = new JTextField(10);
		JTextField vehicleIDfield = new JTextField(10);
		JTextField engineIDfield = new JTextField(10);
		JTextField hallIDfield = new JTextField(10);
		JTextField timeOfBuyfield = new JTextField(10);
		JTextField workingTimefield = new JTextField(10);

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
		BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
		BaseUI.myAdd(bpanel, hallID, constraints, 0, 3, 1, 1);
		BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
		BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
		BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
		BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
		BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 3, 1, 1);
		BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
		BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);

		JButton submit = new JButton("提交");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					carvo = new CarVO(vehicleMarkfield.getText(), hallIDfield
							.getText(), vehicleIDfield.getText(), Integer
							.parseInt(workingTimefield.getText()));
					car.save(carvo);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		/***********************************************/
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);

		addVehiclePanel.add(bpanel);
	}

	private static void createDeleteVehiclePanel() {
		deleteVehiclePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("车辆代号");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询删除车辆信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bpanel.remove(submit);
				bpanel.remove(vehicleMark);
				bpanel.remove(vehicleMarkfield);

				carvo = car.select(vehicleMarkfield.getText());

				JLabel vehicleMark = new JLabel("车辆代号");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel engineID = new JLabel("发动机号");
				JLabel hallID = new JLabel("所属单位");
				JLabel timeOfBuy = new JLabel("购买时间");
				JLabel workingTime = new JLabel("服役时间");
				JLabel picture = new JLabel("车辆图片");
				JLabel vehicleMarkfield = new JLabel(carvo.getIDNumber());
				JLabel vehicleIDfield = new JLabel(carvo.getLicenseNumber());
				JLabel engineIDfield = new JLabel("00003");
				JLabel hallIDfield = new JLabel(carvo.getWorkPlaceNumber());
				JLabel timeOfBuyfield = new JLabel("2015/12/06");
				JLabel workingTimefield = new JLabel(carvo.getWorkYear() + "");

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);

				JButton delete = new JButton("确认删除");
				delete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							car.delete(vehicleMarkfield.getText());
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
				BaseUI.myAdd(bpanel, delete, constraints, 0, 7, 2, 1);
			}
		});

		deleteVehiclePanel.add(bpanel);
	}

	private static void createFixVehiclePanel() {
		fixVehiclePanel = new JPanel();

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("车辆代号");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("修改车辆信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);

		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bpanel.remove(submit);
				bpanel.remove(vehicleMark);
				bpanel.remove(vehicleMarkfield);

				JLabel vehicleMark = new JLabel("车辆代号");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel engineID = new JLabel("发动机号");
				JLabel hallID = new JLabel("所属单位");
				JLabel timeOfBuy = new JLabel("购买时间");
				JLabel workingTime = new JLabel("服役时间");
				JLabel picture = new JLabel("车辆图片");
				JTextField vehicleMarkfield = new JTextField(10);
				JTextField vehicleIDfield = new JTextField(10);
				JTextField engineIDfield = new JTextField(10);
				JTextField hallIDfield = new JTextField(10);
				JTextField timeOfBuyfield = new JTextField(10);
				JTextField workingTimefield = new JTextField(10);

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);

				JButton fix = new JButton("确认修改");
				fix.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							carvo = new CarVO(vehicleMarkfield.getText(),
									hallIDfield.getText(), vehicleIDfield
											.getText(), Integer
											.parseInt(workingTimefield
													.getText()));
							car.saveChange(carvo);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				/***********************************************/
				BaseUI.myAdd(bpanel, fix, constraints, 0, 7, 2, 1);
			}

		});

		fixVehiclePanel.add(bpanel);

	}

	private static void createSeekVehiclePanel() {
		seekVehiclePanel = new JPanel();
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(25, 0, 25, 0);
		JPanel bpanel = new JPanel();
		bpanel.setLayout(gb);

		JLabel vehicleMark = new JLabel("车辆代号");
		JTextField vehicleMarkfield = new JTextField(10);
		BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
		BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);

		JButton submit = new JButton("查询车辆信息");
		BaseUI.myAdd(bpanel, submit, constraints, 0, 7, 2, 1);
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				carvo = car.select(vehicleMark.getText());
				submit.setText("确认");
				bpanel.remove(vehicleMark);
				bpanel.remove(vehicleMarkfield);
				JLabel vehicleMark = new JLabel("车辆代号");
				JLabel vehicleID = new JLabel("车辆编号");
				JLabel engineID = new JLabel("发动机号");
				JLabel hallID = new JLabel("所属单位");
				JLabel timeOfBuy = new JLabel("购买时间");
				JLabel workingTime = new JLabel("服役时间");
				JLabel picture = new JLabel("车辆图片");
				JLabel vehicleMarkfield = new JLabel(carvo.getIDNumber());
				JLabel vehicleIDfield = new JLabel(carvo.getLicenseNumber());
				JLabel engineIDfield = new JLabel("00003");
				JLabel hallIDfield = new JLabel(carvo.getWorkPlaceNumber());
				JLabel timeOfBuyfield = new JLabel("2015/12/06");
				JLabel workingTimefield = new JLabel(carvo.getWorkYear()+"");

				BaseUI.myAdd(bpanel, vehicleMark, constraints, 0, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleID, constraints, 0, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineID, constraints, 0, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallID, constraints, 0, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuy, constraints, 0, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTime, constraints, 0, 5, 1, 1);
				BaseUI.myAdd(bpanel, picture, constraints, 0, 6, 1, 1);

				BaseUI.myAdd(bpanel, vehicleMarkfield, constraints, 1, 0, 1, 1);
				BaseUI.myAdd(bpanel, vehicleIDfield, constraints, 1, 1, 1, 1);
				BaseUI.myAdd(bpanel, engineIDfield, constraints, 1, 2, 1, 1);
				BaseUI.myAdd(bpanel, hallIDfield, constraints, 1, 3, 1, 1);
				BaseUI.myAdd(bpanel, timeOfBuyfield, constraints, 1, 4, 1, 1);
				BaseUI.myAdd(bpanel, workingTimefield, constraints, 1, 5, 1, 1);
			}
		});

		seekVehiclePanel.add(bpanel);
	}
}
