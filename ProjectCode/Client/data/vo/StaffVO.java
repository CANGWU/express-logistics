package vo;

import java.io.Serializable;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class StaffVO implements Serializable{
String name; 
String position;
String workNumber;
String workPlaceNumber;
String birthDate;
String idNumber;
String phoneNumber;
String address;
String sex;
int page;

public StaffVO(String name,String position,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,String sex,int page){
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

public StaffVO(StaffPO po){
	this.name=po.getName();
	this.work=po.getWork();
	this.workNumber=po.getWorkNumber();
	this.workPlaceNumber=po.getWorkPlaceNumber();
	this.birthDate=po.getBirthDate();
	this.idNumber=po.getIdNumber();
	this.phoneNumber=po.getPhoneNumber();
	this.address=po.getAddress();
	this.sex=po.getSex();
	this.page=po.getPage();
}

public StaffVO(){};

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

public String getAddress(){
	return address;
}

public String getSex(){
	return sex;
}

public int getPage(){
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

public void setAddress(String address){
	this.address = address;
}

public void setPage(int page){
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