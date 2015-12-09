package po;

import java.io.Serializable;

import enums.Packing;

public class GoodsPO implements Serializable{
	private int numberOfGoods;
	private double weight;
	private double volume;
	private String nameOfGoods;
	private String size;
	private String expressType;
	private Packing packing;

	public GoodsPO(int _numberOfGoods, double _weight, double _volume,
			String _nameOfGoods, String _size, String _expressType,
			Packing _packing) {
		numberOfGoods = _numberOfGoods;
		weight = _weight;
		volume = _volume;
		nameOfGoods = _nameOfGoods;
		size = _size;
		expressType = _expressType;
		packing=_packing;
	}

	public int getNumberOfGoods() {
		return numberOfGoods;
	}

	public void setNumberOfGoods(int numberOfGoods) {
		this.numberOfGoods = numberOfGoods;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getNameOfGoods() {
		return nameOfGoods;
	}

	public void setNameOfGoods(String nameOfGoods) {
		this.nameOfGoods = nameOfGoods;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getExpressType() {
		return expressType;
	}

	public void setExpressType(String expressType) {
		this.expressType = expressType;
	}

	public Packing getPacking() {
		return packing;
	}

	public void setPacking(Packing packing) {
		this.packing = packing;
	}
}
