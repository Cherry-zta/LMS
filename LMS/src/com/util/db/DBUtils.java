package com.util.db;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtils {
  private static Connection conn;
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    public static Connection getConnection() throws PropertyVetoException {
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs,Statement stat,Connection conn){
     try {
             if(rs!=null)rs.close();
             if(stat!=null)stat.close();
             if(conn!=null)conn.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

}
