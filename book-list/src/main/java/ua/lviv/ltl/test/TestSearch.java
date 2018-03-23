package ua.lviv.ltl.test;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.BookSearchCriteria;
import ua.lviv.ltl.dao.BookSearchType;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.dao.impl.SearchEntry;

public class TestSearch {

	public static void main(String[] args) {
		DaoFactory daoFactory = DaoFactory.getInstance();		
		BookDao bookDao = daoFactory.getBookDao();
		BookSearchCriteria searchCriteria = new BookSearchCriteria();
		SearchEntry<BookSearchType> searchEntry = new SearchEntry<>();
		searchEntry.setSearchType(BookSearchType.PUBLISH_YEAR);
		searchEntry.addValue(3333);
		searchEntry.addValue(2222);
		
		
		
		
		searchCriteria.addSearchEntry(searchEntry);
		System.out.println(bookDao.search(searchCriteria).toString());
		

	}

}
