package datastub;

import po.IoputPO;
import dataservice.IoputDataService;

public class IoputDataStub implements IoputDataService {
	
	IoputPO po1 = new IoputPO("1234567890","2015/10/26","10:30:00","上海","(1,2,3)",true);
	IoputPO po2 = new IoputPO("0123456789","2015/10/25","14:45:00","北京","(4,5,6)",true);

	@Override
	public IoputPO find(String id) {
		// TODO Auto-generated method stub
		System.out.print("find Succeed!\n");
		
		if(id.equals("1234567890"))
			return po1;
		else return null;
	}

	@Override
	public IoputPO[] finds(String[] ids) {
		// TODO Auto-generated method stub
		System.out.print("find Succeed!\n");
		
		IoputPO[] pos = {po1,po2};
		return pos;
	}

	@Override
	public IoputPO[] findDate(String date) {
		// TODO Auto-generated method stub
		System.out.print("find Succeed!\n");
			IoputPO[] pos = {po1};
			return pos;
	}

	@Override
	public IoputPO[] findDates(String[] date) {
		// TODO Auto-generated method stub
		System.out.print("find Succeed!\n");
		IoputPO[] pos = {po1,po2};
		return pos;
	}

	@Override
	public IoputPO[] findTimes(String[] time) {
		// TODO Auto-generated method stub
		System.out.print("find Succeed!\n");
		IoputPO[] pos = {po1,po2};
		return pos;
	}

	@Override
	public void insert(IoputPO PO) {
		// TODO Auto-generated method stub
		System.out.print("insert Succeed!\n");
		
	}

	@Override
	public void delete(IoputPO PO) {
		// TODO Auto-generated method stub
		System.out.print("delete Succeed!\n");
		
	}

	@Override
	public void update(IoputPO PO) {
		// TODO Auto-generated method stub
		System.out.print("update Succeed!\n");
	}

}
