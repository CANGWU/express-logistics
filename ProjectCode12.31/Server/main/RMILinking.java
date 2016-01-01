import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import dataservice.AManagementDataService;
import dataservice.CManagementDataService;
import dataservice.CheckDataService;
import dataservice.ConstantDataService;
import dataservice.DManagementDataService;
import dataservice.DataFactoryService;
import dataservice.FinanceDataService;
import dataservice.IoputDataService;
import dataservice.PManagementDataService;
import dataservice.ReceiveDataService;
import dataservice.SalaryStrategyDataService;
import dataservice.SendDataService;
import dataservice.StockDataService;
import dataservice.TransportDataService;
import dataservice.UserDataService;
import dataserviceimpl.DataFactory;

public class RMILinking {
	DataFactoryService dataFactory;
	PManagementDataService pm;
	DManagementDataService dm;
	CManagementDataService cm;
	AManagementDataService am;
	CheckDataService check;
	ConstantDataService constant;
	FinanceDataService finance;
	IoputDataService ioput;
	ReceiveDataService receive;
	SalaryStrategyDataService salary;
	SendDataService send;
	StockDataService stock;
	TransportDataService transport;
	UserDataService user;
	String URL;

	public RMILinking() throws RemoteException{

	}


	public void setService(){


		dataFactory = new DataFactory();

		try {
			pm = dataFactory.getPManagementData();
			dm = dataFactory.getDManagementData();
			cm = dataFactory.getCManagementData();
			am = dataFactory.getAManagementData();
			check = dataFactory.getCheckData();
			constant = dataFactory.getConstantData();
			finance = dataFactory.getFinanceData();
			ioput = dataFactory.getIoputData();
			receive = dataFactory.getReceiveData();
			salary = dataFactory.getSalaryStrategyData();
			send = dataFactory.getSendData();
			stock = dataFactory.getStockDate();
			transport = dataFactory.getTransportDate();
			user = dataFactory.getUserData();

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void setRMI(){
		String URL = "localhost";
//		try {
//			URL = InetAddress.getLocalHost().getHostAddress();
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		System.out.println(URL);

		try{
			LocateRegistry.createRegistry(1099);
			RMISocketFactory.setSocketFactory(new SMRMISocket());

			System.out.println("14....");
			Naming.bind("//"+URL+":1099/getPManagementDataService",pm);
			System.out.println("13....");
			Naming.bind("//"+URL+":1099/getCManagementDataService",cm);
			System.out.println("12....");
			Naming.bind("//"+URL+":1099/getAManagementDataService",am);
			System.out.println("11....");
			Naming.bind("//"+URL+":1099/getDManagementDataService",dm);
			System.out.println("10....");
			Naming.bind("//"+URL+":1099/getCheckDataService",check);
			System.out.println("9....");
			Naming.bind("//"+URL+":1099/getConstantDataService",constant);
			System.out.println("8....");
			Naming.bind("//"+URL+":1099/getFinanceDataService",finance);
			System.out.println("7....");
			Naming.bind("//"+URL+":1099/getIoputDataService",ioput);
			System.out.println("6....");
			Naming.bind("//"+URL+":1099/getTransportDataService",transport);
			System.out.println("5....");
			Naming.bind("//"+URL+":1099/getReceiveDataService",receive);
			System.out.println("4....");
			Naming.bind("//"+URL+":1099/getSalaryStrategyDataService",salary);
			System.out.println("3....");
			Naming.bind("//"+URL+":1099/getSendDataService",send);
			System.out.println("2....");
			Naming.bind("//"+URL+":1099/getStockDataService",stock);
			System.out.println("1....");
			Naming.bind("//"+URL+":1099/getUserDataService",user);
			System.out.println("0....");
			System.out.println("OK to bound the RMI Service");

		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}



	}


}
