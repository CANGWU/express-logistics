package mockcost;

import financeslservice.GetStrategy;

public class MockStrategyInfo implements GetStrategy{

	@Override
	public String getStrategy(String work) {
		// TODO Auto-generated method stub
		String strategy="3000";
		
		return strategy;
	}

}
