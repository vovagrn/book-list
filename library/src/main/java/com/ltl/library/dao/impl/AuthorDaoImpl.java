package com.ltl.library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ltl.library.dao.AuthorDao;
import com.ltl.library.dao.DaoException;
import com.ltl.library.dao.DaoFactory;
import com.ltl.library.model.Author;

public class AuthorDaoImpl implements AuthorDao {	
	
	public static final String SQL_ADD = "INSERT INTO authors (fullName) VALUES (?)";
	public static final String SQL_UPDATE = "UPDATE authors SET fullName = ? WHERE id = ?";
	public static final String SQL_DELETE = "DELETE FROM authors WHERE id = ?";
	public static final String SQL_GET_ALL = "SELECT * FROM authors ORDER BY id";
	public static final String SQL_GET_BY_ID = "SELECT * FROM authors WHERE id = ?";
	
	private DaoFactory daoFactory = DaoFactory.getInstance();

	@Override
	public Author find(Long id) throws DaoException {		
		Author author = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;		
		try{
			connection = daoFactory.getConnection();
			statement = connection.prepareStatement(SQL_GET_BY_ID);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				author = new Author();
				author.setId(resultSet.getLong("id"));
				author.setFullName(resultSet.getString("fullName"));	
			}
		}catch (SQLException e) {
			throw new DaoException("Cannot get author", e);
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(statement !=null) statement.close();
				if(connection != null) connection.close();
			} catch (SQLException e) {
				throw new DaoException("Cannot close resources", e);					
			}
		}
		
		return author;
	}

	@Override
	public List<Author> getAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Author object) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Author object) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Author object) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Author find(String sql, Object... values) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
