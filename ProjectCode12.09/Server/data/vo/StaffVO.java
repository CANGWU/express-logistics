package vo;

import java.io.Serializable;

import enums.Sex;
import enums.Work;
import po.StaffPO;

/*
 * 
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 *
 */

public class StaffVO implements Serializable {
	protected String name;
	protected Work work;
	protected String workNumber;
	protected String workPlaceNumber;
	protected String birthDate;
	protected String idNumber;
	protected String phoneNumber;
	protected String address;
	protected Sex sex;
	protected double page;
	protected int number;

	public StaffVO(String name, Work work, String workNumber,
			String workPlaceNumber, String birthDate, String idNumber,
			String phoneNumber, String address, Sex sex, double page) {
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
	}

	public StaffVO(StaffPO po) {
		this.name = po.getName();
		this.work = po.getWork();
		this.workNumber = po.getWorkNumber();
		this.workPlaceNumber = po.getWorkPlaceNumber();
		this.birthDate = po.getBirthDate();
		this.idNumber = po.getIdNumber();
		this.phoneNumber = po.getPhoneNumber();
		this.address = po.getAddress();
		this.sex = po.getSex();
		this.page = po.getPage();
	}

	public StaffVO() {
	};

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getName() {
		return name;
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

	public double getPage() {
		return page;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setPage(double page) {
		this.page = page;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPage(int page) {
		this.page = page;
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

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StaffPO changeToPO() {
		StaffPO po = new StaffPO(this.name, this.work, this.workNumber,
				this.workPlaceNumber, this.birthDate, this.idNumber,
				this.phoneNumber, this.address, this.sex, this.page);
		return po;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
}