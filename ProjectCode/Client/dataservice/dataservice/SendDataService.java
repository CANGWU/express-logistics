package dataservice;

import java.rmi.Remote;

import enums.ResultMessage;
import po.*;

public interface SendDataService extends Remote{
           public ResultMessage insertOrderPO(OrderPO order);
           
           public ResultMessage insertReceiptsPO(ReceiptsPO receipts);
}
