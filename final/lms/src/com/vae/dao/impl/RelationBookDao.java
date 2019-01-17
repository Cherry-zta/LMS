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

import com.vae.domain.Record;

import com.vae.domain.RelationBook;
import com.vae.domain.User;

public class RelationBookDao {
	public void add(RelationBook rebook) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into relation_book(	bid, cid) values(?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				ps.setInt(1, rebook.getBid());
				ps.setInt(2, rebook.getCid());
				ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("�������ʧ��");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(RelationBook rebook) throws SQLException {

		// TODO Auto-generated method stub

		 Connection conn = null;

		 PreparedStatement ps = null;

		 String sql = "update relation_book set bid=? where cid=?";

		 try{

				 try {

					conn = DBUtils.getConnection();

				} catch (PropertyVetoException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

				 ps = conn.prepareStatement(sql);

				

				ps.setInt(1, rebook.getBid());

				ps.setInt(2, rebook.getCid());

					

				 

             ps.executeUpdate();

         }catch(SQLException e){

             e.printStackTrace();

             throw new SQLException("��������ʧ��");

         }finally{

             DBUtils.close(null, ps, conn);

         }

	}



	public void delete(RelationBook rebook) throws SQLException {

		// TODO Auto-generated method stub

		Connection conn = null;

		 PreparedStatement ps = null;

		 String sql = "delete from relation_book where bid=?";

		 try{

				 try {

					conn = DBUtils.getConnection();

				} catch (PropertyVetoException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}

				 ps = conn.prepareStatement(sql);

				 ps.setInt(1, rebook.getBid());

            ps.executeUpdate();

        }catch(SQLException e){

            e.printStackTrace();

            throw new SQLException("ɾ������ʧ��");

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

			throw new SQLException("��ѯ����ʧ��");

		}finally{

           DBUtils.close(null, stmt, conn);

       }

		return resultList;	

	}
	
	public RelationBook queryById(int cid,int bid) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 RelationBook relationBook = null;
		 String sql = "select * from relation_book where cid=? and bid=?";
		 try{
			 try {
				conn = DBUtils.getConnection();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		             ps = conn.prepareStatement(sql);
		            ps.setInt(1, cid);
		            ps.setInt(2, bid);
		             rs = ps.executeQuery();
		            if(rs.next()){
	                 relationBook = new RelationBook();
	                 relationBook.setBid(bid);
	                 relationBook.setCid(cid);
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("����ID��ѯ����ʧ��");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return relationBook;
	}

}