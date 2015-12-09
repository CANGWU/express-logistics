package vo;

import java.util.ArrayList;

import enums.DocumentType;

public class DocumentVO {
	private DocumentType Type;
	
	@SuppressWarnings("rawtypes")
	private ArrayList list;
	public DocumentVO(DocumentType t,ArrayList list){
		setType(t);
		setList(list);

	}
	
	
	public DocumentType getType() {
		return Type;
	}
	public void setType(DocumentType type) {
		Type = type;
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getList() {
		return list;
	}


	@SuppressWarnings("rawtypes")
	public void setList(ArrayList list) {
		this.list = list;
	}
}


