package auditdataservice;

import java.util.ArrayList;

import po.DecumentPO;

public interface AuditDataService {
	
	public DecumentPO find(String id);
	public ArrayList<DecumentPO> find(String[] ids);
	public ArrayList<DecumentPO> findALl();
	public void insert(DecumentPO po);
	public void delect(DecumentPO po);
	public void delect(String id);
	public void update(DecumentPO po);
	public void update(ArrayList<DecumentPO> decuments);
	public void init();
	public void finish();
	

}
