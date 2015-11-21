package usersl;



import dataservice.UserDataService;
import po.UserPO;
import enums.LoginResult;
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
		UserDataService data=datafactory.getUserData();
		user=data.findUserPO(accountandcode[0]);
		if(user==null){
			return LoginResult.WrongAccount;
		}else if(!accountandcode[1].equals(user.getCode())){
			return LoginResult.WrongCode;
		}
		
		
		
		
		return LoginResult.Success;
	}
	
	static Login creatLogin(DataFactory datafactory){
		if(login==null)
			login = new Login(datafactory);	
		
		 return login;
	}

}
