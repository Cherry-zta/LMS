package com.vae.dao.impl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.db.DBUtils;
import com.vae.domain.Book;
import com.vae.domain.Record;
import com.vae.domain.User;

public class RecordDao {
	public void add(Record record) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into record(	record_id, bid, userid, borrow_time, return_time) values(?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				ps.setInt(1, record.getRecord_id());
				ps.setInt(2, record.getBid());
				ps.setInt(3, record.getUserid());
				ps.setDate(4,new java.sql.Date(record.getBorrow_time().getTime()));
				ps.setDate(5, new java.sql.Date(record.getReturn_time().getTime()));
				
				
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("error");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(Record record) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update record set bid=?, userid=?, borrow_time=?, return_time=? where record_id=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				
				ps.setInt(5, record.getRecord_id());
				ps.setInt(1, record.getBid());
				ps.setInt(2, record.getUserid());
				ps.setDate(3, new java.sql.Date(record.getBorrow_time().getTime()));
				ps.setDate(4, new java.sql.Date(record.getReturn_time().getTime()));
					
				 
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("error");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(Record record) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from record where record_id=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, record.getRecord_id());
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
	
	public Record queryById(int id) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Record record = null;
		 String sql = "select * from record where record_id=?";
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
	                record = new Record();
	                record.setRecord_id(id);
	                record.setBid(rs.getInt("bid"));
	                record.setUserid(rs.getInt("userid"));
	                record.setBorrow_time(rs.getDate("borrow_time"));
	                record.setReturn_time(rs.getDate("return_time"));
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("根据ID查询数据失败");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return record;
	}
}
