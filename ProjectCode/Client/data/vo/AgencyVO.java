package vo;

import java.io.Serializable;
import java.util.ArrayList;

import po.AgencyPO;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/25
 *
 */

public class AgencyVO implements Serializable{
	String name;
	String idNumber;
	ArrayList<String>staff;
	String phoneNumber;
	String address;
	String leader;

public AgencyVO(String name,String idNumber,ArrayList<String> staff,String phoneNumber,String address,String leader){
this.name = name;
this.staff = staff;
this.idNumber = idNumber;
this.phoneNumber = phoneNumber;
this.address = address;
this.leader = leader;
}

public AgencyVO(){};

public AgencyVO(AgencyPO po){
	this.name=po.getName();
	this.idNumber=po.getIDNumber();
	this.staff=po.getStaff();
	this.phoneNumber=po.getPhoneNumber();
	this.address=po.getAddress();
	this.leader=po.getLeader();
}

public String getName(){
return name;
}


public String getIDNumber(){
	return idNumber;
}

public String getAddress(){
	return address;
}



public String getPhoneNumber(){
	return phoneNumber;
}




public void setName(String name){
	this.name = name;
}

public void setIDNumber(String idNumber){
	this.idNumber = idNumber;
}


public void setAddress(String address){
	this.address = address;
}

public void setPhoneNumber(String phoneNumber){
	this.phoneNumber = phoneNumber;
}



public String getIdNumber() {
	return idNumber;
}

public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
}

public String getLeader() {
	return leader;
}

public void setLeader(String leader) {
	this.leader = leader;
}

public ArrayList<String> getStaff() {
	return staff;
}

public void setStaff(ArrayList<String> staff) {
	this.staff = staff;
}



}
