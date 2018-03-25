package ua.lviv.ltl.dao;

import java.util.List;

import ua.lviv.ltl.model.Book;

public interface BookDao extends GenericDao<Book, BookSearchType>{
	
	public List<Book> getBookByTitle(String title);
	
	public List<Book> getBookByLetter(String letter);

}
