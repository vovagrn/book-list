package ua.lviv.ltl.test;

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

		// DaoFactory daoFactory = DaoFactory.getInstance();
		// AuthorDao authorDao = daoFactory.getAythorDao();
		// BookDao bookDao = daoFactory.getBookDao();
		// List<Author> authors = authorDao.getAll();

		addEntity();
		addRelations();

	}

	public static void addEntity() {

		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();
		BookDao bookDao = daoFactory.getBookDao();

//		Author aa1 = new Author("Vladimir", "Hrebin", "Igorovich");
//		authorDao.add(aa1);
//
//		Author aa2 = new Author("Ivan", "Ilkiv", "Ivanovich");
//		authorDao.add(aa2);
//
//		Author aa3 = new Author("Vasil", "Kirichuk", "Volodimirovich");
//		authorDao.add(aa3);
//
//		Author aa4 = new Author("Sergey", "Bistrov", "Volodimirovich");
//		authorDao.add(aa4);
//
//		Author aa5 = new Author("Anrij", "Griga", "Stepanovich");
//		authorDao.add(aa5);
//
//		Author aa6 = new Author("Victorij", "Naumec", "Victorivna");
//		authorDao.add(aa6);
//
//		Book bb1 = new Book("Poter", "Fantazy", 377540);
//		bookDao.add(bb1);
//
//		Book bb2 = new Book("Voina", "History", 265657);
//		bookDao.add(bb2);
//
//		Book bb3 = new Book("Orel", "Travel", 738964);
//		bookDao.add(bb3);
//
//		Book bb4 = new Book("Kombat", "War", 597342);
//		bookDao.add(bb4);
	}

	public static void addRelations() {

		DaoFactory daoFactory = DaoFactory.getInstance();
		AuthorDao authorDao = daoFactory.getAythorDao();
		BookDao bookDao = daoFactory.getBookDao();
		List<Author> authors = authorDao.getAll();

		Author a0 = authors.get(0);
		Set<Book> b0 = a0.getBooks();
		b0.add(bookDao.getById(1L));
		b0.add(bookDao.getById(4L));
		authorDao.update(a0);

		Author a1 = authors.get(1);
		Set<Book> b1 = a1.getBooks();
		b1.add(bookDao.getById(2L));
		b1.add(bookDao.getById(3L));
		authorDao.update(a1);

		Author a2 = authors.get(2);
		Set<Book> b2 = a2.getBooks();
		b2.add(bookDao.getById(1L));
		b2.add(bookDao.getById(3L));
		authorDao.update(a2);

		Author a3 = authors.get(3);
		Set<Book> b3 = a3.getBooks();
		b3.add(bookDao.getById(2L));
		b3.add(bookDao.getById(4L));
		authorDao.update(a3);

		Author a4 = authors.get(4);
		Set<Book> b4 = a4.getBooks();
		b4.add(bookDao.getById(1L));
		b4.add(bookDao.getById(4L));
		authorDao.update(a4);
	}

}
