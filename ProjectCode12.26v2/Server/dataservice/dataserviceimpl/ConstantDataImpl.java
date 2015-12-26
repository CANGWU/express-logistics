package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataservice.ConstantDataService;
import enums.ResultMessage;
import link.Helper;
import po.ConstantPO;

public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService {

	private ConstantDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConstantPO find() {
		ResultSet result = null;
		String sql = "select*from constantpo;";
		ConstantPO po = null;
		
		try {
			result = Helper.find(sql);
			if(result.next())
			po = new ConstantPO(result.getDouble("lengthOfBN"),result.getDouble("lengthOfBS"),result.getDouble("lengthOfBG"),result.getDouble("lengthOfSG"),result.getDouble("lengthOfSN"),result.getDouble("lengthOfGN"),result.getDouble("lengthOfHall"),
					result.getDouble("priceOfCheapest"),result.getDouble("priceOfStandard"),result.getDouble("priceOfExpress"),
					result.getDouble("costOfCar"),result.getDouble("costOfTrain"),result.getDouble("costOfAir"),
					result.getDouble("priceOfCarton"),result.getDouble("priceOfWood"),result.getDouble("priceOfBag"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
				}

	@Override
	public ResultMessage insert(ConstantPO po) {
		// TODO Auto-generated method stub
		String sql = "insert into constantpo values("+po.getLengthOfBN()+","+po.getLengthOfBS()+","+po.getLengthOfBG()+","+po.getLengthOfSG()+","+po.getLengthOfSN()+","+po.getLengthOfGN()+","+po.getLengthOfHall()+","
				+po.getPriceOfCheapest()+","+po.getPriceOfStandard()+","+po.getPriceOfExpress()+","
				+po.getCostOfCar()+","+po.getCostOfTrain()+","+po.getCostOfAir()+","
		+po.getPriceOfCarton()+","+po.getPriceOfWood()+","+po.getPriceOfBag()+");";
	    return Helper.insert(sql);	
 
	}

	@Override
	public ResultMessage delete() {
		String sql = "delete from constantpo;";
		return Helper.delete(sql);
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(ConstantPO po) {
	    ResultMessage result = delete();
	    if(result==ResultMessage.FAIL)
	    	return result;
	    return insert(po);
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}  
	
	public static ConstantDataImpl create() throws RemoteException{
		if(constant == null){
			synchronized(ConstantDataImpl.class){
		
		if(constant == null)
		constant = new ConstantDataImpl();
			}
		}
			
		return constant;
	}
	
   private volatile static ConstantDataImpl constant;  
   
   

}
