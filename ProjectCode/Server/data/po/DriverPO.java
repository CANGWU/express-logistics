package po;

import vo.DriverVO;

import java.io.Serializable;

import enums.Sex;
import enums.Work;

public class DriverPO extends StaffPO implements Serializable{
	private int driverYear;

	public DriverPO(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, int driverYear,
			int page) {
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

	public DriverPO(DriverVO vo) {
		this.name = vo.getName();
		this.work = vo.getWork();
		this.workNumber = vo.getWorkNumber();
		this.workPlaceNumber = vo.getWorkPlaceNumber();
		this.birthDate = vo.getBirthDate();
		this.idNumber = vo.getIdNumber();
		this.phoneNumber = vo.getPhoneNumber();
		this.address = vo.getAddress();
		this.sex = vo.getSex();
		this.page = vo.getPage();
		this.driverYear = this.getDriverYear();
	}

	public void setDriverYear(int driverYear) {
		this.driverYear = driverYear;
	}

	public int getDriverYear() {
		return driverYear;
	}
}
