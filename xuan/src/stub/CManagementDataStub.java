package stub;

import java.util.ArrayList;

import pamanagementdataservice.CManagementDataService;
import po.CarPO;

public class CManagementDataStub implements CManagementDataService{

	@Override
	public CarPO find(String id) {
		// TODO Auto-generated method stub
		return new CarPO("020001001","020001","2323u12u43u",10);
	}

	
	public ArrayList<CarPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<CarPO>cars = new ArrayList<CarPO>();
		cars.add(new CarPO("020001001","020001","2323u12u43u",10));
		return cars;
	}

	@Override
	public void insert(CarPO po) {
		// TODO Auto-generated method stub
		System.out.println("车辆信息单插入成功！！！");
		
	}

	@Override
	public void delect(CarPO po) {
		// TODO Auto-generated method stub
		System.out.println("车辆信息单删除成功！！！");
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("车辆信息单删除成功！！！");
	}

	@Override
	public void update(CarPO po) {
		// TODO Auto-generated method stub
		System.out.println("车辆信息更新成功！！！");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("信息初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("数据持久化成功，正在结束车辆信息管理！！！");
	}

}
