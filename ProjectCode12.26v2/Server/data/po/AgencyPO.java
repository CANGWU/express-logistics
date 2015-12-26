package po;

import java.io.Serializable;
import java.util.ArrayList;

import vo.AgencyVO;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class AgencyPO implements Serializable{
private String name;
private String idNumber;
private ArrayList<String>staff;
private String phoneNumber;
private String address;
private String leader;

public AgencyPO(String name,String idNumber,ArrayList<String>staff,String phoneNumber,String address,String leader){
this.name = name;
this.staff = staff;
this.idNumber = idNumber;
this.phoneNumber = phoneNumber;
this.address = address;
this.leader = leader;
}

public AgencyPO(AgencyVO vo){
	this.name = vo.getName();
	this.staff = vo.getStaff();
	this.idNumber = vo.getIDNumber();
	this.phoneNumber = vo.getPhoneNumber();
	this.address = vo.getAddress();
	this.leader = vo.getLeader();
	
	
}

public AgencyPO(){};

public String getName(){
return name;
}


public String getIDNumber(){
	return idNumber;
}

public String getAddress(){
	return address;
}

public ArrayList<String>getStaff(){
	return staff;
}

public String getPhoneNumber(){
	return phoneNumber;
}

public String getLeader(){
	return leader;
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

public void setLeader(String leader){
	this.leader = leader;
}

public void setStaff(ArrayList<String>staff){
	this.staff = staff;
}

}
