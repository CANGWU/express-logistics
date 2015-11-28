
package dataserviceimpl;

import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.TransportDataService;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import link.Helper;
import po.TransportPO;

public class TransportDataImpl implements TransportDataService {

	@Override
	public TransportPO find(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select* from transportpo where id='"+id+"';";
	    ArrayList<String> member = null;
	    ArrayList<String> order = null;
		ArrayList<Condition> condition = null;
		ResultSet result = null;
		TransportPO po =null;
		try{
			result = Helper.find(sql);
			if(result.next()){
				
				ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("member"));  
		        member = (ArrayList<String>)oips.readObject();
		        oips =  new ObjectInputStream(result.getBinaryStream("order"));
		        order = (ArrayList<String>)oips.readObject();
		        oips =  new ObjectInputStream(result.getBinaryStream("condition"));
		        condition = (ArrayList<Condition>)oips.readObject();
				po = new TransportPO(TransportType.valueOf(result.getString("sign")),result.getString("id"),Position.valueOf(result.getString("departure")),
						Position.valueOf(result.getString("destination")),result.getString("time"),
						Traffic.valueOf(result.getString("traffic")),
						result.getDouble("fare"),member,order,condition,DocumentCondition.valueOf(result.getString("DocumentCondition")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return po;
	}



	@Override
	public ResultMessage insert(TransportPO po){
		String sql = "insert into transportpo values('"+po.getSign()+"','"+po.getID()+"','"+po.getDeparture()+"','"+po.getDestination()+"','"+po.getTime()+"','"+po.getTraffic()+"',"+po.getfare()+"?,?,?,'"+po.getdCondition()+ "');";		// TODO Auto-generated method stub
		try {
			Helper.pStatement = Helper.conn.prepareStatement(sql);
			Helper.pStatement.setObject(7, po.getMember());
			Helper.pStatement.setObject(8, po.getOrder());
			Helper.pStatement.setObject(9, po.getCondition());
			Helper.pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}

		return ResultMessage.SUCCESS;   
	}

	@Override
	public ResultMessage delete(TransportPO po) throws Exception {
		String sql = "delete from transportpo where id='"+po.getID()+"';";
		// TODO Auto-generated method stub
         return Helper.delete(sql);
	}

	@Override
	public ResultMessage update(TransportPO po) throws Exception {
		ResultMessage result = delete(po);
	    if(result==ResultMessage.FAIL)
	    	return ResultMessage.FAIL;
	    return insert(po);
		// TODO Auto-generated method stub

	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() throws Exception {
		// TODO Auto-generated method stub

	}
	public static TransportDataImpl creat() throws RemoteException {
		if(transport == null){
			synchronized(TransportDataImpl.class){

				if(transport == null)
					transport = new TransportDataImpl();
			}
		}

		return transport;
	}

	private volatile static TransportDataImpl transport;

	@Override
	public ArrayList<TransportPO> finds(TransportType sign) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<TransportPO>pos = new ArrayList<TransportPO>();
		String sql = "select* from transportpo where sign='"+sign+"';";
	    ArrayList<String> member = null;
	    ArrayList<String> order = null;
		ArrayList<Condition> condition = null;
		ResultSet result = null;
		TransportPO po =null;
		try{
			result = Helper.find(sql);
			while(result.next()){
				
				ObjectInputStream oips = new ObjectInputStream(result.getBinaryStream("member"));  
		        member = (ArrayList<String>)oips.readObject();
		        oips =  new ObjectInputStream(result.getBinaryStream("order"));
		        order = (ArrayList<String>)oips.readObject();
		        oips =  new ObjectInputStream(result.getBinaryStream("condition"));
		        condition = (ArrayList<Condition>)oips.readObject();
				po = new TransportPO(TransportType.valueOf(result.getString("sign")),result.getString("id"),Position.valueOf(result.getString("departure")),
						Position.valueOf(result.getString("destination")),result.getString("time"),
						Traffic.valueOf(result.getString("traffic")),
						result.getDouble("fare"),member,order,condition,DocumentCondition.valueOf(result.getString("documentcondition")));
				pos.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pos;
	}

}
	
