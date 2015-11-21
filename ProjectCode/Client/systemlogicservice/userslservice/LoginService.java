package userslservice;

import enums.ResultMessage;

public interface LoginService {
	public ResultMessage login(String[] accountandcode);
}
