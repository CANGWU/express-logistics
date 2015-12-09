package dataserviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import enums.Condition;

public class IOObject {

	public static Object getArray(byte[] b){
		ByteArrayInputStream bais;
		ObjectInputStream in = null;
		try{
			bais = new ByteArrayInputStream(b);
			in = new ObjectInputStream(bais);
			
				return in.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return null;
	}
	
	
	public static byte[] toByteArray(Object object){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(baos);
			out.writeObject(object);		
		} catch (IOException e) {
			//logger.error("msg2Bytes error!", e);
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				//logger.error("msg2Bytes error!", e);
			}
		}
		return baos.toByteArray();

	}
	
	

}
