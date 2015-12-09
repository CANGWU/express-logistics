package vo;

import po.GoodsPO;
import enums.Packing;

public class GoodsVO {
	private int numberOfGoods;
	private double weight;
	private double volume;
	private String nameOfGoods;
	private String size;
	private String expressType;
	private Packing packing;

	public GoodsVO(int _numberOfGoods, double _weight, double _volume,
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

	public GoodsVO(GoodsPO po) {
		// TODO Auto-generated constructor stub
		this.numberOfGoods=po.getNumberOfGoods();
		this.weight=po.getWeight();
		this.volume=po.getVolume();
		this.nameOfGoods=po.getNameOfGoods();
		this.size=po.getSize();
		this.expressType=po.getExpressType();
		this.packing=po.getPacking();
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

