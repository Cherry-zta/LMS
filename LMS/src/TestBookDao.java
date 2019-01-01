import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.BookDao;
import com.vae.domain.Book;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBookDao {
	BookDao bookDao = null;
	
	@Before
	public void init() {
		bookDao = new BookDao();
	}
	
	@Test
	public void AqueryById()  throws SQLException {
		Book book = bookDao.queryById(1);
		assertEquals("test1", book.getTitle());
	}
	
	@Test
	public void Badd() throws SQLException {
		Book book = new Book();
		book.setTitle("数据库");
		book.setLocation("图书馆一层");
		book.setAuthor("信息学院");
		bookDao.add(book);
	}
	
	@Test
	public void Cupdate() throws SQLException {
		Book book = bookDao.queryById(39);
		book.setTitle("数据库2");
		bookDao.update(book);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Book book = bookDao.queryById(1);
		bookDao.delete(book);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from book where title='test1'";
		System.out.println(bookDao.query(sql));
	}
}
