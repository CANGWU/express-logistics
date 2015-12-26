package dataserviceimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.FinanceDataService;
import enums.DocumentCondition;
import enums.PaymentType;
import enums.ResultMessage;
import link.Helper;
import po.AccountPO;
import po.CompanyAccountPO;
import po.PaymentPO;
import po.ReceiptsPO;

public class FinanceDataImpl extends UnicastRemoteObject implements FinanceDataService {

	private FinanceDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	//	@Override
	//	public ReceiptsPO findReceiptsPO(String id) {
	//		// TODO Auto-generated method stub
	//		ResultSet result = null; 
	//		String sql1 = "set sql_safe_update=0;";
	//		String sql2 = "select*from receiptspo where data = '"+id+"';";
	//		ReceiptsPO po = null;
	//		try{
	//			Helper.insert(sql1);
	//			result = Helper.find(sql2);
	//			if(result.next()){
	//				String[]orderNumbers = result.getString("orderNumbers").split(" ");
	//			po = new ReceiptsPO(result.getString("data"),result.getDouble("fee"),result.getString("courier"),orderNumbers);
	//			
	//			}
	//		}catch(Exception e){
	//			e.printStackTrace();
	//		}
	//		
	//		
	//		
	//		return null;
	//	}



	@Override
	public ResultMessage insertPaymentPO(PaymentPO payment) {

		// TODO Auto-generated method stub
		String sql = "insert into paymentpo values('"+payment.getReceiver()+"','"+payment.getType()+"',"+payment.getNumberOfPayment()+",'"+payment.getAccountname()+"','"+payment.getCondition()+"','"+payment.getNameOfWriter()+"','"+payment.getRemarks()+"','"+payment.getAuditnumber()+"');";
		return Helper.insert(sql);
	}

	@Override
	public AccountPO findAccountPO(String id) {
		// TODO Auto-generated method stub
		AccountPO po = null; 
		ResultSet result = null;
		String sql = "select*from Accountpo where name='"+id+"';";
		try{
			result = Helper.find(sql);
			if(result.next())
				po = new AccountPO(result.getString("name"),result.getDouble("balance"));
		}catch (Exception e){
			e.printStackTrace();
		}
		return po;
	}


