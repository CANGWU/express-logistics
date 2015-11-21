package usersl;

import java.util.ArrayList;





import po.UserPO;
import dataservice.UserDataService;
import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import enums.Work;
import userslservice.UserService;
import vo.LogVO;
import vo.UserVO;

public class UserManagement implements UserService{
	
	DataFactory datafactory;
	static UserManagement um;

	private UserManagement(DataFactory datafactory){
		this.datafactory=datafactory;
	}
	
	
	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();

		return  userdata.deleteUserPO(id);
	}

	
	@Override
	public UserVO revise(String id) {
		// TODO Auto-generated method stub
		
		
		return this.select(id);
		
	}

	@Override
	public ResultMessage saveChange(UserVO vo) {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();
		UserPO po=new UserPO(vo.getName(),vo.getAccountnumber(),vo.getCode(),vo.getPrivileges(),vo.getWork());
			
		
		
		return userdata.updateUserPO(po);
	}

	@Override
	public ResultMessage add(String name, String accountnumber, String code,
			String privileges,Work work) {
		// TODO Auto-generated method stub
		
		UserPO po=new UserPO(name,accountnumber,code,privileges,work);
		UserDataService userdata=datafactory.getUserData();

		
		return 	userdata.insertUserPO(po);
	}

	@Override
	public ResultMessage save() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserVO> getAllUser() {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();
		ArrayList<UserPO> polist=userdata.getAllUsers();
		ArrayList<UserVO> volist=new ArrayList<UserVO>();
		for(int i=0;i<polist.size();i++){
			volist.add(new UserVO(polist.get(i).getName(),polist.get(i).getAccountnumber(),polist.get(i).getCode(),polist.get(i).getPrivileges(),polist.get(i).getWork())) ;
		}
		return volist;
	}

	@Override
	public UserVO select(String id) {
		// TODO Auto-generated method stub
		
		UserDataService userdata=datafactory.getUserData();
		UserPO po=userdata.findUserPO(id);
		
		UserVO vo=new UserVO(po.getName(),po.getAccountnumber(),po.getName(),po.getPrivileges(),po.getWork());
		
		return vo;
	}


	
	
	static UserManagement creatCheck(DataFactory datafactory){
		if(um==null)
			um = new UserManagement(datafactory);	
		
		 return um;
	}

}
