package vo;

import enums.Sex;
import enums.Work;

public class DriverVO extends StaffVO{
	public int driverYear;
	public DriverVO(String name,Work work,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,Sex sex,int driverYear,int page){
		this.name = name;
		this.work = work;
		this.workNumber = workNumber;
		this.workPlaceNumber = workPlaceNumber;
		this.birthDate = birthDate;
		this.idNumber = idNumber;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.sex = sex;
		this.page = page;
		this.driverYear = driverYear;
		}
	public DriverVO(){};
	
	public void setDriverYear(int driverYear){
		this.driverYear = driverYear;
	}
	public int getDriverYear(){
		return driverYear;
	}
}
