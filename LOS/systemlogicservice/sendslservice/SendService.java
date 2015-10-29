package sendslservice;

import java.util.ArrayList;

import vo.*;

public interface SendService {
      public OrderVO calculate(String[] info);
      public BillVO setBill(OrderVO order);
      public BillVO getchange(double cash,BillVO bill);
      public void orderend(BillVO bill,OrderVO order);
      public String computeOrdernumber();
      public String computedue(OrderVO order);
      public OrderInputCheckMessage inputcheck(String[] info);
      public OrderInputCheckMessage changecheck(BillVO bill);
      
      public ArrayList<ReceiptsVO> receiptsNew(String office);
      public ArrayList<ReceiptsVO> receiptscheck(String office,String data);

      
}
