 package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.DManagementDataService;
import enums.ResultMessage;
import enums.Sex;
import enums.Work;
import link.Helper;
import po.DriverPO;
import po.StaffPO;

public class DManagementDataImpl extends UnicastRemoteObject implements DManagementDataService {

	private DManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public DriverPO find(String id){
		// TODO Auto-generated method stub
		ResultSet result = null;
		String sql = "SELECT*FROM driverpo WHERE workNumber= '" + id + "';";
	
		DriverPO driver = null;
		
		try {
			result = Helper.find(sql);
			if(result.next())
			driver = new DriverPO(result.getString("name"),Work.valueOf(result.getString("work")),result.getString("workNumber"),
					result.getString("workPlaceNumber"),result.getString("birthDate"),result.getString("idNumber"),result.getString("phoneNumber"),
					result.getString("address"),Sex.valueOf(result.getString("sex")),result.getInt("driverYear"),result.getInt("page"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	@Override
	public ArrayList<DriverPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<DriverPO>drivers = new ArrayList<DriverPO>();
		DriverPO driver = null;
		ResultSet result = null;
		String sql = "SELECT*FROM driverpo;";
		try {
	     result = Helper.find(sql);
			while(result.next()){
				driver = new DriverPO(result.getString("name"),Work.valueOf(result.getString("work")),result.getString("workNumber"),
								result.getString("workPlaceNumber"),result.getString("birthDate"),result.getString("idNumber"),result.getString("phoneNumber"),
								result.getString("address"),Sex.valueOf(result.getString("sex")),result.getInt("driverYear"),result.getInt("page"));
				drivers.add(driver);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drivers;
	}

	@Override
	public ResultMessage insert(DriverPO po) {
		// TODO Auto-generated method stub
       String sql = "insert into driverpo(name,work,workNumber,workPlaceNumber,birthdate,idNumber,phoneNumber,address,sex,driverYear,page) values('"
		+po.getName()+"','"+po.getWork()+"','"+po.getWorkNumber()+"','"+po.getWorkPlaceNumber()+"','"+po.getBirthDate()+"','"+po.getIdNumber()+"','"+po.getPhoneNumber()+
		"','"+po.getAddress()+"','"+po.getSex()+"',"+po.getDriverYear()+","+po.getPage()+");";
       return Helper.insert(sql);
	}

	@Override
	public ResultMessage delete(DriverPO po) {
		// TODO Auto-generated method stub	
		String sql = "DELETE FROM driverpo WHERE idNumber='"+po.getIdNumber()+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM driverpo WHERE workNumber='"+id+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage update(DriverPO po) {
		// TODO Auto-generated method stub
		//UPDATE student SET sage = 20 WHERE Snum = '09032401' ; 
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

	public static DManagementDataImpl create() throws RemoteException{
		if(dm == null){
			synchronized(DManagementDataImpl.class){
		
		if(dm == null)
		dm = new DManagementDataImpl();
			}
		}
			
		return dm;
	}
	
   private volatile static DManagementDataImpl dm;
}
