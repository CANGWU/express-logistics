

import java.rmi.RemoteException;
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
		rmi.setRMI();
		Helper helper = new Helper();

	}

}
