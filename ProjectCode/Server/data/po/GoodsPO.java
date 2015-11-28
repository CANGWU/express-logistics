package po;

import enums.Packing;

public class GoodsPO {
    int numberOfGoods;
    double weight;
    double volume;
    Packing packing;
    String nameOfGoods;
    String size;
    String expressType;
    
    public GoodsPO(int _numberOfGoods, double _weight, double _volume, String _nameOfGoods, String _size, String _expressType, Packing packing){
        numberOfGoods=_numberOfGoods;
        weight=_weight;
        volume=_volume;
        nameOfGoods=_nameOfGoods;
        size=_size;
        expressType=_expressType;
        this.packing = packing;
    }
    
	public Packing getPacking() {
		return packing;
	}

	public void setPacking(Packing packing) {
		this.packing = packing;
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
}
