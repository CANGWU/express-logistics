package vo;

import po.PeoplePO;

public class PeopleVO {
     String name;
     String address;
     String workPlace;
     String telNumber;
     String phoneNumber;
     
    public PeopleVO(String _name, String _address, String _workPlace, String _telNumber, String _phoneNumber){
        name=_name;
        address=_address;
        workPlace=_workPlace;
        telNumber=_telNumber;
        phoneNumber=_phoneNumber;
    }
    
    public PeopleVO(PeoplePO po){
    	this.name=po.getName();
    	this.address=po.getAddress();
    	this.workPlace=po.getWorkPlace();
    	this.telNumber=po.getTelNumber();
    	this.phoneNumber=po.getPhoneNumber();
    }
     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
     
     
}
