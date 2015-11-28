package vo;

<<<<<<< HEAD
=======
import po.DriverPO;
import enums.Sex;
import enums.Work;

>>>>>>> origin/master
public class DriverVO extends StaffVO{
	public int driverYear;
	public DriverVO(String name,String position,String workNumber,String workPlaceNumber,String birthDate,String idNumber,String phoneNumber,String address,String sex,int driverYear,int page){
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
	
	
	public DriverVO(DriverPO po){
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
		this.driverYear=po.getDriverYear();
	}
	public DriverVO(){};
	
	public void setDriverYear(int driverYear){
		this.driverYear = driverYear;
	}
	public int getDriverYear(){
		return driverYear;
	}
}
