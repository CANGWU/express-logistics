package po;

public class DriverPO extends StaffPO{
	public int driverYear;
	public DriverPO(String name,String position,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,String sex,int driverYear,int page){
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
		this.driverYear = driverYear;
		}
	
	public void setDriverYear(int driverYear){
		this.driverYear = driverYear;
	}
	public int getDriverYear(){
		return driverYear;
	}
}
