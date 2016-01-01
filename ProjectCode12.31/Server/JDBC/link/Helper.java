package link;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.ResultMessage;
 
  
public class Helper {  
    public static final String url = "jdbc:mysql://127.0.0.1:3306/sys";  
    public static final String driver = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
    public static final String characterEncoding = "utf-8";
  
    public static Connection conn = null;  
    private static Statement statement = null;  
    public static PreparedStatement pStatement = null;
  
    public Helper() {  
        try {  
            Class.forName(driver);//指定连接类型  
            conn = DriverManager.getConnection(url+"?user=" + user + "&password" + password + "&useUnicode=true&characterEncoding" + characterEncoding);//获取连接  
//            "jdbc:mysql://localhost:3306/test?                         "
//            + "user=root&password=1&useUnicode=true&characterEncoding=utf-8"
            statement = conn.createStatement();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    
   static public ResultSet find(String sql) throws SQLException{
    ResultSet result = statement.executeQuery(sql);
    return result;
    }
   
   
   public static ResultMessage insert(String sql) {
		// TODO Auto-generated method stub
		 try {
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        return ResultMessage.FAIL;
		}
		 return ResultMessage.SUCCESS;
	}  
   
   static public ResultMessage delete(String sql){
	   try {
		statement.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return ResultMessage.FAIL;
	}
	   return ResultMessage.SUCCESS;
   }
    
    public void close() {  
        try {  
            conn.close();  
            statement.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }


	
}  
