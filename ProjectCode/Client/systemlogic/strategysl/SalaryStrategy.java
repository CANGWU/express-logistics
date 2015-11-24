package strategysl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import po.SalaryPO;
import dataservice.DataFactoryService;
import dataservice.SalaryStrategyDataService;
import strategyslservice.SalaryStrategyService;
import vo.SalaryVO;

public class SalaryStrategy {
	DataFactoryService datafactory;
	SalaryStrategyDataService salarystrategyData;
	
	public SalaryStrategy(DataFactoryService datafactory){
		this.datafactory=datafactory;
		salarystrategyData=datafactory.getSalaryStrategyData();
	}
	
	public ArrayList<SalaryVO> getSalaryStrategy() throws RemoteException {
		ArrayList<SalaryPO> salarypolist=salarystrategyData.findAll();
		ArrayList<SalaryVO> salaryvolist=new ArrayList<SalaryVO>();
		SalaryVO vo;
		SalaryPO po;
		for(int i=0;i<salarypolist.size();i++){
			po=salarypolist.get(i);
			vo=new SalaryVO(po.getBaseWage(),po.getAllowance(),po.getCommission(),po.getWork());
			salaryvolist.add(vo);
		}
		return salaryvolist;
	}

	public void endSalaryStrategy() throws RemoteException {
		salarystrategyData.finish();
	}

	public void save(SalaryVO vo) throws RemoteException {
		SalaryPO po=new SalaryPO(vo.getBaseWage(),vo.getAllowance(),vo.getCommission(),vo.getWork());
		salarystrategyData.insert(po);
	}

	public void saveChange(SalaryVO vo) throws RemoteException {
		SalaryPO po=new SalaryPO(vo.getBaseWage(),vo.getAllowance(),vo.getCommission(),vo.getWork());
		salarystrategyData.update(po);
	}

	public void newSalaryVO() {

	}

	public SalaryVO select(Work work) throws RemoteException {
		ArrayList<SalaryPO> salarypolist=salarystrategyData.findAll();
		SalaryPO po=new SalaryPO();
		for(int i=0;i<salarypolist.size();i++){
			po=salarypolist.get(i);
			if(po.getWork().equals(work))
				break;
		}
		SalaryVO vo=new SalaryVO(po.getBaseWage(),po.getAllowance(),po.getCommission(),po.getWork());
		return vo;
	}

	public void revise() {

		
	}
}
