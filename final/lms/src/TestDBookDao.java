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
		dBook.setAuthor("·ң");
		dBook.setAuthornotes("**������");
		dBook.setBookspecification("3�� (463, 465, 464ҳ);22cm");
		dBook.setCategorynumber("12��");
		dBook.setDoubanintroduce("��ƽ��������(��װȫ3��)��");
		dBook.setIntroduction("��ƽ�������硷��һ����ʵ����С˵");
		dBook.setIsbn("978");
		dBook.setPublishinghouse("����:����ʮ�����ճ�����,2010");
		dBook.setReadernotes("��ѧ�����߼���ض���");
		dBook.setSecondauthor("·ң");
		dBook.setSeries("·ңȫ��");
		dBook.setStatus("�ܷ�");
		dBook.setSummary("������һ���й�������ƪС˵������Ũ�����й�����ũ�����ʷ��Ǩ����");
		dBookDao.add(dBook);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		DetailedBook dBook = dBookDao.queryById(1);
		assertEquals("·ң", dBook.getAuthor());
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
		String sql="select * from detailed_book where author='·ң'";
		System.out.println(dBookDao.query(sql));
	}
}
