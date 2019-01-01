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
		assertEquals("路遥", dBook.getAuthor());
	}
	
	@Test
	public void Badd() throws SQLException {
		DetailedBook dBook = new DetailedBook();
		dBook.setBid(1);
		dBook.setBorrowtimes(20);
		dBook.setAuthor("路遥");
		dBook.setAuthornotes("**地区人");
		dBook.setBookspecification("3册 (463, 465, 464页);22cm");
		dBook.setCategorynumber("12章");
		dBook.setDoubanintroduce("《平凡的世界(套装全3册)》是一部现实主义小说，也是小说化的家族史。作家高度浓缩了中国西北农村的历史变迁过程，作品达到了思想性与艺术性的高度统一，特别是主人公面对困境艰苦奋斗的精神，对今天的大学生朋友仍有启迪。\r\n" + 
				"这是一部全景式地表现中国当代城乡社会生活的长篇小说。全书共三部。作者在近十年问广阔背景上，通过复杂的矛盾纠葛，刻划了社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。");
		dBook.setIntroduction("《平凡的世界》是一部现实主义小说，也是小说化的家族史。作家高度浓缩了中国西北农村的历史变迁过程，作品达到了思想性与艺术性的高度统一，特别是主人公面对困境艰苦奋斗的精神，对今天的大学生朋友仍有启迪。这是一部全景式地表现中国当代城乡社会生活的长篇小说。全书共三部。作者在近十年问广阔背景上，通过复杂的矛盾纠葛，刻划了社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，");
		dBook.setIsbn("978-7-5302-1018-5");
		dBook.setPublishinghouse("北京:北京十月文艺出版社,2010");
		dBook.setReadernotes("文学爱好者及相关读者");
		dBook.setSecondauthor("路遥");
		dBook.setSeries("路遥全集");
		dBook.setStatus("密封");
		dBook.setSummary("本书是一本中国当代长篇小说。作者浓缩了中国西北农村的历史变迁过程，在小说中全景式地表现了中国当代城乡的社会生活。在近十年的广阔背景下，通过复杂的矛盾纠葛，刻划社会各阶层众多普通人的形象。劳动与爱情，挫折与追求，痛苦与欢乐，日常生活与巨大社会冲突，纷繁地交织在一起，深刻地展示了普通人在大时代历史进程中所走过的艰难曲折的道路。");
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
		String sql="select * from detailed_book where author='路遥'";
		System.out.println(dBookDao.query(sql));
	}
}
