package dataserviceimpl;

import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import dataservice.CheckDataService;
import link.Helper;
import po.LogisticsPO;

public class CheckDataImpl  extends UnicastRemoteObject implements CheckDataService {

	private CheckDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public LogisticsPO find(String orderNumber) {
		// TODO Auto-generated method stub
		String sql = "select*from logisticspo where orderNumber='"+orderNumber+"';";
		LogisticsPO po = null;
		ResultSet result = null;
		try{
			result = Helper.find(sql);
			ArrayList<String> logistics = new ArrayList<String>();
			ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("logisticsMessage"));  
			logistics = (ArrayList<String>)oips.readObject();
			po = new LogisticsPO(result.getString("orderNumber"),logistics);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		return po;
	}
	
	
	
	
	public static CheckDataImpl create() throws RemoteException{
		if(check == null){
			synchronized(CheckDataImpl.class){
		
		if(check == null)
		check = new CheckDataImpl();
			}
		}
			
		return check;
	}
	
   private volatile static CheckDataImpl check;
}
