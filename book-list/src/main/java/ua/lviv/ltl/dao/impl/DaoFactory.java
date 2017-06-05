package ua.lviv.ltl.dao.impl;

import ua.lviv.ltl.dao.AuthorDao;
import ua.lviv.ltl.dao.BookDao;

public class DaoFactory {

	private static DaoFactory daoFactory;

	public DaoFactory() {

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

	public BookDao getBookDao() {
		return new BookDaoImpl();
	}
	
	public AuthorDao getAythorDao(){
		return new AuthorDaoImpl();
	}

}
