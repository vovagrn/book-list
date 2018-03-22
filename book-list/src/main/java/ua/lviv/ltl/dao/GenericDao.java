package ua.lviv.ltl.dao;

import java.util.List;
import ua.lviv.ltl.model.BaseModel;

public interface GenericDao<E extends BaseModel, C extends SearchCriteria<?>> {

	public E getById(Long id) throws DaoException;

	public List<E> getAll() throws DaoException;

	public void add(E object) throws DaoException;

	public void update(E object) throws DaoException;

	public void delete(E object) throws DaoException;
	
	public List<E> search(C searchCriteria) throws DaoException;
	
	public long count(C searchCriteria) throws DaoException;

}
