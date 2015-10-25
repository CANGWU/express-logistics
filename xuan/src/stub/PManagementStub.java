package stub;

import java.util.ArrayList;

import pamanagementslservice.PManagementService;
import vo.StaffVO;

public class PManagementStub implements PManagementService{

	@Override
	public StaffVO select(String id) {
		// TODO Auto-generated method stub
		return new StaffVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "男", 4000);
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功！！！");
	}

	@Override
	public void revise(String id) {
		// TODO Auto-generated method stub
		System.out.println("正在修改！！！");
	}

	@Override
	public void saveChange(StaffVO vo) {
		// TODO Auto-generated method stub
		System.out.println("修改保存成功！！！");
	}

	@Override
	public void save(StaffVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新的人员信息单保存成功！！！");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("正在添加！！！");
	}

	@Override
	public void endPManagement() {
		// TODO Auto-generated method stub
		System.out.println("数据更新成功，正在结束人员管理！！！");
	}

	@Override
	public ArrayList<StaffVO> getAllStaff() {
		// TODO Auto-generated method stub
		ArrayList<StaffVO>staff = new ArrayList<StaffVO>();
		staff.add(new StaffVO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "男", 4000));
		return staff;
	}

}
