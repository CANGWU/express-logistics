package ioputsl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.IoputPO;
import dataservice.DataFactoryService;
import enums.Ioput;

public class IoputCal implements IoputCalculation {
	
	DataFactoryService Data;
	
	int InNum;
	int OutNum;
	
	public IoputCal(DataFactoryService d){
		Data = d;
	}
	
	private void getIoputs(String[] time){
		
		ArrayList<IoputPO> All = null;

		try {
			All = Data.getIoputData().findTimes(time);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InNum = 0;
		OutNum = 0;
		if(All !=null){
			for(int i =0;i<All.size();i++){
				if(All.get(i).getIoput() == Ioput.in)
					InNum++;
				if(All.get(i).getIoput() == Ioput.out )
					OutNum++;
			}
		}
		
	}

	@Override
	public int getInputs(String[] time) {
		// TODO Auto-generated method stub
		this.getIoputs(time);
		
		return InNum;
	}

	@Override
	public int getOutputs(String[] time) {
		// TODO Auto-generated method stub
		this.getIoputs(time);
		
		return OutNum;
	}


}
