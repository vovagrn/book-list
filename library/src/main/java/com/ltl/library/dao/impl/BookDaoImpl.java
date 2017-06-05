package com.ltl.library.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltl.library.dao.BookDao;
import com.ltl.library.dao.DaoException;
import com.ltl.library.model.Book;

public class BookDaoImpl extends AbstractGenericDaoImpl<Book> implements BookDao {
	
	public static final String SQL_ADD = "INSERT INTO book (name) VALUES (?)";									//!
	public static final String SQL_UPDATE = "UPDATE book SET name = ? WHERE id = ?";							//!
	public static final String SQL_DELETE = "DELETE FROM book WHERE id = ?";
	public static final String SQL_GET_ALL = "SELECT * FROM book ORDER BY id";
	public static final String SQL_GET_BY_ID = "SELECT * FROM book WHERE id = ?";

	@Override
	public List<Object> parseEntity(Book object) throws IllegalArgumentException {								//!
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> parseResultSet(ResultSet resultSet) throws IllegalArgumentException, DaoException, SQLException {
		if(resultSet == null) throw new IllegalArgumentException();
		List<Book> list = new ArrayList<>();
		while (resultSet.next()) {
			Book book = new Book();
			book.setId(resultSet.getLong("id"));
			book.setName(resultSet.getString("name"));
			book.setIsbn(resultSet.getString("isbn"));
			book.setImage(resultSet.getString("image"));
			book.setContent(resultSet.getString("content"));
			book.setDescription(resultSet.getString("descr"));
			book.setPageCount(resultSet.getInt("page_count"));
			book.setPublishYear(resultSet.getInt("publish_year"));
			
			book.setGenre(getDaoFactory().getGenreDao().find(resultSet.getLong("genre_id")));
			book.setAuthor(getDaoFactory().getAuthorDao().find(resultSet.getLong("author_id")));
			book.setPublisher(getDaoFactory().getPublisherDao().find(resultSet.getLong("publisher_id")));		
						
			list.add(book);
		}
		return list;
	}

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
