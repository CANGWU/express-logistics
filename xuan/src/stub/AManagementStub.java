package stub;

import java.util.ArrayList;

import pamanagementslservice.AManagementService;
import vo.AgencyVO;
import vo.StaffVO;

public class AManagementStub implements AManagementService{

	@Override
	public AgencyVO select(String id) {
		// TODO Auto-generated method stub
		AgencyVO agency = new AgencyVO("鼓楼营业厅","020001",new ArrayList<StaffVO>(), "1371372278","南京鼓楼区xx大道63号",new StaffVO());
		return agency;
	}


	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		System.out.println("删除成功！！！");
	}

	@Override
	public void revise(String id) {
		// TODO Auto-generated method stub
		System.out.println("正在更改！！！");
	}

	@Override
	public void saveChange(AgencyVO vo) {
		// TODO Auto-generated method stub
		System.out.println("修改保存成功！！！");
		
	}

	@Override
	public void save(AgencyVO vo) {
		// TODO Auto-generated method stub
		System.out.println("新机构信息单保存成功！！！");
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("正在添加！！！");
		
	}

	@Override
	public void endAManagement() {
		// TODO Auto-generated method stub
		System.out.println("数据保存成功，正在结束机构管理！！！");
		
	}


	@Override
	public ArrayList<AgencyVO> getAllAgency() {
		// TODO Auto-generated method stub
		ArrayList<AgencyVO> agencys = new ArrayList<AgencyVO>();
		AgencyVO agency = new AgencyVO("鼓楼营业厅","020001",new ArrayList<StaffVO>(), "1371372278","南京鼓楼区xx大道63号",new StaffVO());
		agencys.add(agency);
		return agencys;
				
	}

}
