package userslservice;


import java.util.ArrayList;

import po.ResultMessage;
import vo.*;



public interface UserService {
	public ResultMessage login(String id,String password);
	public ResultMessage delete(String id);
	public void revise(String id);
	public ResultMessage saveChange(UserVO vo);
	public UserVO	 add(String name,String accountnumber,String code,String privileges);
	public ResultMessage save();
	public ArrayList<UserVO> getAllUser();
	
	public UserVO select(String id);
    public ArrayList<LogVO> getLog(String office,String staff,String time);
}
