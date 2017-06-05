package com.ltl.library.dao;

import java.util.List;

import com.ltl.library.model.BaseModel;

public interface GenericDao<E extends BaseModel> {
	
	public E find(Long id) throws DaoException;
	
	public E find(String sql, Object... values) throws DaoException;
	
	public List<E> getAll()throws DaoException;
	
	public void add(E object) throws DaoException;
	
	public void update(E object) throws DaoException;
	
	public void delete(E object) throws DaoException;

}
