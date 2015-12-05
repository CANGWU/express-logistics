package vo;

import enums.Condition;
import enums.DocumentCondition;
import enums.Ioput;
import enums.Position;
import enums.Traffic;

public class IoputVO {
	/**
	 * 
	 */
	private String id;/*¿ìµÝÌõÐÎÂëºÅ*/
	private String inputdate;//DATE
	private String outputdate;
	private String time;
	private Position destination;
	private String position;
	private Traffic transport;
	private String receiptID;
	private Ioput ioput;
	private Condition condition;
	private DocumentCondition dCondition;
	private String nameOfWriter;
	
	public IoputVO(String i,String idate,String it,Position des,String posi,Ioput ioput,Condition condition, DocumentCondition dCondition,	String nameOfWriter){
		id = i;
		inputdate = idate;
		time = it;
		position = posi;
		destination = des;
		this.ioput = ioput;
		this.dCondition  = dCondition;
		this.nameOfWriter = nameOfWriter;
		
	}
	public IoputVO(String i,String odate,String t,Position des,Traffic trans,String rID,Ioput ioput,Condition condition,DocumentCondition dCondition,String nameOfWriter){
		id = i;
		outputdate = odate;
		time = t;
		transport = trans;
		destination = des;
		receiptID = rID;
		this.ioput = ioput;
		this.condition = condition;
		this.dCondition = dCondition;
		this.nameOfWriter = nameOfWriter;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInputdate() {
		return inputdate;
	}
	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}
	public String getOutputdate() {
		return outputdate;
	}
	public void setOutputdate(String outputdate) {
		this.outputdate = outputdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Position getDestination() {
		return destination;
	}
	public void setDestination(Position destination) {
		this.destination = destination;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Traffic getTransport() {
		return transport;
	}
	public void setTransport(Traffic transport) {
		this.transport = transport;
	}
	public String getReceiptID() {
		return receiptID;
	}
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}
	
	public Ioput getIoput(){
		return this.ioput;
	}
	
	public void setIoput(Ioput ioput){
		this.ioput = ioput;
	}
	
	public Condition getCondition(){
		return this.condition;
	}
	
	public void setCondition(Condition condition){
		this.condition = condition;
	}
	public DocumentCondition getdCondition(){
		return this.dCondition;
	}
	
	public void setDocumentCondition (DocumentCondition dCondition){
		this.dCondition = dCondition;
	}
	
	public String getNameOfWriter(){
		return this.nameOfWriter;
	}
	
	public void setNameOfWriter(String nameOfWriter){
		this.nameOfWriter = nameOfWriter;
	}

}
