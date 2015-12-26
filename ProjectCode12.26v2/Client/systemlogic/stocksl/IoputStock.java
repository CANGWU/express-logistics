package stocksl;

import enums.ResultMessage;
import enums.WarningMessage;

public interface IoputStock {
	public ResultMessage Input(int row,int shelf,int seat,String id,String date);
	public ResultMessage Output(int row,int shelf,int seat);
	public WarningMessage StockSafe();
	

}
