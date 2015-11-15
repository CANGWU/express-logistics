package dataservice;

import java.util.ArrayList;

import po.ConstantPO;

public interface ConstantDataService {


	public ConstantPO find();
	public void insert(ConstantPO po);
	public void delect();
	public void update(ConstantPO po);
	public void init();
	public void finish();

}
