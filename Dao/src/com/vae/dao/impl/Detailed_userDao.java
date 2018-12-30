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
import com.vae.domain.Detailed_user;

public class Detailed_userDao {
	public void add(Detailed_user user) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into detailed_user(userid, id_number, departement, sex, identify, company, degree, birth, borrow_max, appionent_max, entrust_max, phone, postcode, cash_pledge, position, borrow_account, break_rules_account, handing_charge, borrow_grade, address)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,user.getUserid());
				 ps.setString(2,user.getId_number());
				 ps.setString(3, user.getDepartement());
				 ps.setString(4, user.getSex());
				 ps.setString(5, user.getIdentify());
				 ps.setString(6, user.getCompany());
				 ps.setString(7, user.getDegree());
				 ps.setDate(8, new java.sql.Date(user.getBirth().getTime()));
				 ps.setInt(9, user.getBorrow_max());
				 ps.setInt(10, user.getAppionent_max());
				 ps.setInt(11, user.getEntrust_max());
				 ps.setString(12, user.getPhone());
				 ps.setString(13, user.getPostcode());
				 ps.setFloat(14, user.getCash_pledge());
				 ps.setString(15, user.getPosition());
				 ps.setInt(16, user.getBorrow_account());
				 ps.setInt(17, user.getBreak_rules_account());
				 ps.setFloat(18, user.getHanding_charge());
				 ps.setInt(19, user.getBorrow_grade());
				 ps.setString(20, user.getAddress());
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("添加数据失败");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(Detailed_user user) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update detailed_user set id_number=?, departement=?, sex=?, identify=?, company=?, degree=?, birth=?, borrow_max=?, appionent_max=?, entrust_max=?, phone=?, postcode=?, cash_pledge=?, position=?, borrow_account=?, break_rules_account=?, handing_charge=?, borrow_grade=?, address=? where userid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
			
				 ps.setString(1,user.getId_number());
				 ps.setString(2, user.getDepartement());
				 ps.setString(3, user.getSex());
				 ps.setString(4, user.getIdentify());
				 ps.setString(5, user.getCompany());
				 ps.setString(6, user.getDegree());
				 ps.setDate(7, new java.sql.Date(user.getBirth().getTime()));
				 ps.setInt(8, user.getBorrow_max());
				 ps.setInt(9, user.getAppionent_max());
				 ps.setInt(10, user.getEntrust_max());
				 ps.setString(11, user.getPhone());
				 ps.setString(12, user.getPostcode());
				 ps.setFloat(13, user.getCash_pledge());
				 ps.setString(14, user.getPosition());
				 ps.setInt(15, user.getBorrow_account());
				 ps.setInt(16, user.getBreak_rules_account());
				 ps.setFloat(17, user.getHanding_charge());
				 ps.setInt(18, user.getBorrow_grade());
				 ps.setString(19, user.getAddress());
				 
				 ps.setInt(20,user.getUserid());
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("更新数据失败");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(Detailed_user user) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from detailed_user where userid=?";
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
