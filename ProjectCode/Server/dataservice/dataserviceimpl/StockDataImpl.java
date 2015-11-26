package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import dataservice.StockDataService;
import enums.ResultMessage;
import link.Helper;
import po.StockPO;

public class StockDataImpl extends UnicastRemoteObject implements StockDataService {

	private StockDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public StockPO findposition(int row, int shelf, int seat) {
		// TODO Auto-generated method stub
		String sql = "select* from stockpo where row="+row+" and shelf="+shelf+" and seat="+seat+";";
		ResultSet result = null;
		StockPO po = null;
		try{
			result = Helper.find(sql);
			if(result.next()){
				po = new StockPO(result.getInt(0),result.getString(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getString(5).equals("true")?true:false,result.getString(6),result.getString(7));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return po;
	}

	@Override
	public ArrayList<StockPO> findpositions(int[][] positions) {
		// TODO Auto-generated method stub
		ArrayList<StockPO> pos = new ArrayList<StockPO>();
		StockPO po = null;
		for(int i=0;i<positions.length;i++){
			po = findposition(positions[i][0],positions[i][1],positions[i][3]);
			pos.add(po);
		}
		return pos;
	}

	@Override
	public ResultMessage insert(StockPO PO) {
		String sql = "insert into stockpo values("+PO.getNum()+",'"+PO.getArea()+"',"+PO.getRow()+","+PO.getShelf()+","+PO.getSeat()+",'"+PO.isEmpty()+"','"+PO.getID()+"','"+PO.getInputDate()+"');";
		return Helper.insert(sql);
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delete(StockPO PO) {
		String sql = "delete from stockpo where row="+PO.getRow()+" and shelf="+PO.getShelf()+" and seat="+PO.getSeat()+";";
		// TODO Auto-generated method stub
				return Helper.delete(sql);

	}

	@Override
	public ResultMessage update(StockPO PO) {
		
		// TODO Auto-generated method stub
		ResultMessage result = delete(PO);
	    if(result==ResultMessage.FAIL)
	    	return result;
	    return insert(PO);
	}
	public static StockDataImpl creat() throws RemoteException {
		if(stock == null){
			synchronized(StockDataImpl.class){
		
		if(stock == null)
		stock = new StockDataImpl();
			}
		}
			
		return stock;
	}
	
   private volatile static StockDataImpl stock;

}
