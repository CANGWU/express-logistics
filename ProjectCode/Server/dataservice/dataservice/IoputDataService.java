package dataservice;

import po.*;

public interface IoputDataService {
	
	public IoputPO find(String id);
	public IoputPO[] finds(String[]ids);
	public IoputPO[] findDate(String date);
	public IoputPO[] findDates(String[] date);
	public IoputPO[] findTimes(String[] time);
	public void insert(IoputPO PO);
	public void delete(IoputPO PO);
	public void update(IoputPO PO);


}
