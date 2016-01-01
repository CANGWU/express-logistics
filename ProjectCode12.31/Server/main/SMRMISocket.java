
import   java.rmi.server.*;  

import   java.io.*;  

import   java.net.*;  

public class SMRMISocket extends RMISocketFactory   {  

	public Socket createSocket(String host, int port)throws IOException{  

		return new Socket(host,port);  

	}  


	public ServerSocket createServerSocket(int port)throws IOException{  

		if(port == 0)  

			port = 20110; //不指定就随机分配了 
			return new ServerSocket(port);  

	}  

}   