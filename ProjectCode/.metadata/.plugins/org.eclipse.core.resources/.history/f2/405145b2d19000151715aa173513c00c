package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.SalaryStrategyDataService;
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
	public void insert(SalaryPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect(SalaryPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delect(ArrayList<SalaryPO> salarys) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(SalaryPO po) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ArrayList<SalaryPO> salarys) {
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
