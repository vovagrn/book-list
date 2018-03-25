package ua.lviv.ltl.dao.impl;

import ua.lviv.ltl.dao.PublisherDao;
import ua.lviv.ltl.dao.PublisherSearchType;
import ua.lviv.ltl.model.Publisher;

public class PublisherDaoImpl extends AbstractGenericDao<Publisher, PublisherSearchType> implements PublisherDao {

	public PublisherDaoImpl() {
		super(Publisher.class);
	}

}
