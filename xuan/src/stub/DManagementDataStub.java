package stub;

import java.util.ArrayList;

import pamanagementdataservice.DManagementDataService;
import po.DriverPO;

public class DManagementDataStub implements DManagementDataService{

	@Override
	public DriverPO find(String id) {
		// TODO Auto-generated method stub
		return new DriverPO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10);
	}

	@Override
	public ArrayList<DriverPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<DriverPO>drivers = new ArrayList<DriverPO>();
		drivers.add(new DriverPO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", 
				"137137223728", "南京市栖霞区仙林大道162号", "男", 4000, 10));
		return drivers;
	}

	@Override
	public void insert(DriverPO po) {
		// TODO Auto-generated method stub
		System.out.println("司机信息单插入成功！！！");
	}

	@Override
	public void delect(DriverPO po) {
		// TODO Auto-generated method stub
		System.out.println("司机信息单删除成功！！！");
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("司机信息单删除成功！！！");
	}

	@Override
	public void update(DriverPO po) {
		// TODO Auto-generated method stub
		System.out.println("司机信息单更新成功！！！");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("数据持久化成功，正在结束司机信息管理！！！");
	}

}
