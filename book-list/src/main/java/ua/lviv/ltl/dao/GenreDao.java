package ua.lviv.ltl.dao;

import ua.lviv.ltl.model.Genre;

public interface GenreDao extends GenericDao<Genre, GenreSearchCriteria> {
	
	public Genre getFullGenreById(Long id);

}
