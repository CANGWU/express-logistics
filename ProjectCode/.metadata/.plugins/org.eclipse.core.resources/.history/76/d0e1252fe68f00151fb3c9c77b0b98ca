
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

import dataservice.DataFactoryService;
import dataservice.PManagementDataService;
import dataserviceimpl.DataFactory;
import dataserviceimpl.PManagementDataImpl;

public class Main {
	//@SuppressWarnings("deprecation")
	public static void main(String[]args){
		//set RMISercurity
	
//		if(System.getSecurityManager() == null){
//			System.setSecurityManager(new RMISecurityManager());	
//		}
//		
		try{
			//LocateRegistry.createRegistry(port); 
			//DataFactoryService dataFactory = new DataFactory();
			PManagementDataService pm = new PManagementDataImpl();
		    LocateRegistry.createRegistry(8000); 
			Naming.bind("//localhost:8000/getDataFactory",pm);
			System.out.println("OK to bound the RMI Service");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
