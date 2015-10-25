package stub;

import java.util.ArrayList;

import pamanagementdataservice.PManagementDataService;
import po.StaffPO;
import vo.StaffVO;

public class PManagementDataStub implements PManagementDataService{

	@Override
	public StaffPO find(String id) {
		// TODO Auto-generated method stub
		return new StaffPO("张三", "司机", "020001003", "020001", "1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "男", 4000);
	}

	@Override
	public ArrayList<StaffPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<StaffPO>staff = new ArrayList<StaffPO>();
		staff.add(new StaffPO("张三", "司机", "020001003", "020001", 
				"1980/2/2", "23712314843724", "137137223728", "南京市栖霞区仙林大道162号", "男", 4000));
		return staff;
	}

	@Override
	public void insert(StaffPO po) {
		// TODO Auto-generated method stub
		System.out.println("人员信息单插入成功！！！");
	}

	@Override
	public void delect(StaffPO po) {
		// TODO Auto-generated method stub
	   System.out.println("人员信息单删除成功！！！");	
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("人员信息单删除成功！！！");	
	}

	@Override
	public void update(StaffPO po) {
		// TODO Auto-generated method stub
		System.out.println("人员信息单更新成功！！！");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("数据持久化成功，正在结束人员管理！！！");
	}

}
