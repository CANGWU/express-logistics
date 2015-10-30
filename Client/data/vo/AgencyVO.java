package vo;

import java.io.Serializable;
import java.util.ArrayList;

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
	ArrayList<StaffVO>staff;
	String phoneNumber;
	String address;
	StaffVO leader;

public AgencyVO(String name,String idNumber,ArrayList<StaffVO> staff,String phoneNumber,String address,StaffVO leader){
this.name = name;
this.staff = staff;
this.idNumber = idNumber;
this.phoneNumber = phoneNumber;
this.address = address;
this.leader = leader;
}

public AgencyVO(){};

public String getName(){
return name;
}


public String getIDNumber(){
	return idNumber;
}

public String getAddress(){
	return address;
}

public ArrayList<StaffVO> getStaff(){
	return staff;
}

public String getPhoneNumber(){
	return phoneNumber;
}

public StaffVO getLeader(){
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

public void setLeader(StaffVO leader){
	this.leader = leader;
}

public void setStaff(ArrayList<StaffVO>staff){
	this.staff = staff;
}

}
