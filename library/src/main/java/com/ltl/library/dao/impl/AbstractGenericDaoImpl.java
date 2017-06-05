package com.ltl.library.dao.impl;

import static com.ltl.library.dao.impl.DaoUtil.prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltl.library.dao.DaoException;
import com.ltl.library.dao.DaoFactory;
import com.ltl.library.dao.GenericDao;
import com.ltl.library.model.BaseModel;

public abstract class AbstractGenericDaoImpl<E extends BaseModel> implements GenericDao<E>{
	
	private DaoFactory daoFactory = DaoFactory.getInstance();	
	
	public abstract List<Object> parseEntity(E object) throws IllegalArgumentException;	
	public abstract List<E> parseResultSet(ResultSet resultSet) throws IllegalArgumentException, SQLException, DaoException;
	public abstract String getSelectByIdQuery();
	public abstract String getSelectAllQuery();
	public abstract String getDeleteQuery();
	public abstract String getUpdateQuery();
	public abstract String getAddQuery();	
	
	public E find(Long id) throws DaoException{
		String sql = getSelectByIdQuery();
		return find(sql, id);		
	}
	
	public E find(String sql, Object... values) throws DaoException {
		List<E> list = new ArrayList<E>();
		
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, values);
				ResultSet resultSet = statement.executeQuery()) {

			list = parseResultSet(resultSet);

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		if (list == null || list.size() == 0) {
			throw new DaoException("Record not found.");
		}
		if (list.size() > 1) {
			throw new DaoException("Received more than one record.");
		}
		return list.iterator().next();
	}

	@Override
	public List<E> getAll() throws DaoException {
		List<E> list = new ArrayList<E>();
		String sql = getSelectAllQuery();
		
		try (Connection connection = daoFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			list = parseResultSet(resultSet);

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		if (list == null || list.size() == 0) {
			throw new DaoException("Records not found.");
		}		
		return list;
	}

	@Override
	public void add(E object) throws DaoException {
		List<Object> list = parseEntity(object);
		Object[] values = list.toArray();
		String sql = getAddQuery();		
		
		try(Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, values)){			
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
                throw new DaoException("Creating user failed, no rows affected.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(E object) throws DaoException {
		List<Object> list = parseEntity(object);
		list.add(object.getId());
		Object[] values = list.toArray();
		String sql = getUpdateQuery();
		
		try(Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, values)){
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
                throw new DaoException("Updating user failed, no rows affected.");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(E object) throws DaoException {
		Object[] values = {
				object.getId()
		};
		String sql = getDeleteQuery();
		
		try(Connection connection = daoFactory.getConnection();
				PreparedStatement statement = prepareStatement(connection, sql, values)){
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
                throw new DaoException("Deleting user failed, no rows affected.");
            } else {
                object.setId(null);
            }
		}catch (Exception e) {
			throw new DaoException(e.getMessage(),e);
		}
		
	}
	
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}

}
