package dataservice;

import java.rmi.Remote;


import po.ConstantPO;

public interface ConstantDataService extends Remote{


	public ConstantPO find();
	public void insert(ConstantPO po);
	public void delect();
	public void update(ConstantPO po);
	public void init();
	public void finish();

}
