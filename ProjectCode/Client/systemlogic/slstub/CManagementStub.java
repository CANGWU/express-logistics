package slstub;

import java.util.ArrayList;

import pamanagementslservice.CManagementService;
import vo.CarVO;

public class CManagementStub implements CManagementService{

	@Override
	public CarVO select(String id) {
		// TODO Auto-generated method stub
		CarVO car = new CarVO("020001001","020001","2323u12u43u",10);
		return car;
	}


	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功！！�?");
	}

	@Override
	public CarVO revise(String id) {
		// TODO Auto-generated method stub
		System.out.println("正在修改！！�?");
		return new CarVO("020001001","020001","2323u12u43u",10);
	}

	@Override
	public void saveChange(CarVO vo) {
		// TODO Auto-generated method stub
		System.out.println("修改保存成功！！�?");
	}

	@Override
	public void save(CarVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新的车辆信息单保存成功！！！");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("正在添加！！�?");
	}

	@Override
	public void endCManagement() {
		// TODO Auto-generated method stub
		System.out.println("数据更新成功，正在结束车辆信息管理！！！");
	}


	@Override
	public ArrayList<CarVO> getAllCar() {
		// TODO Auto-generated method stub
		ArrayList<CarVO>cars = new ArrayList<CarVO>();
		CarVO car = new CarVO("020001001","020001","2323u12u43u",10);
		cars.add(car);
		return cars;
	}

}
