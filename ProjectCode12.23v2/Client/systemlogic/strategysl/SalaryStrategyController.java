package strategysl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import enums.ResultMessage;
import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategyController implements SalaryStrategyService{
	
	SalaryStrategy salarystrategy;

	public SalaryStrategyController(SalaryStrategy salarystrategy){
		this.salarystrategy=salarystrategy;
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

}
