import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.Detailed_userDao;
import com.vae.domain.Detailed_user;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDUserDao {
	Detailed_userDao dUserDao = null;
	
	@Before
	public void init() {
		dUserDao = new Detailed_userDao();
	}
	
	@Test
	public void Aadd() throws SQLException,ParseException {
		Detailed_user dUser = new Detailed_user();
		dUser.setAddress("����");
		dUser.setAppionent_max(5);
		java.text.SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd ");
		String s= "2011-07-09 ";
		java.util.Date date = formatter.parse(s);
		dUser.setBirth(date);
		dUser.setBorrow_account(20);
		dUser.setBorrow_grade(1);
		dUser.setBreak_rules_account(0);
		dUser.setCash_pledge(100);
		dUser.setCompany("�ִ�");
		dUser.setDegree("����");
		dUser.setDepartement("��һ");
		dUser.setEntrust_max(3);
		dUser.setHanding_charge(3);
		dUser.setId_number("11111111");
		dUser.setIdentify("ѧ��");
		dUser.setPhone("123456");
		dUser.setPosition("����");
		dUser.setPostcode("444100");
		dUser.setSex("Ů");
		dUser.setUserid(1);
		dUserDao.add(dUser);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		Detailed_user dUser = dUserDao.queryById(1);
		assertEquals("ѧ��", dUser.getIdentify());
	}
	
	@Test
	public void Cupdate() throws SQLException {
		Detailed_user dUser = dUserDao.queryById(1);
		dUser.setIdentify("�о���");
		dUserDao.update(dUser);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Detailed_user dUser = dUserDao.queryById(1);
		dUserDao.delete(dUser);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from detailed_user where identify='ѧ��'";
		System.out.println(dUserDao.query(sql));
	}
}
