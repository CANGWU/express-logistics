package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import link.Helper;

public class JDBCTest {

static String sql = null;  
static Helper db1 = null;  
static ResultSet ret = null;  

public static void main(String[] args) {  
    sql = "SELECT * FROM staffpo;";//SQL语句  
    db1 = new Helper();//创建DBHelper对象  

    try {  
        ret = Helper.run(sql);//执行语句，得到结果集  
        while (ret.next()) {  
            String uid = ret.getString(1);  
            String ufname = ret.getString(2);  
            String ulname = ret.getString(3);  
            String udate = ret.getString(4);  
            System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
        }//显示数据  
        ret.close();  
        db1.close();//关闭连接  
    } catch (SQLException e) {  
        e.printStackTrace();  
    }  
}  
}