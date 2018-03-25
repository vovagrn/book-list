package ua.lviv.ltl.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.GenericDao;
import ua.lviv.ltl.dao.SearchFilter;
import ua.lviv.ltl.dao.SearchFilter.SortOrder;
import ua.lviv.ltl.dao.SearchType;
import ua.lviv.ltl.model.BaseModel;
import ua.lviv.ltl.util.HibernateUtil;

public abstract class AbstractGenericDao<E extends BaseModel, T extends SearchType> implements GenericDao<E, T> {
	
	private final Class<E> clazz;

	public AbstractGenericDao(Class<E> clazz) {
		super();
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E getById(Long id) throws DaoException {
		E result = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			result = (E) session.get(clazz, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getAll() throws DaoException {
		List<E> result = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(clazz);

			result = (List<E>) criteria.list();
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
	public void add(E object) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
	}

	@Override
	public void update(E object) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}

	}

	@Override
	public void delete(E object) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
	}

	@Override
	public List<E> find(SearchFilter<T> searchFilter) throws DaoException {
		List<E> result = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(clazz);
			SearchFilterParser<T> parser = (SearchFilterParser<T>) SearchFilterParser.getParser(criteria);
			criteria = parser.parse(searchFilter);
			

//			if (searchFilter.isPagination()) {
//				criteria.setFirstResult(searchFilter.getFirstResult());
//				criteria.setMaxResults(searchFilter.getPageSize());
//			}
//			SortOrder sortOrder = searchFilter.getSortOrder();
//			if (sortOrder != null) {
//				switch (sortOrder) {
//				case ASC:
//					criteria.addOrder(Order.asc(searchFilter.getSortBy().getValue()));
//					break;
//				case DESC:
//					criteria.addOrder(Order.desc(searchFilter.getSortBy().getValue()));
//					break;
//				}
//
//			}
//
//			for (SearchEntry<T> searchEntry : searchFilter.getSearcEntrys()) {
//				String propertyName = searchEntry.getSearchType().getValue();
//
//				if (searchEntry.isSearchByDiapason()) {
//					criteria.add(Restrictions.between(propertyName, searchEntry.getStartDiapason(),
//							searchEntry.getEndDiapason()));
//				}
//				criteria.add(Restrictions.in(propertyName, searchEntry.getValues()));
//
//			}

			result = (List<E>) criteria.list();
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
	public long count(SearchFilter<T> searchFilter) throws DaoException {
		// TODO Auto-generated method stub
		return 0;
	}

}
