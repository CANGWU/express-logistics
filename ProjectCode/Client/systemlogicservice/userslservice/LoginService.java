package userslservice;


import enums.LoginResult;



public interface LoginService {
	public LoginResult login(String[] accountandcode);
}
