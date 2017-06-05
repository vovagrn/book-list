package com.ltl.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltl.library.dao.GenreDao;
import com.ltl.library.model.Genre;

public class GenreDaoImpl extends AbstractGenericDaoImpl<Genre> implements GenreDao {
	
	public static final String SQL_ADD = "INSERT INTO genre (name) VALUES (?)";
	public static final String SQL_UPDATE = "UPDATE genre SET name = ? WHERE id = ?";
	public static final String SQL_DELETE = "DELETE FROM genre WHERE id = ?";
	public static final String SQL_GET_ALL = "SELECT * FROM genre ORDER BY id";
	public static final String SQL_GET_BY_ID = "SELECT * FROM genre WHERE id = ?";
	
	@Override
	public List<Object> parseEntity(Genre object) throws IllegalArgumentException{
		if(object == null) throw new IllegalArgumentException();		
		List<Object> list = new ArrayList<>();
		list.add(object.getName());		
		return list;
	}
	
	@Override
	public List<Genre> parseResultSet(ResultSet resultSet) throws IllegalArgumentException, SQLException {
		if(resultSet == null) throw new IllegalArgumentException();
		List<Genre> list = new ArrayList<>();
		while (resultSet.next()) {
			Genre genre = new Genre();
			genre.setId(resultSet.getLong("id"));
			genre.setName(resultSet.getString("name"));
			list.add(genre);
		}
		return list;
	}
	
	//public Genre getByName(String name) throws DaoException{
	//	return find(SQL_GET_BY_NAME, name);
	//}
	
	@Override
	public String getSelectByIdQuery() {		
		return SQL_GET_BY_ID;
	}
	
	@Override
	public String getSelectAllQuery() {		
		return SQL_GET_ALL;
	}
	
	@Override
	public String getDeleteQuery() {		
		return SQL_DELETE;
	}
	
	@Override
	public String getUpdateQuery() {		
		return SQL_UPDATE;
	}
	
	@Override
	public String getAddQuery() {		
		return SQL_ADD;
	}	
}

	