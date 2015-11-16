package audittest;

import usersl.Log;
import mocklog.MockLogInfo;

public class LogTest {
	public void test(){
		MockLogInfo loginfo=new MockLogInfo();
		loginfo.createLog("张三，快递员，鼓楼营业厅，订单输入，2015/11/11");
		
	}

}
