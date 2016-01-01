package transportsl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.DeliverPO;
import po.TransportPO;
import dataservice.DataFactoryService;
import dataservice.TransportDataService;
import enums.Condition;
import enums.DocumentCondition;
import enums.Position;
import enums.ResultMessage;
import enums.Traffic;
import enums.TransportType;
import vo.DeliverVO;
import vo.TransportVO;

public class Transport {
	DataFactoryService datafactory;
	TransportDataService transportData;
	ConstantInfo constantinfo;

	public Transport(DataFactoryService datafactory, ConstantInfo constantinfo) {
		this.constantinfo = constantinfo;
		this.datafactory = datafactory;
		try {
			this.transportData = datafactory.getTransportDate();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TransportVO newTransport(TransportType sign, String id,
			String departure, String destination, String transportID,
			String time, String trafficID, Traffic trafficType, double fare,
			ArrayList<String> member, ArrayList<String> order,
			ArrayList<Condition> condition,
			DocumentCondition documentCondition, String nameOfWriter) {
		TransportVO vo = new TransportVO(sign, id, departure, destination,
				transportID, time, trafficID, trafficType, fare, member, order,
				condition, documentCondition, nameOfWriter);
		return vo;
	}

	public TransportVO getTransport(String Transportid) throws Exception {
		TransportPO po = transportData.find(Transportid);
		TransportVO vo = new TransportVO(po.getSign(), po.getID(),
				po.getDeparture(), po.getDestination(), po.getTransportID(),
				po.getTime(), po.getTrafficID(), po.getTrafficType(),
				po.getfare(), po.getMember(), po.getOrder(), po.getCondition(),
				po.getDocumentCondition(), po.getWriter());
		return vo;
	}

	public ArrayList<TransportVO> getTransportList(String nameOfWriter,
			DocumentCondition dCondition) throws Exception {
		ArrayList<TransportVO> voList = new ArrayList<TransportVO>();
		TransportPO po;
		TransportVO vo;

		ArrayList<TransportPO> poList = transportData.findWithdCondition(
				nameOfWriter, dCondition);
		for (Iterator<TransportPO> i = poList.iterator(); i.hasNext();) {
			po = (TransportPO) i.next();
			vo = new TransportVO(po.getSign(), po.getID(), po.getDeparture(),
					po.getDestination(), po.getTransportID(), po.getTime(),
					po.getTrafficID(), po.getTrafficType(), po.getfare(),
					po.getMember(), po.getOrder(), po.getCondition(),
					po.getDocumentCondition(), po.getWriter());
			voList.add(vo);
		}
		return voList;
	}

	public double addFare(TransportVO transportvo) {
		Position departure = Position.Nanjing;
		Position destination = Position.Nanjing;

		switch (transportvo.getDeparture().substring(0, 3)) {
		case "010":
			departure = Position.Beijing;
			break;
		case "021":
			departure = Position.Shanghai;
			break;
		case "025":
			departure = Position.Nanjing;
			break;
		case "020":
			departure = Position.Guangzhou;
			break;
		}
		switch (transportvo.getDestination().substring(0, 3)) {
		case "010":
			destination = Position.Beijing;
			break;
		case "021":
			destination = Position.Shanghai;
			break;
		case "025":
			destination = Position.Nanjing;
			break;
		case "020":
			destination = Position.Guangzhou;
			break;
		}

		double fare = constantinfo.getFare(departure, destination,
				transportvo.getTrafficType());
		transportvo.setFare(fare);
		return fare;
	}

	public ResultMessage saveTransport(TransportVO transportvo)
			throws Exception {
		TransportPO po = new TransportPO(transportvo.getSign(),
				transportvo.getID(), transportvo.getDeparture(),
				transportvo.getDestination(), transportvo.getTransportID(),
				transportvo.getTime(), transportvo.getTrafficID(),
				transportvo.getTrafficType(), transportvo.getfare(),
				transportvo.getMember(), transportvo.getOrder(),
				transportvo.getCondition(), transportvo.getDocumentCondition(),
				transportvo.getWriter());
		return transportData.insert(po);
	}

	public ResultMessage deleteTransport(String Transportid) throws Exception {
		TransportPO po = transportData.find(Transportid);
		return transportData.delete(po);
	}

	public ResultMessage updateTransport(TransportVO transportvo)
			throws Exception {
		TransportPO po = new TransportPO(transportvo.getSign(),
				transportvo.getID(), transportvo.getDeparture(),
				transportvo.getDestination(), transportvo.getTransportID(),
				transportvo.getTime(), transportvo.getTrafficID(),
				transportvo.getTrafficType(), transportvo.getfare(),
				transportvo.getMember(), transportvo.getOrder(),
				transportvo.getCondition(), transportvo.getDocumentCondition(),
				transportvo.getWriter());
		return transportData.update(po);
	}

	public void printTransport(String id) {

	}

	public void endTransport() throws Exception {
		transportData.finish();
	}

	public ArrayList<TransportVO> getAuditInfo() {
		ArrayList<TransportVO> volist = new ArrayList<TransportVO>();
		ArrayList<TransportPO> polist;
		TransportPO po;
		try {
			polist = transportData.findAudit();
			for (Iterator<TransportPO> i = polist.iterator(); i.hasNext();) {
				po = i.next();
				volist.add(new TransportVO(po.getSign(), po.getID(), po
						.getDeparture(), po.getDestination(), po
						.getTransportID(), po.getTime(), po.getTrafficID(), po
						.getTrafficType(), po.getfare(), po.getMember(), po
						.getOrder(), po.getCondition(), po
						.getDocumentCondition(), po.getWriter()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return volist;
	}

	public ResultMessage EndAudit(ArrayList list) {
		TransportVO vo;
		TransportPO po;
		for (Iterator<TransportVO> i = list.iterator(); i.hasNext();) {
			vo = i.next();
			po = new TransportPO(vo.getSign(), vo.getID(), vo.getDeparture(),
					vo.getDestination(), vo.getTransportID(), vo.getTime(),
					vo.getTrafficID(), vo.getTrafficType(), vo.getfare(),
					vo.getMember(), vo.getOrder(), vo.getCondition(),
					vo.getDocumentCondition(), vo.getWriter());
			try {
				transportData.update(po);
			} catch (Exception ex) {
				return ResultMessage.FAIL;
			}
		}
		return ResultMessage.SUCCESS;
	}
}
