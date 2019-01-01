import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.RelationBookDao;
import com.vae.domain.RelationBook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRBDao {
	RelationBookDao rBookDao= new RelationBookDao();
	
	@Before
	public void init() {
		rBookDao = new RelationBookDao();
	}
	
	@Test
	public void AqueryById()  throws SQLException {
		RelationBook relationBook = rBookDao.queryById(1,1);
		assertEquals(1, relationBook.getBid());
	}
	
	@Test
	public void Badd() throws SQLException {
		RelationBook relationBook = new RelationBook();
		relationBook.setBid(1);
		relationBook.setCid(1);
		rBookDao.add(relationBook);
	}
	
	@Test
	public void Cupdate() throws SQLException {
		RelationBook relationBook = rBookDao.queryById(1,1);
		relationBook.setBid(2);
		rBookDao.update(relationBook);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		RelationBook relationBook = rBookDao.queryById(1,2);
		rBookDao.delete(relationBook);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from relation_book where bid='2'";
		System.out.println(rBookDao.query(sql));
	}
}
