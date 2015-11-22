package dataservice;

import java.rmi.Remote;

import enums.ResultMessage;
import po.ConstantPO;

public interface ConstantDataService extends Remote{


	public ConstantPO find();
	public ResultMessage insert(ConstantPO po);
	public ResultMessage delect();
	public ResultMessage update(ConstantPO po);
	public void init();
	public void finish();

}
