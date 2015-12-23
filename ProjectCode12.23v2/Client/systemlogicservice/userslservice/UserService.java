package userslservice;


import java.util.ArrayList;

import enums.ResultMessage;
import enums.Work;
import vo.*;



public interface UserService {
	public ResultMessage delete(String id);
	public UserVO revise(String id);
	public ResultMessage saveChange(UserVO vo);
	public ResultMessage	 add(String name,String accountnumber,String code,String privileges,Work work);
	public ResultMessage save();
	public ArrayList<UserVO> getAllUser();
	
	public UserVO select(String id);

}
