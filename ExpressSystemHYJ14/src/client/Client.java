package client;

import receiveservice_driver.ReceiveService_Driver;
import receiveslservice.ReceiveService;
import receiveslservice_stub.ReceiveService_Stub;
import reportservice_driver.ReportService_Driver;
import reportservice_stub.ReportService_Stub;
import reportslservice.ReportService;
import transportservice_driver.TransportService_Driver;
import transportservice_stub.TransportService_Stub;
import transportslservice.TransportService;

public class Client {
	public static void main(String[] args){
		ReceiveService receivestub=new ReceiveService_Stub();
		ReceiveService_Driver receivedriver=new ReceiveService_Driver();
		receivedriver.drive(receivestub);
		
		ReportService reportstub=new ReportService_Stub();
		ReportService_Driver reportdriver=new ReportService_Driver();
		reportdriver.drive(reportstub);
		
		TransportService transportstub=new TransportService_Stub();
		TransportService_Driver transportdriver=new TransportService_Driver();
		transportdriver.drive(transportstub);
	}
}
