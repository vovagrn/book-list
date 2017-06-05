package ua.lviv.ltl.dao.impl;

import java.util.List;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.model.Author;

public class AuthorDaoImpl extends AbstractGenericDao<Author> implements AuthorDao {

	@Override
	public Author getById(Long id) throws DaoException {		
		return super.getByIdGeneric(Author.class, id);
	}

	@Override
	public List<Author> getAll() throws DaoException {
		return super.getAllGeneric(Author.class);
	}

}
