package stub;

import java.util.ArrayList;

import pamanagementdataservice.AManagementDataService;
import po.AgencyPO;
import po.StaffPO;

public class AManagementDataStub implements AManagementDataService{

	@Override
	public AgencyPO find(String id) {
		// TODO Auto-generated method stub
		return new AgencyPO("鼓楼营业厅","020001",new ArrayList<StaffPO>(), 
				"1371372278","南京鼓楼区xx大道63号",new StaffPO());
	}

	@Override
	public void insert(AgencyPO po) {
		// TODO Auto-generated method stub
		System.out.println("机构信息单插入成功！！！");
	}

	@Override
	public void delect(AgencyPO po) {
		// TODO Auto-generated method stub
		System.out.println("机构信息单删除成功！！！");
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("机构信息单删除成功！！！");
	}

	@Override
	public void update(AgencyPO po) {
		// TODO Auto-generated method stub
		System.out.println("机构信息单更新成功！！！");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("机构信息持久化成功，结束机构管理！！！");
	}

	@Override
	public ArrayList<AgencyPO> findAll() {
		// TODO Auto-generated method stub
		ArrayList<AgencyPO> agencys = new ArrayList<AgencyPO>();
		agencys.add(new AgencyPO("鼓楼营业厅","020001",new ArrayList<StaffPO>(), 
				"1371372278","南京鼓楼区xx大道63号",new StaffPO()));
		return agencys;
	}


}
