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
import com.vae.domain.Record;

public class Borrow_currDao {
	
	public void add(Borrow_curr borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into borrow_curr(	borrow_crr_id , bid , userid , borrow_time , should_return_time) values(?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				ps.setInt(1, borrow_curr.getBorrow_crr_id());
				ps.setInt(2, borrow_curr.getBid());
				ps.setInt(3, borrow_curr.getUserid());
				
				Date date=new Date();
				borrow_curr.setBorrow_time(date);
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH, 30);
				date = calendar.getTime();
				borrow_curr.setShould_return_time(date);
				
				ps.setDate(4,new java.sql.Date(borrow_curr.getBorrow_time().getTime()));
				ps.setDate(5,new java.sql.Date(borrow_curr.getShould_return_time().getTime()));	
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("error");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(Borrow_curr Borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update borrow_curr set bid=? , userid=? , borrow_time=? , should_return_time=? where borrow_crr_id=? ";
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
             throw new SQLException("error");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(Borrow_curr Borrow_curr) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from borrow_curr where bid=?";
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
	
	public Borrow_curr queryById(int id) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Borrow_curr borrow_curr = null;
		 String sql = "select * from borrow_curr where borrow_crr_id=?";
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
		            	borrow_curr = new Borrow_curr();
		            	borrow_curr.setBorrow_crr_id(id);
		            	borrow_curr.setBid(rs.getInt("bid"));
		            	borrow_curr.setUserid(rs.getInt("userid"));
		            	borrow_curr.setBorrow_time(rs.getDate("borrow_time"));
		            	borrow_curr.setShould_return_time(rs.getDate("should_return_time"));
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("根据ID查询数据失败");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return borrow_curr;
	}
}
