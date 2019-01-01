package com.vae.dao.impl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.util.db.DBUtils;
import com.vae.domain.Book;
import com.vae.domain.DetailedBook;

public class DetailedBookDao {
	public void add(DetailedBook book) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "insert into detailed_book(bid, status, publishing_house, series, ISBN, borrow_times, category_number,author, second_author, introduction, summary, author_notes, reader_notes, book_specification, douban_introduce)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,book.getBid());
				 ps.setString(2,book.getStatus());
				 ps.setString(3, book.getPublishinghouse());
				 ps.setString(4, book.getSeries());
				 ps.setString(5, book.getIsbn());
				 ps.setInt(6, book.getBorrowtimes());
				 ps.setString(7, book.getCategorynumber());
				 ps.setString(8, book.getAuthor());
				 ps.setString(9, book.getSecondauthor());
				 ps.setString(10, book.getIntroduction());
				 ps.setString(11, book.getSummary());
				 ps.setString(12, book.getAuthornotes());
				 ps.setString(13, book.getReadernotes());
				 ps.setString(14, book.getBookspecification());
				 ps.setString(15, book.getDoubanintroduce());
              ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
              throw new SQLException("erroe");
          }finally{
              DBUtils.close(null, ps, conn);
          }
	}

	public void update(DetailedBook book) throws SQLException {
		// TODO Auto-generated method stub
		 Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "update detailed_book set status=?, publishing_house=?, series=?, isbn=?, borrow_times=?, category_number=?,author=?, second_author=?, introduction=?, summary=?, author_notes=?, reader_notes=?, book_specification=?, douban_introduce=? where bid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 
				 ps.setString(1,book.getStatus());
				 ps.setString(2, book.getPublishinghouse());
				 ps.setString(3, book.getSeries());
				 ps.setString(4, book.getIsbn());
				 ps.setInt(5, book.getBorrowtimes());
				 ps.setString(6, book.getCategorynumber());
				 ps.setString(7, book.getAuthor());
				 ps.setString(8, book.getSecondauthor());
				 ps.setString(9, book.getIntroduction());
				 ps.setString(10, book.getSummary());
				 ps.setString(11, book.getAuthornotes());
				 ps.setString(12, book.getReadernotes());
				 ps.setString(13, book.getBookspecification());
				 ps.setString(14, book.getDoubanintroduce());
				 ps.setInt(15,book.getBid());
             ps.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
             throw new SQLException("error");
         }finally{
             DBUtils.close(null, ps, conn);
         }
	}

	public void delete(DetailedBook book) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		 PreparedStatement ps = null;
		 String sql = "delete from detailed_book where bid=?";
		 try{
				 try {
					conn = DBUtils.getConnection();
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 ps = conn.prepareStatement(sql);
				 ps.setInt(1,book.getBid());
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
	
	public DetailedBook queryById(int id) throws SQLException{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 DetailedBook dBook = null;
		 String sql = "select * from detailed_book where bid=?";
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
		            	dBook = new DetailedBook();
		            	dBook.setAuthor(rs.getString("author"));
		            	dBook.setAuthornotes(rs.getString("author_notes"));
		            	dBook.setBid(id);
		            	dBook.setBookspecification(rs.getString("book_specification"));
		            	dBook.setBorrowtimes(rs.getInt("borrow_times"));
		            	dBook.setCategorynumber(rs.getString("category_number"));
		            	dBook.setDoubanintroduce(rs.getString("douban_introduce"));
		            	dBook.setIntroduction(rs.getString("introduction"));
		            	dBook.setIsbn(rs.getString("isbn"));
		            	dBook.setPublishinghouse(rs.getString("publishing_house"));
		            	dBook.setReadernotes(rs.getString("reader_notes"));
		            	dBook.setSecondauthor(rs.getString("second_author"));
		            	dBook.setSeries(rs.getString("series"));
		            	dBook.setStatus(rs.getString("status"));
		            	dBook.setSummary(rs.getString("summary"));	     
	             }
	         }catch(SQLException e){
	             e.printStackTrace();
	            throw new SQLException("根据ID查询数据失败");
	        }finally{
	             DBUtils.close(rs, ps, conn);
	         }
	         return dBook;
	}
}
