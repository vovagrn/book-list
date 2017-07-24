package ua.lviv.ltl.dao.impl;

import java.util.List;

import ua.lviv.ltl.dao.DaoException;
import ua.lviv.ltl.dao.PublisherDao;
import ua.lviv.ltl.model.Publisher;

public class PublisherDaoImpl extends AbstractGenericDao<Publisher> implements PublisherDao {

	@Override
	public Publisher getById(Long id) throws DaoException {		
		return super.getByIdGeneric(Publisher.class, id);
	}

	@Override
	public List<Publisher> getAll() throws DaoException {		
		return super.getAllGeneric(Publisher.class);
	}

	

}
