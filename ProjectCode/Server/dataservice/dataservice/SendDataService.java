package dataservice;

import po.*;

public interface SendDataService {
           public ResultMessage insertOrderPO(OrderPO order);
           
           public ResultMessage insertReceiptsPO(ReceiptsPO receipts);
}
