import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.Borrow_currDao;
import com.vae.domain.Borrow_curr;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBCDao {
	Borrow_currDao bCurrDao = null;
	
	@Before
	public void init() {
		bCurrDao = new Borrow_currDao();
	}
	
	@Test
	public void AqueryById()  throws SQLException {
		Borrow_curr borrow_curr = bCurrDao.queryById(2);
		assertEquals(1, borrow_curr.getBid());
	}
	
	@Test
	public void Badd() throws SQLException {
		Borrow_curr borrow_curr = new Borrow_curr();
		borrow_curr.setBid(1);
		borrow_curr.setUserid(1);
		bCurrDao.add(borrow_curr);
	}
	
	@Test
	public void Dupdate() throws SQLException {
		Borrow_curr borrow_curr = bCurrDao.queryById(2);
		borrow_curr.setBid(2);
		bCurrDao.update(borrow_curr);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Borrow_curr borrow_curr = bCurrDao.queryById(2);
		bCurrDao.delete(borrow_curr);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from borrow_curr where bid='2'";
		System.out.println(bCurrDao.query(sql));
	}
}
