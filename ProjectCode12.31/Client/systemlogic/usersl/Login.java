package usersl;



import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import po.UserPO;
import enums.LoginResult;
import enums.ResultMessage;
import userslservice.LoginService;

public class Login implements LoginService{
	static Login login;
	DataFactory datafactory;
	UserPO user;
	
	
	private Login(DataFactory datafactory){
		this.datafactory=datafactory;
	}

	@Override
	public LoginResult login(String[] accountandcode) {
		// TODO Auto-generated method stub

		try {
			UserDataService data=datafactory.getUserData();
			user=data.findUserPO(accountandcode[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return LoginResult.NoServer;
		}
		LoginResult result=null;
		
		if(user==null){
			return LoginResult.WrongAccount;
		}else if(!accountandcode[1].equals(user.getCode())){
			return LoginResult.WrongCode;
		}
		
		
		switch(user.getWork()){
		   case Courier:
			   return LoginResult.Courier;
		   case Finance:
			   return LoginResult.Finance;
		   case Manager:
			   return LoginResult.Manager;
		   case Admin :
			   return LoginResult.Admin;
		   case Stock:
			   return LoginResult.Stock;
		   case TransOffice:
			   return LoginResult.TransOffice;
		   case Officer:
			   return LoginResult.Officer;

			   
		}
		
		
		
		return LoginResult.Courier;
	}
	

	
	public static Login creatLogin(DataFactory datafactory){
		if(login==null)
			login = new Login(datafactory);	
		
		 return login;
	}

}
