package stub;

import po.ConstantPO;
import strategydataservice.ConstantDataService;

public class ConstantDataStub implements ConstantDataService{

	@Override
	public ConstantPO find() {
		// TODO Auto-generated method stub
		return new ConstantPO(3423,342,4234,324,3432,343,30,5,10,15,5,3,10,10,5,1);
	}

	@Override
	public void insert(ConstantPO po) {
		// TODO Auto-generated method stub
		System.out.println("常量插入成功！！！");
	}

	@Override
	public void delect() {
		// TODO Auto-generated method stub
		System.out.println("常量表删除成功！！！");
	}



	@Override
	public void update(ConstantPO po) {
		// TODO Auto-generated method stub
		System.out.println("常量表更新成功！！！");
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("数据初始化成功！！！");
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("数据持久化成功，正在结束制定常量！！！");
	}

}
