package RMItest;

import java.rmi.Naming;
import dataservice.DataFactoryService;

public class TestMain {
	
	public static void main(String[]args){
		DataFactoryService dataFactory;
		
		try{
			dataFactory = (DataFactoryService)Naming.lookup("//localhost:1099/getDataFactory");
			System.out.println(dataFactory.getPManagementData().find("1"));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
