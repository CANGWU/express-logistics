package po;

/*
 * нˮ�����й��ʵ����ݶ���
 * @author:xuan
 * Lastupdater:xuan
 * updateDate:2015/10/22
 * 
 */


import java.io.Serializable;

public class SalaryPO implements Serializable{
private int baseWage;
private int allowance;
private int commission;

public SalaryPO(int baseWage, int allowance, int commision){
this.baseWage = baseWage;
this.allowance = allowance;
this.commission = commision;
}

public SalaryPO(){};


public int getBaseWage(){
return baseWage;
}

public int getAllowance(){
return allowance;
}

public int getCommission(){
return commission;
}

public void setBaseWage(int baseWage){
this.baseWage = baseWage;
}

public void setAllowance(int allowance){
this.allowance = allowance;
}

public void setCommission(int commission){
this.commission = commission;
}

}