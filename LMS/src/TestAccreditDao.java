import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.AccreditDao;
import com.vae.domain.Accredit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAccreditDao {
	AccreditDao accreditDao = null;
	
	@Before
	public void init() {
		accreditDao = new AccreditDao();
	}
	
	@Test
	public void Aadd() throws SQLException {
		Accredit accredit = new Accredit();
		accredit.setAccredit_id("123@qq.com");
		accredit.setAccredit_type("email");
		accredit.setStatus(1);
		accredit.setUserid(1);
		accreditDao.add(accredit);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		Accredit accredit = accreditDao.queryById("123@qq.com");
		assertEquals("email", accredit.getAccredit_type());
	}
	
	
	@Test
	public void Cupdate() throws SQLException {
		Accredit accredit = accreditDao.queryById("123@qq.com");
		accredit.setStatus(0);
		accreditDao.update(accredit);
	}
	
	@Test
	public void Dquery() throws SQLException {
		String sql="select * from accredit where userid='1'";
		System.out.println(accreditDao.query(sql));
	}
	
	@Test
	public void Edelete() throws SQLException {
		Accredit accredit = accreditDao.queryById("123@qq.com");
		accreditDao.delete(accredit);
	}
}
