package Test;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

import dataservice.AManagementDataService;
import dataservice.CManagementDataService;
import dataservice.CheckDataService;
import dataservice.ConstantDataService;
import dataservice.DManagementDataService;
import dataservice.FinanceDataService;
import dataservice.PManagementDataService;
import dataservice.SendDataService;
import dataservice.TransportDataService;
import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import dataserviceimpl.FinanceDataImpl;
import dataserviceimpl.SendDataImpl;
import dataserviceimpl.TransportDataImpl;
import enums.Condition;
import enums.DocumentCondition;
import enums.PaymentType;
import enums.Position;
import enums.Sex;
import enums.Traffic;
import enums.TransportType;
import link.Helper;
import po.AgencyPO;
import po.CarPO;
import po.ConstantPO;
import po.DriverPO;
import po.LogisticsPO;
import po.PaymentPO;
import po.ReceiptsPO;
import po.StaffPO;
import po.TransportPO;
import po.UserPO;
import vo.AgencyVO;
import vo.DriverVO;
import vo.PaymentVO;

public class JDBCTest {
 

public static void main(String[] args) throws RemoteException {  
  Helper helper = new Helper();
  DataFactory datafactory = new DataFactory();
//	
//	String 	sql = "select * from userpo order by accountnumber desc;";
//	ResultSet resultSet;
//	try {
//		resultSet = Helper.find(sql);
//		resultSet.next();
//		System.out.println(resultSet.getString(1));
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//  
//  Sex male = Sex.male;
//  TransportDataImpl dm  = TransportDataImpl.create();
//  //ConstantPO po = new ConstantPO(34324,0,0,43434,343,434,343,343,434324,3423,32,43,43,43,4.342,324);
//  ArrayList<String>member=new ArrayList<>();
//  member.add("100");
//  ArrayList<String>order=new ArrayList<>();
//  order.add("000999090");
//  ArrayList<Condition>condition=new ArrayList<>();
//  condition.add(Condition.demage);
//  
////  dm.insert(new TransportPO(TransportType.Load, "00000098765678765432", "3123123",Position.Beijing, Position.Guangzhou, "2010-02-09", "231243", Traffic.Air, 1000, member, order, condition, DocumentCondition.handing, "李四"));
//   ArrayList<TransportPO>pos ;
//  pos = dm.findWithdCondition("李四", DocumentCondition.handing);
//  System.out.println(pos.isEmpty());
//  TransportPO po=pos.get(0);
//  System.out.println(po.getID());
// System.out.println(po.getWriter());
// System.out.println(po.getOrder().get(0));
//  CheckDataService checkDataService = datafactory.getCheckData();
//  
// checkDataService.add("0000000001");
// LogisticsPO po = new LogisticsPO("0000000001");
// po.addMessage("fuck you");
// po.addMessage("let us go");
// checkDataService.update(po);
// LogisticsPO po2 = checkDataService.find("0000000001");
// System.out.println(po2.getLogisticsMessage().get(1));
// SendDataService sendDataImpl = datafactory.getSendData();
// ReceiptsPO po = new ReceiptsPO("dasd", 20, " da", null, "dasd", DocumentCondition.audited);
// // sendDataImpl.insertReceiptsPO(po);
// sendDataImpl.deleteReceiptsPO("dasd", " da");
AManagementDataService aManagementDataService = datafactory.getAManagementData();
ArrayList<AgencyPO>agencyVOs = aManagementDataService.findAllOffice();
System.out.println(agencyVOs.size());

  


}

	
}