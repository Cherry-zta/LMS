package com.vae.dao.impl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.db.DBUtils;
import com.vae.domain.Book;
import com.vae.domain.User;

public class UserDao {

	public void add(User user) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into user(userid, effective_date, expiry_date, type, profession)values(?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,user.getUserid());
				 Date d=new Date();
				 user.setEffective_date(d);
				 if(user.getType().equals("student")) {
					 Calendar calendar = Calendar.getInstance();
					 calendar.add(Calendar.DAY_OF_YEAR,4*365+1);
					 d = calendar.getTime();
					 user.setExpiry_date(d);
				 }
				 if(user.getType().equals("teacher")) {
					 Calendar calendar = Calendar.getInstance();
					 calendar.add(Calendar.DAY_OF_YEAR,365);
					 d = calendar.getTime();
					 user.setExpiry_date(d);
				 }
				 if(user.getType().equals("postgradute")) {
					 Calendar calendar = Calendar.getInstance();
					 calendar.add(Calendar.DAY_OF_YEAR,365*3);
					 d = calendar.getTime();
					 user.setExpiry_date(d);
				 }
				 
				 ps.setDate(2, new java.sql.Date(user.getEffective_date().getTime()));
				 ps.setDate(3, new java.sql.Date(user.getExpiry_date().getTime()));
				 ps.setString(4, user.getType());
				 ps.setString(5, user.getProfession());
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("error");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	
	public void update(User user) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update user set effective_date=?,expiry_date=?,type=?,profession=? where userid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(5,user.getUserid());
				 ps.setDate(1, new java.sql.Date(user.getEffective_date().getTime()));
				 ps.setDate(2, new java.sql.Date(user.getExpiry_date().getTime()));
				 ps.setString(3, user.getType());
				 ps.setString(4, user.getProfession());
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("error");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(User user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from user where userid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,user.getUserid());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("error");
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
			throw new SQLException("error");
		}finally{
           DBUtils.close(null, stmt, conn);
       }
		return resultList;	
	}
	
	public User queryById(int id) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 User u = null;
		 String sql = "select * from user where userid=?";
		 try{
			 try {
				conn = DBUtils.getConnection();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		             ps = conn.prepareStatement(sql);
		            ps.setInt(1, id);
		             rs = ps.executeQuery();
		            if(rs.next()){
	                 u = new User();
	                 u.setUserid(id);
	                 u.setEffective_date(rs.getDate("effective_date"));
	                 u.setExpiry_date(rs.getDate("expiry_date"));
	                 u.setProfession(rs.getString("profession"));
	                 u.setType(rs.getString("type"));
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("根据ID查询数据失败");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return u;
	}
}
