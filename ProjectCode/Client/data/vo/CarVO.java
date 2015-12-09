package vo;

import po.CarPO;

public class CarVO {
private String idNumber;
private String workPlaceNumber;
private String licenseNumber;
private int workYear;

public CarVO(String idNumber, String workPlaceNumber, String licenseNumber, int workYear){
	this.idNumber = idNumber;
	this.workPlaceNumber = workPlaceNumber;
	this.licenseNumber = licenseNumber;
	this.workYear = workYear;
}


public CarVO(CarPO po){
	this.idNumber=po.getIDNumber();
	this.workPlaceNumber=po.getWorkPlaceNumber();
	this.licenseNumber=po.getLicenseNumber();
	this.workYear=po.getWorkYear();
}
public CarVO(){};



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
