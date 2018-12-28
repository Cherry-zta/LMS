import java.sql.SQLException;

import com.vae.dao.impl.BookDao;
import com.vae.domain.Book;

public class test {
	public static void main(String arg[]) {
		Book b=new Book();
//		b.setAuthor("author");
//		b.setBid(1);
//		b.setLocation("location");
//		b.setTitle("titl");
		BookDao bd=new BookDao();
		try {
//			bd.add(b);
			System.out.println(bd.query("select * from book where title='titl'"));
//			bd.delete(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
