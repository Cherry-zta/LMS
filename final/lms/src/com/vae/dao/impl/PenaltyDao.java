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
import com.vae.domain.Penalty;
import com.vae.domain.User;

public class PenaltyDao {
	public void add(Penalty penalty) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into penalty(penalty_id, userid, bid, return_time, should_return_time, assessment, paid) values(?,?,?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				ps.setInt(1, penalty.getPid());
				ps.setInt(2, penalty.getUserid());
				ps.setInt(3, penalty.getBid());
				ps.setDate(4,new java.sql.Date(penalty.getReturntime().getTime()));
				ps.setDate(5, new java.sql.Date(penalty.getShouldreturntime().getTime()));
				ps.setFloat(6, penalty.getAssessment());
				ps.setFloat(7, penalty.getPaid());
				
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("error");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(Penalty penalty) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update penalty set userid=?, bid=?, return_time=?, should_return_time=?, assessment=?, paid=? where penalty_id=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				
				ps.setInt(1, penalty.getUserid());
				ps.setInt(2, penalty.getBid());
				ps.setDate(3,new java.sql.Date(penalty.getReturntime().getTime()));
				ps.setDate(4, new java.sql.Date(penalty.getShouldreturntime().getTime()));
				ps.setFloat(5, penalty.getAssessment());
				ps.setFloat(6, penalty.getPaid());
				 
				ps.setInt(7, penalty.getPid());
				 
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("error");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(Penalty penalty) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from penalty where penalty_id=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1, penalty.getPid());
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
	
	public Penalty queryById(int id) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 Penalty penalty = null;
		 String sql = "select * from penalty where penalty_id=?";
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
	                 penalty = new Penalty();
	                 penalty.setPid(id);
	                 penalty.setBid(rs.getInt("bid"));
	                 penalty.setUserid(rs.getInt("userid"));
	                 penalty.setAssessment(rs.getFloat("assessment"));
	                 penalty.setPaid(rs.getFloat("paid"));
	                 penalty.setReturntime(rs.getDate("return_time"));
	                 penalty.setShouldreturntime(rs.getDate("should_return_time"));
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("根据ID查询数据失败");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return penalty;
	}
}
