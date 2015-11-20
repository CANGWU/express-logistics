package Junit_test;

import org.junit.Test;

import usersl.Log;
import usersl.LogList;
import mocklog.MockLogInfo;

public class LogListTest {




	@Test
	public void testCreateLog() {
		MockLogInfo info=new MockLogInfo();
		info.createLog("张三，管理员，日志管理，2015/11/11");
	}
}
