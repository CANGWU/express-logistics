package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.DriverPO;
import po.StaffPO;
import dataservice.PManagementDataService;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import link.Helper;

public class PManagementDataImpl extends UnicastRemoteObject implements PManagementDataService{

	private PManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StaffPO find(String id) {
		// TODO Auto-generated method stub
		ResultSet result = null;
		String sql = "select*from staffpo where workNumber='"+id+"';";

		StaffPO po = null;


		try {
			result = Helper.find(sql);
			if(result.next())
				po  = new StaffPO(result.getString("name"),Work.valueOf(result.getString("work")),result.getString("workNumber"),
						result.getString("workPlaceNumber"),result.getString("birthDate"),result.getString("idNumber"),result.getString("phoneNumber"),
						result.getString("address"),Sex.valueOf(result.getString("sex")),result.getInt("page"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ArrayList<StaffPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<StaffPO>staff = new ArrayList<StaffPO>();
		StaffPO sta = null;
		ResultSet result = null;
		String sql = "SELECT*FROM staffpo;";
		try {
			result = Helper.find(sql);
			while(result.next()){
				sta = new StaffPO(result.getString("name"),Work.valueOf(result.getString("work")),result.getString("workNumber"),
						result.getString("workPlaceNumber"),result.getString("birthDate"),result.getString("idNumber"),result.getString("phoneNumber"),
						result.getString("address"),Sex.valueOf(result.getString("sex")),result.getInt("page"));
				staff.add(sta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public ResultMessage insert(StaffPO po) {
		// TODO Auto-generated method stub 
		String sql = "insert into staffpo(name,work,workNumber,workPlaceNumber,birthdate,idNumber,phoneNumber,address,sex,page) values('"
				+po.getName()+"','"+po.getWork()+"','"+po.getWorkNumber()+"','"+po.getWorkPlaceNumber()+"','"+po.getBirthDate()+"','"+po.getIdNumber()+"','"+po.getPhoneNumber()+
				"','"+po.getAddress()+"','"+po.getSex()+"',"+po.getPage()+");";

		return Helper.insert(sql);

	}

	@Override
	public ResultMessage delete(StaffPO po) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM staffpo WHERE idNumber='"+po.getIdNumber()+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM staffpo WHERE workNumber='"+id+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage update(StaffPO po) {
		// TODO Auto-generated method stub
		ResultMessage result = delete(po.getWorkNumber());
		if(result==ResultMessage.FAIL)
			return ResultMessage.FAIL;
		return insert(po);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}

	public static PManagementDataImpl create() throws RemoteException{
		if(pm == null){
			synchronized(PManagementDataImpl.class){

				if(pm == null)
					pm = new PManagementDataImpl();
			}
		}

		return pm;
	}

	private volatile static PManagementDataImpl pm;

	@Override
	public ArrayList<StaffPO> findMember(Work work, String workplace) throws RemoteException {

		String sql = "select*from staffpo where work='"+work+"' and workplacenumber='"+workplace+"';";

		ArrayList<StaffPO>staffPOs=new ArrayList<>();
		ResultSet result = null;

		try {
			result = Helper.find(sql);
			while(result.next()){
				StaffPO sta = new StaffPO(result.getString("name"),Work.valueOf(result.getString("work")),result.getString("workNumber"),
						result.getString("workPlaceNumber"),result.getString("birthDate"),result.getString("idNumber"),result.getString("phoneNumber"),
						result.getString("address"),Sex.valueOf(result.getString("sex")),result.getInt("page"));
				staffPOs.add(sta);




			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// TODO Auto-generated method stub
		return staffPOs;
	}

}
