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
	public void AqueryById()  throws SQLException {
		User user = userDao.queryById(1);
		assertEquals("cs", user.getProfession());
	}
	
	@Test
	public void Badd() throws SQLException {
		User user1 = new User();
		user1.setProfession("cs");
		user1.setType("teacher");
		userDao.add(user1);
		
		User user2 = new User();
		user2.setProfession("cs");
		user2.setType("student");
		userDao.add(user2);
		
		User user3 = new User();
		user3.setProfession("cs");
		user3.setType("postgradute");
		userDao.add(user3);
	}
	
	@Test
	public void Cupdate() throws SQLException {
		User user = userDao.queryById(3);
		user.setProfession("la");
		userDao.update(user);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		User user1 = userDao.queryById(2);
		User user2 = userDao.queryById(3);
		User user3 = userDao.queryById(4);
		userDao.delete(user1);
		userDao.delete(user2);
		userDao.delete(user3);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from user where profession='cs'";
		System.out.println(userDao.query(sql));
	}
}
