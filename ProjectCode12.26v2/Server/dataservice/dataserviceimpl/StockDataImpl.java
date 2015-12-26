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
				po = new StockPO(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getInt(5),result.getString(6).equals("true")?true:false,result.getString(7),result.getString(8));
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
		String sql = "insert into stockpo values("+PO.getNum()+",'"+PO.getArea()+"',"+PO.getRow()+","+PO.getShelf()+","+PO.getSeat()+",'"+PO.isEmpty()+"','"+PO.getId()+"','"+PO.getInputdate()+"');";
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
	
	
	public static StockDataImpl create() throws RemoteException {
		if(stock == null){
			synchronized(StockDataImpl.class){

				if(stock == null)
					stock = new StockDataImpl();
			}
		}

		return stock;
	}

	private volatile static StockDataImpl stock;

	@Override
	public ArrayList<StockPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub

		String sql = "select* from stockpo;";
		ResultSet result = null;
		ArrayList<StockPO>stockPOs=new ArrayList<StockPO>();
		try{
			result = Helper.find(sql);
			while(result.next()){
				StockPO po = new StockPO(result.getInt(1),result.getString(2),result.getInt(3),result.getInt(4),result.getInt(5),result.getString(6).equals("true")?true:false,result.getString(7),result.getString(8));
				stockPOs.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return stockPOs;
	}

	@Override
	public ResultMessage clean() {
		// TODO Auto-generated method stub
	    String sql = "delete from stockpo;";
	    return Helper.delete(sql);
	}

}
