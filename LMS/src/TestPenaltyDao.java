import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.vae.dao.impl.PenaltyDao;
import com.vae.domain.Penalty;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPenaltyDao {
	PenaltyDao penaltyDao = null;
	
	@Before
	public void init() {
		penaltyDao = new PenaltyDao();
	}
	
	@Test
	public void AqueryById()  throws SQLException {
		Penalty penalty = penaltyDao.queryById(1);
		assertEquals(1, penalty.getBid());
	}
	
	@Test
	public void Badd() throws SQLException,ParseException {
		java.text.SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd ");
		Penalty penalty = new Penalty();
		penalty.setBid(1);
		penalty.setUserid(1);
		penalty.setAssessment(50);
		penalty.setPaid(50);
		
		String s= "2018-10-09 ";
		java.util.Date date = formatter.parse(s);
		penalty.setReturntime(date);
		
		s= "2018-08-09 ";
		date = formatter.parse(s);
		penalty.setShouldreturntime(date);
		
		penaltyDao.add(penalty);
	}
	
	@Test
	public void Cupdate() throws SQLException {
		Penalty penalty = penaltyDao.queryById(1);
		penalty.setBid(2);
		penaltyDao.update(penalty);
	}
	
	@Test
	public void Ddelete() throws SQLException {
		Penalty penalty = penaltyDao.queryById(1);
		penaltyDao.delete(penalty);
	}
	
	@Test
	public void Equery() throws SQLException {
		String sql="select * from penalty where bid='2'";
		System.out.println(penaltyDao.query(sql));
	}
}
