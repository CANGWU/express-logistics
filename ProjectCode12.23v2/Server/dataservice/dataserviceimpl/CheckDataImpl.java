package dataserviceimpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sun.org.apache.regexp.internal.RESyntaxException;

import dataservice.CheckDataService;
import enums.Condition;
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
		ArrayList<String> logistics=null;
		ResultSet result = null;
		try{
			result = Helper.find(sql);
			if (result.next()) {
				try {
					logistics = (ArrayList<String>)IOObject.getArray(result.getBytes("logisticsMessage"));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			//ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("logisticsMessage"));  
			//logistics = (ArrayList<String>)oips.readObject();
			po = new LogisticsPO(result.getString("orderNumber"));
			po.setLogisticsMessage(logistics);
		}
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
