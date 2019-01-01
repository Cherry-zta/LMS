import static org.junit.Assert.*;

import java.sql.SQLException;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.CategoryDao;
import com.vae.domain.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCategoryDao {
	CategoryDao categoryDao = null;
	
	@Before
	public void init() {
		categoryDao = new CategoryDao();
	}
	
	@Test
	public void AqueryById()  throws SQLException {
		Category category = categoryDao.queryById(1);
		assertEquals("��ѧ", category.getCname());
	}
	
	@Test
	public void Badd() throws SQLException {
		Category category = new Category();
		category.setCname("��ѧ");
		categoryDao.add(category);
	}
	
	@Test
	public void Cupdate() throws SQLException {
		Category category = categoryDao.queryById(1);
		category.setCname("�ƻ�");
		categoryDao.update(category);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Category category = categoryDao.queryById(1);
		categoryDao.delete(category);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from category where category_name='�ƻ�'";
		System.out.println(categoryDao.query(sql));
	}
}
