package ua.lviv.ltl.dao;

import ua.lviv.ltl.dao.impl.GenreSearchType;
import ua.lviv.ltl.model.Genre;

public interface GenreDao extends GenericDao<Genre, GenreSearchType> {
	
	public Genre getFullGenreById(Long id);

}
