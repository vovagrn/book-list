package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.BookSearchCriteria;
import ua.lviv.ltl.dao.BookSearchType;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.SearchCriteria.SortOrder;
import ua.lviv.ltl.model.Book;
import ua.lviv.ltl.util.HibernateUtil;

public class BookDaoImpl extends AbstractGenericDao<Book, BookSearchCriteria> implements BookDao {

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
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			books = criteria.getExecutableCriteria(session).list();
			session.getTransaction().commit();
		} catch (Exception e) {
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
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			books = criteria.getExecutableCriteria(session).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return books;
	}

	@Override
	public List<Book> search(BookSearchCriteria searchCriteria) throws DaoException {
		List<Book> result = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Book.class);

			if (searchCriteria.isPagination()) {
				criteria.setFirstResult(searchCriteria.getFirstResult());
				criteria.setMaxResults(searchCriteria.getPageSize());
			}
			SortOrder sortOrder = searchCriteria.getSortOrder();
			if (sortOrder != null) {
				switch (sortOrder) {
				case ASC:
					criteria.addOrder(Order.asc(searchCriteria.getSortBy().getValue()));
					break;
				case DESC:
					criteria.addOrder(Order.desc(searchCriteria.getSortBy().getValue()));
					break;
				}

			}

			for (SearchEntry<BookSearchType> searchEntry : searchCriteria.getSearcEntrys()) {
				String propertyName = searchEntry.getSearchType().getValue();

				if (searchEntry.isSearchByDiapason()) {
					criteria.add(Restrictions.between(propertyName, searchEntry.getStartDiapason(),
							searchEntry.getEndDiapason()));
				}
				criteria.add(Restrictions.in(propertyName, searchEntry.getValues()));

			}

			result = (List<Book>) criteria.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return result;
	}

	@Override
	public long count(BookSearchCriteria searchCriteria) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

}
