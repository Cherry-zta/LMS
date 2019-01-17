import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.AdminDao;
import com.vae.domain.Admin;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAdmin {
	AdminDao adminDao = null;
	
	@Before
	public void init() {
		adminDao = new AdminDao();
	}
	
	@Test
	public void Aadd() throws SQLException {
		Admin admin = new Admin();
		admin.setName("adc");
		admin.setPwd("abc");
		admin.setSex("ÄÐ");
		admin.setTel("123456");
		admin.setAdress("±±¾©");
		adminDao.add(admin);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		Admin admin = adminDao.queryById(1);
		assertEquals("abc", admin.getName());
	}
	
	
	@Test
	public void Cupdate() throws SQLException {
		Admin admin = adminDao.queryById(1);
		admin.setName("123");
		adminDao.update(admin);
	}
	
	@Test
	public void Dquery() throws SQLException {
		String sql="select * from admin where name='123'";
		System.out.println(adminDao.query(sql));
	}
	
	@Test
	public void Edelete() throws SQLException {
		Admin admin = adminDao.queryById(1);
		adminDao.delete(admin);
	}
}
