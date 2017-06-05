package com.ltl.library.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ltl.library.dao.impl.AuthorDaoImpl;
import com.ltl.library.dao.impl.BookDaoImpl;
import com.ltl.library.dao.impl.GenreDaoImpl;
import com.ltl.library.dao.impl.PublisherDaoImpl;

public class DaoFactory {

	private static DaoFactory daoFactory;
	private DataSource dataSource;

	public DaoFactory() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("jdbc/library");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static DaoFactory getInstance() {
		if (daoFactory == null) {
			synchronized (DaoFactory.class) {
				if (daoFactory == null) {
					daoFactory = new DaoFactory();
				}
			}
		}
		return daoFactory;
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public AuthorDao getAuthorDao() {
		return new AuthorDaoImpl();
	}

	public BookDao getBookDao() {
		return new BookDaoImpl();
	}

	public GenreDao getGenreDao() {
		return new GenreDaoImpl();
	}

	public PublisherDao getPublisherDao() {
		return new PublisherDaoImpl();
	}

}
