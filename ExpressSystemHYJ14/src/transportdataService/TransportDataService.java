package transportdataService;

import java.util.ArrayList;

import po.TransportPO;

public interface TransportDataService {
	public TransportPO find(String id) throws Exception;
	public ArrayList<TransportPO> finds(String fields,String id) throws Exception;
	public void insert(TransportPO po) throws Exception;
	public void delete(TransportPO po) throws Exception;
	public void update(TransportPO po) throws Exception;
	public void init() throws Exception;
	public void finish() throws Exception;
}
