package po;

import java.io.Serializable;

import vo.StaffVO;
import enums.Sex;
import enums.Work;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class StaffPO implements Serializable {
	String name;
	Work work;
	String workNumber;
	String workPlaceNumber;
	String birthDate;
	String idNumber;
	String phoneNumber;
	String address;
	Sex sex;
	double page;

	public StaffPO(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, double page) {
		this.name = name;
		this.work = work;
		this.workNumber = workNumber;
		this.workPlaceNumber = workPlaceNumber;
		this.setBirthDate(birthDate);
		this.setIdNumber(idNumber);
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.sex = sex;
		this.page = page;
	}

	public StaffPO(StaffVO vo) {
		this.name = vo.getName();
		this.work = vo.getWork();
		this.workNumber = vo.getWorkNumber();
		this.workPlaceNumber = vo.getWorkPlaceNumber();
		this.setBirthDate(vo.getBirthDate());
		this.setIdNumber(vo.getIdNumber());
		this.phoneNumber = vo.getPhoneNumber();
		this.address = vo.getAddress();
		this.sex = vo.getSex();
		this.page = vo.getPage();
	}

	public StaffPO() {
	};

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return name;
	}

	public Work getWork() {
		return work;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public String getWorkPlaceNumber() {
		return workPlaceNumber;
	}

	public String getAddress() {
		return address;
	}

	public Sex getSex() {
		return sex;
	}

	public double getPage() {
		return page;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public void setWorkPlaceNumber(String workPlaceNumber) {
		this.workPlaceNumber = workPlaceNumber;
	}

	public void setBrithDate(String birthDate) {
		this.setBirthDate(birthDate);
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPage(double page) {
		this.page = page;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}