package po;

import java.io.Serializable;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class StaffPO implements Serializable{
String name; 
String position;
String workNumber;
String workPlaceNumber;
String birthDate;
String idNumber;
String phoneNumber;
String address;
String sex;
double page;

public StaffPO(String name,String position,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,String sex,double page){
this.name = name;
this.position = position;
this.workNumber = workNumber;
this.workPlaceNumber = workPlaceNumber;
this.birthDate = birthDate;
this.idNumber = idNumber;
this.phoneNumber = phoneNumber;
this.address = address;
this.sex = sex;
this.page = page;
}

public StaffPO(){};

public String getPhoneNumber(){
	    return phoneNumber;
}

public String getName(){
return name;
}

public String getPosition(){
	return position;
}

public String getWorkNumber(){
return workNumber;
}

public String getWorkPlaceNumber(){
	return workPlaceNumber;	
}

public String getBrithDate(){
	return birthDate;
}

public String getIDNumber(){
	return idNumber;
}

public String getAddress(){
	return address;
}

public String getSex(){
	return sex;
}

public double getPage(){
	return page;
}

public void setName(String name){
	this.name = name;
}

public void setWorkNumber(String workNumber){
	this.workNumber = workNumber;
}

public void setWorkPlaceNumber(String workPlaceNumber){
	this.workPlaceNumber =workPlaceNumber;
}

public void setIDNumber(String idNumber){
	this.idNumber = idNumber;
}

public void setBrithDate(String birthDate){
	this.birthDate = birthDate;
}

public void setAddress(String address){
	this.address = address;
}

public void setPage(double page){
	this.page = page;
}

public void setPosition(String position){
	this.position = position;
}

public void setSex(String sex){
	this.sex = sex;
}

public void setPhoneNumber(String phoneNumber){
	this.phoneNumber = phoneNumber;
}
}