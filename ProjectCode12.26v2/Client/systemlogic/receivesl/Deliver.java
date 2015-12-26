package receivesl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import auditsl.AuditInfo;
import po.DeliverPO;
import dataservice.DataFactoryService;
import dataservice.ReceiveDataService;
import dataserviceimpl.DataFactory;
import enums.DocumentCondition;
import enums.ResultMessage;
import receiveslservice.DeliverService;
import vo.DeliverVO;

public class Deliver implements DeliverService, AuditInfo {

	DataFactoryService dataFactory;
	ReceiveDataService receiveData;

	public Deliver() {
		try {
			this.dataFactory = DataFactory.create();
			this.receiveData = dataFactory.getReceiveData();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public DeliverVO newDeliver(String id, String nameOfWriter, String time,
			ArrayList<String> member, ArrayList<String> order,
			DeliverVO delivervo) {
		delivervo.setID(id);
		delivervo.setWriter(nameOfWriter);
		delivervo.setTime(time);
		delivervo.setMember(member);
		delivervo.setOrder(order);
		delivervo.setDocumentCondition(DocumentCondition.handing);
		return delivervo;
	}

	@Override
	public ArrayList<DeliverVO> findDWithdCondition(String nameOfWriter,
			DocumentCondition dCondition) throws Exception {
		ArrayList<DeliverVO> voList = new ArrayList<DeliverVO>();
		DeliverPO deliverpo;
		ArrayList<DeliverPO> poList = receiveData.findDWithdCondition(
				nameOfWriter, dCondition);
		for (Iterator<DeliverPO> i = poList.iterator(); i.hasNext();) {
			deliverpo = i.next();
			voList.add(new DeliverVO(deliverpo.getID(), deliverpo.getWriter(),
					deliverpo.getTime(), deliverpo.getMember(), deliverpo
							.getOrder(), deliverpo.getDocumentCondition()));
		}
		return voList;
	}

	@Override
	public DeliverVO getDeliver(String deliverNumber) throws Exception {
		DeliverPO deliverpo = receiveData.findD(deliverNumber);
		DeliverVO delivervo = new DeliverVO(deliverpo.getID(),
				deliverpo.getWriter(), deliverpo.getTime(),
				deliverpo.getMember(), deliverpo.getOrder(),
				deliverpo.getDocumentCondition());
		return delivervo;
	}

	@Override
	public ResultMessage updateDeliver(DeliverVO delivervo) throws Exception {
		DeliverPO deliverpo = new DeliverPO(delivervo.getID(),
				delivervo.getWriter(), delivervo.getTime(),
				delivervo.getMember(), delivervo.getOrder(),
				delivervo.getDocumentCondition());
		return receiveData.updateD(deliverpo);
	}

	@Override
	public ResultMessage deleteDeliver(String id) throws Exception {
		return receiveData.deleteD(id);
	}

	@Override
	public ResultMessage saveDeliver(DeliverVO delivervo) throws Exception {
		DeliverPO deliverpo = new DeliverPO(delivervo.getID(),
				delivervo.getWriter(), delivervo.getTime(),
				delivervo.getMember(), delivervo.getOrder(),
				delivervo.getDocumentCondition());
		return receiveData.insertD(deliverpo);

	}

	@Override
	public void printDeliver(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void endDeliver() throws Exception {
		receiveData.finish();
	}

	@Override
	public ArrayList getAuditInfo() {
		ArrayList<DeliverVO> volist = new ArrayList<DeliverVO>();
		ArrayList<DeliverPO> polist;
		DeliverPO po;
		try {
			polist = receiveData.findAudit();
			for (Iterator<DeliverPO> i = polist.iterator(); i.hasNext();) {
				po = i.next();
				volist.add(new DeliverVO(po.getID(), po.getWriter(), po
						.getTime(), po.getMember(), po.getOrder(), po
						.getDocumentCondition()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return volist;
	}

	@Override
	public ResultMessage EndAudit(ArrayList list) {
		DeliverVO vo;
		DeliverPO po;
		for (Iterator<DeliverVO> i = list.iterator(); i.hasNext();) {
			vo = i.next();
			po = new DeliverPO(vo.getID(), vo.getWriter(), vo.getTime(),
					vo.getMember(), vo.getOrder(), vo.getDocumentCondition());
			try {
				receiveData.updateD(po);
			} catch (Exception ex) {
				return ResultMessage.FAIL;
			}
		}
		return ResultMessage.SUCCESS;
	}
}
