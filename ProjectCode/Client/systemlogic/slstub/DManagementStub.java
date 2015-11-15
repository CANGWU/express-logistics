package slstub;

import java.util.ArrayList;

import pamanagementslservice.DManagementService;
import vo.DriverVO;

public class DManagementStub implements DManagementService{

	@Override
	public DriverVO select(String id) {
		// TODO Auto-generated method stub
		return new DriverVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162�?", "�?", 4000, 10);
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功！！�?");
	}

	@Override
	public DriverVO revise(String id) {
		// TODO Auto-generated method stub
		System.out.println("正在修改！！�?");
		return new DriverVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162�?", "�?", 4000, 10);
	}

	@Override
	public void saveChange(DriverVO vo) {
		// TODO Auto-generated method stub
		System.out.println("修改保存成功！！�?");
	}

	@Override
	public void save(DriverVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新的司机信息单保存成功！！！");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("正在添加！！�?");
	}

	@Override
	public void endDManagement() {
		// TODO Auto-generated method stub
		System.out.println("数据更新成功，正在结束司机信息管理！！！");
	}

	@Override
	public ArrayList<DriverVO> getAllDriver() {
		// TODO Auto-generated method stub
		ArrayList <DriverVO> drivers = new ArrayList<DriverVO>();
		drivers.add(new DriverVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162�?", "�?", 4000, 10));
		return drivers;
	}

}
