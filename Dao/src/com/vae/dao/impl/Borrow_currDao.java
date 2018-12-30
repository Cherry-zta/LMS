package com.vae.dao.impl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.db.DBUtils;
import com.vae.domain.Borrow_curr;

public class Borrow_currDao {

	public void add(Borrow_curr Borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 Date date=new Date();
		 String sql = "insert into borrow_curr(borrow_crr_id , bid , userid , borrow_time , should_return_time)values(?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,Borrow_curr.getBid());
				 ps.setInt(2, Borrow_curr.getBorrow_crr_id());
				 ps.setInt(3, Borrow_curr.getUserid());
				 Borrow_curr.setBorrow_time(date);
				 Calendar calendar = Calendar.getInstance();
				 calendar.add(Calendar.DAY_OF_MONTH, 30);
				 date = calendar.getTime();
				 Borrow_curr.setShould_return_time(date);
			
				 ps.setDate(4, new java.sql.Date(Borrow_curr.getBorrow_time().getTime()));
				 ps.setDate(5, new java.sql.Date(Borrow_curr.getShould_return_time().getTime()));
				 
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("添加数据失败");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(Borrow_curr Borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update Borrow_curr set bid=? , userid=? , borrow_time=? , should_return_time=? where borrow_crr_id=? ";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,Borrow_curr.getBid());
				 ps.setInt(2, Borrow_curr.getUserid());
				 ps.setDate(3, new java.sql.Date(Borrow_curr.getBorrow_time().getTime()));
				 ps.setDate(4, new java.sql.Date(Borrow_curr.getShould_return_time().getTime()));
				 ps.setInt(5, Borrow_curr.getBorrow_crr_id());
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("更新数据失败");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(Borrow_curr Borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from Borrow_curr where bid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,Borrow_curr.getBid());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("删除数据失败");
        }finally{
            DBUtils.close(null, ps, conn);
        }
	}
	
	public List<Map<String, Object>> query(String s) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		List<Map<String,Object>> resultList=new ArrayList<Map<String,Object>>();
		try{
				conn = DBUtils.getConnection();
				stmt = conn.createStatement();
				String sql = s;
				rs = stmt.executeQuery(sql);   
				ResultSetMetaData rsmd=rs.getMetaData();
				int columnNum=rsmd.getColumnCount();
				while(rs.next()) {
					Map<String,Object> dataMap=new HashMap<String,Object>(0);
					for(int i=1;i<=columnNum;i++) {
						dataMap.put(rsmd.getColumnName(i), rs.getObject(i));
					}
					resultList.add(dataMap);
	         }	       
		}catch(Exception e){
			e.printStackTrace();
			throw new SQLException("查询数据失败");
		}finally{
           DBUtils.close(null, stmt, conn);
       }
		return resultList;	
		
		
	}
}
