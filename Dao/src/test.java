import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.vae.dao.impl.BookDao;
import com.vae.dao.impl.Borrow_currDao;
import com.vae.dao.impl.UserDao;
import com.vae.domain.Book;
import com.vae.domain.Borrow_curr;
import com.vae.domain.User;

public class test {
	public static void main(String arg[]) {
		Date d=new Date();
		
		Borrow_curr b=new Borrow_curr();
		b.setBid(1);
		b.setBorrow_crr_id(1);
		b.setUserid(1);
//
		Borrow_currDao bd=new Borrow_currDao();
		
		User user=new User();
		user.setUserid(1);
		user.setProfession("cs");
		user.setType("teacher");
		
		UserDao ud=new UserDao();
		
		try {
			ud.add(user);
			bd.add(b);
//			System.out.println(bd.query("select * from book where title='titl'"));
//			bd.delete(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
