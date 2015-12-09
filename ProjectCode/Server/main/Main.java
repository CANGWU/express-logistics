
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

import dataservice.DManagementDataService;
import dataservice.DataFactoryService;
import dataservice.PManagementDataService;
import dataserviceimpl.DManagementDataImpl;
import dataserviceimpl.DataFactory;
import dataserviceimpl.PManagementDataImpl;
import link.Helper;

public class Main {
	//@SuppressWarnings("deprecation")
	public static void main(String[]args){
		//set RMISercurity

		//		if(System.getSecurityManager() == null){
		//			System.setSecurityManager(new RMISecurityManager());	
		//		}
		//		
       RMILinking rmi = new RMILinking();
       rmi.setRMI();
       Helper helper = new Helper();

	}

}
