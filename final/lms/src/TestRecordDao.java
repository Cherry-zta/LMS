import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.RecordDao;
import com.vae.domain.Record;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRecordDao {
	RecordDao recordDao = null;
	
	@Before
	public void init() {
		recordDao = new RecordDao();
	}
	
	@Test
	public void Aadd() throws SQLException,ParseException {
		java.text.SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd ");
		Record record = new Record();
		record.setBid(1);
		record.setUserid(1);
		
		String s= "2018-07-09 ";
		java.util.Date date = formatter.parse(s);
		record.setBorrow_time(date);
		
		s= "2018-08-09 ";
		date = formatter.parse(s);
		record.setReturn_time(date);
		
		recordDao.add(record);
	}
	
	@Test
	public void BqueryById()  throws SQLException {
		Record record = recordDao.queryById(2);
		assertEquals(1, record.getBid());
	}
	
	@Test
	public void Cupdate() throws SQLException {
		Record record = recordDao.queryById(2);
		record.setBid(8);
		recordDao.update(record);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Record record = recordDao.queryById(2);
		recordDao.delete(record);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from record where bid='2'";
		System.out.println(recordDao.query(sql));
	}
}
