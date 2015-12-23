package usersl;

import java.util.ArrayList;

import enums.ResultMessage;
import enums.Work;
import userslservice.UserService;
import vo.UserVO;

public class UserManagementController implements UserService {
    UserManagement userManagement;
    
    public UserManagementController(){
    	this.userManagement=UserManagement.creatUserManagement();
    }
	
	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		return userManagement.delete(id);
	}

	@Override
	public UserVO revise(String id) {
		// TODO Auto-generated method stub
		return userManagement.revise(id);
	}

	@Override
	public ResultMessage saveChange(UserVO vo) {
		// TODO Auto-generated method stub
		return userManagement.saveChange(vo);
	}

	@Override
	public ResultMessage add(String name, String accountnumber, String code,
			String privileges, Work work) {
		// TODO Auto-generated method stub
		return userManagement.add(name, accountnumber, code, privileges, work);
	}

	@Override
	public ResultMessage save() {
		// TODO Auto-generated method stub
		return userManagement.save();
	}

	@Override
	public ArrayList<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		return userManagement.getAllUser();
	}

	@Override
	public UserVO select(String id) {
		// TODO Auto-generated method stub
		return userManagement.select(id);
	}

}
