package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.CManagementDataService;
import enums.ResultMessage;
import link.Helper;
import po.CarPO;

public class CManagementDataImpl extends UnicastRemoteObject implements CManagementDataService {

	private CManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public CarPO find(String id) {
		// TODO Auto-generated method stub
		ResultSet result = null;
		String sql = "select*from carpo where idNumber='"+id+"';";
		CarPO car = null;
		
		try{
			result = Helper.find(sql);
			if(result.next())
				car = new CarPO(result.getString("idNumber"),result.getString("workPlaceNumber"),
						result.getString("licenseNumber"),result.getInt("workYear"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}

	@Override
	public ArrayList<CarPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<CarPO>cars = new ArrayList<CarPO>();
		ResultSet result = null;
		String sql = "select*from carpo";
		CarPO car = null;
		
		try{
			result = Helper.find(sql);
			while(result.next()){
				car = new CarPO(result.getString("idNumber"),result.getString("workPlaceNumber"),
						result.getString("licenseNumber"),result.getInt("workYear"));
			cars.add(car);
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public ResultMessage insert(CarPO po) {
		// TODO Auto-generated method stub
		String sql = "insert into carpo values('"+po.getIDNumber()+"','"+po.getWorkPlaceNumber()+"','"
				+po.getLicenseNumber()+"',"+po.getWorkYear()+");";
		
		return Helper.insert(sql);

	}

	@Override
	public ResultMessage delete(CarPO po) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM carpo WHERE licenseNumber='"+po.getLicenseNumber()+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage delete(String id) {
		String sql = "DELETE FROM carpo WHERE idNumber='"+id+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(CarPO po){
		// TODO Auto-generated method stub
		ResultMessage result = delete(po.getIDNumber());
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
	public static CManagementDataImpl create() throws RemoteException{
		if(cm == null){
			synchronized(CManagementDataImpl.class){
		
		if(cm == null)
		cm = new CManagementDataImpl();
			}
		}
			
		return cm;
	}
	
   private volatile static CManagementDataImpl cm;

}
