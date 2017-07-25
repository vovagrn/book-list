package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookByTitle(String title) {
		Session session = null;
		List<Book> books = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.like("title", title, MatchMode.ANYWHERE).ignoreCase());
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			books = criteria.getExecutableCriteria(session).list();
			session.getTransaction().commit();			
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return books;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBookByLetter(String letter) {
		Session session = null;
		List<Book> books = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.like("title", letter, MatchMode.START).ignoreCase());
		try{
			session = HibernateUtil.getSession();
			session.beginTransaction();
			books = criteria.getExecutableCriteria(session).list();
			session.getTransaction().commit();			
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return books;
	}

}
