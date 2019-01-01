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
	public void AqueryById()  throws SQLException {
		DetailedBook dBook = dBookDao.queryById(1);
		assertEquals("·ң", dBook.getAuthor());
	}
	
	@Test
	public void Badd() throws SQLException {
		DetailedBook dBook = new DetailedBook();
		dBook.setBid(1);
		dBook.setBorrowtimes(20);
		dBook.setAuthor("·ң");
		dBook.setAuthornotes("**������");
		dBook.setBookspecification("3�� (463, 465, 464ҳ);22cm");
		dBook.setCategorynumber("12��");
		dBook.setDoubanintroduce("��ƽ��������(��װȫ3��)����һ����ʵ����С˵��Ҳ��С˵���ļ���ʷ�����Ҹ߶�Ũ�����й�����ũ�����ʷ��Ǩ���̣���Ʒ�ﵽ��˼�����������Եĸ߶�ͳһ���ر������˹�����������ܶ��ľ��񣬶Խ���Ĵ�ѧ�������������ϡ�\r\n" + 
				"����һ��ȫ��ʽ�ر����й����������������ĳ�ƪС˵��ȫ�鹲�����������ڽ�ʮ���ʹ��������ϣ�ͨ�����ӵ�ì�ܾ��𣬿̻��������ײ��ڶ���ͨ�˵������Ͷ��밮�飬������׷��ʹ���뻶�֣��ճ�������޴�����ͻ���׷��ؽ�֯��һ����̵�չʾ����ͨ���ڴ�ʱ����ʷ���������߹��ļ������۵ĵ�·��");
		dBook.setIntroduction("��ƽ�������硷��һ����ʵ����С˵��Ҳ��С˵���ļ���ʷ�����Ҹ߶�Ũ�����й�����ũ�����ʷ��Ǩ���̣���Ʒ�ﵽ��˼�����������Եĸ߶�ͳһ���ر������˹�����������ܶ��ľ��񣬶Խ���Ĵ�ѧ�������������ϡ�����һ��ȫ��ʽ�ر����й����������������ĳ�ƪС˵��ȫ�鹲�����������ڽ�ʮ���ʹ��������ϣ�ͨ�����ӵ�ì�ܾ��𣬿̻��������ײ��ڶ���ͨ�˵������Ͷ��밮�飬������׷��ʹ���뻶�֣��ճ�������޴�����ͻ��");
		dBook.setIsbn("978-7-5302-1018-5");
		dBook.setPublishinghouse("����:����ʮ�����ճ�����,2010");
		dBook.setReadernotes("��ѧ�����߼���ض���");
		dBook.setSecondauthor("·ң");
		dBook.setSeries("·ңȫ��");
		dBook.setStatus("�ܷ�");
		dBook.setSummary("������һ���й�������ƪС˵������Ũ�����й�����ũ�����ʷ��Ǩ���̣���С˵��ȫ��ʽ�ر������й�����������������ڽ�ʮ��Ĺ��������£�ͨ�����ӵ�ì�ܾ��𣬿̻������ײ��ڶ���ͨ�˵������Ͷ��밮�飬������׷��ʹ���뻶�֣��ճ�������޴�����ͻ���׷��ؽ�֯��һ����̵�չʾ����ͨ���ڴ�ʱ����ʷ���������߹��ļ������۵ĵ�·��");
		dBookDao.add(dBook);
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
