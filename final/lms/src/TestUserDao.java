import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.UserDao;
import com.vae.domain.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserDao {
	UserDao userDao = null;
	
	@Before
	public void init() {
		userDao = new UserDao();
	}
	
	@Test
	public void Aadd() throws SQLException {
		User user1 = new User();
		user1.setProfession("cs");
		user1.setType("teacher");
		user1.setPwd("123");
		userDao.add(user1);
		
		User user2 = new User();
		user2.setProfession("cs");
		user2.setType("student");
		user2.setPwd("123");
		userDao.add(user2);
		
		User user3 = new User();
		user3.setProfession("cs");
		user3.setType("postgradute");
		user3.setPwd("123");
		userDao.add(user3);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		User user = userDao.queryById(17);
		assertEquals("123", user.getPwd());
	}
	
	@Test
	public void Cupdate() throws SQLException {
		User user = userDao.queryById(17);
		user.setPwd("234");
		userDao.update(user);
	}
	
	@Test
	public void Dquery() throws SQLException {
		String sql="select * from user where profession='cs'";
		System.out.println(userDao.query(sql));
	}
	
	@Test
	public void Edelete() throws SQLException {
		User user1 = userDao.queryById(17);
		User user2 = userDao.queryById(18);
		User user3 = userDao.queryById(19);
		userDao.delete(user1);
		userDao.delete(user2);
		userDao.delete(user3);
	}
}
