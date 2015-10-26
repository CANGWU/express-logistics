package slstub;

import java.util.ArrayList;

import po.ResultMessage;
import userslservice.UserService;
import vo.LogVO;
import vo.UserVO;

public class UserStub implements UserService{

	@Override
	public ResultMessage login(String id, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void revise(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage saveChange(UserVO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public UserVO add(String name,String accountnumber,String code,String privileges) {
		// TODO Auto-generated method stub
		UserVO user=new UserVO( name, accountnumber, code, privileges);
		return user;
	}

	@Override
	public ResultMessage save() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		 ArrayList<UserVO> list=new  ArrayList<UserVO>();
		 UserVO user=new UserVO( "zhangsan", "1234567890", "123456", "high");
		 list.add(user);
		return list;
	}

	@Override
	public UserVO select(String id) {
		// TODO Auto-generated method stub
		 UserVO user=new UserVO( "zhangsan", "1234567890", "123456", "high");
		return user;
	}

	@Override
	public ArrayList<LogVO> getLog(String office, String staff, String time) {
		// TODO Auto-generated method stub
		LogVO log=new LogVO("2015/1/1","gulou","000001","hh");
		ArrayList<LogVO> list=new ArrayList<LogVO>();
		list.add(log);
		return list;
	}

}
