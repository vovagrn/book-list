package ua.lviv.ltl.dao.impl;

import org.hibernate.Session;

import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.GenreDao;
import ua.lviv.ltl.model.Genre;
import ua.lviv.ltl.util.HibernateUtil;

public class GenreDaoImpl extends AbstractGenericDao<Genre, GenreSearchType> implements GenreDao {
	
	
	public GenreDaoImpl() {
		super(Genre.class);
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
	
}
