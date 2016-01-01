package sendslservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import enums.OrderInputCheckMessage;
import enums.ResultMessage;
import vo.*;

public interface SendService {
      public OrderVO calculate(OrderVO info);
      public BillVO setBill(OrderVO order);
      public BillVO getchange(double cash,BillVO bill);
      public void orderend(BillVO bill,OrderVO order);
      public String computeOrdernumber();
      public String computedue(OrderVO order);

      
      public ArrayList<ReceiptsVO> newReceipts(String Date,String workplace) throws RemoteException;
      public ReceiptsVO findReceipt(String Date,String courier) throws RemoteException;
      public ArrayList<ReceiptsVO> findReceipts(String Date,String office);
      public ResultMessage updateReceipts(ReceiptsVO receiptsvo);
      public ResultMessage deleteReceipts(String Date,String courier);
}
