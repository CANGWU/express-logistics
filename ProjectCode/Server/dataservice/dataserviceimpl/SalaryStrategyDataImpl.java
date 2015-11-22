package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.SalaryStrategyDataService;
import enums.ResultMessage;
import po.SalaryPO;

public class SalaryStrategyDataImpl extends UnicastRemoteObject implements SalaryStrategyDataService {

	private SalaryStrategyDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<SalaryPO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage insert(SalaryPO po) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delect(SalaryPO po) {
		return null;
	}

	@Override
	public ResultMessage delect(String id) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage delect(ArrayList<String> ids) {
		
		
		return null;

	}

	@Override
	public ResultMessage update(SalaryPO po) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(ArrayList<SalaryPO> salarys) {
		return null;
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

}
