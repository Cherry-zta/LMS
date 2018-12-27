package dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.util.db.DBUtils;

public class test {
	public static void main(String[] args) {  
        Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			System.out.println("连接成功");
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("连接失败");
		}
        
        DBUtils.close(conn);
    }
}
