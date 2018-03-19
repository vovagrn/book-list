package ua.lviv.ltl.dao.impl;

import java.util.List;

import org.hibernate.Session;

import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.GenreDao;
import ua.lviv.ltl.dao.GenreSearchCriteria;
import ua.lviv.ltl.model.Genre;
import ua.lviv.ltl.util.HibernateUtil;

public class GenreDaoImpl extends AbstractGenericDao<Genre, GenreSearchCriteria> implements GenreDao {

	@Override
	public Genre getById(Long id) throws DaoException {		
		return super.getByIdGeneric(Genre.class, id);
	}

	@Override
	public List<Genre> getAll() throws DaoException {		
		return super.getAllGeneric(Genre.class);
	}
	
	@Override
	public Genre getFullGenreById(Long id){
		Genre genre= null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			genre = (Genre) session.get(Genre.class, id);
			genre.getBooks().size();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ((session != null) && (session.isOpen()))
				session.close();
		}
		return genre;		
	}

	@Override
	public List<Genre> search(GenreSearchCriteria searchCriteria) throws DaoException {
		throw new UnsupportedOperationException("Unsupported operation");	
	}

	@Override
	public long count(GenreSearchCriteria searchCriteria) throws DaoException {
		throw new UnsupportedOperationException("Unsupported operation");	
	}
}
