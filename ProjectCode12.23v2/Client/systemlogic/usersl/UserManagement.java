package usersl;

import java.rmi.RemoteException;
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

	private UserManagement(){
		try {
			this.datafactory=DataFactory.create();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		UserDataService userdata=datafactory.getUserData();

		try {
			return  userdata.deleteUserPO(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			
		
		
		try {
			return userdata.updateUserPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage add(String name, String accountnumber, String code,
			String privileges,Work work) {
		// TODO Auto-generated method stub
		
		UserPO po=new UserPO(name,accountnumber,code,privileges,work);
		UserDataService userdata=datafactory.getUserData();

		
		try {
			return 	userdata.insertUserPO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		ArrayList<UserPO> polist=null;
		try {
			polist = userdata.getAllUsers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		UserPO po=null;
		try {
			po = userdata.findUserPO(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserVO vo=new UserVO(po);
		
		return vo;
	}


	
	
	public static UserManagement creatUserManagement(){
		if(um==null)
			um = new UserManagement();	
		
		 return um;
	}

}
