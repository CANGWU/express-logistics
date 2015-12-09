package vo;

import po.AccountPO;

public class AccountVO {
     String name;
     double balance;
     
     public AccountVO(String name,double balance){
    	 this.name=name;
    	 this.balance=balance;;
     }
     
     public AccountVO(AccountPO po){
    	 this.name=po.getName();
    	 this.balance=po.getBalance();
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
	
	public AccountPO changeToPo(){
		AccountPO po=new AccountPO(this.name,this.balance);
		return po;
	}
}
