package ua.lviv.ltl.test;

import ua.lviv.ltl.dao.BookDao;
import ua.lviv.ltl.dao.BookSearchType;
import ua.lviv.ltl.dao.SearchFilter;
import ua.lviv.ltl.dao.SearchFilter.SortOrder;
import ua.lviv.ltl.dao.impl.DaoFactory;
import ua.lviv.ltl.dao.impl.SearchEntry;
import ua.lviv.ltl.model.Book;

public class TestSearch {

	public static void main(String[] args) {
		DaoFactory daoFactory = DaoFactory.getInstance();		
		BookDao bookDao = daoFactory.getBookDao();
		SearchFilter<BookSearchType> searchFilter = new SearchFilter<>();
		SearchEntry<BookSearchType> searchEntry = new SearchEntry.Builder<>(BookSearchType.BY_PUBLISH_YEAR)
				.addRange(1111, 3333)
				.addRange(6666, 9999)
				.addValue(5555)
				.build();		
		
		searchFilter.setPagination(true);
		searchFilter.addSearchEntry(searchEntry);
		searchFilter.setSortBy(BookSearchType.BY_PUBLISH_YEAR);
		searchFilter.setSortOrder(SortOrder.ASC);
		searchFilter.setFirstResult(3);
		searchFilter.setPageSize(5);
		
		
		for(Book book : bookDao.find(searchFilter)){
			System.out.println(book);
		}
		
	}

}
