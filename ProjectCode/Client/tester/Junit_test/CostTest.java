package Junit_test;

import static org.junit.Assert.*;

import org.junit.Test;

import financesl.Cost;
import mockcost.MockStrategyInfo;

public class CostTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		MockStrategyInfo strategyinfo=new MockStrategyInfo();
		String strategy=strategyinfo.getStrategy("¿ìµÝÔ±");
		Cost cost=new Cost();
		cost.computePayment(null);
		assertEquals(cost.getStrategy(null),"");
		assertEquals(strategy,"3000");

	}

}
