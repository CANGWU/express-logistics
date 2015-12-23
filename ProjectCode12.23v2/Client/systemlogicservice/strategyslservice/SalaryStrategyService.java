package strategyslservice;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import enums.ResultMessage;
import vo.SalaryVO;

public interface SalaryStrategyService {
	
	public ArrayList<SalaryVO> getSalaryStrategy() throws RemoteException;
        public void endSalaryStrategy() throws RemoteException;
        public ResultMessage save(SalaryVO vo) throws RemoteException;
        public ResultMessage saveChange(SalaryVO vo) throws RemoteException;
	    public void newSalaryVO(); 
        public SalaryVO select(Work work) throws RemoteException;
        public void revise();
     
    
}