	@Override
	public ResultMessage insertAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		String sql = "insert into accountpo value('"+account.getName()+"',"+account.getBalance()+");";
		return Helper.insert(sql);
	}

	@Override
	public ResultMessage deleteAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		String sql1 = "set sql_safe_updates=0;";
		String sql2 = "delete from accountpo where name='"+account.getName()+"';";
		String sql3 = "set sql_safe_updates=1;";
		Helper.insert(sql1);
		Helper.delete(sql2);
		Helper.insert(sql3);
		return null;
	}

	@Override
	public ResultMessage updateAccountPO(AccountPO account) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ResultMessage result = deleteAccountPO(account);
		if(result==ResultMessage.FAIL)
			return result;
		return insertAccountPO(account);
	}

	@Override
	public CompanyAccountPO findCompanyAccountPO(String id) {
		// TODO Auto-generated method stub
		CompanyAccountPO po = null; 
		ResultSet result = null;
		String sql = "select*from CompanyAccountpo where agency='"+id+"';";
		try{
			result = Helper.find(sql);
			if(result.next())
				po = new CompanyAccountPO();
			po.setAgency(result.getString("agency"));
			po.setBankaccount(result.getString("bankaccount"));
			po.setCustomer(result.getString("customer"));
			po.setPeople(result.getString("people"));
			po.setStock(result.getString("stock"));
		}catch (Exception e){
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public ResultMessage insertCompanyAccountPO(CompanyAccountPO companyaccount) {
		// TODO Auto-generated method stub
		String sql = "insert into accountpo value('"+companyaccount.getCustomer()+"','"+companyaccount.getAgency()+"','"+companyaccount.getPeople()+"','"+companyaccount.getStock()+"','"+companyaccount.getBankaccount()+"');";
		return Helper.insert(sql);
	}

	public static FinanceDataImpl creat() throws RemoteException {
		if(finance == null){
			synchronized(FinanceDataImpl.class){

				if(finance == null)
					finance = new FinanceDataImpl();
			}
		}

		return finance;
	}

	private volatile static FinanceDataImpl finance;

	@Override
	public ArrayList<AccountPO> seekAccount(String name) {
		// TODO Auto-generated method stub
		ArrayList<AccountPO>pos = new ArrayList<AccountPO>();
		AccountPO po = null; 
		ResultSet result = null;
		String sql = "select*from Accountpo where name like'%"+name+"%';";
		try{
			result = Helper.find(sql);
			while(result.next()){
				po = new AccountPO(result.getString("name"),result.getDouble("balance"));
				pos.add(po);
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return pos;
	}

	@Override
	public ArrayList<PaymentPO> findsPaymentPO(String workplacenumber) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO>pays = new ArrayList<PaymentPO>();
		PaymentPO po = null;
		ResultSet result = null;
		String sql = "select *from paymentpo where workplacenumber="+workplacenumber+";";
		try{
			result = Helper.find(sql);
			while(result.next()){
				po = new PaymentPO();
				po.setReceiver(result.getString("receiver"));
				po.setRemarks(result.getString("remarks"));
				po.setAccountname(result.getString("accountname"));
				po.setCondition(DocumentCondition.valueOf(result.getString("dCondition")));
				po.setNameOfWriter(result.getString("nameOfWriter"));
				po.setType(PaymentType.valueOf(result.getString("paymentType")));
				po.setNumberOfPayment(result.getDouble("numberOfPayment"));
				po.setAuditnumber(result.getString("auditnumber"));
				pays.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pays;
	}

	@Override
	public ArrayList<PaymentPO> findPWithdContion(String nameOfWriter, DocumentCondition dCondition) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO>pays = new ArrayList<PaymentPO>();
		PaymentPO po = null;
		ResultSet result = null;
		String sql = "select *from paymentpo where nameOfWriter="+nameOfWriter+"' and documentcondition='"+dCondition+"';";
		try{
			result = Helper.find(sql);
			while(result.next()){
				po = new PaymentPO();
				po.setReceiver(result.getString("receiver"));
				po.setRemarks(result.getString("remarks"));
				po.setAccountname(result.getString("accountname"));
				po.setCondition(DocumentCondition.valueOf(result.getString("dCondition")));
				po.setNameOfWriter(result.getString("nameOfWriter"));
				po.setType(PaymentType.valueOf(result.getString("paymentType")));
				po.setNumberOfPayment(result.getDouble("numberOfPayment"));	
				po.setAuditnumber(result.getString("auditnumber"));
				pays.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pays;
	}

	@Override
	public ArrayList<AccountPO> getAllAccount() throws RemoteException {
		
		// TODO Auto-generated method stub
		String sql="select*from accountpo;";
		ResultSet resultSet = null;
		ArrayList<AccountPO>accountPOs=new ArrayList<AccountPO>();
		
		
		try {
			resultSet=Helper.find(sql);
			while(resultSet.next()){
				AccountPO po=new AccountPO(resultSet.getString(1), resultSet.getDouble(2));
				accountPOs.add(po);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return accountPOs;
	}

	@Override
	public ArrayList<PaymentPO> findAudit() {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO>pays = new ArrayList<PaymentPO>();
		PaymentPO po = null;
		ResultSet result = null;
		String sql = "select *from paymentpo where documentcondition= 'handing';";
		try{
			result = Helper.find(sql);
			while(result.next()){
				po = new PaymentPO();
				po.setReceiver(result.getString("receiver"));
				po.setRemarks(result.getString("remarks"));
				po.setAccountname(result.getString("accountname"));
				po.setCondition(DocumentCondition.valueOf(result.getString("dCondition")));
				po.setNameOfWriter(result.getString("nameOfWriter"));
				po.setType(PaymentType.valueOf(result.getString("paymentType")));
				po.setNumberOfPayment(result.getDouble("numberOfPayment"));
				po.setAuditnumber(result.getString("auditnumber"));
				pays.add(po);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pays;
	}

	@Override
	public ResultMessage updatePaymentPO(PaymentPO payment) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "update paymentpo set receiver='"+ payment.getReceiver()+ "',paymenttype='"+ payment.getType() 
		+ "', numberOfpayment ="+ payment.getNumberOfPayment() + ", accountname='"
		+ payment.getAccountname() +"',dCondition='"+ payment.getCondition()+"', nameOfwriter='"+ payment.getNameOfWriter()
		+ "', remarks ='"+ payment.getRemarks()+ "' where auditnumber='"+ payment.getAuditnumber()+"';";
		
		
		return Helper.delete(sql);
	}

	@Override
	public PaymentPO findLastest() throws RemoteException {
		// TODO Auto-generated method stub
		String sql="select * from paymentpo order by auditnumber desc;";
		PaymentPO po = null;
		ResultSet result = null;
		
		try{
			result = Helper.find(sql);
			if(result.next()){
				po = new PaymentPO();
				po.setReceiver(result.getString("receiver"));
				po.setRemarks(result.getString("remarks"));
				po.setAccountname(result.getString("accountname"));
				po.setCondition(DocumentCondition.valueOf(result.getString("dCondition")));
				po.setNameOfWriter(result.getString("nameOfWriter"));
				po.setType(PaymentType.valueOf(result.getString("paymentType")));
				po.setNumberOfPayment(result.getDouble("numberOfPayment"));	
				po.setAuditnumber(result.getString("auditnumber"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return po;
	}


}
