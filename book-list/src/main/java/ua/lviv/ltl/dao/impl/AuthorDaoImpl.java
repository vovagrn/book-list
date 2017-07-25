package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.model.Author;
import ua.lviv.ltl.util.HibernateUtil;

public class AuthorDaoImpl extends AbstractGenericDao<Author> implements AuthorDao {

	@Override
	public Author getById(Long id) throws DaoException {
		return super.getByIdGeneric(Author.class, id);
	}

	@Override
	public List<Author> getAll() throws DaoException {
		return super.getAllGeneric(Author.class);
	}

	@SuppressWarnings("unchecked")
	public List<Author> getAuthorByName(String name) {
		Session session = null;
		List<Author> author = null;
		DetachedCriteria criteria = DetachedCriteria.forClass(Author.class);
		criteria.add(Restrictions.like("fullName", name, MatchMode.ANYWHERE).ignoreCase());
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			author = criteria.getExecutableCriteria(session).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return author;
	}

	@Override
	public Author getFullAuthorById(Long id) {
		Author author = null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			author = (Author) session.get(Author.class, id);
			author.getBooks().size();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return author;
	}
}
