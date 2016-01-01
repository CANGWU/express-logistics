

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

import link.Helper;

public class Main {
	//@SuppressWarnings("deprecation")
	public static void main(String[]args) throws RemoteException{
		//set RMISercurity

		//		if(System.getSecurityManager() == null){
		//			System.setSecurityManager(new RMISecurityManager());	
		//		}
		//		
		
		
		RMILinking rmi = new RMILinking();
		rmi.setService();
		rmi.setRMI();
		Helper helper = new Helper();

	}

}
