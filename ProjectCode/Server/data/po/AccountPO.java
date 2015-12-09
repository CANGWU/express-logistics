package po;

import java.io.Serializable;

public class AccountPO implements Serializable{
     String name;
     double balance;
     
     public AccountPO(String name,double balance){
    	 this.name=name;
    	 this.balance=balance;;
     }



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
