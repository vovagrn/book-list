package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Session;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.model.Book;
import ua.lviv.ltl.util.HibernateUtil;

public class BookDaoImpl extends AbstractGenericDao<Book> implements BookDao {

	@Override
	public Book getById(Long id) throws DaoException {
		return super.getByIdGeneric(Book.class, id);
	}

	@Override
	public List<Book> getAll() throws DaoException {
		return super.getAllGeneric(Book.class);
	}

	@Override
	public void delete(Book object) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			object.getAuthors().clear();
			session.update(object);
			System.out.println("<----update---->"+ object.getAuthors());
			//session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
	}
	
	

}
