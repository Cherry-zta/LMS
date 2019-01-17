import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.AdminDao;
import com.vae.dao.impl.Admin_bookDao;
import com.vae.domain.Admin;
import com.vae.domain.Admin_book;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestABDao {
	Admin_bookDao admin_bookDao = null;
	
	@Before
	public void init() {
		admin_bookDao = new Admin_bookDao();
	}
	
	@Test
	public void Aadd() throws SQLException {
		Admin_book admin_book = new Admin_book();
		admin_book.setAid(1);
		admin_book.setBid(1);
		admin_bookDao.add(admin_book);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		Admin_book admin_book = admin_bookDao.queryById(1,1);
		assertEquals(1, admin_book.getAid());
	}
	
	
	@Test
	public void Cupdate() throws SQLException {
		Admin_book admin_book = admin_bookDao.queryById(1,1);
		admin_book.setStatus(1);
		admin_bookDao.update(admin_book);
	}
	
	@Test
	public void Dquery() throws SQLException {
		String sql="select * from admin_book where aid='1'";
		System.out.println(admin_bookDao.query(sql));
	}
	
	@Test
	public void Edelete() throws SQLException {
		Admin_book admin_book = admin_bookDao.queryById(1,1);
		admin_bookDao.delete(admin_book);
	}
}
