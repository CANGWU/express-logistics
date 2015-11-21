package RMItest;

import java.rmi.Naming;

import dataservice.DManagementDataService;
import dataservice.DataFactoryService;
import dataservice.PManagementDataService;
import pamanagementslservice.PManagementService;
import po.DriverPO;
import po.StaffPO;

public class TestMain {
	
	public static void main(String[]args){
		PManagementDataService pamanagementData;
		DManagementDataService dmanagementData;
		
		try{
			pamanagementData = (PManagementDataService)Naming.lookup("//localhost:1099/getPManagementDataService");
			//PManagementDataService pmanagementData = dataFactory.getPManagementData();
			StaffPO po = pamanagementData.find("1");
			System.out.println(po.getName());
			//System.out.println(dataFactory.getPManagementData().find("1").getName());
			dmanagementData = (DManagementDataService)Naming.lookup("//localhost:1099/getDManagementDataService");
			//PManagementDataService pmanagementData = dataFactory.getPManagementData();
			//DriverPO op = dmanagementData.find("1");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
