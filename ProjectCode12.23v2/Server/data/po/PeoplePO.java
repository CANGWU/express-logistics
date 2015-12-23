package po;

import java.io.Serializable;

public class PeoplePO implements Serializable{
     String name;
     String address;
     String workPlace;
     String telNumber;
     String phoneNumber;
     
    public PeoplePO(String _name, String _address, String _workPlace, String _telNumber, String _phoneNumber){
        name=_name;
        address=_address;
        workPlace=_workPlace;
        telNumber=_telNumber;
        phoneNumber=_phoneNumber;
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
