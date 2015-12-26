package strategysl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.SalaryPO;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import dataserviceimpl.DataFactory;
import enums.ResultMessage;
import financesl.GetSingleStrategy;
import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategyController implements SalaryStrategyService,GetSingleStrategy{
	
	SalaryStrategy salarystrategy;

	public SalaryStrategyController(){
		try {
			this.salarystrategy=new SalaryStrategy(DataFactory.create());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<SalaryVO> getSalaryStrategy() throws RemoteException {
		return salarystrategy.getSalaryStrategy();
	}

	@Override
	public void endSalaryStrategy() throws RemoteException {
		salarystrategy.endSalaryStrategy();
	}

	@Override
	public ResultMessage save(SalaryVO vo) throws RemoteException {
		return salarystrategy.save(vo);
	}

	@Override
	public ResultMessage saveChange(SalaryVO vo) throws RemoteException {
		return salarystrategy.saveChange(vo);
	}

	@Override
	public void newSalaryVO() {
		salarystrategy.newSalaryVO();
	}

	@Override
	public SalaryVO select(Work work) throws RemoteException {
		return salarystrategy.select(work);
	}

	@Override
	public void revise() {
		salarystrategy.revise();
	}

	@Override
	public SalaryPO getSingleSalaryStrategy(enums.Work work) {
		// TODO Auto-generated method stub
		return salarystrategy.getSingleSalaryStrategy(work);
	}

}
