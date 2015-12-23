package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

import dataservice.SalaryStrategyDataService;
import enums.ResultMessage;
import enums.Work;
import link.Helper;
import po.SalaryPO;

public class SalaryStrategyDataImpl extends UnicastRemoteObject implements SalaryStrategyDataService {

	private SalaryStrategyDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<SalaryPO> findAll() {
		// TODO Auto-generated method stub
		String sql = "select*from salarypo;";
		ArrayList<SalaryPO>salarys = new ArrayList<SalaryPO>();
		SalaryPO po = null;
		ResultSet result = null;
		try{
			result = Helper.find(sql);
			while(result.next()){
				po =  new SalaryPO(result.getDouble("basewage"),result.getDouble("allowance"),result.getDouble("commission"),Work.valueOf(result.getString("work")));
				salarys.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return salarys;
	}

	@Override
	public ResultMessage insert(SalaryPO po) {
		String sql = "insert into salarypo values("+po.getBaseWage()+","+po.getAllowance()+","+po.getCommission()+",'"+po.getWork()+"');";
		return Helper.insert(sql);
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delete(SalaryPO po) {
		return delete(po.getWork());
	}

	@Override
	public ResultMessage delete(Work work) {
		// TODO Auto-generated method stub
       String sql = "delete from salarypo where work='"+work+"';";
    		 return Helper.delete(sql);
	}



	@Override
	public ResultMessage update(SalaryPO po) {
		ResultMessage result = delete(po);
	    if(result==ResultMessage.FAIL)
	    	return result;
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
	  public static SalaryStrategyDataImpl create() throws RemoteException{
			if(salary == null){
				synchronized(SalaryStrategyDataImpl.class){
			
			if(salary == null)
			salary = new SalaryStrategyDataImpl();
				}
			}
				
			return salary;
		}
		
	   private volatile static SalaryStrategyDataImpl salary;



	@Override
	public SalaryPO find(Work work) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "select*from salarypo where work='"+work+"';";
		ResultSet result = null;
		SalaryPO po = null;
				try{
					result= Helper.find(sql);
					if(result.next())
						po = new SalaryPO(result.getDouble("basewage"),result.getDouble("allowance"),result.getDouble("commission"),Work.valueOf(result.getString("work")));
					
				}catch(Exception e){
					e.printStackTrace();
				}
		return po;
	}  

}
