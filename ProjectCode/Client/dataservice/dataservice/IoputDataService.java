package dataservice;

import java.rmi.Remote;

import enums.ResultMessage;
import po.*;

public interface IoputDataService extends Remote{
	
	public IoputPO find(String id);
	public IoputPO[] finds(String[]ids);
	public IoputPO[] findDate(String date);
	public IoputPO[] findDates(String[] date);
	public IoputPO[] findTimes(String[] time);
	public ResultMessage insert(IoputPO PO);
	public ResultMessage delete(IoputPO PO);
	public ResultMessage update(IoputPO PO);


}
