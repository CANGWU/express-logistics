package dataserviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dataservice.AManagementDataService;
import enums.Condition;
import enums.ResultMessage;
import link.Helper;
import po.AgencyPO;
import po.StaffPO;

public class AManagementDataImpl extends UnicastRemoteObject  implements AManagementDataService {

	private AManagementDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgencyPO find(String id) {
		// TODO Auto-generated method 
		ResultSet result =null;
		String sql = "select*from Agencypo where idNumber='"+id+"';";
		AgencyPO agency = null;
		ArrayList<String>staff = new ArrayList<String>();

		try{
			result = Helper.find(sql);
			if(result.next()){
				//ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("staff"));  
				try {
					staff = (ArrayList<String>)IOObject.getArray(result.getBytes("staff"));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				//staff = (ArrayList<String>)oips.readObject();
				agency = new AgencyPO(result.getString("name"),result.getString("idNumber"),staff,result.getString("phoneNumber"),result.getString("address"),result.getString("leader"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return agency;
	}

	@Override
	public ArrayList<AgencyPO> findAll() {

		ResultSet result =null;
		String sql = "select*from agencypo";
		AgencyPO agency = null;
		ArrayList<AgencyPO>agencys = new ArrayList<AgencyPO>();
		ArrayList<String>staff=null;

		try{
			result = Helper.find(sql);
			while(result.next()){
				try {
					staff = (ArrayList<String>)IOObject.getArray(result.getBytes("staff"));

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				agency = new AgencyPO(result.getString("name"),result.getString("idNumber"),staff,result.getString("phoneNumber"),result.getString("address"),result.getString("leader"));
				agencys.add(agency);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return agencys;
	}
	@Override
	public ResultMessage insert(AgencyPO po) {

		String sql = "insert into agencypo values('"+po.getName()+"','"+po.getIDNumber()+"','"+po.getPhoneNumber()+"','"+po.getLeader()+"','"
				+po.getAddress()+"',?);";
		try{
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(1, IOObject.toByteArray(po.getStaff()));
			Helper.pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

		return ResultMessage.SUCCESS;

	}

	@Override
	public ResultMessage delete(AgencyPO po) {
		String sql = "DELETE FROM agencypo WHERE idNumber='"+po.getIDNumber()+"';";
		ResultMessage result = Helper.delete(sql);
		return result;

	}

	@Override
	public ResultMessage delete(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM agencypo WHERE idNumber='"+id+"';";
		ResultMessage result = Helper.delete(sql);
		return result;
	}

	@Override
	public ResultMessage update(AgencyPO po) {
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
	
	
	
	public static AManagementDataImpl create() throws RemoteException{
		if(am == null){
			synchronized(AManagementDataImpl.class){

				if(am == null)
					am = new AManagementDataImpl();
			}
		}

		return am;
	}

	private volatile static AManagementDataImpl am;

	@Override
	public ArrayList<AgencyPO> findAllOffice() throws RemoteException {
		// TODO Auto-generated method stub
		ResultSet result =null;
		String sql = "select*from agencypo";
		AgencyPO agency = null;
		ArrayList<AgencyPO>agencys = new ArrayList<AgencyPO>();
		ArrayList<String>staff=null;

		try{
			result = Helper.find(sql);
			while(result.next()){
				if(result.getString("idNumber").charAt(3)=='0'){
				try {
					staff = (ArrayList<String>)IOObject.getArray(result.getBytes("staff"));

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				agency = new AgencyPO(result.getString("name"),result.getString("idNumber"),staff,result.getString("phoneNumber"),result.getString("address"),result.getString("leader"));
				agencys.add(agency);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return agencys;	}

}
