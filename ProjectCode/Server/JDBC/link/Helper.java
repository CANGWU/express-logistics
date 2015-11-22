package link;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;  
  
public class Helper {  
    public static final String url = "jdbc:mysql://127.0.0.1:3306/sys";  
    public static final String driver = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "";  
  
    private static Connection conn = null;  
    private static PreparedStatement pst = null;  
  
    public Helper() {  
        try {  
            Class.forName(driver);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    
   static public ResultSet run(String sql) throws SQLException{
    	pst = conn.prepareStatement(sql);
    	ResultSet result = pst.executeQuery();
    	return result;
    }
    
    
    
    public void close() {  
        try {  
            conn.close();  
            pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
