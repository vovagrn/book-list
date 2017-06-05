package ua.lviv.ltl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.model.Book;

public class Test {

	public static void main(String... args) throws DaoException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();
		BookDao bookDao = daoFactory.getBookDao();
		
		List<Author> authors =authorDao.getAll();
		
		Author a0=authors.get(0);
		Set<Book> b0 = a0.getBooks();
		b0.add(bookDao.getById(17L));
		b0.add(bookDao.getById(20L));		
		authorDao.update(a0);
		
		Author a1=authors.get(1);
		Set<Book> b1 = a1.getBooks();
		b1.add(bookDao.getById(18L));
		b1.add(bookDao.getById(19L));		
		authorDao.update(a1);
		
		Author a2=authors.get(2);
		Set<Book> b2 = a2.getBooks();
		b2.add(bookDao.getById(17L));
		b2.add(bookDao.getById(19L));		
		authorDao.update(a2);
		
		Author a3=authors.get(3);
		Set<Book> b3 = a3.getBooks();
		b3.add(bookDao.getById(18L));
		b3.add(bookDao.getById(20L));		
		authorDao.update(a3);
		
		Author a4=authors.get(4);
		Set<Book> b4 = a4.getBooks();
		b4.add(bookDao.getById(17L));
		b4.add(bookDao.getById(20L));		
		authorDao.update(a4);
		
		
		
		
//   <--------------------------------------------------------------------->
//		Author a1 = new Author("Vladimir", "Hrebin", "Igorovich");
//		authorDao.add(a1);
//
//		Author a2 = new Author("Ivan", "Ilkiv", "Ivanovich");
//		authorDao.add(a2);
//
//		Author a3 = new Author("Vasil", "Kirichuk", "Volodimirovich");
//		authorDao.add(a3);
//
//		Author a4 = new Author("Sergey", "Bistrov", "Volodimirovich");
//		authorDao.add(a4);
//
//		Author a5 = new Author("Anrij", "Griga", "Stepanovich");
//		authorDao.add(a5);
//
//		Author a6 = new Author("Victorij", "Naumec", "Victorivna");
//		authorDao.add(a6);
//		
//		
//		Book b1=new Book("Poter", "Fantazy", 377540);
//		bookDao.add(b1);
//		
//		Book b2=new Book("Voina", "History", 265657);
//		bookDao.add(b2);
//		
//		Book b3=new Book("Orel", "Travel", 738964);
//		bookDao.add(b3);
//		
//		Book b4=new Book("Kombat", "War", 597342);
//		bookDao.add(b4);
//   <--------------------------------------------------------------------->
		
		
		// BookDao bookDao1 = daoFactory.getBookDao();
		// BookDao bookDao2 = daoFactory.getBookDao();
		// //System.out.println("1"+bookDao1);
		// Book b = new Book();
		// b.setTitle("test");
		// b.setDescription("test22");
		// b.setIsbn(1234);
		//
		//
		//
		// bookDao1.add(b);
		//
		// List<Book> books = bookDao2.getAll();
		// System.out.println("2"+bookDao2);
		// System.out.println("1"+bookDao1);
		// for (Book book : books) {
		// System.out.println(book.getId()+" - "+book.getTitle()+" -
		// "+book.getDescription()+" - "+book.getIsbn());
		// }
		// System.out.println("------------");
		// bookDao1.getById(3L);
	}

}
