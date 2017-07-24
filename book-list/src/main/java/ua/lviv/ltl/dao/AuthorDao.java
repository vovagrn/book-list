package ua.lviv.ltl.dao;

import java.util.List;

import ua.lviv.ltl.model.Author;

public interface AuthorDao extends GenericDao<Author> {

	public List<Author> getAuthorByName(String name);
	
	public Author getFullAuthorById(Long id);
	
}
