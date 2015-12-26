package po;

import java.io.Serializable;

import vo.CarVO;

public class CarPO implements Serializable{
private String idNumber;
private String workPlaceNumber;
private String licenseNumber;
private int workYear;

public CarPO(String idNumber, String workPlaceNumber, String licenseNumber, int workYear){
	this.idNumber = idNumber;
	this.workPlaceNumber = workPlaceNumber;
	this.licenseNumber = licenseNumber;
	this.workYear = workYear;
}

public CarPO(CarVO vo){
	this.idNumber=vo.getIDNumber();
	this.workPlaceNumber=vo.getWorkPlaceNumber();
	this.licenseNumber=vo.getLicenseNumber();
	this.workYear=vo.getWorkYear();
}


public CarPO(){};



public String getIDNumber() {
	return idNumber;
}
public void setIDNumber(String idNumber) {
	this.idNumber = idNumber;
}
public String getWorkPlaceNumber() {
	return workPlaceNumber;
}
public void setWorkPlaceNumber(String workPlaceNumber) {
	this.workPlaceNumber = workPlaceNumber;
}
public String getLicenseNumber() {
	return licenseNumber;
}
public void setLicenseNumber(String licenseNumber) {
	this.licenseNumber = licenseNumber;
}
public int getWorkYear() {
	return workYear;
}
public void setWorkYear(int workYear) {
	this.workYear = workYear;
}
}
