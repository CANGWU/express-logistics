package strategysl;

import po.ConstantPO;

import java.rmi.RemoteException;

import dataservice.ConstantDataService;
import dataservice.DataFactoryService;
import dataserviceimpl.DataFactory;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import vo.ConstantVO;

public class Constant {
	DataFactoryService datafactory;
	ConstantDataService constantData;

	public Constant() {
		try {
			this.datafactory = DataFactory.create();
			this.constantData = datafactory.getConstantData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ConstantVO getConstant() {
		ConstantPO po=null;
		try {
			po = constantData.find();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConstantVO vo = new ConstantVO(po.getLengthOfBN(), po.getLengthOfBS(),
				po.getLengthOfBG(), po.getLengthOfSG(), po.getLengthOfSN(),
				po.getLengthOfGN(), po.getLengthOfHall(),
				po.getPriceOfCheapest(), po.getPriceOfStandard(),
				po.getPriceOfExpress(), po.getCostOfCar(), po.getCostOfTrain(),
				po.getCostOfAir(), po.getPriceOfCarton(), po.getPriceOfWood(),
				po.getPriceOfBag());
		return vo;
	}

	public void newConstant() {

	}

	public ResultMessage save(ConstantVO vo) {
		ConstantPO po = new ConstantPO(vo.getLengthOfBN(), vo.getLengthOfBS(),
				vo.getLengthOfBG(), vo.getLengthOfSG(), vo.getLengthOfSN(),
				vo.getLengthOfGN(), vo.getLengthOfHall(),
				vo.getPriceOfCheapest(), vo.getPriceOfStandard(),
				vo.getPriceOfExpress(), vo.getCostOfCar(), vo.getCostOfTrain(),
				vo.getCostOfAir(), vo.getPriceOfCarton(), vo.getPriceOfWood(),
				vo.getPriceOfBag());
		try {
			return constantData.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public void endConstant() {
		try {
			constantData.finish();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getFare(Position departure, Position destination,
			Traffic trafficType) {
		ConstantPO constantpo=null;
		try {
			constantpo = constantData.find();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double cost = 0;
		switch (trafficType) {
		case Air:
			cost = constantpo.getCostOfAir();
			break;
		case Train:
			cost = constantpo.getCostOfTrain();
			break;
		case Car:
			cost = constantpo.getCostOfCar();
			break;
		}
		double length = 0;
		if (departure.equals(destination))
			length = constantpo.getLengthOfHall();
		else {
			if ((departure.equals(Position.Beijing) & destination
					.equals(Position.Nanjing))
					|| (departure.equals(Position.Nanjing) & destination
							.equals(Position.Beijing)))
				length = constantpo.getLengthOfBN();
			else if ((departure.equals(Position.Beijing) & destination
					.equals(Position.Guangzhou))
					|| (departure.equals(Position.Guangzhou) & destination
							.equals(Position.Beijing)))
				length = constantpo.getLengthOfBG();
			else if ((departure.equals(Position.Beijing) & destination
					.equals(Position.Shanghai))
					|| (departure.equals(Position.Shanghai) & destination
							.equals(Position.Beijing)))
				length = constantpo.getLengthOfBS();
			else if ((departure.equals(Position.Shanghai) & destination
					.equals(Position.Nanjing))
					|| (departure.equals(Position.Nanjing) & destination
							.equals(Position.Shanghai)))
				length = constantpo.getLengthOfSN();
			else if ((departure.equals(Position.Shanghai) & destination
					.equals(Position.Guangzhou))
					|| (departure.equals(Position.Guangzhou) & destination
							.equals(Position.Shanghai)))
				length = constantpo.getLengthOfSG();
			else if ((departure.equals(Position.Guangzhou) & destination
					.equals(Position.Nanjing))
					|| (departure.equals(Position.Nanjing) & destination
							.equals(Position.Guangzhou)))
				length = constantpo.getLengthOfGN();
		}
		return length * cost;
	}
}
