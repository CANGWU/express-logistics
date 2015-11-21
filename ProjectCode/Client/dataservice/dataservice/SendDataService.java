package dataservice;

import java.rmi.Remote;

import po.*;
import slstub.ResultMessage;

public interface SendDataService extends Remote{
           public ResultMessage insertOrderPO(OrderPO order);
           
           public ResultMessage insertReceiptsPO(ReceiptsPO receipts);
}
