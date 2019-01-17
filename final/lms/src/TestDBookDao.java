import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.DetailedBookDao;
import com.vae.domain.DetailedBook;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDBookDao {
	DetailedBookDao dBookDao = null;
	
	@Before
	public void init() {
		dBookDao = new DetailedBookDao();
	}
	
	@Test
	public void Aadd() throws SQLException {
		DetailedBook dBook = new DetailedBook();
		dBook.setBid(1);
		dBook.setBorrowtimes(20);
		dBook.setAuthor("路遥");
		dBook.setAuthornotes("**地区人");
		dBook.setBookspecification("3册 (463, 465, 464页);22cm");
		dBook.setCategorynumber("12章");
		dBook.setDoubanintroduce("《平凡的世界(套装全3册)》");
		dBook.setIntroduction("《平凡的世界》是一部现实主义小说");
		dBook.setIsbn("978");
		dBook.setPublishinghouse("北京:北京十月文艺出版社,2010");
		dBook.setReadernotes("文学爱好者及相关读者");
		dBook.setSecondauthor("路遥");
		dBook.setSeries("路遥全集");
		dBook.setStatus("密封");
		dBook.setSummary("本书是一本中国当代长篇小说。作者浓缩了中国西北农村的历史变迁过程");
		dBookDao.add(dBook);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		DetailedBook dBook = dBookDao.queryById(1);
		assertEquals("路遥", dBook.getAuthor());
	}
	
	
	@Test
	public void Cupdate() throws SQLException {
		DetailedBook dBook = dBookDao.queryById(1);
		dBook.setAuthor("luyao");
		dBookDao.update(dBook);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		DetailedBook dBook = dBookDao.queryById(1);
		dBookDao.delete(dBook);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from detailed_book where author='路遥'";
		System.out.println(dBookDao.query(sql));
	}
}
