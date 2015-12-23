package Test;

import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.AManagementDataService;
import dataservice.CManagementDataService;
import dataservice.CheckDataService;
import dataservice.ConstantDataService;
import dataservice.DManagementDataService;
import dataservice.PManagementDataService;
import dataservice.TransportDataService;
import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import dataserviceimpl.TransportDataImpl;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.Sex;
import enums.Traffic;
import enums.TransportType;
import link.Helper;
import po.AgencyPO;
import po.CarPO;
import po.ConstantPO;
import po.DriverPO;
import po.StaffPO;
import po.TransportPO;
import po.UserPO;
import vo.DriverVO;

public class JDBCTest {
 

public static void main(String[] args) throws RemoteException {  
  Helper helper = new Helper();
  DataFactory datafactory = new DataFactory();
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
  ConstantDataService c = datafactory.getConstantData();
  c.delete();


}

	
}