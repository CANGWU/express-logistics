package dataservice;

import po.LogisticsPO;

public interface CheckDataService {
	
           public LogisticsPO find(String ordernumber);
}
