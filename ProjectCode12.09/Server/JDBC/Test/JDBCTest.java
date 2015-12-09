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
import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import enums.Sex;
import link.Helper;
import po.AgencyPO;
import po.CarPO;
import po.ConstantPO;
import po.DriverPO;
import po.StaffPO;
import po.UserPO;
import vo.DriverVO;

public class JDBCTest {
 

public static void main(String[] args) throws RemoteException {  
  Helper helper = new Helper();
  DataFactory datafactory = new DataFactory();
//  
//  Sex male = Sex.male;
  UserDataService dm  = datafactory.getUserData();
  //ConstantPO po = new ConstantPO(34324,0,0,43434,343,434,343,343,434324,3423,32,43,43,43,4.342,324);
  UserPO po=dm.findUserPO("000000001");
  System.out.println(po.getCode());

}

	
}