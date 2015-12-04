package po;

import java.io.Serializable;
import java.util.ArrayList;

import enums.DocumentCondition;

public class DeliverPO implements Serializable {
	private DocumentCondition documentCondition;
	private String id;
	private String nameOfWriter;
	private String time;
	private ArrayList<String> member;
	private ArrayList<String> order;

	public DeliverPO(String id, String nameOfWriter, String time,
			ArrayList<String> member, ArrayList<String> order,
			DocumentCondition documentCondition) {
		this.id = id;
		this.nameOfWriter = nameOfWriter;
		this.time = time;
		this.member = member;
		this.order = order;
		this.documentCondition = documentCondition;
	}

	public String getTime() {
		return time;
	}

	public String getID() {
		return id;
	}

	public String getWriter() {
		return nameOfWriter;
	}

	public ArrayList<String> getMember() {
		return member;
	}

	public ArrayList<String> getOrder() {
		return order;
	}

	public DocumentCondition getDocumentCondition() {
		return documentCondition;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setWriter(String nameOfWriter) {
		this.nameOfWriter = nameOfWriter;
	}

	public void setMember(ArrayList<String> member) {
		this.member = member;
	}

	public void setOrder(ArrayList<String> order) {
		this.order = order;
	}

	public void setDocumentCondition(DocumentCondition documentCondition) {
		this.documentCondition = documentCondition;
	}
}